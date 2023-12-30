package com.example.BaybayiNatin.Lessons;

import static com.example.BaybayiNatin.Fragment.Home.SHARED_PREF_NAME;
import static com.example.BaybayiNatin.Fragment.Home.Yunit3_baka;
import static com.example.BaybayiNatin.Fragment.Profile.Yunit3_panimula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.BaybayiNatin.R;
import com.example.BaybayiNatin.databinding.Yunit3LessonIntroductionBinding;

public class Yunit3_Lesson_Introduction extends AppCompatActivity {
    Yunit3LessonIntroductionBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Yunit3LessonIntroductionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        editor = preferences.edit();

        binding.susunod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString(Yunit3_baka, "baka");
                editor.putFloat(Yunit3_panimula, 0.1f);
                editor.commit();
                Intent intent = new Intent(Yunit3_Lesson_Introduction.this, Yunit3_Lesson_Ba_Ka.class);
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