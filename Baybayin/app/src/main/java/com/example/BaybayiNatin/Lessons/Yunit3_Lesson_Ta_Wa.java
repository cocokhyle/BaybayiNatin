package com.example.BaybayiNatin.Lessons;

import static com.example.BaybayiNatin.Fragment.Home.Quiz_Note;
import static com.example.BaybayiNatin.Fragment.Home.SHARED_PREF_NAME;
import static com.example.BaybayiNatin.Fragment.Profile.Yunit3_Ta_wa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.example.BaybayiNatin.R;
import com.example.BaybayiNatin.databinding.Yunit3LessonTaWaBinding;

public class Yunit3_Lesson_Ta_Wa extends AppCompatActivity {

    Yunit3LessonTaWaBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Yunit3LessonTaWaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.taBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player == null){
                    binding.taBtn.setBackgroundResource(R.drawable.ic_sound_on);
                    player = MediaPlayer.create(Yunit3_Lesson_Ta_Wa.this, R.raw.ta);
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            player.release();
                            binding.taBtn.setBackgroundResource(R.drawable.ic_sound_mute);
                            player = null;
                        }
                    });
                }
                player.start();

            }

        });
        binding.waBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player == null){
                    binding.waBtn.setBackgroundResource(R.drawable.ic_sound_on);
                    player = MediaPlayer.create(Yunit3_Lesson_Ta_Wa.this, R.raw.wa);
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            player.release();
                            binding.waBtn.setBackgroundResource(R.drawable.ic_sound_mute);
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
                editor.putString(Quiz_Note, "tawa");
                editor.putFloat(Yunit3_Ta_wa, 0.1f);
                editor.commit();
                Intent intent = new Intent(Yunit3_Lesson_Ta_Wa.this, com.example.BaybayiNatin.Quiz_Note.Quiz_Note.class);
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