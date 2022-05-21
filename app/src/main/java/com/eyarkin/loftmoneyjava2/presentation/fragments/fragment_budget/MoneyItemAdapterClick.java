package com.eyarkin.loftmoneyjava2.presentation.fragments.fragment_budget;


import com.eyarkin.loftmoneyjava2.presentation.fragments.fragment_budget.models.MoneyItem;

public interface MoneyItemAdapterClick {
    void onCellClick(MoneyItem moneyItem);
    void onLongCellClick(MoneyItem moneyItem);
}
