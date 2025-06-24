package com.qppd.babycradle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.qppd.babycradle.Classes.Token;
import com.qppd.babycradle.Libs.Firebasez.FirebaseRTDBHelper;
import com.qppd.babycradle.Libs.Functionz.FunctionClass;
import com.qppd.babycradle.Libs.IntentManager.IntentManagerClass;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {
    private FunctionClass functionClass = new FunctionClass(this);
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        functionClass.setActionbar(getSupportActionBar(), 0, "", 0);

        initializeComponents();

    }

    private void initializeComponents() {

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                this.finish();
                break;

        }
    }
}