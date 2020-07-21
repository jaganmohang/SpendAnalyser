package com.jagan.spendanalayser.ui.overview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jagan.spendanalayser.R
import com.jagan.spendanalayser.databinding.LayoutSpentListItemBinding
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
 * Created by jaganmohana on 2020-02-21.
 */
class CategorySpentAdapter(private val context: Context, private val mAllExpenses: MutableList<SpentAmount>) :
    RecyclerView.Adapter<CategorySpentAdapter.MyViewHolder>() {
    private val mInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutSpentListItemBinding = DataBindingUtil.inflate<LayoutSpentListItemBinding>(
            mInflater,
            R.layout.layout_spent_list_item,
            parent,
            false
        )
        return MyViewHolder(layoutSpentListItemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val spentAmount = mAllExpenses[position]
        holder.updateSpentAmount(spentAmount)
    }

    override fun getItemCount(): Int {
        return mAllExpenses.size
    }

    inner class MyViewHolder(private val layoutSpentListItemBinding: LayoutSpentListItemBinding) :
        RecyclerView.ViewHolder(layoutSpentListItemBinding.root) {

        fun updateSpentAmount(spentAmount: SpentAmount) {
            layoutSpentListItemBinding.spentAmount = spentAmount
        }
    }

    fun addAllExpenses(allExpenses: MutableList<SpentAmount>) {
        mAllExpenses.addAll(allExpenses)
        notifyDataSetChanged()
    }

    fun clear() {
        mAllExpenses.clear()
        notifyDataSetChanged()
    }
}