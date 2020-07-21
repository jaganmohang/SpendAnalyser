package com.jagan.spendanalayser.ui.categories

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jagan.spendanalayser.R
import com.jagan.spendanalayser.data.db.entity.Category
import com.jagan.spendanalayser.databinding.CategoryItemLayoutBinding

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
 * Created by jaganmohana on 2020-06-05.
 */
class CategoryAdapter(
    mContext: Context,
    private var mCategories: MutableList<Category>,
    private var listener: (category: Category) -> Unit
) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private var mInflater: LayoutInflater = LayoutInflater.from(mContext)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val categoryItemBinding =
            DataBindingUtil.inflate<CategoryItemLayoutBinding>(
                mInflater,
                R.layout.category_item_layout,
                parent,
                false
            )
        return CategoryViewHolder(categoryItemBinding)
    }

    override fun getItemCount(): Int {
        return mCategories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = mCategories[position]
        holder.categoryItemBinding.category = category
        holder.categoryItemBinding.categoryItemView.setOnClickListener { listener(category) }
    }

    inner class CategoryViewHolder(val categoryItemBinding: CategoryItemLayoutBinding) :
        RecyclerView.ViewHolder(categoryItemBinding.root) {

    }

    fun updateCategories(categories: MutableList<Category>) {
        if (!mCategories.isEmpty())
            mCategories.clear()
        mCategories.addAll(categories)
        notifyDataSetChanged()
    }

}