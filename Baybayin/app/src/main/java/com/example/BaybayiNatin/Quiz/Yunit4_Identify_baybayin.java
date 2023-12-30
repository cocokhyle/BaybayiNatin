package com.example.BaybayiNatin.Quiz;

import static com.example.BaybayiNatin.Fragment.Home.SHARED_PREF_NAME;
import static com.example.BaybayiNatin.Fragment.Profile.Yunit4DrawingScore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.BaybayiNatin.R;

public class Yunit4_Identify_baybayin extends AppCompatActivity {

    private int currentIndex = 0;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private int[] imageResources = {
            R.drawable.baha,
            R.drawable.bala,
            R.drawable.bata,
            R.drawable.gala,
            R.drawable.gawa,
            R.drawable.haba,
            R.drawable.haya,
            R.drawable.kapa,
            R.drawable.kaya,
            R.drawable.lala,
            R.drawable.lata,
            R.drawable.mama,
            R.drawable.nana,
            R.drawable.pala,
            R.drawable.pata,
            R.drawable.saga,
            R.drawable.sapa,
            R.drawable.taba,
            R.drawable.wala,
            R.drawable.yata
    };
    Handler handler;

    int score = 0;

    int yunit4score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yunit4_identify_baybayin);

        preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        editor = preferences.edit();

        Button surrin = findViewById(R.id.suriin);
        ImageButton back = findViewById(R.id.backBtn);
        EditText ans1 = findViewById(R.id.ansContainer1);
        EditText ans2 = findViewById(R.id.ansContainer2);
        EditText ans3 = findViewById(R.id.ansContainer3);
        EditText ans4 = findViewById(R.id.ansContainer4);
        FrameLayout picContainer = findViewById(R.id.picContainer);
        LinearLayout wrong = findViewById(R.id.wrongView);
        LinearLayout correct = findViewById(R.id.correctView);
        TextView pageCountTxt = findViewById(R.id.pagecountTxt);



        yunit4score = preferences.getInt(Yunit4DrawingScore, 0);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = 0;
                    if (yunit4score <= score || yunit4score == 0){
                        editor.putInt(Yunit4DrawingScore, score);
                        editor.commit();
                    }
                    else {
                        editor.putInt(Yunit4DrawingScore, yunit4score);
                        editor.commit();
                    }



                finish();
            }
        });


        handler = new Handler();

        int white = ContextCompat.getColor(Yunit4_Identify_baybayin.this, R.color.white);


        surrin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer1 = ans1.getText().toString().toLowerCase();
                String answer2 = ans2.getText().toString().toLowerCase();
                String answer3 = ans3.getText().toString().toLowerCase();
                String answer4 = ans4.getText().toString().toLowerCase();
                String buttonTxt = surrin.getText().toString();
                if (buttonTxt.equals("Suriin")){
                if (currentIndex == 0){
                    if (answer1.equals("") || answer2.equals("") || answer3.equals("") || answer4.equals("")){
                        Toast.makeText(Yunit4_Identify_baybayin.this, "Complete the answer!", Toast.LENGTH_SHORT).show();
                    }
                    if (answer1.equals("")){
                        ans1.setBackgroundResource(R.drawable.container_answer_red);
                    }else {
                        ans1.setBackgroundColor(white);
                    }
                    if (answer2.equals("")) {
                        ans2.setBackgroundResource(R.drawable.container_answer_red);
                    } else {
                        ans2.setBackgroundColor(white);
                    }
                    if (answer3.equals("")) {
                        ans3.setBackgroundResource(R.drawable.container_answer_red);
                    }else {
                        ans3.setBackgroundColor(white);
                    }
                   if (answer4.equals("")) {
                        ans4.setBackgroundResource(R.drawable.container_answer_red);
                    }else {
                       ans4.setBackgroundColor(white);
                   }
                   if (!answer1.equals("") && !answer2.equals("") && !answer3.equals("") && !answer4.equals("")) {
                       if (!answer1.equals("b") || !answer2.equals("a") || !answer3.equals("h") || !answer4.equals("a")){
                           Toast.makeText(Yunit4_Identify_baybayin.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                           wrong.setVisibility(View.VISIBLE);
                       }
                        if (!answer1.equals("b")){
                            ans1.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans1.setBackgroundResource(R.drawable.container_answer_blue);
                        }
                        if (!answer2.equals("a")) {
                            ans2.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans2.setBackgroundResource(R.drawable.container_answer_blue);
                        }
                        if (!answer3.equals("h")) {
                            ans3.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans3.setBackgroundResource(R.drawable.container_answer_blue);
                        }
                        if (!answer4.equals("a")) {
                            ans4.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans4.setBackgroundResource(R.drawable.container_answer_blue);
                        }
                        if (answer1.equals("b") && answer2.equals("a") && answer3.equals("h") && answer4.equals("a")) {
                            Toast.makeText(Yunit4_Identify_baybayin.this, "Tama ang iyong sagot!", Toast.LENGTH_SHORT).show();
                            correct.setVisibility(View.VISIBLE);
                            wrong.setVisibility(View.GONE);
                            surrin.setText("Next");
                            score += 1;

                        }
                    }
                }
                    if (currentIndex == 1){
                        if (answer1.equals("") || answer2.equals("") || answer3.equals("") || answer4.equals("")){
                            Toast.makeText(Yunit4_Identify_baybayin.this, "Complete the answer!", Toast.LENGTH_SHORT).show();
                        }
                        if (answer1.equals("")){
                            ans1.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans1.setBackgroundColor(white);
                        }
                        if (answer2.equals("")) {
                            ans2.setBackgroundResource(R.drawable.container_answer_red);
                        } else {
                            ans2.setBackgroundColor(white);
                        }
                        if (answer3.equals("")) {
                            ans3.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans3.setBackgroundColor(white);
                        }
                        if (answer4.equals("")) {
                            ans4.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans4.setBackgroundColor(white);
                        }
                        if (!answer1.equals("") && !answer2.equals("") && !answer3.equals("") && !answer4.equals("")) {
                            if (!answer1.equals("b") || !answer2.equals("a") || !answer3.equals("l") || !answer4.equals("a")){
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                                wrong.setVisibility(View.VISIBLE);
                            }
                            if (!answer1.equals("b")){
                                ans1.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans1.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer2.equals("a")) {
                                ans2.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans2.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer3.equals("l")) {
                                ans3.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans3.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer4.equals("a")) {
                                ans4.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans4.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (answer1.equals("b") && answer2.equals("a") && answer3.equals("l") && answer4.equals("a")) {
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Tama ang iyong sagot!", Toast.LENGTH_SHORT).show();
                                correct.setVisibility(View.VISIBLE);
                                wrong.setVisibility(View.GONE);
                                surrin.setText("Next");
                                score += 1;

                            }
                        }
                    }
                    if (currentIndex == 2){
                        if (answer1.equals("") || answer2.equals("") || answer3.equals("") || answer4.equals("")){
                            Toast.makeText(Yunit4_Identify_baybayin.this, "Complete the answer!", Toast.LENGTH_SHORT).show();
                        }
                        if (answer1.equals("")){
                            ans1.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans1.setBackgroundColor(white);
                        }
                        if (answer2.equals("")) {
                            ans2.setBackgroundResource(R.drawable.container_answer_red);
                        } else {
                            ans2.setBackgroundColor(white);
                        }
                        if (answer3.equals("")) {
                            ans3.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans3.setBackgroundColor(white);
                        }
                        if (answer4.equals("")) {
                            ans4.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans4.setBackgroundColor(white);
                        }
                        if (!answer1.equals("") && !answer2.equals("") && !answer3.equals("") && !answer4.equals("")) {
                            if (!answer1.equals("b") || !answer2.equals("a") || !answer3.equals("t") || !answer4.equals("a")){
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                                wrong.setVisibility(View.VISIBLE);
                            }
                            if (!answer1.equals("b")){
                                ans1.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans1.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer2.equals("a")) {
                                ans2.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans2.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer3.equals("t")) {
                                ans3.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans3.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer4.equals("a")) {
                                ans4.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans4.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (answer1.equals("b") && answer2.equals("a") && answer3.equals("t") && answer4.equals("a")) {
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Tama ang iyong sagot!", Toast.LENGTH_SHORT).show();
                                correct.setVisibility(View.VISIBLE);
                                wrong.setVisibility(View.GONE);
                                surrin.setText("Next");
                                score += 1;

                            }
                        }
                    }
                    if (currentIndex == 3){
                        if (answer1.equals("") || answer2.equals("") || answer3.equals("") || answer4.equals("")){
                            Toast.makeText(Yunit4_Identify_baybayin.this, "Complete the answer!", Toast.LENGTH_SHORT).show();
                        }
                        if (answer1.equals("")){
                            ans1.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans1.setBackgroundColor(white);
                        }
                        if (answer2.equals("")) {
                            ans2.setBackgroundResource(R.drawable.container_answer_red);
                        } else {
                            ans2.setBackgroundColor(white);
                        }
                        if (answer3.equals("")) {
                            ans3.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans3.setBackgroundColor(white);
                        }
                        if (answer4.equals("")) {
                            ans4.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans4.setBackgroundColor(white);
                        }
                        if (!answer1.equals("") && !answer2.equals("") && !answer3.equals("") && !answer4.equals("")) {
                            if (!answer1.equals("g") || !answer2.equals("a") || !answer3.equals("l") || !answer4.equals("a")){
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                                wrong.setVisibility(View.VISIBLE);
                            }
                            if (!answer1.equals("g")){
                                ans1.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans1.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer2.equals("a")) {
                                ans2.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans2.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer3.equals("l")) {
                                ans3.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans3.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer4.equals("a")) {
                                ans4.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans4.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (answer1.equals("g") && answer2.equals("a") && answer3.equals("l") && answer4.equals("a")) {
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Tama ang iyong sagot!", Toast.LENGTH_SHORT).show();
                                correct.setVisibility(View.VISIBLE);
                                wrong.setVisibility(View.GONE);
                                surrin.setText("Next");
                                score += 1;

                            }
                        }
                    }
                    if (currentIndex == 4){
                        if (answer1.equals("") || answer2.equals("") || answer3.equals("") || answer4.equals("")){
                            Toast.makeText(Yunit4_Identify_baybayin.this, "Complete the answer!", Toast.LENGTH_SHORT).show();
                        }
                        if (answer1.equals("")){
                            ans1.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans1.setBackgroundColor(white);
                        }
                        if (answer2.equals("")) {
                            ans2.setBackgroundResource(R.drawable.container_answer_red);
                        } else {
                            ans2.setBackgroundColor(white);
                        }
                        if (answer3.equals("")) {
                            ans3.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans3.setBackgroundColor(white);
                        }
                        if (answer4.equals("")) {
                            ans4.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans4.setBackgroundColor(white);
                        }
                        if (!answer1.equals("") && !answer2.equals("") && !answer3.equals("") && !answer4.equals("")) {
                            if (!answer1.equals("g") || !answer2.equals("a") || !answer3.equals("w") || !answer4.equals("a")){
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                                wrong.setVisibility(View.VISIBLE);
                            }
                            if (!answer1.equals("g")){
                                ans1.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans1.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer2.equals("a")) {
                                ans2.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans2.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer3.equals("w")) {
                                ans3.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans3.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer4.equals("a")) {
                                ans4.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans4.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (answer1.equals("g") && answer2.equals("a") && answer3.equals("w") && answer4.equals("a")) {
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Tama ang iyong sagot!", Toast.LENGTH_SHORT).show();
                                correct.setVisibility(View.VISIBLE);
                                wrong.setVisibility(View.GONE);
                                surrin.setText("Next");
                                score += 1;

                            }
                        }
                    }
                    if (currentIndex == 5){
                        if (answer1.equals("") || answer2.equals("") || answer3.equals("") || answer4.equals("")){
                            Toast.makeText(Yunit4_Identify_baybayin.this, "Complete the answer!", Toast.LENGTH_SHORT).show();
                        }
                        if (answer1.equals("")){
                            ans1.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans1.setBackgroundColor(white);
                        }
                        if (answer2.equals("")) {
                            ans2.setBackgroundResource(R.drawable.container_answer_red);
                        } else {
                            ans2.setBackgroundColor(white);
                        }
                        if (answer3.equals("")) {
                            ans3.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans3.setBackgroundColor(white);
                        }
                        if (answer4.equals("")) {
                            ans4.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans4.setBackgroundColor(white);
                        }
                        if (!answer1.equals("") && !answer2.equals("") && !answer3.equals("") && !answer4.equals("")) {
                            if (!answer1.equals("h") || !answer2.equals("a") || !answer3.equals("b") || !answer4.equals("a")){
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                                wrong.setVisibility(View.VISIBLE);
                            }
                            if (!answer1.equals("h")){
                                ans1.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans1.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer2.equals("a")) {
                                ans2.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans2.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer3.equals("b")) {
                                ans3.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans3.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer4.equals("a")) {
                                ans4.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans4.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (answer1.equals("h") && answer2.equals("a") && answer3.equals("b") && answer4.equals("a")) {
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Tama ang iyong sagot!", Toast.LENGTH_SHORT).show();
                                correct.setVisibility(View.VISIBLE);
                                wrong.setVisibility(View.GONE);
                                surrin.setText("Next");
                                score += 1;

                            }
                        }
                    }
                    if (currentIndex == 6){
                        if (answer1.equals("") || answer2.equals("") || answer3.equals("") || answer4.equals("")){
                            Toast.makeText(Yunit4_Identify_baybayin.this, "Complete the answer!", Toast.LENGTH_SHORT).show();
                        }
                        if (answer1.equals("")){
                            ans1.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans1.setBackgroundColor(white);
                        }
                        if (answer2.equals("")) {
                            ans2.setBackgroundResource(R.drawable.container_answer_red);
                        } else {
                            ans2.setBackgroundColor(white);
                        }
                        if (answer3.equals("")) {
                            ans3.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans3.setBackgroundColor(white);
                        }
                        if (answer4.equals("")) {
                            ans4.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans4.setBackgroundColor(white);
                        }
                        if (!answer1.equals("") && !answer2.equals("") && !answer3.equals("") && !answer4.equals("")) {
                            if (!answer1.equals("h") || !answer2.equals("a") || !answer3.equals("y") || !answer4.equals("a")){
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                                wrong.setVisibility(View.VISIBLE);
                            }
                            if (!answer1.equals("h")){
                                ans1.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans1.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer2.equals("a")) {
                                ans2.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans2.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer3.equals("y")) {
                                ans3.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans3.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer4.equals("a")) {
                                ans4.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans4.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (answer1.equals("h") && answer2.equals("a") && answer3.equals("y") && answer4.equals("a")) {
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Tama ang iyong sagot!", Toast.LENGTH_SHORT).show();
                                correct.setVisibility(View.VISIBLE);
                                wrong.setVisibility(View.GONE);
                                surrin.setText("Next");
                                score += 1;

                            }
                        }
                    }
                    if (currentIndex == 7){
                        if (answer1.equals("") || answer2.equals("") || answer3.equals("") || answer4.equals("")){
                            Toast.makeText(Yunit4_Identify_baybayin.this, "Complete the answer!", Toast.LENGTH_SHORT).show();
                        }
                        if (answer1.equals("")){
                            ans1.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans1.setBackgroundColor(white);
                        }
                        if (answer2.equals("")) {
                            ans2.setBackgroundResource(R.drawable.container_answer_red);
                        } else {
                            ans2.setBackgroundColor(white);
                        }
                        if (answer3.equals("")) {
                            ans3.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans3.setBackgroundColor(white);
                        }
                        if (answer4.equals("")) {
                            ans4.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans4.setBackgroundColor(white);
                        }
                        if (!answer1.equals("") && !answer2.equals("") && !answer3.equals("") && !answer4.equals("")) {
                            if (!answer1.equals("k") || !answer2.equals("a") || !answer3.equals("p") || !answer4.equals("a")){
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                                wrong.setVisibility(View.VISIBLE);
                            }
                            if (!answer1.equals("k")){
                                ans1.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans1.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer2.equals("a")) {
                                ans2.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans2.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer3.equals("p")) {
                                ans3.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans3.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer4.equals("a")) {
                                ans4.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans4.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (answer1.equals("k") && answer2.equals("a") && answer3.equals("p") && answer4.equals("a")) {
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Tama ang iyong sagot!", Toast.LENGTH_SHORT).show();
                                correct.setVisibility(View.VISIBLE);
                                wrong.setVisibility(View.GONE);
                                surrin.setText("Next");
                                score += 1;

                            }
                        }
                    }
                    if (currentIndex == 8){
                        if (answer1.equals("") || answer2.equals("") || answer3.equals("") || answer4.equals("")){
                            Toast.makeText(Yunit4_Identify_baybayin.this, "Complete the answer!", Toast.LENGTH_SHORT).show();
                        }
                        if (answer1.equals("")){
                            ans1.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans1.setBackgroundColor(white);
                        }
                        if (answer2.equals("")) {
                            ans2.setBackgroundResource(R.drawable.container_answer_red);
                        } else {
                            ans2.setBackgroundColor(white);
                        }
                        if (answer3.equals("")) {
                            ans3.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans3.setBackgroundColor(white);
                        }
                        if (answer4.equals("")) {
                            ans4.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans4.setBackgroundColor(white);
                        }
                        if (!answer1.equals("") && !answer2.equals("") && !answer3.equals("") && !answer4.equals("")) {
                            if (!answer1.equals("k") || !answer2.equals("a") || !answer3.equals("y") || !answer4.equals("a")){
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                                wrong.setVisibility(View.VISIBLE);
                            }
                            if (!answer1.equals("k")){
                                ans1.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans1.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer2.equals("a")) {
                                ans2.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans2.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer3.equals("y")) {
                                ans3.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans3.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer4.equals("a")) {
                                ans4.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans4.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (answer1.equals("k") && answer2.equals("a") && answer3.equals("y") && answer4.equals("a")) {
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Tama ang iyong sagot!", Toast.LENGTH_SHORT).show();
                                correct.setVisibility(View.VISIBLE);
                                wrong.setVisibility(View.GONE);
                                surrin.setText("Next");
                                score += 1;

                            }
                        }
                    }
                    if (currentIndex == 9){
                        if (answer1.equals("") || answer2.equals("") || answer3.equals("") || answer4.equals("")){
                            Toast.makeText(Yunit4_Identify_baybayin.this, "Complete the answer!", Toast.LENGTH_SHORT).show();
                        }
                        if (answer1.equals("")){
                            ans1.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans1.setBackgroundColor(white);
                        }
                        if (answer2.equals("")) {
                            ans2.setBackgroundResource(R.drawable.container_answer_red);
                        } else {
                            ans2.setBackgroundColor(white);
                        }
                        if (answer3.equals("")) {
                            ans3.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans3.setBackgroundColor(white);
                        }
                        if (answer4.equals("")) {
                            ans4.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans4.setBackgroundColor(white);
                        }
                        if (!answer1.equals("") && !answer2.equals("") && !answer3.equals("") && !answer4.equals("")) {
                            if (!answer1.equals("l") || !answer2.equals("a") || !answer3.equals("l") || !answer4.equals("a")){
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                                wrong.setVisibility(View.VISIBLE);
                            }
                            if (!answer1.equals("l")){
                                ans1.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans1.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer2.equals("a")) {
                                ans2.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans2.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer3.equals("l")) {
                                ans3.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans3.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer4.equals("a")) {
                                ans4.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans4.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (answer1.equals("l") && answer2.equals("a") && answer3.equals("l") && answer4.equals("a")) {
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Tama ang iyong sagot!", Toast.LENGTH_SHORT).show();
                                correct.setVisibility(View.VISIBLE);
                                wrong.setVisibility(View.GONE);
                                surrin.setText("Next");
                                score += 1;

                            }
                        }
                    }
                    if (currentIndex == 10){
                        if (answer1.equals("") || answer2.equals("") || answer3.equals("") || answer4.equals("")){
                            Toast.makeText(Yunit4_Identify_baybayin.this, "Complete the answer!", Toast.LENGTH_SHORT).show();
                        }
                        if (answer1.equals("")){
                            ans1.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans1.setBackgroundColor(white);
                        }
                        if (answer2.equals("")) {
                            ans2.setBackgroundResource(R.drawable.container_answer_red);
                        } else {
                            ans2.setBackgroundColor(white);
                        }
                        if (answer3.equals("")) {
                            ans3.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans3.setBackgroundColor(white);
                        }
                        if (answer4.equals("")) {
                            ans4.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans4.setBackgroundColor(white);
                        }
                        if (!answer1.equals("") && !answer2.equals("") && !answer3.equals("") && !answer4.equals("")) {
                            if (!answer1.equals("l") || !answer2.equals("a") || !answer3.equals("t") || !answer4.equals("a")){
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                                wrong.setVisibility(View.VISIBLE);
                            }
                            if (!answer1.equals("l")){
                                ans1.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans1.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer2.equals("a")) {
                                ans2.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans2.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer3.equals("t")) {
                                ans3.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans3.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer4.equals("a")) {
                                ans4.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans4.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (answer1.equals("l") && answer2.equals("a") && answer3.equals("t") && answer4.equals("a")) {
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Tama ang iyong sagot!", Toast.LENGTH_SHORT).show();
                                correct.setVisibility(View.VISIBLE);
                                wrong.setVisibility(View.GONE);
                                surrin.setText("Next");
                                score += 1;

                            }
                        }
                    }
                    if (currentIndex == 11){
                        if (answer1.equals("") || answer2.equals("") || answer3.equals("") || answer4.equals("")){
                            Toast.makeText(Yunit4_Identify_baybayin.this, "Complete the answer!", Toast.LENGTH_SHORT).show();
                        }
                        if (answer1.equals("")){
                            ans1.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans1.setBackgroundColor(white);
                        }
                        if (answer2.equals("")) {
                            ans2.setBackgroundResource(R.drawable.container_answer_red);
                        } else {
                            ans2.setBackgroundColor(white);
                        }
                        if (answer3.equals("")) {
                            ans3.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans3.setBackgroundColor(white);
                        }
                        if (answer4.equals("")) {
                            ans4.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans4.setBackgroundColor(white);
                        }
                        if (!answer1.equals("") && !answer2.equals("") && !answer3.equals("") && !answer4.equals("")) {
                            if (!answer1.equals("m") || !answer2.equals("a") || !answer3.equals("m") || !answer4.equals("a")){
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                                wrong.setVisibility(View.VISIBLE);
                            }
                            if (!answer1.equals("m")){
                                ans1.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans1.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer2.equals("a")) {
                                ans2.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans2.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer3.equals("m")) {
                                ans3.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans3.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer4.equals("a")) {
                                ans4.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans4.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (answer1.equals("m") && answer2.equals("a") && answer3.equals("m") && answer4.equals("a")) {
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Tama ang iyong sagot!", Toast.LENGTH_SHORT).show();
                                correct.setVisibility(View.VISIBLE);
                                wrong.setVisibility(View.GONE);
                                surrin.setText("Next");
                                score += 1;

                            }
                        }
                    }
                    if (currentIndex == 12){
                        if (answer1.equals("") || answer2.equals("") || answer3.equals("") || answer4.equals("")){
                            Toast.makeText(Yunit4_Identify_baybayin.this, "Complete the answer!", Toast.LENGTH_SHORT).show();
                        }
                        if (answer1.equals("")){
                            ans1.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans1.setBackgroundColor(white);
                        }
                        if (answer2.equals("")) {
                            ans2.setBackgroundResource(R.drawable.container_answer_red);
                        } else {
                            ans2.setBackgroundColor(white);
                        }
                        if (answer3.equals("")) {
                            ans3.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans3.setBackgroundColor(white);
                        }
                        if (answer4.equals("")) {
                            ans4.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans4.setBackgroundColor(white);
                        }
                        if (!answer1.equals("") && !answer2.equals("") && !answer3.equals("") && !answer4.equals("")) {
                            if (!answer1.equals("n") || !answer2.equals("a") || !answer3.equals("n") || !answer4.equals("a")){
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                                wrong.setVisibility(View.VISIBLE);
                            }
                            if (!answer1.equals("n")){
                                ans1.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans1.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer2.equals("a")) {
                                ans2.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans2.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer3.equals("n")) {
                                ans3.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans3.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer4.equals("a")) {
                                ans4.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans4.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (answer1.equals("n") && answer2.equals("a") && answer3.equals("n") && answer4.equals("a")) {
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Tama ang iyong sagot!", Toast.LENGTH_SHORT).show();
                                correct.setVisibility(View.VISIBLE);
                                wrong.setVisibility(View.GONE);
                                surrin.setText("Next");
                                score += 1;

                            }
                        }
                    }
                    if (currentIndex == 13){
                        if (answer1.equals("") || answer2.equals("") || answer3.equals("") || answer4.equals("")){
                            Toast.makeText(Yunit4_Identify_baybayin.this, "Complete the answer!", Toast.LENGTH_SHORT).show();
                        }
                        if (answer1.equals("")){
                            ans1.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans1.setBackgroundColor(white);
                        }
                        if (answer2.equals("")) {
                            ans2.setBackgroundResource(R.drawable.container_answer_red);
                        } else {
                            ans2.setBackgroundColor(white);
                        }
                        if (answer3.equals("")) {
                            ans3.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans3.setBackgroundColor(white);
                        }
                        if (answer4.equals("")) {
                            ans4.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans4.setBackgroundColor(white);
                        }
                        if (!answer1.equals("") && !answer2.equals("") && !answer3.equals("") && !answer4.equals("")) {
                            if (!answer1.equals("p") || !answer2.equals("a") || !answer3.equals("l") || !answer4.equals("a")){
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                                wrong.setVisibility(View.VISIBLE);
                            }
                            if (!answer1.equals("p")){
                                ans1.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans1.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer2.equals("a")) {
                                ans2.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans2.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer3.equals("l")) {
                                ans3.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans3.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer4.equals("a")) {
                                ans4.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans4.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (answer1.equals("p") && answer2.equals("a") && answer3.equals("l") && answer4.equals("a")) {
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Tama ang iyong sagot!", Toast.LENGTH_SHORT).show();
                                correct.setVisibility(View.VISIBLE);
                                wrong.setVisibility(View.GONE);
                                surrin.setText("Next");
                                score += 1;

                            }
                        }
                    }
                    if (currentIndex == 14){
                        if (answer1.equals("") || answer2.equals("") || answer3.equals("") || answer4.equals("")){
                            Toast.makeText(Yunit4_Identify_baybayin.this, "Complete the answer!", Toast.LENGTH_SHORT).show();
                        }
                        if (answer1.equals("")){
                            ans1.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans1.setBackgroundColor(white);
                        }
                        if (answer2.equals("")) {
                            ans2.setBackgroundResource(R.drawable.container_answer_red);
                        } else {
                            ans2.setBackgroundColor(white);
                        }
                        if (answer3.equals("")) {
                            ans3.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans3.setBackgroundColor(white);
                        }
                        if (answer4.equals("")) {
                            ans4.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans4.setBackgroundColor(white);
                        }
                        if (!answer1.equals("") && !answer2.equals("") && !answer3.equals("") && !answer4.equals("")) {
                            if (!answer1.equals("p") || !answer2.equals("a") || !answer3.equals("t") || !answer4.equals("a")){
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                                wrong.setVisibility(View.VISIBLE);
                            }
                            if (!answer1.equals("p")){
                                ans1.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans1.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer2.equals("a")) {
                                ans2.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans2.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer3.equals("t")) {
                                ans3.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans3.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer4.equals("a")) {
                                ans4.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans4.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (answer1.equals("p") && answer2.equals("a") && answer3.equals("t") && answer4.equals("a")) {
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Tama ang iyong sagot!", Toast.LENGTH_SHORT).show();
                                correct.setVisibility(View.VISIBLE);
                                wrong.setVisibility(View.GONE);
                                surrin.setText("Next");
                                score += 1;

                            }
                        }
                    }
                    if (currentIndex == 15){
                        if (answer1.equals("") || answer2.equals("") || answer3.equals("") || answer4.equals("")){
                            Toast.makeText(Yunit4_Identify_baybayin.this, "Complete the answer!", Toast.LENGTH_SHORT).show();
                        }
                        if (answer1.equals("")){
                            ans1.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans1.setBackgroundColor(white);
                        }
                        if (answer2.equals("")) {
                            ans2.setBackgroundResource(R.drawable.container_answer_red);
                        } else {
                            ans2.setBackgroundColor(white);
                        }
                        if (answer3.equals("")) {
                            ans3.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans3.setBackgroundColor(white);
                        }
                        if (answer4.equals("")) {
                            ans4.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans4.setBackgroundColor(white);
                        }
                        if (!answer1.equals("") && !answer2.equals("") && !answer3.equals("") && !answer4.equals("")) {
                            if (!answer1.equals("s") || !answer2.equals("a") || !answer3.equals("g") || !answer4.equals("a")){
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                                wrong.setVisibility(View.VISIBLE);
                            }
                            if (!answer1.equals("s")){
                                ans1.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans1.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer2.equals("a")) {
                                ans2.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans2.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer3.equals("g")) {
                                ans3.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans3.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer4.equals("a")) {
                                ans4.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans4.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (answer1.equals("s") && answer2.equals("a") && answer3.equals("g") && answer4.equals("a")) {
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Tama ang iyong sagot!", Toast.LENGTH_SHORT).show();
                                correct.setVisibility(View.VISIBLE);
                                wrong.setVisibility(View.GONE);
                                surrin.setText("Next");
                                score += 1;

                            }
                        }
                    }
                    if (currentIndex == 16){
                        if (answer1.equals("") || answer2.equals("") || answer3.equals("") || answer4.equals("")){
                            Toast.makeText(Yunit4_Identify_baybayin.this, "Complete the answer!", Toast.LENGTH_SHORT).show();
                        }
                        if (answer1.equals("")){
                            ans1.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans1.setBackgroundColor(white);
                        }
                        if (answer2.equals("")) {
                            ans2.setBackgroundResource(R.drawable.container_answer_red);
                        } else {
                            ans2.setBackgroundColor(white);
                        }
                        if (answer3.equals("")) {
                            ans3.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans3.setBackgroundColor(white);
                        }
                        if (answer4.equals("")) {
                            ans4.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans4.setBackgroundColor(white);
                        }
                        if (!answer1.equals("") && !answer2.equals("") && !answer3.equals("") && !answer4.equals("")) {
                            if (!answer1.equals("s") || !answer2.equals("a") || !answer3.equals("p") || !answer4.equals("a")){
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                                wrong.setVisibility(View.VISIBLE);
                            }
                            if (!answer1.equals("s")){
                                ans1.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans1.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer2.equals("a")) {
                                ans2.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans2.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer3.equals("p")) {
                                ans3.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans3.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer4.equals("a")) {
                                ans4.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans4.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (answer1.equals("s") && answer2.equals("a") && answer3.equals("p") && answer4.equals("a")) {
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Tama ang iyong sagot!", Toast.LENGTH_SHORT).show();
                                correct.setVisibility(View.VISIBLE);
                                wrong.setVisibility(View.GONE);
                                surrin.setText("Next");
                                score += 1;

                            }
                        }
                    }
                    if (currentIndex == 17){
                        if (answer1.equals("") || answer2.equals("") || answer3.equals("") || answer4.equals("")){
                            Toast.makeText(Yunit4_Identify_baybayin.this, "Complete the answer!", Toast.LENGTH_SHORT).show();
                        }
                        if (answer1.equals("")){
                            ans1.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans1.setBackgroundColor(white);
                        }
                        if (answer2.equals("")) {
                            ans2.setBackgroundResource(R.drawable.container_answer_red);
                        } else {
                            ans2.setBackgroundColor(white);
                        }
                        if (answer3.equals("")) {
                            ans3.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans3.setBackgroundColor(white);
                        }
                        if (answer4.equals("")) {
                            ans4.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans4.setBackgroundColor(white);
                        }
                        if (!answer1.equals("") && !answer2.equals("") && !answer3.equals("") && !answer4.equals("")) {
                            if (!answer1.equals("t") || !answer2.equals("a") || !answer3.equals("b") || !answer4.equals("a")){
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                                wrong.setVisibility(View.VISIBLE);
                            }
                            if (!answer1.equals("t")){
                                ans1.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans1.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer2.equals("a")) {
                                ans2.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans2.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer3.equals("b")) {
                                ans3.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans3.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer4.equals("a")) {
                                ans4.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans4.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (answer1.equals("t") && answer2.equals("a") && answer3.equals("b") && answer4.equals("a")) {
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Tama ang iyong sagot!", Toast.LENGTH_SHORT).show();
                                correct.setVisibility(View.VISIBLE);
                                wrong.setVisibility(View.GONE);
                                surrin.setText("Next");
                                score += 1;

                            }
                        }
                    }
                    if (currentIndex == 18){
                        if (answer1.equals("") || answer2.equals("") || answer3.equals("") || answer4.equals("")){
                            Toast.makeText(Yunit4_Identify_baybayin.this, "Complete the answer!", Toast.LENGTH_SHORT).show();
                        }
                        if (answer1.equals("")){
                            ans1.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans1.setBackgroundColor(white);
                        }
                        if (answer2.equals("")) {
                            ans2.setBackgroundResource(R.drawable.container_answer_red);
                        } else {
                            ans2.setBackgroundColor(white);
                        }
                        if (answer3.equals("")) {
                            ans3.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans3.setBackgroundColor(white);
                        }
                        if (answer4.equals("")) {
                            ans4.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans4.setBackgroundColor(white);
                        }
                        if (!answer1.equals("") && !answer2.equals("") && !answer3.equals("") && !answer4.equals("")) {
                            if (!answer1.equals("w") || !answer2.equals("a") || !answer3.equals("l") || !answer4.equals("a")){
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                                wrong.setVisibility(View.VISIBLE);
                            }
                            if (!answer1.equals("w")){
                                ans1.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans1.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer2.equals("a")) {
                                ans2.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans2.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer3.equals("l")) {
                                ans3.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans3.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer4.equals("a")) {
                                ans4.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans4.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (answer1.equals("w") && answer2.equals("a") && answer3.equals("l") && answer4.equals("a")) {
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Tama ang iyong sagot!", Toast.LENGTH_SHORT).show();
                                correct.setVisibility(View.VISIBLE);
                                wrong.setVisibility(View.GONE);
                                surrin.setText("Next");
                                score += 1;

                            }
                        }
                    }
                    if (currentIndex == 19){
                        if (answer1.equals("") || answer2.equals("") || answer3.equals("") || answer4.equals("")){
                            Toast.makeText(Yunit4_Identify_baybayin.this, "Complete the answer!", Toast.LENGTH_SHORT).show();
                        }
                        if (answer1.equals("")){
                            ans1.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans1.setBackgroundColor(white);
                        }
                        if (answer2.equals("")) {
                            ans2.setBackgroundResource(R.drawable.container_answer_red);
                        } else {
                            ans2.setBackgroundColor(white);
                        }
                        if (answer3.equals("")) {
                            ans3.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans3.setBackgroundColor(white);
                        }
                        if (answer4.equals("")) {
                            ans4.setBackgroundResource(R.drawable.container_answer_red);
                        }else {
                            ans4.setBackgroundColor(white);
                        }
                        if (!answer1.equals("") && !answer2.equals("") && !answer3.equals("") && !answer4.equals("")) {
                            if (!answer1.equals("y") || !answer2.equals("a") || !answer3.equals("t") || !answer4.equals("a")){
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                                wrong.setVisibility(View.VISIBLE);
                            }
                            if (!answer1.equals("y")){
                                ans1.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans1.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer2.equals("a")) {
                                ans2.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans2.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer3.equals("t")) {
                                ans3.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans3.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (!answer4.equals("a")) {
                                ans4.setBackgroundResource(R.drawable.container_answer_red);
                            }else {
                                ans4.setBackgroundResource(R.drawable.container_answer_blue);
                            }
                            if (answer1.equals("y") && answer2.equals("a") && answer3.equals("t") && answer4.equals("a")) {
                                Toast.makeText(Yunit4_Identify_baybayin.this, "Tama ang iyong sagot!", Toast.LENGTH_SHORT).show();
                                correct.setVisibility(View.VISIBLE);
                                wrong.setVisibility(View.GONE);
                                surrin.setText("Continue");
                                score += 1;

                            }
                        }
                    }
                }
                if (buttonTxt.equals("Next")){
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            correct.setVisibility(View.GONE);
                            ans1.setText("");
                            ans2.setText("");
                            ans3.setText("");
                            ans4.setText("");
                            ans1.setBackgroundColor(white);
                            ans2.setBackgroundColor(white);
                            ans3.setBackgroundColor(white);
                            ans4.setBackgroundColor(white);
                            surrin.setText("Suriin");
                            ans1.requestFocus();
                            if (currentIndex < imageResources.length - 1) {
                                currentIndex++;

                            } else {
                                currentIndex = 0;
                            }
                            // Set the next drawable as the background
                            picContainer.setBackgroundResource(imageResources[currentIndex]);
                            int indexCount = currentIndex + 1;
                            pageCountTxt.setText(indexCount + "/20");
                        }
                    }, 500);
                }
                if (buttonTxt.equals("Continue")){
                    editor.putInt(Yunit4DrawingScore, score);
                    editor.commit();
                    showDialog();
                }


            }
        });



        ans2.setFocusableInTouchMode(true);
        ans3.setFocusableInTouchMode(true);
        ans4.setFocusableInTouchMode(true);

       ans1.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               if (charSequence.length() == 1) {
                   ans2.requestFocus();
               }
           }

           @Override
           public void afterTextChanged(Editable editable) {

           }
       });

        ans2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 1) {
                    ans3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        ans3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 1) {
                    ans4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        ans4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 1) {
                    // Move focus to editText2
                    hideKeyboard(ans4);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



    }
    private void hideKeyboard(View view) {

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    private void showDialog(){
        View alertCustomDialog = LayoutInflater.from(Yunit4_Identify_baybayin.this).inflate(R.layout.dialog_congratulation, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Yunit4_Identify_baybayin.this);
        alertDialog.setView(alertCustomDialog);
        Button continueBtn = (Button) alertCustomDialog.findViewById(R.id.magpatuloyBtn);
        final AlertDialog d_dialog = alertDialog.create();

        d_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        d_dialog.show();

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                d_dialog.cancel();
            }
        });
    }

}