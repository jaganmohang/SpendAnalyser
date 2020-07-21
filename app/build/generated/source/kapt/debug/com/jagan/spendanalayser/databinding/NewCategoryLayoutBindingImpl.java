package com.jagan.spendanalayser.databinding;
import com.jagan.spendanalayser.R;
import com.jagan.spendanalayser.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class NewCategoryLayoutBindingImpl extends NewCategoryLayoutBinding implements com.jagan.spendanalayser.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tvAddNewCategory, 4);
        sViewsWithIds.put(R.id.divider, 5);
        sViewsWithIds.put(R.id.tilCategory, 6);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback9;
    @Nullable
    private final android.view.View.OnClickListener mCallback8;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener etCategoryandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of newCategoryViewModel.categoryName.getValue()
            //         is newCategoryViewModel.categoryName.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etCategory);
            // localize variables for thread safety
            // newCategoryViewModel.categoryName.getValue()
            java.lang.String newCategoryViewModelCategoryNameGetValue = null;
            // newCategoryViewModel.categoryName != null
            boolean newCategoryViewModelCategoryNameJavaLangObjectNull = false;
            // newCategoryViewModel
            com.jagan.spendanalayser.ui.categories.NewCategoryViewModel newCategoryViewModel = mNewCategoryViewModel;
            // newCategoryViewModel.categoryName
            androidx.lifecycle.MutableLiveData<java.lang.String> newCategoryViewModelCategoryName = null;
            // newCategoryViewModel != null
            boolean newCategoryViewModelJavaLangObjectNull = false;



            newCategoryViewModelJavaLangObjectNull = (newCategoryViewModel) != (null);
            if (newCategoryViewModelJavaLangObjectNull) {


                newCategoryViewModelCategoryName = newCategoryViewModel.getCategoryName();

                newCategoryViewModelCategoryNameJavaLangObjectNull = (newCategoryViewModelCategoryName) != (null);
                if (newCategoryViewModelCategoryNameJavaLangObjectNull) {




                    newCategoryViewModelCategoryName.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public NewCategoryLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private NewCategoryLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.Button) bindings[3]
            , (android.widget.ImageButton) bindings[1]
            , (android.view.View) bindings[5]
            , (com.google.android.material.textfield.TextInputEditText) bindings[2]
            , (com.google.android.material.textfield.TextInputLayout) bindings[6]
            , (android.widget.TextView) bindings[4]
            );
        this.btnAdd.setTag(null);
        this.btnClose.setTag(null);
        this.etCategory.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback9 = new com.jagan.spendanalayser.generated.callback.OnClickListener(this, 2);
        mCallback8 = new com.jagan.spendanalayser.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
        if (BR.newCategoryViewModel == variableId) {
            setNewCategoryViewModel((com.jagan.spendanalayser.ui.categories.NewCategoryViewModel) variable);
        }
        else if (BR.categoryHandler == variableId) {
            setCategoryHandler((com.jagan.spendanalayser.ui.categories.NewCategoryBottomSheet.CategoryHandler) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setNewCategoryViewModel(@Nullable com.jagan.spendanalayser.ui.categories.NewCategoryViewModel NewCategoryViewModel) {
        this.mNewCategoryViewModel = NewCategoryViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.newCategoryViewModel);
        super.requestRebind();
    }
    public void setCategoryHandler(@Nullable com.jagan.spendanalayser.ui.categories.NewCategoryBottomSheet.CategoryHandler CategoryHandler) {
        this.mCategoryHandler = CategoryHandler;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.categoryHandler);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeNewCategoryViewModelEnableAddButton((androidx.lifecycle.LiveData<java.lang.Boolean>) object, fieldId);
            case 1 :
                return onChangeNewCategoryViewModelCategoryName((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeNewCategoryViewModelEnableAddButton(androidx.lifecycle.LiveData<java.lang.Boolean> NewCategoryViewModelEnableAddButton, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeNewCategoryViewModelCategoryName(androidx.lifecycle.MutableLiveData<java.lang.String> NewCategoryViewModelCategoryName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
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
        androidx.lifecycle.LiveData<java.lang.Boolean> newCategoryViewModelEnableAddButton = null;
        java.lang.String newCategoryViewModelCategoryNameGetValue = null;
        com.jagan.spendanalayser.ui.categories.NewCategoryViewModel newCategoryViewModel = mNewCategoryViewModel;
        com.jagan.spendanalayser.ui.categories.NewCategoryBottomSheet.CategoryHandler categoryHandler = mCategoryHandler;
        androidx.lifecycle.MutableLiveData<java.lang.String> newCategoryViewModelCategoryName = null;
        java.lang.Boolean newCategoryViewModelEnableAddButtonGetValue = null;

        if ((dirtyFlags & 0x17L) != 0) {


            if ((dirtyFlags & 0x15L) != 0) {

                    if (newCategoryViewModel != null) {
                        // read newCategoryViewModel.enableAddButton
                        newCategoryViewModelEnableAddButton = newCategoryViewModel.getEnableAddButton();
                    }
                    updateLiveDataRegistration(0, newCategoryViewModelEnableAddButton);


                    if (newCategoryViewModelEnableAddButton != null) {
                        // read newCategoryViewModel.enableAddButton.getValue()
                        newCategoryViewModelEnableAddButtonGetValue = newCategoryViewModelEnableAddButton.getValue();
                    }
            }
            if ((dirtyFlags & 0x16L) != 0) {

                    if (newCategoryViewModel != null) {
                        // read newCategoryViewModel.categoryName
                        newCategoryViewModelCategoryName = newCategoryViewModel.getCategoryName();
                    }
                    updateLiveDataRegistration(1, newCategoryViewModelCategoryName);


                    if (newCategoryViewModelCategoryName != null) {
                        // read newCategoryViewModel.categoryName.getValue()
                        newCategoryViewModelCategoryNameGetValue = newCategoryViewModelCategoryName.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            this.btnAdd.setOnClickListener(mCallback9);
            this.btnClose.setOnClickListener(mCallback8);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etCategory, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etCategoryandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x15L) != 0) {
            // api target 1

            com.jagan.spendanalayser.binding.BindingAdapters.updateButtonState(this.btnAdd, newCategoryViewModelEnableAddButton);
        }
        if ((dirtyFlags & 0x16L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etCategory, newCategoryViewModelCategoryNameGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // categoryHandler != null
                boolean categoryHandlerJavaLangObjectNull = false;
                // categoryHandler
                com.jagan.spendanalayser.ui.categories.NewCategoryBottomSheet.CategoryHandler categoryHandler = mCategoryHandler;



                categoryHandlerJavaLangObjectNull = (categoryHandler) != (null);
                if (categoryHandlerJavaLangObjectNull) {



                    categoryHandler.onAddClick(callbackArg_0);
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // categoryHandler != null
                boolean categoryHandlerJavaLangObjectNull = false;
                // categoryHandler
                com.jagan.spendanalayser.ui.categories.NewCategoryBottomSheet.CategoryHandler categoryHandler = mCategoryHandler;



                categoryHandlerJavaLangObjectNull = (categoryHandler) != (null);
                if (categoryHandlerJavaLangObjectNull) {



                    categoryHandler.onCancelClick(callbackArg_0);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): newCategoryViewModel.enableAddButton
        flag 1 (0x2L): newCategoryViewModel.categoryName
        flag 2 (0x3L): newCategoryViewModel
        flag 3 (0x4L): categoryHandler
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}