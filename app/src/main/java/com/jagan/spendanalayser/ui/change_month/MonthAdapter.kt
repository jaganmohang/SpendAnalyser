package com.jagan.spendanalayser.ui.change_month

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jagan.spendanalayser.R
import com.jagan.spendanalayser.databinding.LayoutMonthBinding
import com.jagan.spendanalayser.model.DateItem
import com.jagan.spendanalayser.ui.callbacks.OnDateSelector
import com.jagan.spendanalayser.utils.DateType

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
 * Created by jaganmohana on 2020-01-02.
 */
class MonthAdapter(
    private var mMonths: MutableList<DateItem>,
    private val mContext: Context,
    private val mDateSelector: OnDateSelector
) :
    RecyclerView.Adapter<MonthAdapter.MonthViewHolder>() {

    private var mInflater: LayoutInflater = LayoutInflater.from(mContext)
    private var previousSelectedPosition: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthViewHolder {
        val layoutDateBinding =
            DataBindingUtil.inflate<LayoutMonthBinding>(mInflater, R.layout.layout_month, parent, false)
        return MonthViewHolder(layoutDateBinding)
    }

    override fun onBindViewHolder(holder: MonthViewHolder, position: Int) {
        val date = mMonths[position]
        holder.update(date)//Binding selected date to layout

        //Change the state of month based on the status
        if (date.isSelected) holder.changeToSelected() else holder.changeToDefault()
        if (!date.isEnabled)
            holder.changeToDisabled()

        holder.layoutDateBinding.llDateItem.setOnClickListener {
            if (date.isSelected || !date.isEnabled) return@setOnClickListener

            //Clearing previous selected item state
            if (previousSelectedPosition != -1) {
                mMonths[previousSelectedPosition].isSelected = false
                notifyItemChanged(previousSelectedPosition)
            }

            //Changing the clicked month state to selected
            date.isSelected = true
            notifyItemChanged(holder.adapterPosition)
            previousSelectedPosition = position
            mDateSelector.onDateSelected(date, DateType.MONTH)
        }
    }

    override fun getItemCount(): Int {
        return mMonths.size
    }

    inner class MonthViewHolder(val layoutDateBinding: LayoutMonthBinding) :
        RecyclerView.ViewHolder(layoutDateBinding.root) {

        fun update(date: DateItem) {
            layoutDateBinding.dateItem = date
        }

        fun changeToDefault() {
            layoutDateBinding.tvDate.setTextColor(
                ContextCompat.getColor(mContext, R.color.colorBlack)
            )
            layoutDateBinding.tvDate.setBackgroundResource(R.drawable.month_bg_default)
        }

        fun changeToSelected() {
            layoutDateBinding.tvDate.setTextColor(
                ContextCompat.getColor(mContext, R.color.colorAccent)
            )
            layoutDateBinding.tvDate.setBackgroundResource(R.drawable.month_bg_selected)
        }

        fun changeToDisabled() {
            layoutDateBinding.tvDate.setTextColor(
                ContextCompat.getColor(mContext, R.color.colorLightGrey)
            )
        }
    }

    fun updateMonths(months: MutableList<DateItem>) {
        mMonths.addAll(months)
        notifyDataSetChanged()
    }

    fun updateSelectedPosition(month: Int) {
        for (i in 0 until mMonths.size) {
            val monthItem = mMonths[i]
            if (month == monthItem.originalValue.toInt()) {
                monthItem.isSelected = true
                previousSelectedPosition = i
                break
            }
        }
        notifyItemChanged(previousSelectedPosition)
    }

    fun reset() {
        mMonths.clear()
        previousSelectedPosition = -1
    }


}