package com.jagan.spendanalayser.ui.spending

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jagan.spendanalayser.R
import com.jagan.spendanalayser.data.db.entity.Spend
import com.jagan.spendanalayser.databinding.ExpenseItemLayoutBinding

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
 * Created by jaganmohana on 2019-11-26.
 */
class SpendAdapter(private var mExpenses: MutableList<Spend>, mContext: Context,
                   private val listener: (position: Int, spend: Spend) -> Unit) :
        RecyclerView.Adapter<SpendAdapter.SpendViewModel>() {

    private var mInflater: LayoutInflater = LayoutInflater.from(mContext)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpendViewModel {
        val expenseItemBinding =
                DataBindingUtil.inflate<ExpenseItemLayoutBinding>(mInflater, R.layout.expense_item_layout, parent, false)
        return SpendViewModel(expenseItemBinding)
    }

    override fun getItemCount(): Int {
        return mExpenses.size
    }

    override fun onBindViewHolder(holder: SpendViewModel, position: Int) {
        val spend = mExpenses[position]
        holder.update(spend)
        holder.expenseItemLayoutBinding.ibDelete.setOnClickListener { listener(holder.adapterPosition, spend) }
    }

    inner class SpendViewModel(val expenseItemLayoutBinding: ExpenseItemLayoutBinding) :
            RecyclerView.ViewHolder(expenseItemLayoutBinding.root) {
        fun update(spend: Spend) {
            expenseItemLayoutBinding.expense = spend
        }
    }

    fun addExpenses(expenses: MutableList<Spend>) {
        mExpenses = expenses
        notifyDataSetChanged()
    }

    fun clear() {
        mExpenses.clear()
    }

    fun removeExpense(position: Int) {
        mExpenses.removeAt(position)
        notifyItemRemoved(position)
    }
}