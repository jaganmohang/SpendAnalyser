package com.jagan.spendanalayser.databinding;
import com.jagan.spendanalayser.R;
import com.jagan.spendanalayser.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentOverviewBindingImpl extends FragmentOverviewBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.layoutNoAnalysis, 1);
        sViewsWithIds.put(R.id.contentLayout, 2);
        sViewsWithIds.put(R.id.chartExpenses, 3);
        sViewsWithIds.put(R.id.tvPlanned, 4);
        sViewsWithIds.put(R.id.separator1, 5);
        sViewsWithIds.put(R.id.tvPlannedAmount, 6);
        sViewsWithIds.put(R.id.tvSpent, 7);
        sViewsWithIds.put(R.id.separator2, 8);
        sViewsWithIds.put(R.id.tvSpentAmount, 9);
        sViewsWithIds.put(R.id.divider1, 10);
        sViewsWithIds.put(R.id.tvDifference, 11);
        sViewsWithIds.put(R.id.separator3, 12);
        sViewsWithIds.put(R.id.tvDifferenceAmount, 13);
        sViewsWithIds.put(R.id.tvDetails, 14);
        sViewsWithIds.put(R.id.tvDetails2, 15);
        sViewsWithIds.put(R.id.llHeaders, 16);
        sViewsWithIds.put(R.id.tvCategory, 17);
        sViewsWithIds.put(R.id.tvPlannedLabel, 18);
        sViewsWithIds.put(R.id.tvSpentLabel, 19);
        sViewsWithIds.put(R.id.divider2, 20);
        sViewsWithIds.put(R.id.rvExpenseDetails, 21);
        sViewsWithIds.put(R.id.tvAmountInRupees, 22);
        sViewsWithIds.put(R.id.tvFinancialTip, 23);
        sViewsWithIds.put(R.id.tvFinancialTipAuthor, 24);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentOverviewBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 25, sIncludes, sViewsWithIds));
    }
    private FragmentOverviewBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.github.mikephil.charting.charts.PieChart) bindings[3]
            , (androidx.core.widget.NestedScrollView) bindings[2]
            , (android.view.View) bindings[10]
            , (android.view.View) bindings[20]
            , (android.view.View) bindings[1]
            , (android.widget.LinearLayout) bindings[16]
            , (androidx.recyclerview.widget.RecyclerView) bindings[21]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[19]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
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
            return variableSet;
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
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}