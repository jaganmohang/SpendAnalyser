package com.jagan.spendanalayser.databinding;
import com.jagan.spendanalayser.R;
import com.jagan.spendanalayser.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class AddExpenseLayoutBindingImpl extends AddExpenseLayoutBinding implements com.jagan.spendanalayser.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tvAddNewExpenseLabel, 7);
        sViewsWithIds.put(R.id.divider, 8);
        sViewsWithIds.put(R.id.guidelineStart, 9);
        sViewsWithIds.put(R.id.tvTimeLabel, 10);
        sViewsWithIds.put(R.id.tvCategoryLabel, 11);
        sViewsWithIds.put(R.id.tilAmount, 12);
        sViewsWithIds.put(R.id.tilDescription, 13);
        sViewsWithIds.put(R.id.guidelineEnd, 14);
        sViewsWithIds.put(R.id.guidelineBottom, 15);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback4;
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener etAmountandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of expenseViewModel.expenseAmount.getValue()
            //         is expenseViewModel.expenseAmount.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etAmount);
            // localize variables for thread safety
            // expenseViewModel.expenseAmount
            androidx.lifecycle.MutableLiveData<java.lang.String> expenseViewModelExpenseAmount = null;
            // expenseViewModel != null
            boolean expenseViewModelJavaLangObjectNull = false;
            // expenseViewModel.expenseAmount != null
            boolean expenseViewModelExpenseAmountJavaLangObjectNull = false;
            // expenseViewModel.expenseAmount.getValue()
            java.lang.String expenseViewModelExpenseAmountGetValue = null;
            // expenseViewModel
            com.jagan.spendanalayser.ui.newspend.NewExpenseViewModel expenseViewModel = mExpenseViewModel;



            expenseViewModelJavaLangObjectNull = (expenseViewModel) != (null);
            if (expenseViewModelJavaLangObjectNull) {


                expenseViewModelExpenseAmount = expenseViewModel.getExpenseAmount();

                expenseViewModelExpenseAmountJavaLangObjectNull = (expenseViewModelExpenseAmount) != (null);
                if (expenseViewModelExpenseAmountJavaLangObjectNull) {




                    expenseViewModelExpenseAmount.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener etDescriptionandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of expenseViewModel.expenseDescription.getValue()
            //         is expenseViewModel.expenseDescription.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etDescription);
            // localize variables for thread safety
            // expenseViewModel.expenseDescription.getValue()
            java.lang.String expenseViewModelExpenseDescriptionGetValue = null;
            // expenseViewModel.expenseDescription
            androidx.lifecycle.MutableLiveData<java.lang.String> expenseViewModelExpenseDescription = null;
            // expenseViewModel != null
            boolean expenseViewModelJavaLangObjectNull = false;
            // expenseViewModel.expenseDescription != null
            boolean expenseViewModelExpenseDescriptionJavaLangObjectNull = false;
            // expenseViewModel
            com.jagan.spendanalayser.ui.newspend.NewExpenseViewModel expenseViewModel = mExpenseViewModel;



            expenseViewModelJavaLangObjectNull = (expenseViewModel) != (null);
            if (expenseViewModelJavaLangObjectNull) {


                expenseViewModelExpenseDescription = expenseViewModel.getExpenseDescription();

                expenseViewModelExpenseDescriptionJavaLangObjectNull = (expenseViewModelExpenseDescription) != (null);
                if (expenseViewModelExpenseDescriptionJavaLangObjectNull) {




                    expenseViewModelExpenseDescription.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public AddExpenseLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private AddExpenseLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5
            , (android.widget.Button) bindings[6]
            , (android.widget.ImageButton) bindings[1]
            , (android.view.View) bindings[8]
            , (com.google.android.material.textfield.TextInputEditText) bindings[4]
            , (com.google.android.material.textfield.TextInputEditText) bindings[5]
            , (androidx.constraintlayout.widget.Guideline) bindings[15]
            , (androidx.constraintlayout.widget.Guideline) bindings[14]
            , (androidx.constraintlayout.widget.Guideline) bindings[9]
            , (android.widget.TextView) bindings[3]
            , (com.google.android.material.textfield.TextInputLayout) bindings[12]
            , (com.google.android.material.textfield.TextInputLayout) bindings[13]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[10]
            );
        this.btnAdd.setTag(null);
        this.btnClose.setTag(null);
        this.etAmount.setTag(null);
        this.etDescription.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.spCategory.setTag(null);
        this.tvTime.setTag(null);
        setRootTag(root);
        // listeners
        mCallback4 = new com.jagan.spendanalayser.generated.callback.OnClickListener(this, 4);
        mCallback2 = new com.jagan.spendanalayser.generated.callback.OnClickListener(this, 2);
        mCallback3 = new com.jagan.spendanalayser.generated.callback.OnClickListener(this, 3);
        mCallback1 = new com.jagan.spendanalayser.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x80L;
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
        if (BR.expenseViewModel == variableId) {
            setExpenseViewModel((com.jagan.spendanalayser.ui.newspend.NewExpenseViewModel) variable);
        }
        else if (BR.expenseHandler == variableId) {
            setExpenseHandler((com.jagan.spendanalayser.ui.newspend.NewExpenseBottomSheet.ExpenseHandler) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setExpenseViewModel(@Nullable com.jagan.spendanalayser.ui.newspend.NewExpenseViewModel ExpenseViewModel) {
        this.mExpenseViewModel = ExpenseViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x20L;
        }
        notifyPropertyChanged(BR.expenseViewModel);
        super.requestRebind();
    }
    public void setExpenseHandler(@Nullable com.jagan.spendanalayser.ui.newspend.NewExpenseBottomSheet.ExpenseHandler ExpenseHandler) {
        this.mExpenseHandler = ExpenseHandler;
        synchronized(this) {
            mDirtyFlags |= 0x40L;
        }
        notifyPropertyChanged(BR.expenseHandler);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeExpenseViewModelExpenseTime((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeExpenseViewModelEnableExpenseButton((androidx.lifecycle.LiveData<java.lang.Boolean>) object, fieldId);
            case 2 :
                return onChangeExpenseViewModelExpenseAmount((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeExpenseViewModelExpenseCategoryTitle((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 4 :
                return onChangeExpenseViewModelExpenseDescription((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeExpenseViewModelExpenseTime(androidx.lifecycle.MutableLiveData<java.lang.String> ExpenseViewModelExpenseTime, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeExpenseViewModelEnableExpenseButton(androidx.lifecycle.LiveData<java.lang.Boolean> ExpenseViewModelEnableExpenseButton, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeExpenseViewModelExpenseAmount(androidx.lifecycle.MutableLiveData<java.lang.String> ExpenseViewModelExpenseAmount, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeExpenseViewModelExpenseCategoryTitle(androidx.lifecycle.LiveData<java.lang.String> ExpenseViewModelExpenseCategoryTitle, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeExpenseViewModelExpenseDescription(androidx.lifecycle.MutableLiveData<java.lang.String> ExpenseViewModelExpenseDescription, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
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
        java.lang.Boolean expenseViewModelEnableExpenseButtonGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> expenseViewModelExpenseTime = null;
        java.lang.String expenseViewModelExpenseDescriptionGetValue = null;
        androidx.lifecycle.LiveData<java.lang.Boolean> expenseViewModelEnableExpenseButton = null;
        java.lang.String expenseViewModelExpenseCategoryTitleGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> expenseViewModelExpenseAmount = null;
        java.lang.String expenseViewModelExpenseTimeGetValue = null;
        java.lang.String expenseViewModelExpenseAmountGetValue = null;
        com.jagan.spendanalayser.ui.newspend.NewExpenseViewModel expenseViewModel = mExpenseViewModel;
        androidx.lifecycle.LiveData<java.lang.String> expenseViewModelExpenseCategoryTitle = null;
        com.jagan.spendanalayser.ui.newspend.NewExpenseBottomSheet.ExpenseHandler expenseHandler = mExpenseHandler;
        androidx.lifecycle.MutableLiveData<java.lang.String> expenseViewModelExpenseDescription = null;

        if ((dirtyFlags & 0xbfL) != 0) {


            if ((dirtyFlags & 0xa1L) != 0) {

                    if (expenseViewModel != null) {
                        // read expenseViewModel.expenseTime
                        expenseViewModelExpenseTime = expenseViewModel.getExpenseTime();
                    }
                    updateLiveDataRegistration(0, expenseViewModelExpenseTime);


                    if (expenseViewModelExpenseTime != null) {
                        // read expenseViewModel.expenseTime.getValue()
                        expenseViewModelExpenseTimeGetValue = expenseViewModelExpenseTime.getValue();
                    }
            }
            if ((dirtyFlags & 0xa2L) != 0) {

                    if (expenseViewModel != null) {
                        // read expenseViewModel.enableExpenseButton
                        expenseViewModelEnableExpenseButton = expenseViewModel.getEnableExpenseButton();
                    }
                    updateLiveDataRegistration(1, expenseViewModelEnableExpenseButton);


                    if (expenseViewModelEnableExpenseButton != null) {
                        // read expenseViewModel.enableExpenseButton.getValue()
                        expenseViewModelEnableExpenseButtonGetValue = expenseViewModelEnableExpenseButton.getValue();
                    }
            }
            if ((dirtyFlags & 0xa4L) != 0) {

                    if (expenseViewModel != null) {
                        // read expenseViewModel.expenseAmount
                        expenseViewModelExpenseAmount = expenseViewModel.getExpenseAmount();
                    }
                    updateLiveDataRegistration(2, expenseViewModelExpenseAmount);


                    if (expenseViewModelExpenseAmount != null) {
                        // read expenseViewModel.expenseAmount.getValue()
                        expenseViewModelExpenseAmountGetValue = expenseViewModelExpenseAmount.getValue();
                    }
            }
            if ((dirtyFlags & 0xa8L) != 0) {

                    if (expenseViewModel != null) {
                        // read expenseViewModel.expenseCategoryTitle
                        expenseViewModelExpenseCategoryTitle = expenseViewModel.getExpenseCategoryTitle();
                    }
                    updateLiveDataRegistration(3, expenseViewModelExpenseCategoryTitle);


                    if (expenseViewModelExpenseCategoryTitle != null) {
                        // read expenseViewModel.expenseCategoryTitle.getValue()
                        expenseViewModelExpenseCategoryTitleGetValue = expenseViewModelExpenseCategoryTitle.getValue();
                    }
            }
            if ((dirtyFlags & 0xb0L) != 0) {

                    if (expenseViewModel != null) {
                        // read expenseViewModel.expenseDescription
                        expenseViewModelExpenseDescription = expenseViewModel.getExpenseDescription();
                    }
                    updateLiveDataRegistration(4, expenseViewModelExpenseDescription);


                    if (expenseViewModelExpenseDescription != null) {
                        // read expenseViewModel.expenseDescription.getValue()
                        expenseViewModelExpenseDescriptionGetValue = expenseViewModelExpenseDescription.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x80L) != 0) {
            // api target 1

            this.btnAdd.setOnClickListener(mCallback4);
            this.btnClose.setOnClickListener(mCallback1);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etAmount, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etAmountandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etDescription, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etDescriptionandroidTextAttrChanged);
            this.spCategory.setOnClickListener(mCallback3);
            this.tvTime.setOnClickListener(mCallback2);
        }
        if ((dirtyFlags & 0xa2L) != 0) {
            // api target 1

            com.jagan.spendanalayser.binding.BindingAdapters.updateButtonState(this.btnAdd, expenseViewModelEnableExpenseButton);
        }
        if ((dirtyFlags & 0xa4L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etAmount, expenseViewModelExpenseAmountGetValue);
        }
        if ((dirtyFlags & 0xb0L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etDescription, expenseViewModelExpenseDescriptionGetValue);
        }
        if ((dirtyFlags & 0xa8L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.spCategory, expenseViewModelExpenseCategoryTitleGetValue);
        }
        if ((dirtyFlags & 0xa1L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvTime, expenseViewModelExpenseTimeGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 4: {
                // localize variables for thread safety
                // expenseHandler
                com.jagan.spendanalayser.ui.newspend.NewExpenseBottomSheet.ExpenseHandler expenseHandler = mExpenseHandler;
                // expenseHandler != null
                boolean expenseHandlerJavaLangObjectNull = false;



                expenseHandlerJavaLangObjectNull = (expenseHandler) != (null);
                if (expenseHandlerJavaLangObjectNull) {



                    expenseHandler.onAddClick(callbackArg_0);
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // expenseHandler
                com.jagan.spendanalayser.ui.newspend.NewExpenseBottomSheet.ExpenseHandler expenseHandler = mExpenseHandler;
                // expenseHandler != null
                boolean expenseHandlerJavaLangObjectNull = false;



                expenseHandlerJavaLangObjectNull = (expenseHandler) != (null);
                if (expenseHandlerJavaLangObjectNull) {



                    expenseHandler.onDateClick(callbackArg_0);
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // expenseHandler
                com.jagan.spendanalayser.ui.newspend.NewExpenseBottomSheet.ExpenseHandler expenseHandler = mExpenseHandler;
                // expenseHandler != null
                boolean expenseHandlerJavaLangObjectNull = false;



                expenseHandlerJavaLangObjectNull = (expenseHandler) != (null);
                if (expenseHandlerJavaLangObjectNull) {



                    expenseHandler.onShowCategoriesClick(callbackArg_0);
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // expenseHandler
                com.jagan.spendanalayser.ui.newspend.NewExpenseBottomSheet.ExpenseHandler expenseHandler = mExpenseHandler;
                // expenseHandler != null
                boolean expenseHandlerJavaLangObjectNull = false;



                expenseHandlerJavaLangObjectNull = (expenseHandler) != (null);
                if (expenseHandlerJavaLangObjectNull) {



                    expenseHandler.onCancelClick(callbackArg_0);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): expenseViewModel.expenseTime
        flag 1 (0x2L): expenseViewModel.enableExpenseButton
        flag 2 (0x3L): expenseViewModel.expenseAmount
        flag 3 (0x4L): expenseViewModel.expenseCategoryTitle
        flag 4 (0x5L): expenseViewModel.expenseDescription
        flag 5 (0x6L): expenseViewModel
        flag 6 (0x7L): expenseHandler
        flag 7 (0x8L): null
    flag mapping end*/
    //end
}