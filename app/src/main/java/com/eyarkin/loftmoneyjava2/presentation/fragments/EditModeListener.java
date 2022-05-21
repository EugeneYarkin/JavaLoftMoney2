package com.eyarkin.loftmoneyjava2.presentation.fragments;

public interface EditModeListener {
    void onEditModeChanged(boolean status);
    void onCounterChanged(int newCount);
}