// Generated by Dagger (https://google.github.io/dagger).
package com.jagan.spendanalayser.ui;

import com.jagan.spendanalayser.data.repo.BudgetRepo;
import com.jagan.spendanalayser.data.repo.CategoryRepo;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class MainViewModel_Factory implements Factory<MainViewModel> {
  private final Provider<CategoryRepo> categoryRepoProvider;

  private final Provider<BudgetRepo> budgetRepoProvider;

  public MainViewModel_Factory(
      Provider<CategoryRepo> categoryRepoProvider, Provider<BudgetRepo> budgetRepoProvider) {
    this.categoryRepoProvider = categoryRepoProvider;
    this.budgetRepoProvider = budgetRepoProvider;
  }

  @Override
  public MainViewModel get() {
    return provideInstance(categoryRepoProvider, budgetRepoProvider);
  }

  public static MainViewModel provideInstance(
      Provider<CategoryRepo> categoryRepoProvider, Provider<BudgetRepo> budgetRepoProvider) {
    return new MainViewModel(categoryRepoProvider.get(), budgetRepoProvider.get());
  }

  public static MainViewModel_Factory create(
      Provider<CategoryRepo> categoryRepoProvider, Provider<BudgetRepo> budgetRepoProvider) {
    return new MainViewModel_Factory(categoryRepoProvider, budgetRepoProvider);
  }

  public static MainViewModel newMainViewModel(CategoryRepo categoryRepo, BudgetRepo budgetRepo) {
    return new MainViewModel(categoryRepo, budgetRepo);
  }
}