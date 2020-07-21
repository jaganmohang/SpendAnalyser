package com.jagan.spendanalayser.ui.change_month

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jagan.spendanalayser.R
import com.jagan.spendanalayser.databinding.LayoutYearBinding
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
class YearAdapter(
    private var mYears: List<DateItem>,
    private val mContext: Context,
    private val mDateSelector: OnDateSelector
) :
    RecyclerView.Adapter<YearAdapter.YearViewModel>() {

    private var mInflater: LayoutInflater = LayoutInflater.from(mContext)
    private var previousSelectedPosition: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YearViewModel {
        val layoutYearBinding =
            DataBindingUtil.inflate<LayoutYearBinding>(mInflater, R.layout.layout_year, parent, false)
        return YearViewModel(layoutYearBinding)
    }

    override fun onBindViewHolder(holder: YearViewModel, position: Int) {
        val date = mYears[position]
        holder.update(date)
        if (date.isSelected) holder.changeToSelected() else holder.changeToDefault()
        holder.layoutYearBinding.llDateItem.setOnClickListener {
            if (date.isSelected) return@setOnClickListener
            date.isSelected = true
            if (previousSelectedPosition != -1) {
                mYears[previousSelectedPosition].isSelected = false
                notifyItemChanged(previousSelectedPosition)
            }
            previousSelectedPosition = position
            notifyItemChanged(holder.adapterPosition)
            mDateSelector.onDateSelected(date, DateType.YEAR)
        }
    }

    override fun getItemCount(): Int {
        return mYears.size
    }

    inner class YearViewModel(val layoutYearBinding: LayoutYearBinding) :
        RecyclerView.ViewHolder(layoutYearBinding.root) {
        fun update(date: DateItem) {
            layoutYearBinding.dateItem = date
        }

        fun changeToDefault() {
            layoutYearBinding.tvYear.setTextColor(ContextCompat.getColor(mContext, R.color.colorBlack))
        }

        fun changeToSelected() {
            layoutYearBinding.tvYear.setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent))
        }
    }

    fun addDates(dates: List<DateItem>) {
        mYears = dates
        notifyDataSetChanged()
    }

    fun updateSelectedPosition(year: Int) {
        for (i in 0 until mYears.size) {
            val yearItem = mYears[i];
            if (year == yearItem.originalValue.toInt()) {
                yearItem.isSelected = true
                previousSelectedPosition = i
                break
            }
        }
        notifyItemChanged(previousSelectedPosition)
    }

    fun clear() {
    }
}