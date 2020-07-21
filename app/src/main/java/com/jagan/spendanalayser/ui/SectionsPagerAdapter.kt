package com.jagan.spendanalayser.ui

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.jagan.spendanalayser.R
import com.jagan.spendanalayser.ui.overview.OverviewFragment
import com.jagan.spendanalayser.ui.spending.SpendingFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_text_analysis,
    R.string.tab_text_expenses
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context?, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return if (position == 0) OverviewFragment.newInstance(null) else SpendingFragment.newInstance(null)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context?.resources?.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}