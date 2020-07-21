package com.jagan.spendanalayser.ui.budget

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jagan.spendanalayser.data.db.entity.Budget
import com.jagan.spendanalayser.data.repo.BudgetRepo
import com.jagan.spendanalayser.model.BudgetItem
import com.jagan.spendanalayser.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class BudgetViewModel @Inject constructor(private val budgetRepo: BudgetRepo) : BaseViewModel() {
    private val budgetSetUp = MutableLiveData<Boolean>()
    private val budget = MutableLiveData<MutableList<BudgetItem>>()

    fun setUpBudget(month: Long) {
        viewModelScope.launch {
            budgetRepo.addOrUpdateBudget(month)
            budgetSetUp.postValue(true)
        }
    }

    fun fetchBudget(month: Long) {
        viewModelScope.launch {
            val budgetList = budgetRepo.getActiveBudget(month)
            budget.postValue(budgetList)
        }

    }

    fun getBudgetSetUp(): LiveData<Boolean> {
        return budgetSetUp
    }

    fun getBudget(): LiveData<MutableList<BudgetItem>> {
        return budget
    }

    fun updateBudget(budgetList: MutableList<BudgetItem>) {
        viewModelScope.launch {
            val budget = mutableListOf<Budget>()
            budgetList.forEach {
                val plannedAmount = (it.plannedAmount).toDouble()
                budget.add(
                    Budget(
                        id = it.id,
                        month = it.month,
                        categoryId = it.categoryId,
                        plannedAmount = plannedAmount
                    )
                )
            }
            budgetRepo.updateBudget(budget)
        }

    }
}
