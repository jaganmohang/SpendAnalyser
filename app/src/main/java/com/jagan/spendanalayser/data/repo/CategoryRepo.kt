package com.jagan.spendanalayser.data.repo

import com.jagan.spendanalayser.data.db.dao.BudgetDao
import com.jagan.spendanalayser.data.db.dao.CategoryDao
import com.jagan.spendanalayser.data.db.entity.Budget
import com.jagan.spendanalayser.data.db.entity.Category
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
class CategoryRepo @Inject constructor(
    private val categoryDao: CategoryDao, private val budgetDao: BudgetDao
) {

    suspend fun insertCategories(): LongArray {
        val categories = mutableListOf<Category>().apply {
            add(Category(name = "Food", imageUrl = null))
            add(Category(name = "House Rent", imageUrl = null))
            add(Category(name = "Shopping", imageUrl = null))
            add(Category(name = "Entertainment", imageUrl = null))
            add(Category(name = "Travel", imageUrl = null))
            add(Category(name = "Education", imageUrl = null))
            add(Category(name = "Utility Bills", imageUrl = null))
            add(Category(name = "Miscellaneous", imageUrl = null))
        }
        if (categoryDao.getCategoriesCount() <= 0)
            return categoryDao.insert(categories)
        return LongArray(0);
    }

    suspend fun getCategories(): MutableList<Category> {
        return categoryDao.getCategories()
    }

    suspend fun addCategory(month: Long, categoryTitle: String) {
        val insertedId = categoryDao.insert(Category(name = categoryTitle, imageUrl = null))
        budgetDao.insertBudget(Budget(month = month, categoryId = insertedId, plannedAmount = 0.0))
    }
}
