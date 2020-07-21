package com.jagan.spendanalayser.data.repo

import com.jagan.spendanalayser.data.db.dao.SpendDao
import com.jagan.spendanalayser.data.db.entity.Spend
import com.jagan.spendanalayser.model.SpentAmount
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
 * Created by jaganmohana on 2019-11-07.
 */
class SpendRepo @Inject constructor(
    private val spendDao: SpendDao
) {

    suspend fun addExpense(expense: Spend) {
        spendDao.insertExpense(expense)
    }

    suspend fun deleteExpense(spend: Spend) {
        spendDao.deleteExpense(spend)
    }

    suspend fun getExpenses(date: String): MutableList<Spend> {
        return spendDao.getExpensesByDate("$date%")
    }

    suspend fun getActiveYears(): List<String> {
        return spendDao.getActiveYears()
    }

    suspend fun getAllExpenses(month: Long): MutableList<SpentAmount> {
        return spendDao.getAllExpenses(month)
    }
}