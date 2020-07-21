package com.jagan.spendanalayser.ui.newspend

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.jagan.spendanalayser.R
import com.jagan.spendanalayser.constants.AppConstants
import com.jagan.spendanalayser.constants.AppConstants.Companion.NEW_CATEGORY
import com.jagan.spendanalayser.constants.AppConstants.Companion.REQUEST_CODE_SELECT_CATEGORY
import com.jagan.spendanalayser.constants.AppConstants.Companion.RESULT_CODE_NEW_EXPENSE
import com.jagan.spendanalayser.constants.AppConstants.Companion.RESULT_CODE_SELECT_CATEGORY
import com.jagan.spendanalayser.constants.AppConstants.Companion.SELECTED_CATEGORY
import com.jagan.spendanalayser.data.db.entity.Category
import com.jagan.spendanalayser.databinding.AddExpenseLayoutBinding
import com.jagan.spendanalayser.di.Injectable
import com.jagan.spendanalayser.model.ActiveMonth
import com.jagan.spendanalayser.ui.categories.CategoriesActivity
import com.jagan.spendanalayser.utils.DateUtils
import com.jagan.spendanalayser.utils.autoCleared
import com.kunzisoft.switchdatetime.SwitchDateTimeDialogFragment
import java.text.SimpleDateFormat
import java.util.*
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
 * Created by jaganmohana on 2019-11-18.
 */
class NewExpenseBottomSheet : BottomSheetDialogFragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: NewExpenseViewModel by viewModels { viewModelFactory }

    private var newExpenseBinding by autoCleared<AddExpenseLayoutBinding>()

    private var selectedCategory: Category? = null

    private lateinit var datetimePicker: SwitchDateTimeDialogFragment
    private lateinit var minDate: Date
    private lateinit var maxDate: Date
    private lateinit var selectedDate: Date
    private lateinit var activeMonth: ActiveMonth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            activeMonth = it.getParcelable(AppConstants.ACTIVE_MONTH)
        }
        getMinMaxDates()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val databinding =
            DataBindingUtil.inflate<AddExpenseLayoutBinding>(
                inflater,
                R.layout.add_expense_layout,
                container,
                false
            )
        databinding.lifecycleOwner = viewLifecycleOwner
        databinding.expenseViewModel = viewModel
        newExpenseBinding = databinding

        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newExpenseBinding.expenseHandler = ExpenseHandler()
        initUI()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        registerObservers()
        updateSelectedMonthId()
    }

    private fun initUI() {
        datetimePicker = SwitchDateTimeDialogFragment.newInstance(
            getString(R.string.label_expense_time), getString(R.string.label_ok), getString(R.string.label_cancel)
        ).apply {
            minimumDateTime = minDate
            maximumDateTime = maxDate
            selectedDate = maxDate
            setDefaultDateTime(selectedDate)
            simpleDateMonthAndDayFormat = SimpleDateFormat("dd MMM", Locale.getDefault())

            setOnButtonClickListener(object : SwitchDateTimeDialogFragment.OnButtonClickListener {
                override fun onPositiveButtonClick(date: Date) {
                    selectedDate = date
                    updateSelectedDate()
                }

                override fun onNegativeButtonClick(date: Date) {
                    selectedDate = date
                    updateSelectedDate()
                }
            })
        }
        updateSelectedDate()
    }

    private fun registerObservers() {
        viewModel.categories.observe(viewLifecycleOwner, this::updateCategories)
    }

    private fun updateSelectedMonthId() {
        viewModel.expenseMonth.value = activeMonth.id
    }

    private fun updateSelectedCategory(category: Category) {
        selectedCategory = category
        updateSelectedCategory()
    }

    private fun updateCategories(categories: List<Category>?) {
        categories?.forEachIndexed { index, category ->
            if (index == 0) {
                selectedCategory = category
                updateSelectedCategory()
                return@forEachIndexed
            }
        }

    }

    inner class ExpenseHandler {
        fun onAddClick(view: View) {
            addExpense()
            sendNewExpenseResult(RESULT_CODE_NEW_EXPENSE)
        }

        fun onCancelClick(view: View) {
            dismissBottomSheet()
        }

        fun onDateClick(view: View) {
            showDatePicker()
        }

        fun onShowCategoriesClick(view: View) {
            navigateToCategories()
        }
    }

    private fun addExpense() {
        viewModel.addExpense()
    }

    private fun showDatePicker() {
        datetimePicker.startAtCalendarView()
        datetimePicker.show(childFragmentManager, "dialog_time")
    }

    private fun updateSelectedDate() {
        viewModel.expenseTime.value = DateUtils.formatDate(selectedDate)
    }

    private fun updateSelectedCategory() {
        viewModel.expenseCategory.value = selectedCategory
    }

    private fun dismissBottomSheet() {
        this.dismiss()
    }

    private fun sendNewExpenseResult(resultCode: Int) {
        val expenseDate = DateUtils.parseExpenseDate(selectedDate)
        val data: Intent = Intent().apply { putExtra(AppConstants.EXPENSE_DATE, expenseDate) }
        targetFragment?.onActivityResult(targetRequestCode, resultCode, data);
        dismissBottomSheet()
    }

    private fun navigateToCategories() {
        val intent = Intent(activity, CategoriesActivity::class.java).apply { putExtra(NEW_CATEGORY, true) }
        startActivityForResult(intent, REQUEST_CODE_SELECT_CATEGORY)
    }

    private fun getMinMaxDates() {
        minDate = DateUtils.getDate(activeMonth.month, activeMonth.year, true)
        maxDate = DateUtils.getDate(activeMonth.month, activeMonth.year, false)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SELECT_CATEGORY && resultCode == RESULT_CODE_SELECT_CATEGORY) {
            data?.let { updateSelectedCategory(data.getParcelableExtra(SELECTED_CATEGORY)) }
        }
    }

    companion object {
        const val TAG: String = "NewExpenseBottomSheet"
        @JvmStatic
        fun newInstance(args: Bundle?) = NewExpenseBottomSheet().apply { arguments = args }
    }
}