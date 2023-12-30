package com.example.BaybayiNatin.Quiz;

import static com.example.BaybayiNatin.Fragment.Home.Quiz_Note;
import static com.example.BaybayiNatin.Fragment.Home.SHARED_PREF_NAME;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.BaybayiNatin.Activity.MainActivity;
import com.example.BaybayiNatin.R;
import com.example.BaybayiNatin.databinding.Yunit2QuizBinding;

public class Yunit2_Quiz extends AppCompatActivity {

    Yunit2QuizBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public static final String Yunit2_Quiz_Score = "Yunit2_Quiz";
    private static final String Yunit2_Pagsulat = "Pagsulat";

    private int choices;

    private int q1 = 0;
    private int q2 = 0;
    private int q3 = 0;
    private int q4 = 0;
    private int q5 = 0;

    public int yunit2_quiz_score;
    private int yunit2_quiz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Yunit2QuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Database
        preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        editor = preferences.edit();

        //textfield and button for question and answer
        TextView question = binding.qustion;
        Button choice_1 = binding.choices1;
        Button choice_2 = binding.choices2;
        Button choice_3 = binding.choices3;
        Button suriin = binding.suriin;

        View alertCustomDialog = LayoutInflater.from(Yunit2_Quiz.this).inflate(R.layout.dialog_done_quiz, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Yunit2_Quiz.this);
        alertDialog.setView(alertCustomDialog);
        Button d_magpatuloy = (Button) alertCustomDialog.findViewById(R.id.d_magpatuloy);
        TextView d_score = (TextView) alertCustomDialog.findViewById(R.id.score);
        final AlertDialog d_dialog = alertDialog.create();

        View alertCustomDialog_f = LayoutInflater.from(Yunit2_Quiz.this).inflate(R.layout.dialog_failed_quiz, null);
        AlertDialog.Builder alertDialog_f = new AlertDialog.Builder(Yunit2_Quiz.this);
        alertDialog_f.setView(alertCustomDialog_f);
        Button f_ulitin = (Button) alertCustomDialog_f.findViewById(R.id.f_Ulitin);
        TextView f_score = (TextView) alertCustomDialog_f.findViewById(R.id.f_score);
        final AlertDialog f_dialog = alertDialog_f.create();


        if (suriin.getText().equals("Suriin")){
            suriin.setEnabled(false);
        }

        Handler handler = new Handler();
        View.OnClickListener clickListener = v -> {

            if (v == choice_1){
                suriin.setEnabled(true);
                suriin.setBackgroundResource(R.drawable.container_buttons_green);
                choice_2.setBackgroundResource(R.drawable.container_question_black);
                choice_3.setBackgroundResource(R.drawable.container_question_black);
                choices = 1;
            }
            else if (v == choice_2){
                suriin.setEnabled(true);
                suriin.setBackgroundResource(R.drawable.container_buttons_green);
                choice_1.setBackgroundResource(R.drawable.container_question_black);
                choice_3.setBackgroundResource(R.drawable.container_question_black);
                choices = 2;
            }
            else if (v == choice_3){
                suriin.setEnabled(true);
                suriin.setBackgroundResource(R.drawable.container_buttons_green);
                choice_1.setBackgroundResource(R.drawable.container_question_black);
                choice_2.setBackgroundResource(R.drawable.container_question_black);
                choices = 3;
            }

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (v == choice_1) {
                        suriin.setEnabled(true);
                        suriin.setBackgroundResource(R.drawable.container_buttons_green);
                        choice_1.setBackgroundResource(R.drawable.container_buttons_green);

                    } else if (v == choice_2) {
                        suriin.setEnabled(true);
                        suriin.setBackgroundResource(R.drawable.container_buttons_green);
                        choice_2.setBackgroundResource(R.drawable.container_buttons_green);

                    } else if (v == choice_3) {
                        suriin.setEnabled(true);
                        suriin.setBackgroundResource(R.drawable.container_buttons_green);
                        choice_3.setBackgroundResource(R.drawable.container_buttons_green);

                    } else if (v == suriin) {

                        if (suriin.getText().equals("Suriin")){

                            //Question 1

                            if (question.getText().equals(getString(R.string.yunit2_question1))) {

                                suriin.setText("Susunod");
                                choice_1.setEnabled(false);
                                choice_2.setEnabled(false);
                                choice_3.setEnabled(false);
                                if (choices == 1) {
                                    choice_1.setBackgroundResource(R.drawable.container_question_red);
                                    choice_2.setBackgroundResource(R.drawable.container_question_green);
                                }
                                if (choices == 2) {
                                    q1 = 1;
                                    choice_2.setBackgroundResource(R.drawable.container_question_green);
                                }
                                if (choices == 3) {
                                    choice_3.setBackgroundResource(R.drawable.container_question_red);
                                    choice_2.setBackgroundResource(R.drawable.container_question_green);
                                }
                            }
                            //Question 2
                            if (question.getText().equals(getString(R.string.yunit2_question2))) {

                                suriin.setText("Susunod");
                                choice_1.setEnabled(false);
                                choice_2.setEnabled(false);
                                choice_3.setEnabled(false);
                                if (choices == 1) {
                                    choice_1.setBackgroundResource(R.drawable.container_question_red);
                                    choice_2.setBackgroundResource(R.drawable.container_question_green);
                                }
                                if (choices == 2) {
                                    choice_2.setBackgroundResource(R.drawable.container_question_green);
                                    q2 = 1;
                                }
                                if (choices == 3) {
                                    choice_3.setBackgroundResource(R.drawable.container_question_red);
                                    choice_2.setBackgroundResource(R.drawable.container_question_green);
                                }
                            }
                            //Question 3
                            if (question.getText().equals(getString(R.string.yunit2_question3))) {

                                suriin.setText("Susunod");
                                choice_1.setEnabled(false);
                                choice_2.setEnabled(false);
                                choice_3.setEnabled(false);
                                if (choices == 1) {
                                    choice_1.setBackgroundResource(R.drawable.container_question_red);
                                    choice_3.setBackgroundResource(R.drawable.container_question_green);
                                }
                                if (choices == 2) {
                                    choice_2.setBackgroundResource(R.drawable.container_question_red);
                                    choice_3.setBackgroundResource(R.drawable.container_question_green);
                                }
                                if (choices == 3) {
                                    choice_3.setBackgroundResource(R.drawable.container_question_green);
                                    q3 = 1;
                                }
                            }
                            //Question 4
                            if (question.getText().equals(getString(R.string.yunit2_question4))) {

                                suriin.setText("Susunod");
                                choice_1.setEnabled(false);
                                choice_2.setEnabled(false);
                                choice_3.setEnabled(false);
                                if (choices == 1) {
                                    choice_1.setBackgroundResource(R.drawable.container_question_red);
                                    choice_2.setBackgroundResource(R.drawable.container_question_green);
                                }
                                if (choices == 2) {
                                    choice_2.setBackgroundResource(R.drawable.container_question_green);
                                    q4 = 1;

                                }
                                if (choices == 3) {
                                    choice_3.setBackgroundResource(R.drawable.container_question_red);
                                    choice_2.setBackgroundResource(R.drawable.container_question_green);
                                }
                            }
                            //Question 5
                            if (question.getText().equals(getString(R.string.yunit2_question5))) {

                                suriin.setText("Isumite");
                                choice_1.setEnabled(false);
                                choice_2.setEnabled(false);
                                choice_3.setEnabled(false);
                                if (choices == 1) {
                                    choice_1.setBackgroundResource(R.drawable.container_question_red);
                                    choice_2.setBackgroundResource(R.drawable.container_question_green);
                                }
                                if (choices == 2) {
                                    choice_2.setBackgroundResource(R.drawable.container_question_green);
                                    q5 = 1;

                                }
                                if (choices == 3) {
                                    choice_3.setBackgroundResource(R.drawable.container_question_red);
                                    choice_2.setBackgroundResource(R.drawable.container_question_green);
                                }
                            }
                            yunit2_quiz = addScore(q1, q2, q3, q4, q5);
                            if (yunit2_quiz!= -1){
                                editor.putInt(Yunit2_Quiz_Score, yunit2_quiz);
                                editor.commit();
                            }
                            yunit2_quiz_score = preferences.getInt(Yunit2_Quiz_Score, 0);
                            if (yunit2_quiz_score != -1){
                                d_score.setText(yunit2_quiz_score + "/ 5");
                                f_score.setText(yunit2_quiz_score + "/ 5");
                            }


                        }

                        else if (suriin.getText().equals("Susunod")) {
                            if (question.getText().equals(getString(R.string.yunit2_question1))) {
                                question.setText(R.string.yunit2_question2);
                                choice_1.setText(R.string.yunit2_q2_choice1);
                                choice_2.setText(R.string.yunit2_q2_choice2);
                                choice_3.setText(R.string.yunit2_q2_choice3);
                                choice_1.setBackgroundResource(R.drawable.container_question_black);
                                choice_2.setBackgroundResource(R.drawable.container_question_black);
                                choice_3.setBackgroundResource(R.drawable.container_question_black);
                                suriin.setText("Suriin");
                                suriin.setBackgroundResource(R.drawable.container_buttons_grey);
                                suriin.setEnabled(false);
                                choice_1.setEnabled(true);
                                choice_2.setEnabled(true);
                                choice_3.setEnabled(true);
                            }
                            else if (question.getText().equals(getString(R.string.yunit2_question2))) {
                                question.setText(R.string.yunit2_question3);
                                choice_1.setText(R.string.yunit2_q3_choice1);
                                choice_2.setText(R.string.yunit2_q3_choice2);
                                choice_3.setText(R.string.yunit2_q3_choice3);
                                choice_1.setBackgroundResource(R.drawable.container_question_black);
                                choice_2.setBackgroundResource(R.drawable.container_question_black);
                                choice_3.setBackgroundResource(R.drawable.container_question_black);
                                suriin.setText("Suriin");
                                suriin.setBackgroundResource(R.drawable.container_buttons_grey);
                                suriin.setEnabled(false);
                                choice_1.setEnabled(true);
                                choice_2.setEnabled(true);
                                choice_3.setEnabled(true);
                            }
                            else if (question.getText().equals(getString(R.string.yunit2_question3))) {
                                question.setText(R.string.yunit2_question4);
                                choice_1.setText(R.string.yunit2_q4_choice1);
                                choice_2.setText(R.string.yunit2_q4_choice2);
                                choice_3.setText(R.string.yunit2_q4_choice3);
                                choice_1.setBackgroundResource(R.drawable.container_question_black);
                                choice_2.setBackgroundResource(R.drawable.container_question_black);
                                choice_3.setBackgroundResource(R.drawable.container_question_black);
                                suriin.setText("Suriin");
                                suriin.setBackgroundResource(R.drawable.container_buttons_grey);
                                suriin.setEnabled(false);
                                choice_1.setEnabled(true);
                                choice_2.setEnabled(true);
                                choice_3.setEnabled(true);
                            }
                            else if (question.getText().equals(getString(R.string.yunit2_question4))) {
                                question.setText(R.string.yunit2_question5);
                                choice_1.setText(R.string.yunit2_q5_choice1);
                                choice_2.setText(R.string.yunit2_q5_choice2);
                                choice_3.setText(R.string.yunit2_q5_choice3);
                                choice_1.setBackgroundResource(R.drawable.container_question_black);
                                choice_2.setBackgroundResource(R.drawable.container_question_black);
                                choice_3.setBackgroundResource(R.drawable.container_question_black);
                                suriin.setText("Suriin");
                                suriin.setBackgroundResource(R.drawable.container_buttons_grey);
                                suriin.setEnabled(false);
                                choice_1.setEnabled(true);
                                choice_2.setEnabled(true);
                                choice_3.setEnabled(true);
                            }
                            else if (question.getText().equals(getString(R.string.yunit2_question5))) {

                            }
                        } else if (suriin.getText().equals("Isumite")) {
                            if (yunit2_quiz_score > 2){
                                d_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                d_dialog.show();
                            }else {
                                f_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                f_dialog.show();
                            }
                        }

                    }
                }
            }, 100);

        };
        suriin.setOnClickListener(clickListener);
        choice_1.setOnClickListener(clickListener);
        choice_2.setOnClickListener(clickListener);
        choice_3.setOnClickListener(clickListener);




        d_magpatuloy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString(Yunit2_Pagsulat, "Pagsulat");
                editor.commit();
                Intent intent = new Intent(Yunit2_Quiz.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });

        f_ulitin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString(Quiz_Note, "yunit2");
                editor.commit();
                Intent intent = new Intent(Yunit2_Quiz.this, com.example.BaybayiNatin.Quiz_Note.Quiz_Note.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_right);
    }
    public int addScore(int var1, int var2, int var3, int var4, int var5) {
        return var1 + var2 + var3 + var4 + var5;
    }
}