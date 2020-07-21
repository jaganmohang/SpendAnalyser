package com.jagan.spendanalayser.ui.spending

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.jagan.spendanalayser.R
import com.jagan.spendanalayser.data.db.entity.Spend
import com.jagan.spendanalayser.databinding.FragmentSpendingBinding
import com.jagan.spendanalayser.model.ActiveMonth
import com.jagan.spendanalayser.model.DateItem
import com.jagan.spendanalayser.model.ExpenseDate
import com.jagan.spendanalayser.ui.ExpenseUpdateViewModel
import com.jagan.spendanalayser.ui.base.BaseFragment
import com.jagan.spendanalayser.ui.callbacks.OnDateSelector
import com.jagan.spendanalayser.utils.DateType
import com.jagan.spendanalayser.utils.DateUtils
import com.jagan.spendanalayser.utils.autoCleared


class SpendingFragment : BaseFragment(), OnDateSelector {
    private val spendViewModel: SpendingViewModel by viewModels { viewModelFactory }
    private lateinit var expenseUpdateViewModel: ExpenseUpdateViewModel
    private var spendDataBinding by autoCleared<FragmentSpendingBinding>()
    private var spendingAdapter: SpendAdapter? = null
    private var dateAdapter: DateAdapter? = null
    private var mActiveMonth: ActiveMonth? = null
    private var activeDate: DateItem? = null
    private var dates: MutableList<DateItem> = mutableListOf()

    private val handler = Handler()

    override fun getLayoutRes(): Int = R.layout.fragment_spending

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataBinding = DataBindingUtil.inflate<FragmentSpendingBinding>(inflater, getLayoutRes(), container, false)
        spendDataBinding = dataBinding
        return dataBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        expenseUpdateViewModel = ViewModelProvider(activity!!).get(ExpenseUpdateViewModel::class.java)
        registerObservers()
    }

    private fun initUI() {
        //dates adapter
        dateAdapter = DateAdapter(dates, context!!, this)
        val dateLayoutManager = LinearLayoutManager(context, HORIZONTAL, false)
        spendDataBinding.rvDates.layoutManager = dateLayoutManager
        spendDataBinding.rvDates.adapter = dateAdapter

        //expenses adapter
        spendingAdapter =
            SpendAdapter(mutableListOf(), context!!) { position, spend -> onExpenseDelete(position, spend) }
        val spendLayoutManager = LinearLayoutManager(context)
        spendDataBinding.rvExpenses.layoutManager = spendLayoutManager
        spendDataBinding.rvExpenses.itemAnimator = null
        val dividerItemDecoration = DividerItemDecoration(spendDataBinding.rvExpenses.context, HORIZONTAL)
        spendDataBinding.rvExpenses.addItemDecoration(dividerItemDecoration)
        spendDataBinding.rvExpenses.adapter = spendingAdapter
    }

    private fun registerObservers() {
        spendViewModel.getExpenses().observe(viewLifecycleOwner) { processExpenses(it) }
        expenseUpdateViewModel.monthUpdateLiveData.observe(viewLifecycleOwner) { processMonthUpdate(it) }
        expenseUpdateViewModel.newExpenseLiveData.observe(viewLifecycleOwner) { processNewExpense(it) }
    }

    private fun onExpenseDelete(position: Int, spend: Spend) {
        spendViewModel.deleteExpense(spend)
        spendingAdapter?.removeExpense(position)
        activeDate?.let {
            val expenseDate = DateUtils.parseExpenseDate(it.originalValue)
            expenseUpdateViewModel.updateNewExpense(expenseDate)
        }
    }

    private fun processExpenses(expenses: MutableList<Spend>) {
        if (expenses.isNotEmpty()) displayExpenses(expenses) else showNoExpensesLayout(false)
    }

    private fun processMonthUpdate(activeMonth: ActiveMonth) {
        mActiveMonth = activeMonth
        mActiveMonth?.let {
            val newDates = DateUtils.getDatesForMonth(it.month, it.year)
            updateActiveDate(newDates[newDates.size - 1])
            dateAdapter?.updateDates(newDates)
            dateAdapter?.updateSelectedPosition()
            scrollToLastDate()
            fetchTransactions()
        }

    }

    private fun processNewExpense(expenseDate: ExpenseDate) {
        activeDate?.let {
            val activeParsedDate = DateUtils.parseExpenseDate(it.originalValue)
            if (expenseDate.day == activeParsedDate.day && expenseDate.month == activeParsedDate.month && expenseDate.year == activeParsedDate.year)
                refreshTransactions(1000)
        }
    }

    private fun displayExpenses(expenses: MutableList<Spend>) {
        showNoExpensesLayout(true)
        spendingAdapter?.addExpenses(expenses)
    }

    private fun showNoExpensesLayout(hasExpenses: Boolean) {
        spendDataBinding.layoutNoExpenses.visibility = if (hasExpenses) GONE else VISIBLE
        spendDataBinding.rvExpenses.visibility = if (hasExpenses) VISIBLE else GONE
    }

    private fun refreshTransactions(delay: Long) {
        handler.postDelayed({
            spendingAdapter?.clear()
            fetchTransactions()
        }, delay)
    }

    private fun fetchTransactions() {
        activeDate?.let { spendViewModel.fetchExpenses(it.originalValue) }
    }

    private fun updateActiveDate(date: DateItem) {
        activeDate = date
    }

    override fun onDateSelected(date: DateItem, type: DateType) {
        activeDate = date
        refreshTransactions(0)
    }

    private fun scrollToLastDate() {
        handler.postDelayed({
            val smoothScroller: RecyclerView.SmoothScroller = object : LinearSmoothScroller(context) {
                override fun getHorizontalSnapPreference(): Int {
                    return SNAP_TO_END
                }
            }
            smoothScroller.targetPosition = dates.size - 1;
            spendDataBinding.rvDates.layoutManager?.startSmoothScroll(smoothScroller)
        }, 1000)
    }

    companion object {
        @JvmStatic
        fun newInstance(args: Bundle?) =
            SpendingFragment().apply {
                arguments = args
            }
    }
}
