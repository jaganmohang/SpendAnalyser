package com.jagan.spendanalayser.ui.change_month

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.jagan.spendanalayser.R
import com.jagan.spendanalayser.constants.AppConstants
import com.jagan.spendanalayser.constants.AppConstants.Companion.RESULT_CODE_CHANGE_MONTH
import com.jagan.spendanalayser.databinding.ChangeMonthLayoutBinding
import com.jagan.spendanalayser.di.Injectable
import com.jagan.spendanalayser.model.DateItem
import com.jagan.spendanalayser.model.SelectedMonth
import com.jagan.spendanalayser.ui.callbacks.OnDateSelector
import com.jagan.spendanalayser.utils.DateType
import com.jagan.spendanalayser.utils.DateUtils
import com.jagan.spendanalayser.utils.autoCleared
import javax.inject.Inject

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
 * Created by jaganmohana on 2020-01-02.
 */
class ChangeMonthBottomSheet : BottomSheetDialogFragment(), Injectable, OnDateSelector {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val changeMonthViewModel: ChangeMonthViewModel by viewModels { viewModelFactory }

    private var changeMonthBinding by autoCleared<ChangeMonthLayoutBinding>()

    private lateinit var monthAdapter: MonthAdapter
    private lateinit var yearAdapter: YearAdapter

    private lateinit var activeYears: List<DateItem>
    private lateinit var selectedMonth: SelectedMonth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activeYears = DateUtils.getRecentYears()
        selectedMonth = arguments?.getParcelable(AppConstants.SELECTED_MONTH) ?: SelectedMonth(
            DateUtils.getCurrentMonth(),
            DateUtils.getCurrentYear()
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val databinding =
            DataBindingUtil.inflate<ChangeMonthLayoutBinding>(
                inflater,
                R.layout.change_month_layout,
                container,
                false
            )
        databinding.lifecycleOwner = viewLifecycleOwner
        changeMonthBinding = databinding

        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeMonthBinding.monthHandler = MonthHandler()
        initUI()
    }

    private fun initUI() {
        initYears()
    }

    private fun initYears() {
        yearAdapter = YearAdapter(activeYears, context!!, this)
        val yearLayoutManager: LinearLayoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        changeMonthBinding.rvYears.layoutManager = yearLayoutManager
        changeMonthBinding.rvYears.adapter = yearAdapter
        yearAdapter.updateSelectedPosition(selectedMonth.year)

        initMonths()
    }

    private fun initMonths() {
        monthAdapter = MonthAdapter(DateUtils.getMonths(selectedMonth.year), context!!, this)
        val monthLayoutManger: GridLayoutManager = GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)
        changeMonthBinding.rvMonths.layoutManager = monthLayoutManger
        changeMonthBinding.rvMonths.adapter = monthAdapter
        updateSelectedMonth()
    }

    override fun onDateSelected(date: DateItem, type: DateType) {
        if (type == DateType.MONTH) {
            selectedMonth.month = date.originalValue.toInt()
        } else {
            selectedMonth.year = date.originalValue.toInt()
            updateMonths(selectedMonth.year)
        }
    }

    private fun updateMonths(year: Int) {
        monthAdapter.reset()
        monthAdapter.updateMonths(DateUtils.getMonths(year))
        selectedMonth.month = DateUtils.getLatestMonthInYear(year)
        updateSelectedMonth()

    }


    private fun updateSelectedMonth() {
        monthAdapter.updateSelectedPosition(selectedMonth.month)
    }

    inner class MonthHandler {
        fun onChangeMonthClick(view: View) {
            changeMonthViewModel.insertBudgetMonth(selectedMonth.month, selectedMonth.year)
            sendSelectedMonthResult(RESULT_CODE_CHANGE_MONTH)
        }

        fun onCancelClick(view: View) {
            sendSelectedMonthResult(Activity.RESULT_CANCELED)
        }
    }

    private fun sendSelectedMonthResult(resultCode: Int) {
        val intent = Intent().apply { putExtra(AppConstants.SELECTED_MONTH, selectedMonth) }
        targetFragment?.onActivityResult(targetRequestCode, resultCode, intent);
        dismissBottomSheet()
    }


    private fun dismissBottomSheet() {
        this.dismiss()
    }

    companion object {
        val TAG: String = ChangeMonthBottomSheet::class.java.simpleName
        @JvmStatic
        fun newInstance(args: Bundle?) = ChangeMonthBottomSheet().apply { arguments = args }
    }
}