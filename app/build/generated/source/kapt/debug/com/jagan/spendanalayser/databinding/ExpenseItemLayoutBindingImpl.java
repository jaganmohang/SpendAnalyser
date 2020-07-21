package com.jagan.spendanalayser.databinding;
import com.jagan.spendanalayser.R;
import com.jagan.spendanalayser.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ExpenseItemLayoutBindingImpl extends ExpenseItemLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ibDelete, 5);
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ExpenseItemLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ExpenseItemLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageButton) bindings[5]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.tvExpenseAmount.setTag(null);
        this.tvExpenseDesc.setTag(null);
        this.tvExpenseTime.setTag(null);
        this.tvExpenseTitle.setTag(null);
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
        if (BR.expense == variableId) {
            setExpense((com.jagan.spendanalayser.data.db.entity.Spend) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setExpense(@Nullable com.jagan.spendanalayser.data.db.entity.Spend Expense) {
        this.mExpense = Expense;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.expense);
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
        java.lang.String expenseTime = null;
        double expenseAmount = 0.0;
        com.jagan.spendanalayser.data.db.entity.Spend expense = mExpense;
        java.lang.String expenseDescription = null;
        java.lang.String expenseCategoryName = null;
        java.lang.String dataConverterTimeFromDateExpenseTime = null;
        java.lang.String javaLangStringTimeDataConverterTimeFromDateExpenseTime = null;
        java.lang.String javaLangStringReasonExpenseDescription = null;
        java.lang.String dataConverterConvertToStringExpenseAmountBooleanTrue = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (expense != null) {
                    // read expense.time
                    expenseTime = expense.getTime();
                    // read expense.amount
                    expenseAmount = expense.getAmount();
                    // read expense.description
                    expenseDescription = expense.getDescription();
                    // read expense.categoryName
                    expenseCategoryName = expense.getCategoryName();
                }


                // read DataConverter.timeFromDate(expense.time)
                dataConverterTimeFromDateExpenseTime = com.jagan.spendanalayser.utils.DataConverter.timeFromDate(expenseTime);
                // read DataConverter.convertToString(expense.amount, true)
                dataConverterConvertToStringExpenseAmountBooleanTrue = com.jagan.spendanalayser.utils.DataConverter.convertToString(expenseAmount, true);
                // read ("Reason: ") + (expense.description)
                javaLangStringReasonExpenseDescription = ("Reason: ") + (expenseDescription);


                // read ("Time: ") + (DataConverter.timeFromDate(expense.time))
                javaLangStringTimeDataConverterTimeFromDateExpenseTime = ("Time: ") + (dataConverterTimeFromDateExpenseTime);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvExpenseAmount, dataConverterConvertToStringExpenseAmountBooleanTrue);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvExpenseDesc, javaLangStringReasonExpenseDescription);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvExpenseTime, javaLangStringTimeDataConverterTimeFromDateExpenseTime);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvExpenseTitle, expenseCategoryName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): expense
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}