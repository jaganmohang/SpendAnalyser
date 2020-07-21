package com.jagan.spendanalayser.databinding;
import com.jagan.spendanalayser.R;
import com.jagan.spendanalayser.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ChangeMonthLayoutBindingImpl extends ChangeMonthLayoutBinding implements com.jagan.spendanalayser.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tvAddNewExpenseLabel, 3);
        sViewsWithIds.put(R.id.divider, 4);
        sViewsWithIds.put(R.id.guidelineStart, 5);
        sViewsWithIds.put(R.id.rvYears, 6);
        sViewsWithIds.put(R.id.rvMonths, 7);
        sViewsWithIds.put(R.id.guidelineEnd, 8);
        sViewsWithIds.put(R.id.guidelineBottom, 9);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback7;
    @Nullable
    private final android.view.View.OnClickListener mCallback6;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ChangeMonthLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private ChangeMonthLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[2]
            , (android.widget.ImageButton) bindings[1]
            , (android.view.View) bindings[4]
            , (androidx.constraintlayout.widget.Guideline) bindings[9]
            , (androidx.constraintlayout.widget.Guideline) bindings[8]
            , (androidx.constraintlayout.widget.Guideline) bindings[5]
            , (androidx.recyclerview.widget.RecyclerView) bindings[7]
            , (androidx.recyclerview.widget.RecyclerView) bindings[6]
            , (android.widget.TextView) bindings[3]
            );
        this.btnAdd.setTag(null);
        this.btnClose.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback7 = new com.jagan.spendanalayser.generated.callback.OnClickListener(this, 2);
        mCallback6 = new com.jagan.spendanalayser.generated.callback.OnClickListener(this, 1);
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
        if (BR.monthHandler == variableId) {
            setMonthHandler((com.jagan.spendanalayser.ui.change_month.ChangeMonthBottomSheet.MonthHandler) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMonthHandler(@Nullable com.jagan.spendanalayser.ui.change_month.ChangeMonthBottomSheet.MonthHandler MonthHandler) {
        this.mMonthHandler = MonthHandler;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.monthHandler);
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
        com.jagan.spendanalayser.ui.change_month.ChangeMonthBottomSheet.MonthHandler monthHandler = mMonthHandler;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.btnAdd.setOnClickListener(mCallback7);
            this.btnClose.setOnClickListener(mCallback6);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // monthHandler != null
                boolean monthHandlerJavaLangObjectNull = false;
                // monthHandler
                com.jagan.spendanalayser.ui.change_month.ChangeMonthBottomSheet.MonthHandler monthHandler = mMonthHandler;



                monthHandlerJavaLangObjectNull = (monthHandler) != (null);
                if (monthHandlerJavaLangObjectNull) {



                    monthHandler.onChangeMonthClick(callbackArg_0);
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // monthHandler != null
                boolean monthHandlerJavaLangObjectNull = false;
                // monthHandler
                com.jagan.spendanalayser.ui.change_month.ChangeMonthBottomSheet.MonthHandler monthHandler = mMonthHandler;



                monthHandlerJavaLangObjectNull = (monthHandler) != (null);
                if (monthHandlerJavaLangObjectNull) {



                    monthHandler.onCancelClick(callbackArg_0);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): monthHandler
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}