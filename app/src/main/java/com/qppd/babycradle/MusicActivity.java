package com.qppd.babycradle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.qppd.babycradle.Adapters.MusicList;
import com.qppd.babycradle.Classes.Music;
import com.qppd.babycradle.Libs.Firebasez.FirebaseRTDBHelper;
import com.qppd.babycradle.Libs.Functionz.FunctionClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MusicActivity extends AppCompatActivity implements View.OnClickListener {
    private FunctionClass functionClass = new FunctionClass(this);

    private FirebaseRTDBHelper<Music> musicFirebaseRTDBHelper = new FirebaseRTDBHelper<Music>("babycradle");

    private ImageButton btnBack;

    List<String> titleList = Arrays.asList(
            "Amazing Grace",
            "Are You Sleeping?",
            "Brahms' Lullaby",
            "Gentle Melody",
            "Golden Slumbers",
            "Good Night",
            "Hush Little Baby",
            "Hushabye Mountain",
            "I See the Moon",
            "Little Angel",
            "Little Star",
            "Mimuli et Moi",
            "Rock a Bye Baby",
            "Sleep Tight",
            "Sleep, Baby, Sleep",
            "Stay Awake",
            "Sweet Dreams",
            "Toora Loora Loora",
            "Twinkle Twinkle Little Star",
            "You Are My Sunshine"
    );

    List<String> singerList = Arrays.asList(
            "Baby Lullaby Garden",
            "Baby Lullaby Garden",
            "Johannes Brahms",
            "Baby Relax Channel",
            "Nursery Rhymes TV",
            "Lullaby World",
            "Lullaby World",
            "Tascha Hromyk",
            "Lullaby World",
            "Emma Toppingcroft",
            "Emma Toppingcroft",
            "Mimuli et Moi Baby",
            "Emma Toppingcroft",
            "Emma Toppingcroft",
            "Emma Toppingcroft",
            "Sweet Dreams",
            "Sweet Dreams",
            "Emma Toppingcroft",
            "LooLoo Kids",
            "Nursery Rhymes ABC"
    );



    private ListView listViewMusic;

    private String music_key;
    private ArrayList<String> music_keys;
    private ArrayList<Music> music_list;

    private MusicList musicAdapter;
    private Music music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        functionClass.setActionbar(getSupportActionBar(), 0, "", 0);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        listViewMusic = findViewById(R.id.listViewMusic);

        loadMusic();
    }

    private void loadMusic() {
        musicAdapter = new MusicList(MusicActivity.this, titleList, singerList);
        listViewMusic.setAdapter(musicAdapter);
        listViewMusic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                music = new Music();

                // Set all to 0 first
                music.setMusic1_status(0);
                music.setMusic2_status(0);
                music.setMusic3_status(0);
                music.setMusic4_status(0);
                music.setMusic5_status(0);
                music.setMusic6_status(0);
                music.setMusic7_status(0);
                music.setMusic8_status(0);
                music.setMusic9_status(0);
                music.setMusic10_status(0);
                music.setMusic11_status(0);
                music.setMusic12_status(0);
                music.setMusic13_status(0);
                music.setMusic14_status(0);
                music.setMusic15_status(0);
                music.setMusic16_status(0);
                music.setMusic17_status(0);
                music.setMusic18_status(0);
                music.setMusic19_status(0);
                music.setMusic20_status(0);

                // Then set only the selected one to 1
                switch (position) {
                    case 0:
                        music.setMusic1_status(1);
                        break;
                    case 1:
                        music.setMusic2_status(1);
                        break;
                    case 2:
                        music.setMusic3_status(1);
                        break;
                    case 3:
                        music.setMusic4_status(1);
                        break;
                    case 4:
                        music.setMusic5_status(1);
                        break;
                    case 5:
                        music.setMusic6_status(1);
                        break;
                    case 6:
                        music.setMusic7_status(1);
                        break;
                    case 7:
                        music.setMusic8_status(1);
                        break;
                    case 8:
                        music.setMusic9_status(1);
                        break;
                    case 9:
                        music.setMusic10_status(1);
                        break;
                    case 10:
                        music.setMusic11_status(1);
                        break;
                    case 11:
                        music.setMusic12_status(1);
                        break;
                    case 12:
                        music.setMusic13_status(1);
                        break;
                    case 13:
                        music.setMusic14_status(1);
                        break;
                    case 14:
                        music.setMusic15_status(1);
                        break;
                    case 15:
                        music.setMusic16_status(1);
                        break;
                    case 16:
                        music.setMusic17_status(1);
                        break;
                    case 17:
                        music.setMusic18_status(1);
                        break;
                    case 18:
                        music.setMusic19_status(1);
                        break;
                    case 19:
                        music.setMusic20_status(1);
                        break;
                }

                musicFirebaseRTDBHelper.save("music", music, new FirebaseRTDBHelper.DatabaseCallback() {
                    @Override
                    public void onSuccess() {
                        functionClass.showMessage("Playing " + titleList.get(position));
                        functionClass.showMessage("Artist " + singerList.get(position));
                    }

                    @Override
                    public void onFailure(Exception e) {

                    }
                });
            }
        });


        musicFirebaseRTDBHelper.getRef().child("music").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                functionClass.showMessage(error.getMessage());
            }
        });


    }

    @Override
    public void onClick(View view) {

    }
}