package com.jagan.spendanalayser.databinding;
import com.jagan.spendanalayser.R;
import com.jagan.spendanalayser.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentMainBindingImpl extends FragmentMainBinding implements com.jagan.spendanalayser.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appBar, 3);
        sViewsWithIds.put(R.id.toolbar, 4);
        sViewsWithIds.put(R.id.tabs, 5);
        sViewsWithIds.put(R.id.view_pager, 6);
    }
    // views
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback10;
    @Nullable
    private final android.view.View.OnClickListener mCallback11;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private FragmentMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.appbar.AppBarLayout) bindings[3]
            , (android.widget.TextView) bindings[2]
            , (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0]
            , (com.google.android.material.tabs.TabLayout) bindings[5]
            , (android.widget.TextView) bindings[1]
            , (androidx.appcompat.widget.Toolbar) bindings[4]
            , (androidx.viewpager.widget.ViewPager) bindings[6]
            );
        this.monthSelector.setTag(null);
        this.rootLayout.setTag(null);
        this.title.setTag(null);
        setRootTag(root);
        // listeners
        mCallback10 = new com.jagan.spendanalayser.generated.callback.OnClickListener(this, 1);
        mCallback11 = new com.jagan.spendanalayser.generated.callback.OnClickListener(this, 2);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
        if (BR.clickListener == variableId) {
            setClickListener((com.jagan.spendanalayser.ui.MainFragment.ClickListener) variable);
        }
        else if (BR.activeMonth == variableId) {
            setActiveMonth((com.jagan.spendanalayser.model.ActiveMonth) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setClickListener(@Nullable com.jagan.spendanalayser.ui.MainFragment.ClickListener ClickListener) {
        this.mClickListener = ClickListener;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.clickListener);
        super.requestRebind();
    }
    public void setActiveMonth(@Nullable com.jagan.spendanalayser.model.ActiveMonth ActiveMonth) {
        this.mActiveMonth = ActiveMonth;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.activeMonth);
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
        java.lang.String activeMonthDisplayMonth = null;
        com.jagan.spendanalayser.ui.MainFragment.ClickListener clickListener = mClickListener;
        com.jagan.spendanalayser.model.ActiveMonth activeMonth = mActiveMonth;

        if ((dirtyFlags & 0x6L) != 0) {



                if (activeMonth != null) {
                    // read activeMonth.displayMonth
                    activeMonthDisplayMonth = activeMonth.getDisplayMonth();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.monthSelector.setOnClickListener(mCallback11);
            this.title.setOnClickListener(mCallback10);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.monthSelector, activeMonthDisplayMonth);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 1: {
                // localize variables for thread safety
                // clickListener
                com.jagan.spendanalayser.ui.MainFragment.ClickListener clickListener = mClickListener;
                // clickListener != null
                boolean clickListenerJavaLangObjectNull = false;



                clickListenerJavaLangObjectNull = (clickListener) != (null);
                if (clickListenerJavaLangObjectNull) {



                    clickListener.onChangeMonthClick(callbackArg_0);
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // clickListener
                com.jagan.spendanalayser.ui.MainFragment.ClickListener clickListener = mClickListener;
                // clickListener != null
                boolean clickListenerJavaLangObjectNull = false;



                clickListenerJavaLangObjectNull = (clickListener) != (null);
                if (clickListenerJavaLangObjectNull) {



                    clickListener.onChangeMonthClick(callbackArg_0);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): clickListener
        flag 1 (0x2L): activeMonth
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}