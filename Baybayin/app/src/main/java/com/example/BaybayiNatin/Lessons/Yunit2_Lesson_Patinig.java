package com.example.BaybayiNatin.Lessons;

import static com.example.BaybayiNatin.Fragment.Home.SHARED_PREF_NAME;
import static com.example.BaybayiNatin.Fragment.Profile.Yunit2Patinig;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.example.BaybayiNatin.Fragment.Home;
import com.example.BaybayiNatin.Quiz_Note.Quiz_Note;
import com.example.BaybayiNatin.R;
import com.example.BaybayiNatin.databinding.Yunit2LessonPatinigBinding;

public class Yunit2_Lesson_Patinig extends AppCompatActivity {

    Yunit2LessonPatinigBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Yunit2LessonPatinigBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        editor = preferences.edit();

        binding.aBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player == null){
                    binding.aBtn.setBackgroundResource(R.drawable.ic_sound_on);
                    player = MediaPlayer.create(Yunit2_Lesson_Patinig.this, R.raw.a);
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            player.release();
                            binding.aBtn.setBackgroundResource(R.drawable.ic_sound_mute);
                            player = null;
                        }
                    });
                }
                player.start();

            }
        });
        binding.iBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player == null){
                    binding.iBtn.setBackgroundResource(R.drawable.ic_sound_on);
                    player = MediaPlayer.create(Yunit2_Lesson_Patinig.this, R.raw.ei);
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            player.release();
                            binding.iBtn.setBackgroundResource(R.drawable.ic_sound_mute);
                            player = null;
                        }
                    });
                }
                player.start();

            }

        });
        binding.uBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player == null){
                    binding.uBtn.setBackgroundResource(R.drawable.ic_sound_on);
                    player = MediaPlayer.create(Yunit2_Lesson_Patinig.this, R.raw.ou);
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            player.release();
                            binding.uBtn.setBackgroundResource(R.drawable.ic_sound_mute);
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
                editor.putString(Home.Quiz_Note, "yunit2");
                editor.putFloat(Yunit2Patinig, 0.5f);
                editor.commit();
                Intent intent = new Intent(Yunit2_Lesson_Patinig.this, Quiz_Note.class);
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