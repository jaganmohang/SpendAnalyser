package com.jagan.spendanalayser.ui.budget

import android.os.Bundle
import com.jagan.spendanalayser.R
import com.jagan.spendanalayser.ui.base.BaseActivity
import com.jagan.spendanalayser.utils.FragmentUtils

class BudgetActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget)

        val args: Bundle? = intent?.extras
        FragmentUtils.loadFragment(BudgetFragment.newInstance(args), R.id.fragmentContainer, this)
    }
}
