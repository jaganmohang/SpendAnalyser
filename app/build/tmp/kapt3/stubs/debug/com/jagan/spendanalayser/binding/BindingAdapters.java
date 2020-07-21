package com.jagan.spendanalayser.binding;

import java.lang.System;

/**
 * Data Binding adapters specific to the app.
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/jagan/spendanalayser/binding/BindingAdapters;", "", "()V", "showHide", "", "view", "Landroid/view/View;", "show", "", "updateButtonState", "button", "Landroid/widget/Button;", "enable", "Landroidx/lifecycle/LiveData;", "app_debug"})
public final class BindingAdapters {
    public static final com.jagan.spendanalayser.binding.BindingAdapters INSTANCE = null;
    
    @androidx.databinding.BindingAdapter(value = {"visibleGone"})
    public static final void showHide(@org.jetbrains.annotations.NotNull()
    android.view.View view, boolean show) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"enableButton"})
    public static final void updateButtonState(@org.jetbrains.annotations.NotNull()
    android.widget.Button button, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<java.lang.Boolean> enable) {
    }
    
    private BindingAdapters() {
        super();
    }
}