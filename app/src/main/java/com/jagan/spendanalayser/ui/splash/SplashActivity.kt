package com.jagan.spendanalayser.ui.splash

import android.os.Bundle
import com.jagan.spendanalayser.R
import com.jagan.spendanalayser.ui.base.BaseActivity
import com.jagan.spendanalayser.utils.FragmentUtils

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        FragmentUtils.loadFragment(SplashFragment.newInstance(), R.id.fragmentContainer, this)
    }

}
