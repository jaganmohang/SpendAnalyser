package com.jagan.spendanalayser.ui.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jagan.spendanalayser.R
import com.jagan.spendanalayser.data.repo.SpendRepo
import com.jagan.spendanalayser.model.ActiveMonth
import com.jagan.spendanalayser.model.Impression
import com.jagan.spendanalayser.model.SpentAmount
import com.jagan.spendanalayser.model.SummaryInfo
import com.jagan.spendanalayser.ui.base.BaseViewModel
import com.jagan.spendanalayser.utils.DataConverter
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
class OverviewViewModel @Inject constructor(val spendRepo: SpendRepo) : BaseViewModel() {
    private val allExpenses = MutableLiveData<MutableList<SpentAmount>>()
    private val noDataAvailable = MutableLiveData<String>()

    fun fetchAllExpenses(activeMonth: ActiveMonth) {
        viewModelScope.launch {
            val allExpensesList = spendRepo.getAllExpenses(activeMonth.id)
            if (allExpensesList.isEmpty())
                updateNoDataAvailable()
            else
                allExpenses.postValue(allExpensesList)
        }
    }

    fun getAllExpenses(): LiveData<MutableList<SpentAmount>> {
        return allExpenses;
    }

    fun getNoDateAvailable(): LiveData<String> {
        return noDataAvailable;
    }

    private fun updateNoDataAvailable() {
        noDataAvailable.value = "No expenses available for selected month"
    }

    fun calculateTotal(allExpenses: MutableList<SpentAmount>): SummaryInfo {
        var planned = 0.0
        var spent = 0.0

        allExpenses.forEach {
            planned += it.plannedAmount
            spent += it.spentAmount
        }

        val difference = planned - spent
        val compare = spent.compareTo(planned)
        val impressionColor: Int
        val impression = when {
            compare > 0 -> {
                impressionColor = R.color.colorRed
                Impression.OVERSPEND
            }
            compare < 0 -> {
                impressionColor = R.color.colorGreen
                Impression.SAVED
            }
            else -> {
                impressionColor = R.color.colorOrange
                Impression.ON_CONTROL
            }
        }

        return SummaryInfo(
            DataConverter.convertToString(planned, true),
            DataConverter.convertToString(spent, true),
            DataConverter.convertToString(difference, true),
            impression,
            impressionColor
        )
    }
}