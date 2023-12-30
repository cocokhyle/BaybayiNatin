package com.example.BaybayiNatin.Lessons;

import static com.example.BaybayiNatin.Fragment.Home.Quiz_Note;
import static com.example.BaybayiNatin.Fragment.Home.SHARED_PREF_NAME;
import static com.example.BaybayiNatin.Fragment.Profile.Yunit3_Da_ga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.example.BaybayiNatin.R;
import com.example.BaybayiNatin.databinding.Yunit3LessonDaGaBinding;

public class Yunit3_Lesson_Da_Ga extends AppCompatActivity {
    Yunit3LessonDaGaBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Yunit3LessonDaGaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        editor = preferences.edit();

        binding.daBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player == null){
                    binding.daBtn.setBackgroundResource(R.drawable.ic_sound_on);
                    player = MediaPlayer.create(Yunit3_Lesson_Da_Ga.this, R.raw.da);
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            player.release();
                            binding.daBtn.setBackgroundResource(R.drawable.ic_sound_mute);
                            player = null;
                        }
                    });
                }
                player.start();

            }

        });
        binding.gaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player == null){
                    binding.gaBtn.setBackgroundResource(R.drawable.ic_sound_on);
                    player = MediaPlayer.create(Yunit3_Lesson_Da_Ga.this, R.raw.ga);
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            player.release();
                            binding.gaBtn.setBackgroundResource(R.drawable.ic_sound_mute);
                            player = null;
                        }
                    });
                }
                player.start();

            }

        });


        binding.susunod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString(Quiz_Note, "daga");
                editor.putFloat(Yunit3_Da_ga, 0.1f);
                editor.commit();
                Intent intent = new Intent(Yunit3_Lesson_Da_Ga.this, com.example.BaybayiNatin.Quiz_Note.Quiz_Note.class);
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