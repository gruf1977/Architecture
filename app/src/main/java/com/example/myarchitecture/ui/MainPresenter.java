package com.example.myarchitecture.ui;

import com.example.myarchitecture.domain.Photo;

import java.util.List;

public interface MainPresenter {

    interface View {
        void showRateProposal();
        void recyclerViewVisible(boolean isVisible, List<Photo> photos);
        void progressVisible(boolean isVisible);
        void btnFindIsActive(boolean isVisible);
    }

    void onStart();
    void onRatePositive();
    void onRateNegative();
    void findImageByText(String text);
}
