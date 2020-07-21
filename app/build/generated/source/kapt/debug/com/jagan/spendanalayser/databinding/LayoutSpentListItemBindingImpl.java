package com.jagan.spendanalayser.databinding;
import com.jagan.spendanalayser.R;
import com.jagan.spendanalayser.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class LayoutSpentListItemBindingImpl extends LayoutSpentListItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public LayoutSpentListItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private LayoutSpentListItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvCategory.setTag(null);
        this.tvPlannedAmount.setTag(null);
        this.tvSpentAmount.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.spentAmount == variableId) {
            setSpentAmount((com.jagan.spendanalayser.model.SpentAmount) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSpentAmount(@Nullable com.jagan.spendanalayser.model.SpentAmount SpentAmount) {
        this.mSpentAmount = SpentAmount;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.spentAmount);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        double spentAmountSpentAmount = 0.0;
        com.jagan.spendanalayser.model.SpentAmount spentAmount = mSpentAmount;
        java.lang.String dataConverterConvertToStringSpentAmountPlannedAmountBooleanFalse = null;
        java.lang.String dataConverterConvertToStringSpentAmountSpentAmountBooleanFalse = null;
        java.lang.String spentAmountCategoryName = null;
        double spentAmountPlannedAmount = 0.0;

        if ((dirtyFlags & 0x3L) != 0) {



                if (spentAmount != null) {
                    // read spentAmount.spentAmount
                    spentAmountSpentAmount = spentAmount.getSpentAmount();
                    // read spentAmount.categoryName
                    spentAmountCategoryName = spentAmount.getCategoryName();
                    // read spentAmount.plannedAmount
                    spentAmountPlannedAmount = spentAmount.getPlannedAmount();
                }


                // read DataConverter.convertToString(spentAmount.spentAmount, false)
                dataConverterConvertToStringSpentAmountSpentAmountBooleanFalse = com.jagan.spendanalayser.utils.DataConverter.convertToString(spentAmountSpentAmount, false);
                // read DataConverter.convertToString(spentAmount.plannedAmount, false)
                dataConverterConvertToStringSpentAmountPlannedAmountBooleanFalse = com.jagan.spendanalayser.utils.DataConverter.convertToString(spentAmountPlannedAmount, false);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvCategory, spentAmountCategoryName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvPlannedAmount, dataConverterConvertToStringSpentAmountPlannedAmountBooleanFalse);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSpentAmount, dataConverterConvertToStringSpentAmountSpentAmountBooleanFalse);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): spentAmount
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}