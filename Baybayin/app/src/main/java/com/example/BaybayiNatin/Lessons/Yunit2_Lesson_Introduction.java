package com.example.BaybayiNatin.Lessons;

import static com.example.BaybayiNatin.Fragment.Profile.Yunit2Intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.BaybayiNatin.R;
import com.example.BaybayiNatin.databinding.LessonPagsisimulaBinding;
import com.example.BaybayiNatin.databinding.Yunit2LessonIntroductionBinding;

public class Yunit2_Lesson_Introduction extends AppCompatActivity {

    Yunit2LessonIntroductionBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private static final String SHARED_PREF_NAME= "MyPreferences";
    private static final String Yunit2_Patinig = "patinig";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Yunit2LessonIntroductionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        editor = preferences.edit();

        binding.susunod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString(Yunit2_Patinig, "patinig");
                editor.putFloat(Yunit2Intro, 0.5f);
                editor.commit();
                Intent intent = new Intent(Yunit2_Lesson_Introduction.this, Yunit2_Lesson_Patinig.class);
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