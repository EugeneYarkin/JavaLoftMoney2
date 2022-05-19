package com.eyarkin.loftmoneyjava2.presentation.main;

public interface EditModeListener {
    void onEditModeChanged(boolean status);
    void onCounterChanged(int newCount);
}