package com.jagan.spendanalayser.databinding;
import com.jagan.spendanalayser.R;
import com.jagan.spendanalayser.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class SplashFragmentBindingImpl extends SplashFragmentBinding implements com.jagan.spendanalayser.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.title, 3);
        sViewsWithIds.put(R.id.message, 4);
    }
    // views
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback12;
    @Nullable
    private final android.view.View.OnClickListener mCallback13;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public SplashFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private SplashFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[1]
            , (android.widget.Button) bindings[2]
            , (android.widget.TextView) bindings[4]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.widget.TextView) bindings[3]
            );
        this.btnChooseAccount.setTag(null);
        this.btnSkip.setTag(null);
        this.splash.setTag(null);
        setRootTag(root);
        // listeners
        mCallback12 = new com.jagan.spendanalayser.generated.callback.OnClickListener(this, 1);
        mCallback13 = new com.jagan.spendanalayser.generated.callback.OnClickListener(this, 2);
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
        if (BR.clickHandler == variableId) {
            setClickHandler((com.jagan.spendanalayser.ui.splash.SplashFragment.ClickHandler) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setClickHandler(@Nullable com.jagan.spendanalayser.ui.splash.SplashFragment.ClickHandler ClickHandler) {
        this.mClickHandler = ClickHandler;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.clickHandler);
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
        com.jagan.spendanalayser.ui.splash.SplashFragment.ClickHandler clickHandler = mClickHandler;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.btnChooseAccount.setOnClickListener(mCallback12);
            this.btnSkip.setOnClickListener(mCallback13);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 1: {
                // localize variables for thread safety
                // clickHandler != null
                boolean clickHandlerJavaLangObjectNull = false;
                // clickHandler
                com.jagan.spendanalayser.ui.splash.SplashFragment.ClickHandler clickHandler = mClickHandler;



                clickHandlerJavaLangObjectNull = (clickHandler) != (null);
                if (clickHandlerJavaLangObjectNull) {


                    clickHandler.onChooseAccountClick();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // clickHandler != null
                boolean clickHandlerJavaLangObjectNull = false;
                // clickHandler
                com.jagan.spendanalayser.ui.splash.SplashFragment.ClickHandler clickHandler = mClickHandler;



                clickHandlerJavaLangObjectNull = (clickHandler) != (null);
                if (clickHandlerJavaLangObjectNull) {


                    clickHandler.onSkipClick();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): clickHandler
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}