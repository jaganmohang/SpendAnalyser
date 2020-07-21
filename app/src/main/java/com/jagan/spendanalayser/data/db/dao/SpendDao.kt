package com.jagan.spendanalayser.data.db.dao

import androidx.room.*
import com.jagan.spendanalayser.data.db.entity.Spend
import com.jagan.spendanalayser.model.SpentAmount

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
@Dao
interface SpendDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertExpense(spend: Spend);

    @Query("SELECT * FROM expenses WHERE  time LIKE :date ORDER BY id DESC")
    suspend fun getExpenses(date: String): MutableList<Spend>

    @Query("SELECT name FROM categories WHERE  id =:categoryId")
    suspend fun getCategoryName(categoryId: Long): String

    @Transaction
    suspend fun getExpensesByDate(date: String): MutableList<Spend> {
        val expenses = getExpenses(date)
        expenses.forEach {
            val categoryName = getCategoryName(it.categoryId)
            it.categoryName = categoryName
        }
        return expenses
    }

    @Query("SELECT DISTINCT substr(time,-7,4) FROM expenses")
    suspend fun getActiveYears(): List<String>

    @Query("SELECT e.category_id AS categoryId, c.name AS categoryName, SUM(e.amount) AS spentAmount, b.planned_amount AS plannedAmount FROM expenses e, categories c, budget b WHERE e.month =:month AND e.category_id = c.id AND b.month = e.month AND b.category_id = e.category_id GROUP BY e.category_id")
    suspend fun getAllExpenses(month: Long): MutableList<SpentAmount>

    @Delete
    suspend fun deleteExpense(spend: Spend)
}