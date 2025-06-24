package com.qppd.babycradle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ToggleButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.qppd.babycradle.Adapters.MusicList;
import com.qppd.babycradle.Classes.Live;
import com.qppd.babycradle.Classes.Motor;
import com.qppd.babycradle.Classes.Music;
import com.qppd.babycradle.Libs.Firebasez.FirebaseRTDBHelper;
import com.qppd.babycradle.Libs.Functionz.FunctionClass;
import com.qppd.babycradle.Libs.Imagez.ImageBase64;
import com.qppd.babycradle.Libs.IntentManager.IntentManagerClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LiveActivity extends AppCompatActivity implements View.OnClickListener {

    private FunctionClass functionClass = new FunctionClass(this);
    private ImageBase64 imageBase64 = new ImageBase64();
    private FirebaseRTDBHelper<Live> liveFirebaseRTDBHelper = new FirebaseRTDBHelper<Live>("babycradle");
    private FirebaseRTDBHelper<Motor> motorFirebaseRTDBHelper = new FirebaseRTDBHelper<Motor>("babycradle");


    private ImageButton btnBack;

    private ImageView imgLive;

    private ToggleButton tglSwing;
    private Button btnMusic;

    private int toggleSwingStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);

        functionClass.setActionbar(getSupportActionBar(), 0, "", 0);

        initializeComponents();
        loadImage();
        loadMotor();
    }

    private void loadMotor() {
        motorFirebaseRTDBHelper.getRef().child("motor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Motor motor = snapshot.getValue(Motor.class);
                if(motor.getStatus() == 1){
                    tglSwing.setChecked(false);
                    toggleSwingStatus = motor.getStatus();
                }
                else{
                    toggleSwingStatus = motor.getStatus();
                    tglSwing.setChecked(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void loadImage() {
        liveFirebaseRTDBHelper.getRef().child("camera/detection").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

//                Live live = snapshot.getValue(Live.class);
                imgLive.setImageBitmap(imageBase64.deCode(snapshot.getValue().toString()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void initializeComponents() {

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        imgLive = findViewById(R.id.imgLive);

        tglSwing = findViewById(R.id.tglSwing);
        tglSwing.setOnClickListener(this);

        btnMusic = findViewById(R.id.btnMusic);
        btnMusic.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                this.finish();
                break;
            case R.id.btnMusic:
                IntentManagerClass.intentsify(LiveActivity.this, MusicActivity.class);
                break;
            case R.id.tglSwing:
                Map<String,Object> updates = new HashMap<>();

                if(toggleSwingStatus == 0){
                    updates.put("status", 1);
                }
                else{
                    updates.put("status", 0);
                }

                motorFirebaseRTDBHelper.update("motor", updates, new FirebaseRTDBHelper.DatabaseCallback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onFailure(Exception e) {

                    }
                });
                break;

        }
    }
}