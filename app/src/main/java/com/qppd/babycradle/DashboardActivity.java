package com.qppd.babycradle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.DonutProgress;
import com.qppd.babycradle.Classes.Token;
import com.qppd.babycradle.Libs.Firebasez.FirebaseRTDBHelper;
import com.qppd.babycradle.Libs.Functionz.FunctionClass;
import com.qppd.babycradle.Libs.IntentManager.IntentManagerClass;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    private FunctionClass functionClass = new FunctionClass(this);

    private FirebaseRTDBHelper<Token> tokenFirebaseRTDBHelper = new FirebaseRTDBHelper<Token>("babycradle");

    private Button btnStart;
    private Button btnAbout;
    private Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        functionClass.setActionbar(getSupportActionBar(), 0, "", 0);

        initializeComponents();


    }

    void initializeComponents() {

        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);
        btnAbout = findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(this);
        btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStart:
                IntentManagerClass.intentsify(DashboardActivity.this, LiveActivity.class);
                break;
            case R.id.btnAbout:
                IntentManagerClass.intentsify(DashboardActivity.this, AboutActivity.class);
                break;
            case R.id.btnExit:
                this.finish();
                break;
        }
    }
}