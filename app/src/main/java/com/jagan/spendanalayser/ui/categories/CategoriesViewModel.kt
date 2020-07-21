package com.jagan.spendanalayser.ui.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jagan.spendanalayser.data.db.entity.Category
import com.jagan.spendanalayser.data.repo.CategoryRepo
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
class CategoriesViewModel @Inject constructor(
        private val categoryRepo: CategoryRepo
) : BaseViewModel() {
    private val categoriesLiveData = MutableLiveData<MutableList<Category>>()

    init {
        fetchCategories()
    }

    fun fetchCategories() {
        viewModelScope.launch {
            val categories = categoryRepo.getCategories()
            categoriesLiveData.postValue(categories)
        }
    }

    fun categories(): LiveData<MutableList<Category>> {
        return categoriesLiveData
    }

}