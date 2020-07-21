package com.jagan.spendanalayser.utils

import java.util.*

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
 * Created by jaganmohana on 2019-11-27.
 */
class DataConverter {
    companion object {

        @JvmStatic
        fun convertToString(double: Double?, displayCurrency: Boolean): String {
            val amount = double?.let {
                String.format("%.2f", it)
            } ?: "0.00"

            return if (displayCurrency) String.format("\u20B9%s", amount) else amount
        }

        @JvmStatic
        fun formatAmount(double: Double?): String {
            return double?.let {
                String.format("%.2f", it)
            } ?: "0.00"
        }

        @JvmStatic
        fun timeFromDate(date: String): String {
            return DateUtils.getTimeFromDate(date)
        }
    }

}