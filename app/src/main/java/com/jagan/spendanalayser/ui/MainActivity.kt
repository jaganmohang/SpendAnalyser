package com.jagan.spendanalayser.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.jagan.spendanalayser.R
import com.jagan.spendanalayser.ui.base.BaseActivity
import com.jagan.spendanalayser.utils.FragmentUtils

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FragmentUtils.loadFragment(MainFragment.newInstance(null), R.id.fragmentContainer, this)
    }
}
