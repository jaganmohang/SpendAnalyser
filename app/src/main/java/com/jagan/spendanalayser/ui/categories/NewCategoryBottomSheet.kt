package com.jagan.spendanalayser.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.jagan.spendanalayser.R
import com.jagan.spendanalayser.constants.AppConstants.Companion.ACTIVE_MONTH_ID
import com.jagan.spendanalayser.constants.AppConstants.Companion.RESULT_CODE_NEW_CATEGORY
import com.jagan.spendanalayser.databinding.NewCategoryLayoutBinding
import com.jagan.spendanalayser.di.Injectable
import com.jagan.spendanalayser.utils.autoCleared
import javax.inject.Inject

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
 * Created by jaganmohana on 2020-06-09.
 */
class NewCategoryBottomSheet : BottomSheetDialogFragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: NewCategoryViewModel by viewModels { viewModelFactory }

    private var changeMonthBinding by autoCleared<NewCategoryLayoutBinding>()

    private var activeMonthId: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            activeMonthId = it.getLong(ACTIVE_MONTH_ID)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val databinding =
            DataBindingUtil.inflate<NewCategoryLayoutBinding>(
                inflater,
                R.layout.new_category_layout,
                container,
                false
            )
        databinding.lifecycleOwner = viewLifecycleOwner
        databinding.newCategoryViewModel = viewModel
        changeMonthBinding = databinding

        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeMonthBinding.categoryHandler = CategoryHandler()
    }

    inner class CategoryHandler {
        fun onAddClick(view: View) {
            viewModel.addCategory(activeMonthId!!)
            sendNewCategoryResult(RESULT_CODE_NEW_CATEGORY)
        }

        fun onCancelClick(view: View) {
            dismissBottomSheet()
        }
    }

    private fun sendNewCategoryResult(resultCode: Int) {
        targetFragment?.onActivityResult(targetRequestCode, resultCode, null);
        dismissBottomSheet()
    }

    private fun dismissBottomSheet() {
        this.dismiss()
    }

    companion object {
        val TAG: String = NewCategoryBottomSheet::class.java.simpleName
        @JvmStatic
        fun newInstance(args: Bundle?) = NewCategoryBottomSheet().apply { arguments = args }
    }
}