package com.jagan.spendanalayser.model

import android.os.Parcel
import android.os.Parcelable
import com.jagan.spendanalayser.utils.DateUtils

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
 * Created by jaganmohana on 2020-02-14.
 */
data class ActiveMonth(
    var id: Long,
    var month: Int,
    var year: Int
) : Parcelable {

    private constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeInt(month)
        parcel.writeInt(year)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ActiveMonth> {
        override fun createFromParcel(parcel: Parcel): ActiveMonth {
            return ActiveMonth(parcel)
        }

        override fun newArray(size: Int): Array<ActiveMonth?> {
            return arrayOfNulls(size)
        }
    }

    fun getDisplayMonth(): String {
        return String.format("%s, %d", DateUtils.strMonth(month), year)
    }
}