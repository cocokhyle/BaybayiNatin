package com.example.BaybayiNatin.Lessons;

import static com.example.BaybayiNatin.Fragment.Home.SHARED_PREF_NAME;
import static com.example.BaybayiNatin.Fragment.Profile.Yunit3_Ba_ka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.BaybayiNatin.Fragment.Home;
import com.example.BaybayiNatin.R;
import com.example.BaybayiNatin.databinding.Yunit3LessonBakaBinding;

public class Yunit3_Lesson_Ba_Ka extends AppCompatActivity {

    Yunit3LessonBakaBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    MediaPlayer player;

    boolean ba = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Yunit3LessonBakaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        editor = preferences.edit();



        binding.baBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player == null){
                        binding.baBtn.setBackgroundResource(R.drawable.ic_sound_on);
                        player = MediaPlayer.create(Yunit3_Lesson_Ba_Ka.this, R.raw.ba);
                        ba = true;
                        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                player.release();
                                binding.baBtn.setBackgroundResource(R.drawable.ic_sound_mute);
                                player = null;
                            }
                        });
                }
                player.start();

            }

        });
        binding.kaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player == null){
                    binding.kaBtn.setBackgroundResource(R.drawable.ic_sound_on);
                    player = MediaPlayer.create(Yunit3_Lesson_Ba_Ka.this, R.raw.ka);
                    ba = true;
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            player.release();
                            binding.kaBtn.setBackgroundResource(R.drawable.ic_sound_mute);
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
                editor.putString(Home.Quiz_Note, "baka");
                editor.putFloat(Yunit3_Ba_ka, 0.1f);
                editor.commit();
                Intent intent = new Intent(Yunit3_Lesson_Ba_Ka.this, com.example.BaybayiNatin.Quiz_Note.Quiz_Note.class);
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