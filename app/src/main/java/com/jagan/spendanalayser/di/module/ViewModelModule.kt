/*
 * Copyright (C) 2018 The Android Open Source Project
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

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jagan.spendanalayser.ui.ExpenseUpdateViewModel
import com.jagan.spendanalayser.ui.MainViewModel
import com.jagan.spendanalayser.ui.budget.BudgetViewModel
import com.jagan.spendanalayser.ui.categories.CategoriesViewModel
import com.jagan.spendanalayser.ui.categories.NewCategoryViewModel
import com.jagan.spendanalayser.ui.change_month.ChangeMonthViewModel
import com.jagan.spendanalayser.ui.newspend.NewExpenseViewModel
import com.jagan.spendanalayser.ui.overview.OverviewViewModel
import com.jagan.spendanalayser.ui.settings.SettingsViewModel
import com.jagan.spendanalayser.ui.spending.SpendingViewModel
import com.jagan.spendanalayser.ui.splash.SplashViewModel
import com.jagan.spendanalayser.utils.SViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SpendingViewModel::class)
    abstract fun bindSpendingViewModel(spendingViewModel: SpendingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(OverviewViewModel::class)
    abstract fun bindOverviewViewModel(overviewViewModel: OverviewViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CategoriesViewModel::class)
    abstract fun bindCategoriesViewModel(categoriesViewModel: CategoriesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    abstract fun bindSettingsViewModel(settingsViewModel: SettingsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewExpenseViewModel::class)
    abstract fun bindNewExpenseViewModel(newExpenseViewModel: NewExpenseViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ChangeMonthViewModel::class)
    abstract fun bindChangeMonthViewModel(changeMonthViewModel: ChangeMonthViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ExpenseUpdateViewModel::class)
    abstract fun bindExpenseUpdateViewModel(expenseUpdateViewModel: ExpenseUpdateViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewCategoryViewModel::class)
    abstract fun bindNewCategoryViewModel(newCategoryViewModel: NewCategoryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BudgetViewModel::class)
    abstract fun bindBudgetViewModel(budgetViewModel: BudgetViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: SViewModelFactory): ViewModelProvider.Factory
}
