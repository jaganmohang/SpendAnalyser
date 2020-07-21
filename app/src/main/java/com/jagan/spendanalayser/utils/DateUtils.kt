package com.jagan.spendanalayser.utils

import com.jagan.spendanalayser.model.DateItem
import com.jagan.spendanalayser.model.ExpenseDate
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.*


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
 * Created by jaganmohana on 2019-11-19.
 */
class DateUtils {
    companion object {
        private const val DATE_FORMAT = "dd-MMM-yyyy hh:mm a"
        private const val DATE_FORMAT_WITHOUT_TIME = "dd-MMM-yyyy"
        const val TODAY = "Today"
        const val YESTERDAY = "Yesterday"
        val months = arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")


        private fun getCalendar(): Calendar {
            return getInstance()
        }

        private fun currentDate(): String {
            return getCalendar()
                .let { SimpleDateFormat(DATE_FORMAT_WITHOUT_TIME, Locale.getDefault()).format(it.time) }
        }

        fun formatDate(): String {
            return formatDate(getCalendar().time)
        }

        fun formatDate(date: Date?): String {
            val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
            return date?.let {
                dateFormat.format(it)
            } ?: ""
        }

        fun getTimeFromDate(dateStr: String): String {
            return try {
                SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).parse(dateStr)?.let {
                    getCalendar().run {
                        time = it
                        val hour = this.get(Calendar.HOUR)
                        "${String.format("%02d", if (hour == 0) 12 else hour)}:${String.format(
                            "%02d",
                            this.get(Calendar.MINUTE)
                        )}${if (this.get(Calendar.AM_PM) == 1) " PM" else " AM"}"
                    }
                } ?: ""
            } catch (e: ParseException) {
                ""
            }
        }

        fun getDatesForMonth(month: Int, year: Int): MutableList<DateItem> {
            return getCalendar().run {
                val days = mutableListOf<DateItem>()
                fun displayedDate(nextDate: String) {
                    when {
                        isToday(nextDate) -> days.add(DateItem(nextDate, TODAY, true))
                        isYesterday(nextDate) -> days.add(DateItem(nextDate, YESTERDAY, false))
                        else -> days.add(DateItem(nextDate, nextDate, false))
                    }
                }
                set(YEAR, year)
                set(MONTH, month);
                set(DAY_OF_MONTH, 1);
                val maxDay = getActualMaximum(DAY_OF_MONTH)
                val firstDate = formatDate(time, DATE_FORMAT_WITHOUT_TIME)
                displayedDate(firstDate)
                for (i in 1 until maxDay) {
                    set(DAY_OF_MONTH, i + 1)
                    val nextDate = formatDate(time, DATE_FORMAT_WITHOUT_TIME)
                    displayedDate(nextDate)
                    if (isToday(nextDate))
                        break
                }
                if (year < getCurrentYear() || (year == getCurrentYear() && month < getCurrentMonth()))
                    days[days.size - 1].isSelected = true
                days
            }
        }

        private fun isYesterday(dateStr: String): Boolean {
            val yesterday = getCalendar().run {
                add(Calendar.DATE, -1)
                time
            }
            val yesterdayDate = parseDate(formatDate(yesterday, DATE_FORMAT_WITHOUT_TIME), DATE_FORMAT_WITHOUT_TIME)
            val selectedDate = parseDate(dateStr, DATE_FORMAT_WITHOUT_TIME)
            return if (yesterdayDate != null && selectedDate != null)
                yesterdayDate == selectedDate
            else
                false
        }

        fun isToday(dateStr: String): Boolean {
            val today = parseDate(currentDate(), DATE_FORMAT_WITHOUT_TIME)
            val selectedDate = parseDate(dateStr, DATE_FORMAT_WITHOUT_TIME)
            return if (today != null && selectedDate != null)
                today == selectedDate
            else
                false
        }

        private fun parseDate(dateStr: String, format: String): Date? {
            return try {
                SimpleDateFormat(format, Locale.getDefault()).parse(dateStr)
            } catch (e: ParseException) {
                null
            }
        }

        private fun formatDate(date: Date, format: String): String {
            return SimpleDateFormat(format, Locale.getDefault()).format(date)
        }

        fun readableDate(dateStr: String): String {
            return when {
                isToday(dateStr) -> TODAY
                isYesterday(dateStr) -> YESTERDAY
                else -> dateStr
            }
        }

        fun getMonths(year: Int): MutableList<DateItem> {
            val monthsList = mutableListOf<DateItem>()
            val currentMonth = getCalendar().get(MONTH)
            val currentYear = getCalendar().get(YEAR)
            for (i in 0 until months.size) {
                monthsList.add(DateItem(i.toString(), months[i], false, year < currentYear || i <= currentMonth))
            }
            return monthsList
        }

        fun getRecentYears(): List<DateItem> {
            val yearsList = mutableListOf<DateItem>()
            val currentYear = getCalendar().get(YEAR)
            yearsList.add(DateItem(currentYear.toString(), currentYear.toString(), false))
            for (i in 1 until 5) {
                val prevYear = currentYear - i
                yearsList.add(DateItem(prevYear.toString(), prevYear.toString(), false))
            }
            yearsList.sortBy { it.originalValue }
            return yearsList
        }

        fun getYearFromDate(date: String): Int {
            return parseDate(date, DATE_FORMAT)?.let {
                val calendar = getCalendar()
                calendar.time = it
                calendar.get(YEAR)
            } ?: 0
        }

        fun getMonthFromDate(date: String): Int {
            return parseDate(date, DATE_FORMAT)?.let {
                val calendar = getCalendar()
                calendar.time = it
                calendar.get(MONTH)
            } ?: 0
        }

        fun getYearFromDate(date: Date): Int {
            val calendar = getCalendar()
            calendar.time = date
            return calendar.get(YEAR)
        }

        fun getMonthFromDate(date: Date): Int {
            val calendar = getCalendar()
            calendar.time = date
            return calendar.get(MONTH)
        }

        fun parseExpenseDate(date: Date): ExpenseDate {
            val calendar = getCalendar()
            calendar.time = date
            return ExpenseDate(calendar.get(DAY_OF_MONTH), calendar.get(MONTH), calendar.get(YEAR))
        }

        fun parseExpenseDate(strDate: String): ExpenseDate {
            val calendar = getCalendar()
            calendar.time = parseDate(strDate, DATE_FORMAT_WITHOUT_TIME)
            return ExpenseDate(calendar.get(DAY_OF_MONTH), calendar.get(MONTH), calendar.get(YEAR))
        }

        fun strMonth(intMonth: Int): String {
            return months[intMonth]
        }

        fun getCurrentYear(): Int {
            return getCalendar().get(YEAR)
        }

        fun getCurrentMonth(): Int {
            return getCalendar().get(MONTH)
        }

        fun getCurrentDay(): Int {
            return getCalendar().get(DAY_OF_MONTH)
        }

        fun getLatestMonthInYear(year: Int): Int {
            return if (year < getCurrentYear()) Calendar.DECEMBER else getCurrentMonth()
        }

        fun getDate(month: Int, year: Int, min: Boolean): Date {
            return getCalendar().run {
                set(YEAR, year)
                set(MONTH, month)
                val day: Int = if (min) 1 else {
                    if (month == getCurrentMonth() && year == getCurrentYear()) getCurrentDay()
                    else getActualMaximum(DAY_OF_MONTH)
                }
                set(DAY_OF_MONTH, day)
                time
            }
        }
    }
}