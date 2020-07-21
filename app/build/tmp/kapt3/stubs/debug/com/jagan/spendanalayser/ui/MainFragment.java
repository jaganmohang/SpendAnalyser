package com.jagan.spendanalayser.ui;

import java.lang.System;

/**
 * Created by jaganmohana on 2019-11-07.
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 <2\u00020\u0001:\u0002;<B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\u0012\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\"\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00192\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J&\u0010&\u001a\u0004\u0018\u00010\'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\'2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010.\u001a\u00020\u001bH\u0002J\b\u0010/\u001a\u00020\u001bH\u0002J\b\u00100\u001a\u00020\u001bH\u0002J\u0010\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u0011H\u0002J\b\u00103\u001a\u00020\u001bH\u0002J\u0010\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u000206H\u0002J\u0010\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u00020\u001bH\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006="}, d2 = {"Lcom/jagan/spendanalayser/ui/MainFragment;", "Lcom/jagan/spendanalayser/ui/base/BaseFragment;", "()V", "<set-?>", "Lcom/jagan/spendanalayser/databinding/FragmentMainBinding;", "binding", "getBinding", "()Lcom/jagan/spendanalayser/databinding/FragmentMainBinding;", "setBinding", "(Lcom/jagan/spendanalayser/databinding/FragmentMainBinding;)V", "binding$delegate", "Lcom/jagan/spendanalayser/utils/AutoClearedValue;", "expenseUpdateViewModel", "Lcom/jagan/spendanalayser/ui/ExpenseUpdateViewModel;", "handler", "Landroid/os/Handler;", "mActiveMonth", "Lcom/jagan/spendanalayser/model/ActiveMonth;", "mainViewModel", "Lcom/jagan/spendanalayser/ui/MainViewModel;", "getMainViewModel", "()Lcom/jagan/spendanalayser/ui/MainViewModel;", "mainViewModel$delegate", "Lkotlin/Lazy;", "getLayoutRes", "", "initUI", "", "navigateToBudgetPlan", "navigateToCategories", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "registerObservers", "showMonthChangeBottomSheet", "showNewExpenseBottomSheet", "updateActiveMonth", "activeMonth", "updateBudgetUpdate", "updateMonthDetails", "selectedMonth", "Lcom/jagan/spendanalayser/model/SelectedMonth;", "updateNewExpense", "expenseDate", "Lcom/jagan/spendanalayser/model/ExpenseDate;", "updateSelectedMonth", "ClickListener", "Companion", "app_debug"})
public final class MainFragment extends com.jagan.spendanalayser.ui.base.BaseFragment {
    private final kotlin.Lazy mainViewModel$delegate = null;
    private com.jagan.spendanalayser.ui.ExpenseUpdateViewModel expenseUpdateViewModel;
    @org.jetbrains.annotations.NotNull()
    private final com.jagan.spendanalayser.utils.AutoClearedValue binding$delegate = null;
    private com.jagan.spendanalayser.model.ActiveMonth mActiveMonth;
    private final android.os.Handler handler = null;
    public static final com.jagan.spendanalayser.ui.MainFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    private final com.jagan.spendanalayser.ui.MainViewModel getMainViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jagan.spendanalayser.databinding.FragmentMainBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jagan.spendanalayser.databinding.FragmentMainBinding p0) {
    }
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initUI() {
    }
    
    private final void registerObservers() {
    }
    
    private final void updateActiveMonth(com.jagan.spendanalayser.model.ActiveMonth activeMonth) {
    }
    
    private final void showNewExpenseBottomSheet() {
    }
    
    private final void showMonthChangeBottomSheet() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void updateMonthDetails(com.jagan.spendanalayser.model.SelectedMonth selectedMonth) {
    }
    
    private final void updateSelectedMonth() {
    }
    
    private final void updateNewExpense(com.jagan.spendanalayser.model.ExpenseDate expenseDate) {
    }
    
    private final void updateBudgetUpdate() {
    }
    
    private final void navigateToCategories() {
    }
    
    private final void navigateToBudgetPlan() {
    }
    
    public MainFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/jagan/spendanalayser/ui/MainFragment$ClickListener;", "", "(Lcom/jagan/spendanalayser/ui/MainFragment;)V", "onChangeMonthClick", "", "view", "Landroid/view/View;", "app_debug"})
    public final class ClickListener {
        
        public final void onChangeMonthClick(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
        }
        
        public ClickListener() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/jagan/spendanalayser/ui/MainFragment$Companion;", "", "()V", "newInstance", "Lcom/jagan/spendanalayser/ui/MainFragment;", "args", "Landroid/os/Bundle;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.jagan.spendanalayser.ui.MainFragment newInstance(@org.jetbrains.annotations.Nullable()
        android.os.Bundle args) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}