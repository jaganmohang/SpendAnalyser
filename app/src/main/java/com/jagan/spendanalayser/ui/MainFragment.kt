package com.jagan.spendanalayser.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.jagan.spendanalayser.R
import com.jagan.spendanalayser.constants.AppConstants
import com.jagan.spendanalayser.constants.AppConstants.Companion.ACTIVE_MONTH
import com.jagan.spendanalayser.constants.AppConstants.Companion.REQUEST_CODE_CHANGE_MONTH
import com.jagan.spendanalayser.constants.AppConstants.Companion.REQUEST_CODE_NEW_EXPENSE
import com.jagan.spendanalayser.constants.AppConstants.Companion.REQUEST_CODE_UPDATE_BUDGET
import com.jagan.spendanalayser.constants.AppConstants.Companion.RESULT_CODE_CHANGE_MONTH
import com.jagan.spendanalayser.constants.AppConstants.Companion.RESULT_CODE_NEW_EXPENSE
import com.jagan.spendanalayser.constants.AppConstants.Companion.RESULT_CODE_UPDATE_BUDGET
import com.jagan.spendanalayser.databinding.FragmentMainBinding
import com.jagan.spendanalayser.model.ActiveMonth
import com.jagan.spendanalayser.model.ExpenseDate
import com.jagan.spendanalayser.model.SelectedMonth
import com.jagan.spendanalayser.ui.base.BaseFragment
import com.jagan.spendanalayser.ui.budget.BudgetActivity
import com.jagan.spendanalayser.ui.categories.CategoriesActivity
import com.jagan.spendanalayser.ui.change_month.ChangeMonthBottomSheet
import com.jagan.spendanalayser.ui.newspend.NewExpenseBottomSheet
import com.jagan.spendanalayser.utils.DateUtils
import com.jagan.spendanalayser.utils.autoCleared


/*
* Copyright 2015 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

/**
 * Created by jaganmohana on 2019-11-07.
 */
class MainFragment : BaseFragment() {
    private val mainViewModel: MainViewModel by viewModels { viewModelFactory }
    private lateinit var expenseUpdateViewModel: ExpenseUpdateViewModel

    var binding by autoCleared<FragmentMainBinding>()

    private var mActiveMonth: ActiveMonth? = null
    private val handler = Handler()
    override fun getLayoutRes(): Int {
        return R.layout.fragment_main
    }

    companion object {
        fun newInstance(args: Bundle?) = MainFragment().apply { arguments = args }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val dataBinding = DataBindingUtil.inflate<FragmentMainBinding>(inflater, getLayoutRes(), container, false)
        binding = dataBinding
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
        val sectionsPagerAdapter = SectionsPagerAdapter(context, childFragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)
        binding.clickListener = ClickListener()

        binding.toolbar.setOnMenuItemClickListener {
            val itemId = it.itemId
            if (itemId == R.id.actionCategories) {
                navigateToCategories()
            } else if (itemId == R.id.actionBudget) {
                navigateToBudgetPlan()
            } else if (itemId == R.id.actionAddExpense) {
                showNewExpenseBottomSheet()
            }
            true
        }
    }

    private fun registerObservers() {
        mainViewModel.getInitialDataLoad().observe(viewLifecycleOwner) {
            if (it) updateMonthDetails(
                SelectedMonth(
                    DateUtils.getCurrentMonth(),
                    DateUtils.getCurrentYear()
                )
            )
        }
        mainViewModel.getActiveMonth().observe(viewLifecycleOwner, this::updateActiveMonth)
    }

    private fun updateActiveMonth(activeMonth: ActiveMonth) {
        mActiveMonth = activeMonth
        updateSelectedMonth()
    }

    private fun showNewExpenseBottomSheet() {
        mActiveMonth?.let {
            val args = Bundle().apply { putParcelable(ACTIVE_MONTH, it) }
            val addExpenseBottomSheet = NewExpenseBottomSheet.newInstance(args)
            addExpenseBottomSheet.setTargetFragment(this@MainFragment, REQUEST_CODE_NEW_EXPENSE)
            addExpenseBottomSheet.show(activity?.supportFragmentManager!!, "NewExpenseBottomSheet")
        }

    }

    private fun showMonthChangeBottomSheet() {
        val args = Bundle().apply {
            putParcelable(
                AppConstants.SELECTED_MONTH,
                SelectedMonth(
                    mActiveMonth?.month ?: DateUtils.getCurrentMonth(),
                    mActiveMonth?.year ?: DateUtils.getCurrentYear()
                )
            )
        }
        val changeMonthBottomSheet = ChangeMonthBottomSheet.newInstance(args)
        changeMonthBottomSheet.setTargetFragment(this@MainFragment, REQUEST_CODE_CHANGE_MONTH)
        changeMonthBottomSheet.show(activity?.supportFragmentManager!!, "ChangeMonthBottomSheet")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_CHANGE_MONTH && resultCode == RESULT_CODE_CHANGE_MONTH) {
            val selectedMonth: SelectedMonth? = data?.getParcelableExtra(AppConstants.SELECTED_MONTH)
            selectedMonth?.let {
                handler.postDelayed({
                    updateMonthDetails(selectedMonth)
                }, 1000)
            }
        } else if (requestCode == REQUEST_CODE_NEW_EXPENSE && resultCode == RESULT_CODE_NEW_EXPENSE) {
            data?.let { updateNewExpense(it.getParcelableExtra(AppConstants.EXPENSE_DATE)) }
        } else if (requestCode == REQUEST_CODE_UPDATE_BUDGET && resultCode == RESULT_CODE_UPDATE_BUDGET) {
            updateBudgetUpdate()
        }
    }

    private fun updateMonthDetails(selectedMonth: SelectedMonth) {
        mainViewModel.updateMonthDetails(selectedMonth.month, selectedMonth.year)
    }

    private fun updateSelectedMonth() {
        mActiveMonth?.let {
            binding.activeMonth = it
            expenseUpdateViewModel.updateMonth(it)
        }

    }

    private fun updateNewExpense(expenseDate: ExpenseDate) {
        expenseUpdateViewModel.updateNewExpense(expenseDate)
    }

    private fun updateBudgetUpdate() {
        expenseUpdateViewModel.updateBudget(true)
    }

    private fun navigateToCategories() {
        mActiveMonth?.let {
            val args = Bundle().apply { putLong(AppConstants.ACTIVE_MONTH_ID, it.id) }
            val intent = Intent(activity, CategoriesActivity::class.java).apply { putExtras(args) }
            startActivity(intent)
        }

    }

    private fun navigateToBudgetPlan() {
        mActiveMonth?.let {
            val args = Bundle().apply { putLong(AppConstants.ACTIVE_MONTH_ID, it.id) }
            val intent = Intent(activity, BudgetActivity::class.java).apply { putExtras(args) }
            startActivityForResult(intent, REQUEST_CODE_UPDATE_BUDGET)
        }
    }

    inner class ClickListener {
        fun onChangeMonthClick(view: View) {
            showMonthChangeBottomSheet()
        }
    }
}