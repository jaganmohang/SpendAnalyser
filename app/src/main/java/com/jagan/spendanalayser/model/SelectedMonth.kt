package com.jagan.spendanalayser.model

import android.os.Parcel
import android.os.Parcelable

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
 * Created by jaganmohana on 2020-06-29.
 */
data class SelectedMonth(var month: Int, var year: Int) : Parcelable {
    private constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(month)
        parcel.writeInt(year)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SelectedMonth> {
        override fun createFromParcel(parcel: Parcel): SelectedMonth {
            return SelectedMonth(parcel)
        }

        override fun newArray(size: Int): Array<SelectedMonth?> {
            return arrayOfNulls(size)
        }
    }
}