package com.jagan.spendanalayser.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.jagan.spendanalayser.utils.CommonUtils

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
@Entity(
    tableName = "expenses"
)
data class Spend(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "category_id") var categoryId: Long,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "amount") var amount: Double,
    @ColumnInfo(name = "time") var time: String,
    @ColumnInfo(name = "month") var month: Long
) {
    @Ignore
    var categoryName: String? = null

    companion object {
        fun createEmpty(): Spend {
            return Spend(categoryId = 0, description = "", amount = 0.0, time = "", month = 0)
        }
    }

    @Ignore
    fun isValid(): Boolean {
        return categoryId != 0L && amount != 0.0 && !CommonUtils.isStringEmpty(time)
    }
}