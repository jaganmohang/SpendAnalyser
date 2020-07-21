package com.jagan.spendanalayser.ui.newspend

import androidx.lifecycle.*
import com.jagan.spendanalayser.data.db.entity.Category
import com.jagan.spendanalayser.data.db.entity.Spend
import com.jagan.spendanalayser.data.repo.CategoryRepo
import com.jagan.spendanalayser.data.repo.SpendRepo
import com.jagan.spendanalayser.ui.base.BaseViewModel
import com.jagan.spendanalayser.utils.CommonUtils
import kotlinx.coroutines.launch
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
class NewExpenseViewModel @Inject constructor(
    private val categoryRepo: CategoryRepo,
    private val spendRepo: SpendRepo
) : BaseViewModel() {

    val categories = MutableLiveData<List<Category>>()
    val expenseAmount = MutableLiveData<String>()
    val expenseDescription = MutableLiveData<String>()
    val expenseCategory = MutableLiveData<Category>();
    val expenseTime = MutableLiveData<String>();
    val expenseMonth = MutableLiveData<Long>();
    private val spend = MediatorLiveData<Spend>().apply {
        addSource(expenseTime) { time ->
            time?.let {
                value?.time = it //Updating expense time
                value = value   //Updating spend live data with updated expense
            }
        }
        addSource(expenseMonth) { month ->
            month?.let {
                value?.month = it //Updating expense month
                value = value   //Updating spend live data with updated expense
            }
        }
        addSource(expenseCategory) { category ->
            category?.let {
                value?.categoryId = it.id
                value = value
            }
        }
        addSource(expenseAmount) { amount ->
            amount?.let {
                value?.amount = if (!CommonUtils.isStringEmpty(it)) it.toDouble() else 0.0
                value = value
            }
        }
        addSource(expenseDescription) { description ->
            description?.let {
                value?.description = it
                value = value
            }
        }
    }

    init {
        spend.value = Spend.createEmpty()
        viewModelScope.launch {
            categories.postValue(categoryRepo.getCategories())
        }
    }

    val expenseCategoryTitle = Transformations.map(expenseCategory) { category -> category?.name }

    val enableExpenseButton: LiveData<Boolean> = Transformations.map(spend) {
        it?.isValid() ?: false
    }

    fun addExpense() {
        viewModelScope.launch {
            spend.value?.let {
                if (it.isValid()) spendRepo.addExpense(it)
            }
        }
    }
}