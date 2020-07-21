/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jagan.spendanalayser.di.module

import com.jagan.spendanalayser.ui.MainFragment
import com.jagan.spendanalayser.ui.budget.BudgetFragment
import com.jagan.spendanalayser.ui.categories.CategoriesFragment
import com.jagan.spendanalayser.ui.categories.NewCategoryBottomSheet
import com.jagan.spendanalayser.ui.change_month.ChangeMonthBottomSheet
import com.jagan.spendanalayser.ui.newspend.NewExpenseBottomSheet
import com.jagan.spendanalayser.ui.overview.OverviewFragment
import com.jagan.spendanalayser.ui.settings.SettingsFragment
import com.jagan.spendanalayser.ui.spending.SpendingFragment
import com.jagan.spendanalayser.ui.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun contributeOverviewFragment(): OverviewFragment

    @ContributesAndroidInjector
    abstract fun contributeSpendingFragment(): SpendingFragment

    @ContributesAndroidInjector
    abstract fun contributeCategoriesFragment(): CategoriesFragment

    @ContributesAndroidInjector
    abstract fun contributeSettingsFragment(): SettingsFragment

    @ContributesAndroidInjector
    abstract fun contributeNewExpenseBottomSheetFragment(): NewExpenseBottomSheet

    @ContributesAndroidInjector
    abstract fun contributeChangeMonthBottomSheetFragment(): ChangeMonthBottomSheet

    @ContributesAndroidInjector
    abstract fun contributeNewCategoryBottomSheetFragment(): NewCategoryBottomSheet

    @ContributesAndroidInjector
    abstract fun contributeBudgetFragment(): BudgetFragment

    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashFragment
}
