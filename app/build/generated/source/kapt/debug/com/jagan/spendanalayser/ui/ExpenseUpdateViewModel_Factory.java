// Generated by Dagger (https://google.github.io/dagger).
package com.jagan.spendanalayser.ui;

import dagger.internal.Factory;

public final class ExpenseUpdateViewModel_Factory implements Factory<ExpenseUpdateViewModel> {
  private static final ExpenseUpdateViewModel_Factory INSTANCE =
      new ExpenseUpdateViewModel_Factory();

  @Override
  public ExpenseUpdateViewModel get() {
    return provideInstance();
  }

  public static ExpenseUpdateViewModel provideInstance() {
    return new ExpenseUpdateViewModel();
  }

  public static ExpenseUpdateViewModel_Factory create() {
    return INSTANCE;
  }

  public static ExpenseUpdateViewModel newExpenseUpdateViewModel() {
    return new ExpenseUpdateViewModel();
  }
}
