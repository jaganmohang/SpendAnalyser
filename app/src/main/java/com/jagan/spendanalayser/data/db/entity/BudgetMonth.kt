package com.jagan.spendanalayser.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

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
 * Created by jaganmohana on 2020-06-24.
 */
@Entity(
    tableName = "budget_month",
    indices = [Index(value = ["month", "year"], unique = true)]
)
data class BudgetMonth(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "month") var month: Int,
    @ColumnInfo(name = "year") var year: Int
)