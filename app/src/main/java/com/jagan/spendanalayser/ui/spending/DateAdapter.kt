package com.jagan.spendanalayser.ui.spending

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jagan.spendanalayser.R
import com.jagan.spendanalayser.databinding.LayoutDateBinding
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
 * Created by jaganmohana on 2019-12-30.
 */
class DateAdapter(
    private var mDates: MutableList<DateItem>,
    private val mContext: Context,
    private val mDateSelector: OnDateSelector
) :
    RecyclerView.Adapter<DateAdapter.DateViewModel>() {

    private var mInflater: LayoutInflater = LayoutInflater.from(mContext)
    private var previousSelectedPosition: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewModel {
        val layoutDateBinding =
            DataBindingUtil.inflate<LayoutDateBinding>(mInflater, R.layout.layout_date, parent, false)
        return DateViewModel(layoutDateBinding)
    }

    override fun onBindViewHolder(holder: DateViewModel, position: Int) {
        val date = mDates[position]
        holder.update(date)
        if (date.isSelected) holder.changeToSelected() else holder.changeToDefault()
        holder.layoutDateBinding.llDateItem.setOnClickListener {
            if (date.isSelected) return@setOnClickListener
            date.isSelected = true
            if (previousSelectedPosition != -1) {
                mDates[previousSelectedPosition].isSelected = false
                notifyItemChanged(previousSelectedPosition)
            }
            previousSelectedPosition = position
            notifyItemChanged(holder.adapterPosition)
            mDateSelector.onDateSelected(date, DateType.DATE)
        }
    }

    override fun getItemCount(): Int {
        return mDates.size
    }

    inner class DateViewModel(val layoutDateBinding: LayoutDateBinding) :
        RecyclerView.ViewHolder(layoutDateBinding.root) {
        fun update(date: DateItem) {
            layoutDateBinding.dateItem = date
        }

        fun changeToDefault() {
            layoutDateBinding.tvDate.setTextColor(ContextCompat.getColor(mContext, R.color.colorBlack))
            layoutDateBinding.tvDate.setBackgroundResource(R.drawable.date_bg_default)
        }

        fun changeToSelected() {
            layoutDateBinding.tvDate.setTextColor(ContextCompat.getColor(mContext, R.color.colorWhite))
            layoutDateBinding.tvDate.setBackgroundResource(R.drawable.date_bg_selected)
        }
    }

    fun updateDates(dates: MutableList<DateItem>) {
        mDates.clear()
        mDates.addAll(dates)
        notifyDataSetChanged()
    }

    fun updateSelectedPosition() {
        previousSelectedPosition = mDates.size - 1
    }
}
