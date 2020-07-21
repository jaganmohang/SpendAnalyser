package com.jagan.spendanalayser.data.db.dao

import androidx.room.*
import com.jagan.spendanalayser.data.db.entity.Budget
import com.jagan.spendanalayser.data.db.entity.BudgetMonth
import com.jagan.spendanalayser.model.BudgetItem

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
@Dao
interface BudgetDao {

    @Query("SELECT b.id, b.month, b.category_id AS categoryId, c.name AS categoryName, b.planned_amount AS plannedAmount FROM budget b, categories c WHERE b.month=:month AND b.category_id=c.id")
    suspend fun getBudget(month: Long): MutableList<BudgetItem>

    @Query("SELECT COUNT(id) FROM budget WHERE month=:month")
    suspend fun getBudgetCount(month: Long): Int

    @Query("SELECT planned_amount FROM budget WHERE category_id=:categoryId")
    suspend fun getPlannedAmount(categoryId: Long): Double

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertBudget(budget: Budget): Long

    @Update
    suspend fun updateBudget(budget: Budget)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertBudget(budgetList: MutableList<Budget>)

    @Update
    suspend fun updateBudget(budgetList: MutableList<Budget>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBudgetMonth(budgetMonth: BudgetMonth): Long

    @Query("SELECT id FROM budget_month WHERE month=:month AND year=:year")
    suspend fun getBudgetMonthId(month: Int, year: Int): Long

    @Query("SELECT COUNT(id) FROM budget_month WHERE month=:month AND year=:year")
    suspend fun getBudgetMonthCount(month: Int, year: Int): Int
}