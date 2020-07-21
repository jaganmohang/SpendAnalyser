package com.jagan.spendanalayser.ui.budget

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jagan.spendanalayser.R
import com.jagan.spendanalayser.databinding.LayoutBudgetItemBinding
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
 * Created by jaganmohana on 2020-06-19.
 */
class BudgetAdapter(
        mContext: Context,
        private var mBudget: MutableList<BudgetItem>
) : RecyclerView.Adapter<BudgetAdapter.BudgetViewHolder>() {

    private var mInflater: LayoutInflater = LayoutInflater.from(mContext)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BudgetViewHolder {
        val categoryItemBinding =
                DataBindingUtil.inflate<LayoutBudgetItemBinding>(
                        mInflater,
                        R.layout.layout_budget_item,
                        parent,
                        false
                )
        return BudgetViewHolder(categoryItemBinding)
    }

    override fun getItemCount(): Int {
        return mBudget.size
    }

    override fun onBindViewHolder(holder: BudgetViewHolder, position: Int) {
        val budget = mBudget[position]
        holder.layoutBudgetItemBinding.budget = budget
        holder.layoutBudgetItemBinding.etPlannedAmount.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                mBudget[holder.adapterPosition].plannedAmount = if (s != null && s.isNotEmpty()) s.toString() else "0.0"
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
        holder.layoutBudgetItemBinding.etPlannedAmount.setSelection(holder.layoutBudgetItemBinding.etPlannedAmount.text?.length
                ?: 0)
    }

    inner class BudgetViewHolder(
            val layoutBudgetItemBinding: LayoutBudgetItemBinding
    ) : RecyclerView.ViewHolder(layoutBudgetItemBinding.root)

    fun updateBudget(budget: MutableList<BudgetItem>) {
        if (mBudget.isNotEmpty())
            mBudget.clear()
        mBudget.addAll(budget)
        notifyDataSetChanged()
    }
}