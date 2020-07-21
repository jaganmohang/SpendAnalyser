package com.jagan.spendanalayser.ui

import androidx.lifecycle.MutableLiveData
import com.jagan.spendanalayser.model.ExpenseDate
import com.jagan.spendanalayser.model.ActiveMonth
import com.jagan.spendanalayser.ui.base.BaseViewModel
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
 * Created by jaganmohana on 2020-03-03.
 */
class ExpenseUpdateViewModel @Inject constructor() : BaseViewModel() {
    val newExpenseLiveData = MutableLiveData<ExpenseDate>()
    val monthUpdateLiveData = MutableLiveData<ActiveMonth>()
    val budgetUpdateLiveData = MutableLiveData<Boolean>()

    fun updateNewExpense(expenseDate: ExpenseDate) {
        newExpenseLiveData.value = expenseDate
    }

    fun updateMonth(month: ActiveMonth) {
        monthUpdateLiveData.value = month
    }

    fun updateBudget(budgetUpdated: Boolean) {
        budgetUpdateLiveData.value = budgetUpdated
    }
}