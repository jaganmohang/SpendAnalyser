package com.jagan.spendanalayser.ui.spending

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jagan.spendanalayser.data.db.entity.Spend
import com.jagan.spendanalayser.data.repo.SpendRepo
import com.jagan.spendanalayser.ui.base.BaseViewModel
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
 * Created by jaganmohana on 8/20/19.
 */
class SpendingViewModel @Inject constructor(private val spendRepo: SpendRepo) : BaseViewModel() {
    val date: MutableLiveData<String> = MutableLiveData()

    private val expenses = MutableLiveData<MutableList<Spend>>()

    fun fetchExpenses(date: String) {
        viewModelScope.launch { expenses.postValue(spendRepo.getExpenses(date)) }
    }

    fun getExpenses(): LiveData<MutableList<Spend>> {
        return expenses
    }

    fun deleteExpense(spend: Spend) {
        viewModelScope.launch { spendRepo.deleteExpense(spend) }
    }
}