package com.example.myarchitecture.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myarchitecture.R;
import com.example.myarchitecture.interactor.MainInteractor;

public class MainActivity extends AppCompatActivity implements MainPresenter.View{

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = createPresenter();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
    }

    private MainPresenter createPresenter() {
        MainInteractor mainInteractor = new  MainInteractor(this.getApplicationContext());
        return new MainPresenterImpl(this, mainInteractor);
    }

    private AlertDialog createProposalDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.rate_proposal_message)
                .setPositiveButton(R.string.rate_proposal_yes,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                presenter.onRatePositive();
                            }
                        })
                .setNegativeButton(R.string.rate_proposal_no,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                presenter.onRateNegative();
                            }
                        });
        return builder.create();
    }

    @Override
    public void showRateProposal() {
        createProposalDialog().show();
    }
}