package com.example.BaybayiNatin.Lessons;

import static com.example.BaybayiNatin.Fragment.Home.SHARED_PREF_NAME;
import static com.example.BaybayiNatin.Fragment.Profile.Yunit1Kahalagahan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.example.BaybayiNatin.Fragment.Home;
import com.example.BaybayiNatin.Quiz_Note.Quiz_Note;
import com.example.BaybayiNatin.R;
import com.example.BaybayiNatin.databinding.LessonKahalagahanBinding;


public class Yunit1_Lesson_Kahalagahan extends AppCompatActivity {

    LessonKahalagahanBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LessonKahalagahanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        editor = preferences.edit();

        binding.susunod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString(Home.Quiz_Note, "yunit1");
                editor.putFloat(Yunit1Kahalagahan,0.5f);
                editor.commit();
                Intent intent = new Intent(Yunit1_Lesson_Kahalagahan.this, Quiz_Note.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        binding.bumalik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }
}