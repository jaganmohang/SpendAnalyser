package com.jagan.spendanalayser.ui.categories


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.jagan.spendanalayser.R
import com.jagan.spendanalayser.constants.AppConstants.Companion.ACTIVE_MONTH_ID
import com.jagan.spendanalayser.constants.AppConstants.Companion.REQUEST_CODE_NEW_CATEGORY
import com.jagan.spendanalayser.constants.AppConstants.Companion.RESULT_CODE_NEW_CATEGORY
import com.jagan.spendanalayser.constants.AppConstants.Companion.RESULT_CODE_SELECT_CATEGORY
import com.jagan.spendanalayser.constants.AppConstants.Companion.SELECTED_CATEGORY
import com.jagan.spendanalayser.data.db.entity.Category
import com.jagan.spendanalayser.databinding.FragmentCategoriesBinding
import com.jagan.spendanalayser.ui.base.BaseFragment
import com.jagan.spendanalayser.utils.autoCleared

class CategoriesFragment : BaseFragment() {
    private val categoriesViewModel: CategoriesViewModel by viewModels { viewModelFactory }
    private var categoriesDataBinding by autoCleared<FragmentCategoriesBinding>()

    private lateinit var categoriesAdapter: CategoryAdapter
    private var categories = mutableListOf<Category>()

    private var activeMonthId: Long? = null

    override fun getLayoutRes(): Int = R.layout.fragment_categories

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            activeMonthId = it.getLong(ACTIVE_MONTH_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataBinding = DataBindingUtil.inflate<FragmentCategoriesBinding>(inflater, getLayoutRes(), container, false)
        categoriesDataBinding = dataBinding
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        registerObservers()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_NEW_CATEGORY && resultCode == RESULT_CODE_NEW_CATEGORY) {
            refreshCategories()
        }
    }

    private fun initUI() {
        categoriesDataBinding.clickListener = ClickHandler()
        categoriesAdapter = CategoryAdapter(context!!, categories) { updateSelectedCategory(it) }
        categoriesDataBinding.recyclerViewCategories.layoutManager = LinearLayoutManager(context)
        categoriesDataBinding.recyclerViewCategories.adapter = categoriesAdapter

        categoriesDataBinding.toolbar.setNavigationOnClickListener { finishActivity() }
    }

    private fun registerObservers() {
        categoriesViewModel.categories().observe(viewLifecycleOwner) { processCategories(it) }
    }

    private fun refreshCategories() {
        categoriesViewModel.fetchCategories()
    }

    private fun processCategories(categories: MutableList<Category>) {
        categoriesAdapter.updateCategories(categories)
    }

    companion object {
        @JvmStatic
        fun newInstance(args: Bundle?) =
            CategoriesFragment().apply {
                arguments = args
            }
    }

    inner class ClickHandler {
        fun onNewCategory(view: View) {
            showBottomSheet()
        }
    }

    private fun showBottomSheet() {
        activeMonthId?.let {
            val args = Bundle().apply { putLong(ACTIVE_MONTH_ID, it) }
            val addNewCategoryBottomSheet = NewCategoryBottomSheet.newInstance(args)
            addNewCategoryBottomSheet.setTargetFragment(this@CategoriesFragment, REQUEST_CODE_NEW_CATEGORY)
            addNewCategoryBottomSheet.show(activity?.supportFragmentManager!!, "NewCategoryBottomSheet")
        }

    }

    private fun updateSelectedCategory(category: Category) {
        val intent = Intent().apply { putExtra(SELECTED_CATEGORY, category) }
        activity?.setResult(RESULT_CODE_SELECT_CATEGORY, intent)
        finishActivity()
    }
}
