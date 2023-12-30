package com.example.BaybayiNatin.Quiz_Note;

import static com.example.BaybayiNatin.Fragment.Home.Quiz_Note;
import static com.example.BaybayiNatin.Fragment.Home.SHARED_PREF_NAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.BaybayiNatin.Quiz.Yunit1_Quiz;
import com.example.BaybayiNatin.Quiz.Yunit2_Quiz;
import com.example.BaybayiNatin.Quiz.Yunit3_Quiz_BaKa;
import com.example.BaybayiNatin.Quiz.Yunit3_Quiz_DaGa;
import com.example.BaybayiNatin.Quiz.Yunit3_Quiz_HaLa;
import com.example.BaybayiNatin.Quiz.Yunit3_Quiz_Mana;
import com.example.BaybayiNatin.Quiz.Yunit3_Quiz_Ngapa;
import com.example.BaybayiNatin.Quiz.Yunit3_Quiz_RaSa;
import com.example.BaybayiNatin.Quiz.Yunit3_Quiz_TaWa;
import com.example.BaybayiNatin.Quiz.Yunit3_Quiz_Ya;
import com.example.BaybayiNatin.R;
import com.example.BaybayiNatin.databinding.Yunit1QuizNoteBinding;

public class Quiz_Note extends AppCompatActivity {

    Yunit1QuizNoteBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    private String quiz_note;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Yunit1QuizNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        editor = preferences.edit();

        quiz_note = preferences.getString(Quiz_Note, null);

        binding.magpatuloy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quiz_note != null){
                   if (quiz_note.equals("yunit1")) {
                        Intent intent = new Intent(com.example.BaybayiNatin.Quiz_Note.Quiz_Note.this, Yunit1_Quiz.class);
                        startActivity(intent);
                    }
                   else if (quiz_note.equals("yunit2")){
                       Intent intent = new Intent(com.example.BaybayiNatin.Quiz_Note.Quiz_Note.this, Yunit2_Quiz.class);
                       startActivity(intent);
                   }
                    else if (quiz_note.equals("daga")) {
                        Intent intent = new Intent(com.example.BaybayiNatin.Quiz_Note.Quiz_Note.this, Yunit3_Quiz_DaGa.class);
                        startActivity(intent);
                    }
                    else if (quiz_note.equals("baka")) {
                        Intent intent = new Intent(com.example.BaybayiNatin.Quiz_Note.Quiz_Note.this, Yunit3_Quiz_BaKa.class);
                        startActivity(intent);
                    }
                    else if (quiz_note.equals("hala")) {
                        Intent intent = new Intent(com.example.BaybayiNatin.Quiz_Note.Quiz_Note.this, Yunit3_Quiz_HaLa.class);
                        startActivity(intent);
                    }
                   else if (quiz_note.equals("mana")){
                       Intent intent = new Intent(com.example.BaybayiNatin.Quiz_Note.Quiz_Note.this, Yunit3_Quiz_Mana.class);
                       startActivity(intent);
                   }
                   else if (quiz_note.equals("ngapa")){
                       Intent intent = new Intent(com.example.BaybayiNatin.Quiz_Note.Quiz_Note.this, Yunit3_Quiz_Ngapa.class);
                       startActivity(intent);
                   }
                   else if (quiz_note.equals("rasa")){
                       Intent intent = new Intent(com.example.BaybayiNatin.Quiz_Note.Quiz_Note.this, Yunit3_Quiz_RaSa.class);
                       startActivity(intent);
                   }
                   else if (quiz_note.equals("tawa")){
                       Intent intent = new Intent(com.example.BaybayiNatin.Quiz_Note.Quiz_Note.this, Yunit3_Quiz_TaWa.class);
                       startActivity(intent);
                   }
                   else if (quiz_note.equals("ya")){
                       Intent intent = new Intent(com.example.BaybayiNatin.Quiz_Note.Quiz_Note.this, Yunit3_Quiz_Ya.class);
                       startActivity(intent);
                   }
                }

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