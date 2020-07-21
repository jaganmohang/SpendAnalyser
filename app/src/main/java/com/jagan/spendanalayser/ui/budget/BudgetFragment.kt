package com.jagan.spendanalayser.ui.budget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.jagan.spendanalayser.R
import com.jagan.spendanalayser.constants.AppConstants.Companion.ACTIVE_MONTH_ID
import com.jagan.spendanalayser.constants.AppConstants.Companion.RESULT_CODE_UPDATE_BUDGET
import com.jagan.spendanalayser.databinding.BudgetFragmentBinding
import com.jagan.spendanalayser.model.BudgetItem
import com.jagan.spendanalayser.ui.base.BaseFragment
import com.jagan.spendanalayser.utils.autoCleared

class BudgetFragment : BaseFragment() {
    private val budgetViewModel: BudgetViewModel by viewModels { viewModelFactory }
    private var budgetDataBinding by autoCleared<BudgetFragmentBinding>()

    private lateinit var budgetAdapter: BudgetAdapter
    private var mBudget = mutableListOf<BudgetItem>()

    private var activeMonthId: Long? = null

    override fun getLayoutRes(): Int {
        return R.layout.budget_fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            activeMonthId = it.getLong(ACTIVE_MONTH_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataBinding = DataBindingUtil.inflate<BudgetFragmentBinding>(inflater, getLayoutRes(), container, false)
        budgetDataBinding = dataBinding
        return budgetDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        registerObservers()
        setUpBudget()
    }

    private fun initUI() {
        budgetAdapter = BudgetAdapter(context!!, mBudget)
        budgetDataBinding.recyclerViewBudget.layoutManager = LinearLayoutManager(context)
        budgetDataBinding.recyclerViewBudget.adapter = budgetAdapter

        budgetDataBinding.toolbar.setNavigationOnClickListener { finishActivity() }

        budgetDataBinding.toolbar.inflateMenu(R.menu.budget)
        budgetDataBinding.toolbar.setOnMenuItemClickListener {
            updateBudget()
            true
        }
    }

    private fun registerObservers() {
        budgetViewModel.getBudgetSetUp().observe(viewLifecycleOwner, this::processBudgetSetUp)
        budgetViewModel.getBudget().observe(viewLifecycleOwner, this::processBudget)
    }

    private fun setUpBudget() {
        activeMonthId?.let { budgetViewModel.setUpBudget(it) }
    }

    private fun fetchActiveBudget() {
        activeMonthId?.let { budgetViewModel.fetchBudget(it) }
    }

    private fun processBudgetSetUp(setUpDone: Boolean) {
        if (setUpDone)
            fetchActiveBudget()
    }

    private fun processBudget(budgetList: MutableList<BudgetItem>) {
        budgetDataBinding.progressCircular.hide()
        budgetDataBinding.recyclerViewBudget.visibility = VISIBLE
        budgetAdapter.updateBudget(budgetList)
    }

    private fun updateBudget() {
        budgetViewModel.updateBudget(mBudget)
        activity?.setResult(RESULT_CODE_UPDATE_BUDGET)
        finishActivity()
    }

    companion object {
        fun newInstance(args: Bundle?) = BudgetFragment().apply { arguments = args }
    }
}
