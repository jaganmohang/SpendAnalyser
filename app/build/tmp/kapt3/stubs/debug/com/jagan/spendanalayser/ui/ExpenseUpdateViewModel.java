package com.jagan.spendanalayser.ui;

import java.lang.System;

/**
 * Created by jaganmohana on 2020-03-03.
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007\u00a8\u0006\u0015"}, d2 = {"Lcom/jagan/spendanalayser/ui/ExpenseUpdateViewModel;", "Lcom/jagan/spendanalayser/ui/base/BaseViewModel;", "()V", "budgetUpdateLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getBudgetUpdateLiveData", "()Landroidx/lifecycle/MutableLiveData;", "monthUpdateLiveData", "Lcom/jagan/spendanalayser/model/ActiveMonth;", "getMonthUpdateLiveData", "newExpenseLiveData", "Lcom/jagan/spendanalayser/model/ExpenseDate;", "getNewExpenseLiveData", "updateBudget", "", "budgetUpdated", "updateMonth", "month", "updateNewExpense", "expenseDate", "app_debug"})
public final class ExpenseUpdateViewModel extends com.jagan.spendanalayser.ui.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.jagan.spendanalayser.model.ExpenseDate> newExpenseLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.jagan.spendanalayser.model.ActiveMonth> monthUpdateLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> budgetUpdateLiveData = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.jagan.spendanalayser.model.ExpenseDate> getNewExpenseLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.jagan.spendanalayser.model.ActiveMonth> getMonthUpdateLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getBudgetUpdateLiveData() {
        return null;
    }
    
    public final void updateNewExpense(@org.jetbrains.annotations.NotNull()
    com.jagan.spendanalayser.model.ExpenseDate expenseDate) {
    }
    
    public final void updateMonth(@org.jetbrains.annotations.NotNull()
    com.jagan.spendanalayser.model.ActiveMonth month) {
    }
    
    public final void updateBudget(boolean budgetUpdated) {
    }
    
    @javax.inject.Inject()
    public ExpenseUpdateViewModel() {
        super();
    }
}