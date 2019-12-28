package com.example.myarchitecture.ui;

import com.example.myarchitecture.interactor.MainInteractor;

public class MainPresenterImpl implements MainPresenter {

    private final MainInteractor mainInteractor;
    private final View view;

    MainPresenterImpl(View view, MainInteractor mainInteractor) {
        this.view = view;
        this.mainInteractor = mainInteractor;
    }

    @Override
    public void onStart() {
        int numberStart = mainInteractor.getNumberStart();

        if (mainInteractor.showDialog(numberStart)){
            view.showRateProposal();
        }
    }

    @Override
    public void onRatePositive() {
        // TODO: process user positive reaction
    }

    @Override
    public void onRateNegative() {
        // TODO: process user negative reaction
    }
}
