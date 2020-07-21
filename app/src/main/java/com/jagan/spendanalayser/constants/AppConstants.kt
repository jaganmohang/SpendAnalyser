package com.jagan.spendanalayser.constants

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
class AppConstants private constructor() {
    companion object {
        //General constants
        const val SELECTED_MONTH = "selected_month"
        const val ACTIVE_MONTH = "active_month"
        const val ACTIVE_MONTH_ID = "active_month_id"
        const val EXPENSE_DATE = "expense_date"
        const val NEW_CATEGORY = "new_category"
        const val SELECTED_CATEGORY = "selected_category"


        //Request codes
        const val REQUEST_CODE_CHANGE_MONTH = 1001
        const val REQUEST_CODE_NEW_EXPENSE = 1002
        const val REQUEST_CODE_NEW_CATEGORY = 1003
        const val REQUEST_CODE_SELECT_CATEGORY = 1004
        const val REQUEST_CODE_UPDATE_BUDGET = 1005
        const val REQUEST_CODE_SIGN_IN = 1006

        //Response codes
        const val RESULT_CODE_CHANGE_MONTH = 2001
        const val RESULT_CODE_NEW_EXPENSE = 2002
        const val RESULT_CODE_NEW_CATEGORY = 2003
        const val RESULT_CODE_SELECT_CATEGORY = 2004
        const val RESULT_CODE_UPDATE_BUDGET = 2005
    }
}