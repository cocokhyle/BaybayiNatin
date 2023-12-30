package com.example.BaybayiNatin.Lessons;

import static com.example.BaybayiNatin.Fragment.Home.Quiz_Note;
import static com.example.BaybayiNatin.Fragment.Home.SHARED_PREF_NAME;
import static com.example.BaybayiNatin.Fragment.Profile.Yunit3_Ra_sa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.example.BaybayiNatin.R;
import com.example.BaybayiNatin.databinding.Yunit3LessonNgaPaBinding;
import com.example.BaybayiNatin.databinding.Yunit3LessonRaSaBinding;

public class Yunit3_Lesson_Ra_Sa extends AppCompatActivity {

    Yunit3LessonRaSaBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Yunit3LessonRaSaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.raBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player == null){
                    binding.raBtn.setBackgroundResource(R.drawable.ic_sound_on);
                    player = MediaPlayer.create(Yunit3_Lesson_Ra_Sa.this, R.raw.ra);
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            player.release();
                            binding.raBtn.setBackgroundResource(R.drawable.ic_sound_mute);
                            player = null;
                        }
                    });
                }
                player.start();

            }

        });
        binding.saBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player == null){
                    binding.saBtn.setBackgroundResource(R.drawable.ic_sound_on);
                    player = MediaPlayer.create(Yunit3_Lesson_Ra_Sa.this, R.raw.sa);
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            player.release();
                            binding.saBtn.setBackgroundResource(R.drawable.ic_sound_mute);
                            player = null;
                        }
                    });
                }
                player.start();

            }

        });


            preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
            editor = preferences.edit();

            binding.susunod.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    editor.putString(Quiz_Note, "rasa");
                    editor.putFloat(Yunit3_Ra_sa, 0.1f);
                    editor.commit();
                    Intent intent = new Intent(Yunit3_Lesson_Ra_Sa.this, com.example.BaybayiNatin.Quiz_Note.Quiz_Note.class);
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