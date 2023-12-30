package com.example.BaybayiNatin.Quiz;

import static com.example.BaybayiNatin.Fragment.Home.SHARED_PREF_NAME;
import static com.example.BaybayiNatin.Fragment.Home.Yunit3_intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.BaybayiNatin.Drawing.Yunit2_Drawing;
import com.example.BaybayiNatin.R;
import com.example.BaybayiNatin.databinding.Yunit2LessonPagsulatBinding;

public class Yunit2_Pagsulat extends AppCompatActivity {

    Yunit2LessonPagsulatBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Yunit2LessonPagsulatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        editor = preferences.edit();

        binding.susunod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString(Yunit3_intro, "yunit3intro");
                editor.commit();
                Intent intent = new Intent(Yunit2_Pagsulat.this, Yunit2_Drawing.class);
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