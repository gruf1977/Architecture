package com.example.myarchitecture.ui;

public interface MainPresenter {
    interface View {
        void showRateProposal();
    }

    void onStart();
    void onRatePositive();
    void onRateNegative();
}
