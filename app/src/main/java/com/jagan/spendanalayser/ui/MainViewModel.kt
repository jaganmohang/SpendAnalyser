package com.jagan.spendanalayser.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jagan.spendanalayser.data.repo.BudgetRepo
import com.jagan.spendanalayser.data.repo.CategoryRepo
import com.jagan.spendanalayser.model.ActiveMonth
import com.jagan.spendanalayser.ui.base.BaseViewModel
import com.jagan.spendanalayser.utils.DateUtils
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
 * Created by jaganmohana on 2019-11-20.
 */
class MainViewModel @Inject constructor(
    private val categoryRepo: CategoryRepo,
    private val budgetRepo: BudgetRepo
) : BaseViewModel() {

    private val initialDataLoad = MutableLiveData<Boolean>()
    private val monthDetails = MutableLiveData<Pair<Int, Int>>()
    private val activeMonth: MediatorLiveData<ActiveMonth> = MediatorLiveData<ActiveMonth>().apply {
        addSource(monthDetails) {
            viewModelScope.launch {
                val monthId = budgetRepo.getMonthId(it.first, it.second)
                value = ActiveMonth(monthId, it.first, it.second)
            }
        }
    }

    init {
        setUpInitialData()
    }

    fun updateMonthDetails(month: Int, year: Int) {
        monthDetails.value = Pair(month, year)
    }

    fun getActiveMonth(): LiveData<ActiveMonth> {
        return activeMonth
    }

    fun getInitialDataLoad(): LiveData<Boolean> {
        return initialDataLoad
    }

    private fun setUpInitialData() {
        viewModelScope.launch {
            categoryRepo.insertCategories()
            budgetRepo.addBudgetMonth(DateUtils.getCurrentMonth(), DateUtils.getCurrentYear())
            initialDataLoad.value = true
        }
    }
}