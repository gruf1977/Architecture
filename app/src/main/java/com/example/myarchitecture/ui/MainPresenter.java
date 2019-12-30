package com.example.myarchitecture.ui;

import java.util.List;

public interface MainPresenter {

    interface View {
        void showRateProposal();
        void recyclerViewVisible(Boolean isVisible, List photos);
        void progressVisible(Boolean isVisible);
        void btnFindIsActive(Boolean isVisible);
    }

    void onStart();
    void onRatePositive();
    void onRateNegative();
    void findImageByText(String text);
}
