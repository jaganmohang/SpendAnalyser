package com.jagan.spendanalayser.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jagan.spendanalayser.data.db.dao.BudgetDao
import com.jagan.spendanalayser.data.db.dao.CategoryDao
import com.jagan.spendanalayser.data.db.dao.SpendDao
import com.jagan.spendanalayser.data.db.entity.Budget
import com.jagan.spendanalayser.data.db.entity.BudgetMonth
import com.jagan.spendanalayser.data.db.entity.Category
import com.jagan.spendanalayser.data.db.entity.Spend

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
@Database(
    entities = [Category::class, Spend::class, Budget::class, BudgetMonth::class],
    version = 1,
    exportSchema = false
)
abstract class SpendAnalyserDB : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
    abstract fun spendDao(): SpendDao
    abstract fun budgetDao(): BudgetDao

    companion object {
        const val DB_NAME = "expense_analyser.db"
        /*@Volatile
        private var INSTANCE: SpendAnalyserDB? = null

        fun getInstance(context: Context): SpendAnalyserDB =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        SpendAnalyserDB::class.java, DB_NAME)
                        .build()*/
    }
}