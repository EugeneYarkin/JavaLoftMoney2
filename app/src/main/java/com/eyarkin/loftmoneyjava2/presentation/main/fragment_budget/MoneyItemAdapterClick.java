package com.eyarkin.loftmoneyjava2.presentation.main.fragment_budget;

import com.eyarkin.loftmoneyjava2.presentation.main.models.MoneyItem;

public interface MoneyItemAdapterClick {
    void onCellClick(MoneyItem moneyItem);
    void onLongCellClick(MoneyItem moneyItem);
}
