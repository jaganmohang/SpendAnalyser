package com.jagan.spendanalayser.data.repo

import com.jagan.spendanalayser.data.db.dao.BudgetDao
import com.jagan.spendanalayser.data.db.dao.CategoryDao
import com.jagan.spendanalayser.data.db.entity.Budget
import com.jagan.spendanalayser.data.db.entity.BudgetMonth
import com.jagan.spendanalayser.model.BudgetItem
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
 * Created by jaganmohana on 2020-06-22.
 */
class BudgetRepo @Inject constructor(private val budgetDao: BudgetDao, private val categoryDao: CategoryDao) {

    suspend fun addBudgetMonth(month: Int, year: Int): Long {
        return if (budgetDao.getBudgetMonthCount(month, year) < 1)
            budgetDao.insertBudgetMonth(BudgetMonth(month = month, year = year))
        else budgetDao.getBudgetMonthId(month, year)
    }

    suspend fun addOrUpdateBudget(month: Long) {
        //Inserting/Updating budget
        val existingBudget = budgetDao.getBudget(month)
        val newBudget = mutableListOf<Budget>()

        val categories = categoryDao.getCategories()
        if (existingBudget.isEmpty()) {
            categories.forEach {
                newBudget.add(Budget(month = month, categoryId = it.id, plannedAmount = 0.0))
            }
        } else if (categories.size > existingBudget.size) {
            categoryLoop@ for (category in categories) {
                var notFound = true
                budgetLoop@ for (budgetItem in existingBudget) {
                    if (category.id == budgetItem.categoryId) {
                        notFound = false
                        break@budgetLoop
                    }
                }
                if (notFound) newBudget.add(Budget(month = month, categoryId = category.id, plannedAmount = 0.0))
            }
        }
        if (newBudget.isNotEmpty())
            budgetDao.insertBudget(newBudget)
    }

    suspend fun updateBudget(budgetList: MutableList<Budget>) {
        budgetDao.updateBudget(budgetList)
    }

    suspend fun getActiveBudget(month: Long): MutableList<BudgetItem> {
        return budgetDao.getBudget(month)
    }

    suspend fun getMonthId(month: Int, year: Int): Long {
        return budgetDao.getBudgetMonthId(month, year)
    }
}