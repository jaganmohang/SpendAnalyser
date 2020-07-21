package com.jagan.spendanalayser.ui.overview

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.MPPointF
import com.jagan.spendanalayser.R
import com.jagan.spendanalayser.databinding.FragmentOverviewBinding
import com.jagan.spendanalayser.model.ActiveMonth
import com.jagan.spendanalayser.model.ExpenseDate
import com.jagan.spendanalayser.model.SpentAmount
import com.jagan.spendanalayser.ui.ExpenseUpdateViewModel
import com.jagan.spendanalayser.ui.base.BaseFragment
import com.jagan.spendanalayser.utils.autoCleared
import kotlinx.android.synthetic.main.layout_no_expenses.view.*


class OverviewFragment : BaseFragment() {

    private val overviewViewModel: OverviewViewModel by viewModels { viewModelFactory }
    private lateinit var expenseUpdateViewModel: ExpenseUpdateViewModel

    private var binding by autoCleared<FragmentOverviewBinding>()
    private lateinit var categorySpentAdapter: CategorySpentAdapter
    private var mActiveMonth: ActiveMonth? = null
    private val handler = Handler()

    override fun getLayoutRes(): Int = R.layout.fragment_overview

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val databinding = DataBindingUtil.inflate<FragmentOverviewBinding>(inflater, getLayoutRes(), container, false)
        binding = databinding
        return databinding.root
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
        binding.rvExpenseDetails.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        categorySpentAdapter = CategorySpentAdapter(context!!, mutableListOf())
        binding.rvExpenseDetails.adapter = categorySpentAdapter


        binding.chartExpenses.setUsePercentValues(true)
        binding.chartExpenses.description.isEnabled = false
        binding.chartExpenses.setExtraOffsets(5f, 10f, 5f, 5f)

        binding.chartExpenses.dragDecelerationFrictionCoef = 0.95f

        binding.chartExpenses.isDrawHoleEnabled = true
        binding.chartExpenses.setHoleColor(Color.WHITE)

        binding.chartExpenses.setTransparentCircleColor(Color.WHITE)
        binding.chartExpenses.setTransparentCircleAlpha(110)

        binding.chartExpenses.holeRadius = 55f
        binding.chartExpenses.transparentCircleRadius = 61f

        binding.chartExpenses.setDrawCenterText(true)
        binding.chartExpenses.centerText = "Expense Analyser"

        binding.chartExpenses.rotationAngle = 0f
        // enable rotation of the binding.chartExpenses by touch
        binding.chartExpenses.isRotationEnabled = false
        binding.chartExpenses.isHighlightPerTapEnabled = false

        // binding.chartExpenses.setUnit(" €");
        // binding.chartExpenses.setDrawUnitsInChart(true);


        binding.chartExpenses.animateY(1400, Easing.EaseInOutQuad)
        // binding.chartExpenses.spin(2000, 0, 360);

        val l = binding.chartExpenses.legend
        l.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
        l.orientation = Legend.LegendOrientation.VERTICAL
        l.setDrawInside(false)
        l.xEntrySpace = 7f
        l.yEntrySpace = 0f
        l.yOffset = 0f

        // entry label styling
        binding.chartExpenses.setEntryLabelColor(Color.WHITE)
        binding.chartExpenses.setEntryLabelTextSize(12f)
    }

    private fun registerObservers() {
        overviewViewModel.getAllExpenses().observe(viewLifecycleOwner) { processAllExpenses(it) }
        overviewViewModel.getNoDateAvailable().observe(viewLifecycleOwner) { showNoDataAvailable(it) }
        expenseUpdateViewModel.monthUpdateLiveData.observe(viewLifecycleOwner) {
            processMonthUpdate(it)
        }
        expenseUpdateViewModel.newExpenseLiveData.observe(viewLifecycleOwner) { processNewExpenseAdded(it) }
        expenseUpdateViewModel.budgetUpdateLiveData.observe(viewLifecycleOwner) { if (it) updateMonthExpenses(1000) }
    }

    private fun fetchMonthExpenses(delay: Long) {
        mActiveMonth?.let {
            handler.postDelayed({
                overviewViewModel.fetchAllExpenses(it)
            }, delay)
        }
    }

    private fun processAllExpenses(allExpenses: MutableList<SpentAmount>) {
        showNoDataLayout(false)
        showContentLayout(true)
        clearList()
        loadChart(allExpenses)
        displaySummary(allExpenses)
    }

    private fun showNoDataAvailable(data: String) {
        showContentLayout(false)
        showNoDataLayout(true)
    }

    private fun processMonthUpdate(activeMonth: ActiveMonth) {
        this.mActiveMonth = activeMonth
        mActiveMonth?.let { updateMonthExpenses(0) }
    }

    private fun updateMonthExpenses(delay: Long) {
        clearChart()
        clearList()
        fetchMonthExpenses(delay)
    }

    private fun processNewExpenseAdded(expenseDate: ExpenseDate) {
        mActiveMonth?.let {
            if (expenseDate.month == it.month && expenseDate.year == it.year)
                updateMonthExpenses(1000)
        }

    }

    private fun displaySummary(allExpenses: MutableList<SpentAmount>) {
        val summaryInfo = overviewViewModel.calculateTotal(allExpenses)
        binding.tvPlannedAmount.text = summaryInfo.planned
        binding.tvSpentAmount.text = summaryInfo.spent
        binding.tvDifference.text = summaryInfo.impression.text
        binding.tvDifferenceAmount.text = summaryInfo.difference
        binding.tvDifference.setTextColor(ContextCompat.getColor(context!!, summaryInfo.impressionColor))
        binding.tvDifferenceAmount.setTextColor(ContextCompat.getColor(context!!, summaryInfo.impressionColor))
        categorySpentAdapter.addAllExpenses(allExpenses)
    }

    private fun showContentLayout(show: Boolean) {
        binding.contentLayout.visibility = if (show) VISIBLE else GONE
    }

    private fun showNoDataLayout(show: Boolean) {
        binding.layoutNoAnalysis.visibility = if (show) VISIBLE else GONE
        binding.layoutNoAnalysis.tvTitle.text = getString(R.string.msg_no_data_available)
    }


    private fun loadChart(allExpenses: MutableList<SpentAmount>) {
        val entries = mutableListOf<PieEntry>()

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the binding.chartExpenses.
        for (i in 0 until allExpenses.size) {
            val spentAmount = allExpenses[i]
            entries.add(PieEntry(spentAmount.spentAmount.toFloat(), spentAmount.categoryName, null))
        }

        val dataSet = PieDataSet(entries, "")
        dataSet.setDrawIcons(false)

        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0f, 40f)
        dataSet.selectionShift = 5f

        // add a lot of colors

        val colors = mutableListOf<Int>()

        colors.add(Color.rgb(26, 141, 255))
        colors.add(Color.rgb(255, 26, 141))
        colors.add(Color.rgb(103, 205, 0))
        colors.add(Color.rgb(26, 26, 255))
        colors.add(Color.rgb(255, 140, 26))
        colors.add(Color.rgb(255, 26, 27))
        colors.add(Color.rgb(26, 255, 140))
        colors.add(Color.rgb(0, 0, 255))

        dataSet.colors = colors
        //dataSet.setSelectionShift(0f);

        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter(binding.chartExpenses))
        data.setValueTextSize(11f)
        data.setValueTextColor(Color.WHITE)
        binding.chartExpenses.data = data

        // undo all highlights
        binding.chartExpenses.highlightValues(null)

        binding.chartExpenses.invalidate()
    }

    private fun clearChart() {
        binding.chartExpenses.clear()
    }

    private fun clearList() {
        categorySpentAdapter.clear()
    }

    companion object {
        @JvmStatic
        fun newInstance(args: Bundle?) =
            OverviewFragment().apply {
                arguments = args
            }
    }
}
