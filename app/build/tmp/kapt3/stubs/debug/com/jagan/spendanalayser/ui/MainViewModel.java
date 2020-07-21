package com.jagan.spendanalayser.ui;

import java.lang.System;

/**
 * Created by jaganmohana on 2019-11-20.
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0011J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/jagan/spendanalayser/ui/MainViewModel;", "Lcom/jagan/spendanalayser/ui/base/BaseViewModel;", "categoryRepo", "Lcom/jagan/spendanalayser/data/repo/CategoryRepo;", "budgetRepo", "Lcom/jagan/spendanalayser/data/repo/BudgetRepo;", "(Lcom/jagan/spendanalayser/data/repo/CategoryRepo;Lcom/jagan/spendanalayser/data/repo/BudgetRepo;)V", "activeMonth", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/jagan/spendanalayser/model/ActiveMonth;", "initialDataLoad", "Landroidx/lifecycle/MutableLiveData;", "", "monthDetails", "Lkotlin/Pair;", "", "getActiveMonth", "Landroidx/lifecycle/LiveData;", "getInitialDataLoad", "setUpInitialData", "", "updateMonthDetails", "month", "year", "app_debug"})
public final class MainViewModel extends com.jagan.spendanalayser.ui.base.BaseViewModel {
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> initialDataLoad = null;
    private final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.Integer, java.lang.Integer>> monthDetails = null;
    private final androidx.lifecycle.MediatorLiveData<com.jagan.spendanalayser.model.ActiveMonth> activeMonth = null;
    private final com.jagan.spendanalayser.data.repo.CategoryRepo categoryRepo = null;
    private final com.jagan.spendanalayser.data.repo.BudgetRepo budgetRepo = null;
    
    public final void updateMonthDetails(int month, int year) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.jagan.spendanalayser.model.ActiveMonth> getActiveMonth() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getInitialDataLoad() {
        return null;
    }
    
    private final void setUpInitialData() {
    }
    
    @javax.inject.Inject()
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    com.jagan.spendanalayser.data.repo.CategoryRepo categoryRepo, @org.jetbrains.annotations.NotNull()
    com.jagan.spendanalayser.data.repo.BudgetRepo budgetRepo) {
        super();
    }
}