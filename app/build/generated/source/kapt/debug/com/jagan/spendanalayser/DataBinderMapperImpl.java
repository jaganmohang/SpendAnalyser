package com.jagan.spendanalayser;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jagan.spendanalayser.databinding.ActivityBudgetBindingImpl;
import com.jagan.spendanalayser.databinding.ActivityCategoriesBindingImpl;
import com.jagan.spendanalayser.databinding.ActivityMainBindingImpl;
import com.jagan.spendanalayser.databinding.AddExpenseLayoutBindingImpl;
import com.jagan.spendanalayser.databinding.BudgetFragmentBindingImpl;
import com.jagan.spendanalayser.databinding.CategoryItemLayoutBindingImpl;
import com.jagan.spendanalayser.databinding.ChangeMonthLayoutBindingImpl;
import com.jagan.spendanalayser.databinding.ExpenseItemLayoutBindingImpl;
import com.jagan.spendanalayser.databinding.FragmentCategoriesBindingImpl;
import com.jagan.spendanalayser.databinding.FragmentMainBindingImpl;
import com.jagan.spendanalayser.databinding.FragmentOverviewBindingImpl;
import com.jagan.spendanalayser.databinding.FragmentSpendingBindingImpl;
import com.jagan.spendanalayser.databinding.LayoutBudgetItemBindingImpl;
import com.jagan.spendanalayser.databinding.LayoutDateBindingImpl;
import com.jagan.spendanalayser.databinding.LayoutMonthBindingImpl;
import com.jagan.spendanalayser.databinding.LayoutSpentListItemBindingImpl;
import com.jagan.spendanalayser.databinding.LayoutYearBindingImpl;
import com.jagan.spendanalayser.databinding.NewCategoryLayoutBindingImpl;
import com.jagan.spendanalayser.databinding.SplashActivityBindingImpl;
import com.jagan.spendanalayser.databinding.SplashFragmentBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYBUDGET = 1;

  private static final int LAYOUT_ACTIVITYCATEGORIES = 2;

  private static final int LAYOUT_ACTIVITYMAIN = 3;

  private static final int LAYOUT_ADDEXPENSELAYOUT = 4;

  private static final int LAYOUT_BUDGETFRAGMENT = 5;

  private static final int LAYOUT_CATEGORYITEMLAYOUT = 6;

  private static final int LAYOUT_CHANGEMONTHLAYOUT = 7;

  private static final int LAYOUT_EXPENSEITEMLAYOUT = 8;

  private static final int LAYOUT_FRAGMENTCATEGORIES = 9;

  private static final int LAYOUT_FRAGMENTMAIN = 10;

  private static final int LAYOUT_FRAGMENTOVERVIEW = 11;

  private static final int LAYOUT_FRAGMENTSPENDING = 12;

  private static final int LAYOUT_LAYOUTBUDGETITEM = 13;

  private static final int LAYOUT_LAYOUTDATE = 14;

  private static final int LAYOUT_LAYOUTMONTH = 15;

  private static final int LAYOUT_LAYOUTSPENTLISTITEM = 16;

  private static final int LAYOUT_LAYOUTYEAR = 17;

  private static final int LAYOUT_NEWCATEGORYLAYOUT = 18;

  private static final int LAYOUT_SPLASHACTIVITY = 19;

  private static final int LAYOUT_SPLASHFRAGMENT = 20;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(20);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jagan.spendanalayser.R.layout.activity_budget, LAYOUT_ACTIVITYBUDGET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jagan.spendanalayser.R.layout.activity_categories, LAYOUT_ACTIVITYCATEGORIES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jagan.spendanalayser.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jagan.spendanalayser.R.layout.add_expense_layout, LAYOUT_ADDEXPENSELAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jagan.spendanalayser.R.layout.budget_fragment, LAYOUT_BUDGETFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jagan.spendanalayser.R.layout.category_item_layout, LAYOUT_CATEGORYITEMLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jagan.spendanalayser.R.layout.change_month_layout, LAYOUT_CHANGEMONTHLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jagan.spendanalayser.R.layout.expense_item_layout, LAYOUT_EXPENSEITEMLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jagan.spendanalayser.R.layout.fragment_categories, LAYOUT_FRAGMENTCATEGORIES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jagan.spendanalayser.R.layout.fragment_main, LAYOUT_FRAGMENTMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jagan.spendanalayser.R.layout.fragment_overview, LAYOUT_FRAGMENTOVERVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jagan.spendanalayser.R.layout.fragment_spending, LAYOUT_FRAGMENTSPENDING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jagan.spendanalayser.R.layout.layout_budget_item, LAYOUT_LAYOUTBUDGETITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jagan.spendanalayser.R.layout.layout_date, LAYOUT_LAYOUTDATE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jagan.spendanalayser.R.layout.layout_month, LAYOUT_LAYOUTMONTH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jagan.spendanalayser.R.layout.layout_spent_list_item, LAYOUT_LAYOUTSPENTLISTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jagan.spendanalayser.R.layout.layout_year, LAYOUT_LAYOUTYEAR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jagan.spendanalayser.R.layout.new_category_layout, LAYOUT_NEWCATEGORYLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jagan.spendanalayser.R.layout.splash_activity, LAYOUT_SPLASHACTIVITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.jagan.spendanalayser.R.layout.splash_fragment, LAYOUT_SPLASHFRAGMENT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYBUDGET: {
          if ("layout/activity_budget_0".equals(tag)) {
            return new ActivityBudgetBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_budget is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCATEGORIES: {
          if ("layout/activity_categories_0".equals(tag)) {
            return new ActivityCategoriesBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_categories is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ADDEXPENSELAYOUT: {
          if ("layout/add_expense_layout_0".equals(tag)) {
            return new AddExpenseLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for add_expense_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_BUDGETFRAGMENT: {
          if ("layout/budget_fragment_0".equals(tag)) {
            return new BudgetFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for budget_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_CATEGORYITEMLAYOUT: {
          if ("layout/category_item_layout_0".equals(tag)) {
            return new CategoryItemLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for category_item_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_CHANGEMONTHLAYOUT: {
          if ("layout/change_month_layout_0".equals(tag)) {
            return new ChangeMonthLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for change_month_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_EXPENSEITEMLAYOUT: {
          if ("layout/expense_item_layout_0".equals(tag)) {
            return new ExpenseItemLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for expense_item_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCATEGORIES: {
          if ("layout/fragment_categories_0".equals(tag)) {
            return new FragmentCategoriesBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_categories is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMAIN: {
          if ("layout/fragment_main_0".equals(tag)) {
            return new FragmentMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_main is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTOVERVIEW: {
          if ("layout/fragment_overview_0".equals(tag)) {
            return new FragmentOverviewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_overview is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSPENDING: {
          if ("layout/fragment_spending_0".equals(tag)) {
            return new FragmentSpendingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_spending is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTBUDGETITEM: {
          if ("layout/layout_budget_item_0".equals(tag)) {
            return new LayoutBudgetItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_budget_item is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTDATE: {
          if ("layout/layout_date_0".equals(tag)) {
            return new LayoutDateBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_date is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTMONTH: {
          if ("layout/layout_month_0".equals(tag)) {
            return new LayoutMonthBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_month is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTSPENTLISTITEM: {
          if ("layout/layout_spent_list_item_0".equals(tag)) {
            return new LayoutSpentListItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_spent_list_item is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTYEAR: {
          if ("layout/layout_year_0".equals(tag)) {
            return new LayoutYearBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_year is invalid. Received: " + tag);
        }
        case  LAYOUT_NEWCATEGORYLAYOUT: {
          if ("layout/new_category_layout_0".equals(tag)) {
            return new NewCategoryLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for new_category_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_SPLASHACTIVITY: {
          if ("layout/splash_activity_0".equals(tag)) {
            return new SplashActivityBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for splash_activity is invalid. Received: " + tag);
        }
        case  LAYOUT_SPLASHFRAGMENT: {
          if ("layout/splash_fragment_0".equals(tag)) {
            return new SplashFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for splash_fragment is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(15);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "clickHandler");
      sKeys.put(2, "categoryHandler");
      sKeys.put(3, "activeMonth");
      sKeys.put(4, "expense");
      sKeys.put(5, "monthHandler");
      sKeys.put(6, "newCategoryViewModel");
      sKeys.put(7, "expenseViewModel");
      sKeys.put(8, "spentAmount");
      sKeys.put(9, "expenseHandler");
      sKeys.put(10, "dateItem");
      sKeys.put(11, "category");
      sKeys.put(12, "clickListener");
      sKeys.put(13, "budget");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(20);

    static {
      sKeys.put("layout/activity_budget_0", com.jagan.spendanalayser.R.layout.activity_budget);
      sKeys.put("layout/activity_categories_0", com.jagan.spendanalayser.R.layout.activity_categories);
      sKeys.put("layout/activity_main_0", com.jagan.spendanalayser.R.layout.activity_main);
      sKeys.put("layout/add_expense_layout_0", com.jagan.spendanalayser.R.layout.add_expense_layout);
      sKeys.put("layout/budget_fragment_0", com.jagan.spendanalayser.R.layout.budget_fragment);
      sKeys.put("layout/category_item_layout_0", com.jagan.spendanalayser.R.layout.category_item_layout);
      sKeys.put("layout/change_month_layout_0", com.jagan.spendanalayser.R.layout.change_month_layout);
      sKeys.put("layout/expense_item_layout_0", com.jagan.spendanalayser.R.layout.expense_item_layout);
      sKeys.put("layout/fragment_categories_0", com.jagan.spendanalayser.R.layout.fragment_categories);
      sKeys.put("layout/fragment_main_0", com.jagan.spendanalayser.R.layout.fragment_main);
      sKeys.put("layout/fragment_overview_0", com.jagan.spendanalayser.R.layout.fragment_overview);
      sKeys.put("layout/fragment_spending_0", com.jagan.spendanalayser.R.layout.fragment_spending);
      sKeys.put("layout/layout_budget_item_0", com.jagan.spendanalayser.R.layout.layout_budget_item);
      sKeys.put("layout/layout_date_0", com.jagan.spendanalayser.R.layout.layout_date);
      sKeys.put("layout/layout_month_0", com.jagan.spendanalayser.R.layout.layout_month);
      sKeys.put("layout/layout_spent_list_item_0", com.jagan.spendanalayser.R.layout.layout_spent_list_item);
      sKeys.put("layout/layout_year_0", com.jagan.spendanalayser.R.layout.layout_year);
      sKeys.put("layout/new_category_layout_0", com.jagan.spendanalayser.R.layout.new_category_layout);
      sKeys.put("layout/splash_activity_0", com.jagan.spendanalayser.R.layout.splash_activity);
      sKeys.put("layout/splash_fragment_0", com.jagan.spendanalayser.R.layout.splash_fragment);
    }
  }
}
