package com.example.myarchitecture.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myarchitecture.R;
import com.example.myarchitecture.interactor.MainInteractor;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainPresenter.View{

    private MainPresenter presenter;
    private RecyclerView recyclerView;
    private EditText inputText;
    private Button btnFind;
    private ProgressBar progress_circular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        presenter = createPresenter();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerPhoto);
        inputText = findViewById(R.id.inputText);
        btnFind = findViewById(R.id.btnFind);
        progress_circular = findViewById(R.id.progress_circular);
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.findImageByText(String.valueOf(inputText.getText()));
            }
        });
    }

    public void progressVisible(boolean isActive) {
        if (isActive) {
            progress_circular.setVisibility(View.VISIBLE);
        } else {
            progress_circular.setVisibility(View.INVISIBLE);
        }
    }

    public void btnFindIsActive(boolean isVisible) {
        if (isVisible) {
            btnFind.setVisibility(View.VISIBLE);
        } else {
            btnFind.setVisibility(View.INVISIBLE);
        }
    }

    public void recyclerViewVisible(boolean isVisible, List photos) {
        if (isVisible) {
            recyclerView.setVisibility(View.VISIBLE);
            GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2,
                    RecyclerView.VERTICAL, false);
            layoutManager.setReverseLayout(false);
            PhotoRecyclerAdapter adapter = new PhotoRecyclerAdapter((ArrayList) photos);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(layoutManager);
        } else {
            recyclerView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
    }

    private MainPresenter createPresenter() {
        MainInteractor mainInteractor = new  MainInteractor(this.getApplicationContext());
        return new MainPresenterImpl(this, mainInteractor, this.getApplicationContext());
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