package com.example.BaybayiNatin.Fragment;

import static android.content.Context.MODE_PRIVATE;

import static com.example.BaybayiNatin.Fragment.Home.SHARED_PREF_NAME;
import static com.example.BaybayiNatin.Quiz.Yunit1_Quiz.Yunit1_Quiz_Score;
import static com.example.BaybayiNatin.Quiz.Yunit2_Quiz.Yunit2_Quiz_Score;
import static com.example.BaybayiNatin.Quiz.Yunit3_Quiz_BaKa.Yunit3_Quiz_1_Score;
import static com.example.BaybayiNatin.Quiz.Yunit3_Quiz_DaGa.Yunit3_Quiz_2_Score;
import static com.example.BaybayiNatin.Quiz.Yunit3_Quiz_HaLa.Yunit3_Quiz_3_Score;
import static com.example.BaybayiNatin.Quiz.Yunit3_Quiz_Mana.Yunit3_Quiz_4_Score;
import static com.example.BaybayiNatin.Quiz.Yunit3_Quiz_Ngapa.Yunit3_Quiz_5_Score;
import static com.example.BaybayiNatin.Quiz.Yunit3_Quiz_RaSa.Yunit3_Quiz_6_Score;
import static com.example.BaybayiNatin.Quiz.Yunit3_Quiz_TaWa.Yunit3_Quiz_7_Score;
import static com.example.BaybayiNatin.Quiz.Yunit3_Quiz_Ya.Yunit3_Quiz_8_Score;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.BaybayiNatin.R;
import com.example.BaybayiNatin.databinding.FragmentProfileBinding;

public class Profile extends Fragment {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    public static final String Yunit1Pagsisimula = "Yunit1_Pagsisimula";
    public static final String Yunit1Kahalagahan = "Yunit1_Kahalagahan";
    public static final String Yunit2Intro = "Yunit2_intro";
    public static final String Yunit2Patinig= "Yunit2_patinig";
    public static final String Yunit3_panimula = "Yunit3_panimula";
    public static final String Yunit3_Ba_ka = "Yunit3_Ba_ka";
    public static final String Yunit3_Da_ga = "Yunit3_Da_ga";
    public static final String Yunit3_Ha_la = "Yunit3_Ha_la";
    public static final String Yunit3_Ma_na = "Yunit3_Ma_na";
    public static final String Yunit3_Nga_pa = "Yunit3_Nga_pa";
    public static final String Yunit3_Ra_sa = "Yunit3_Ra_sa";
    public static final String Yunit3_Ta_wa = "Yunit3_Ta_wa";
    public static final String Yunit3_Ya_ = "Yunit3_Ya_";
    public static final String Letrang_NasulatA = "Letrang_NasulatA";
    public static final String Letrang_NasulatEI = "Letrang_NasulatEI";
    public static final String Letrang_NasulatOU= "Letrang_NasulatOU";
    public static final String Letrang_Nasulatdara= "Letrang_Nasulatdara";
    public static final String Letrang_Nasulatga= "Letrang_Nasulatga";
    public static final String Letrang_Nasulatha= "Letrang_Nasulatha";
    public static final String Letrang_Nasulatka= "Letrang_Nasulatka";
    public static final String Letrang_Nasulatla= "Letrang_Nasulatla";
    public static final String Letrang_Nasulatma= "Letrang_Nasulatma";
    public static final String Letrang_Nasulatna= "Letrang_Nasulatna";
    public static final String Letrang_Nasulatnga= "Letrang_Nasulatnga";
    public static final String Letrang_Nasulatpa= "Letrang_Nasulatpa";
    public static final String Letrang_Nasulatsa= "Letrang_Nasulatsa";
    public static final String Letrang_Nasulatta= "Letrang_Nasulatta";
    public static final String Letrang_Nasulatwa= "Letrang_Nasulatwa";
    public static final String Letrang_Nasulatya= "Letrang_Nasulatya";

    public static final String Yunit2DrawingScore= "Yunit2DrawingScore";
    public static final String Yunit3DrawingScore= "Yunit3DrawingScore";
    public static final String Yunit4DrawingScore= "Yunit4DrawingScore";




    FragmentProfileBinding binding;
    ProgressBar ProgressBar;
    ProgressBar Yunit1ProgressBar;
    ProgressBar Yunit2ProgressBar;
    ProgressBar Yunit3ProgressBar;

    private Float kahalagahan;
    private Float pagsisimula;
    private Float yunit2Intro;
    private Float yunit2Patinig;
    private Float yunit3Intro;
    private Float yunit3Baka;
    private Float yunit3Daga;
    private Float yunit3Hala;
    private Float yunit3Mana;
    private  Float yunit3Ngapa;
    private  Float yunit3Rasa;
    private Float yunit3Tawa;
    private Float yunit3Ya;
    float from = 0.0f; // Set your desired initial progress (as a percentage)
    float to = 0.0f;
    float yunit2_to = 0.0f;
    float yunit3_to = 0.0f;
    float yunit4_score;

    int score = 0;
    private int scoreA = 0;
    private int scoreEI = 0;
    private int scoreOU = 0;
    private int scoredara = 0;
    private int scorega = 0;
    private int scoreha = 0;
    private int scoreka = 0;
    private int scorela = 0;
    private int scorema = 0;
    private int scorena = 0;
    private int scorenga = 0;
    private int scorepa= 0;
    private int scoresa = 0;
    private int scoreta = 0;
    private int scorewa = 0;
    private int scoreya = 0;

    private int yunit1;
    private int yunit2;
    private int yunit3_1;
    private int yunit3_2;
    private int yunit3_3;
    private int yunit3_4;
    private int yunit3_5;
    private int yunit3_6;
    private int yunit3_7;
    private int yunit3_8;

    int percentage = 0;

    int quizScore = 0;

    int aveQuizScore = 0;
    int aveDrawScore = 0;
    int total = 0;
    float totalAverage = 0;

    int yunit2DrawingScore;
    int yunit3DrawingScore;
    int yunit4Score;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        preferences = getContext().getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        editor = preferences.edit();

        pagsisimula = preferences.getFloat(Yunit1Pagsisimula, 0);
        kahalagahan = preferences.getFloat(Yunit1Kahalagahan, 0);
        yunit2Intro = preferences.getFloat(Yunit2Intro, 0);
        yunit2Patinig = preferences.getFloat(Yunit2Patinig, 0);
        yunit3Intro = preferences.getFloat(Yunit3_panimula, 0);
        yunit3Baka = preferences.getFloat(Yunit3_Ba_ka, 0);
        yunit3Daga = preferences.getFloat(Yunit3_Da_ga, 0);
        yunit3Hala = preferences.getFloat(Yunit3_Ha_la, 0);
        yunit3Mana = preferences.getFloat(Yunit3_Ma_na, 0);
        yunit3Ngapa = preferences.getFloat(Yunit3_Nga_pa, 0);
        yunit3Rasa = preferences.getFloat(Yunit3_Ra_sa, 0);
        yunit3Tawa = preferences.getFloat(Yunit3_Ta_wa, 0);
        yunit3Ya = preferences.getFloat(Yunit3_Ya_, 0);

        TextView letrangNasulat = binding.letrangNasulat;
        TextView percent = binding.percentage;
        scoreA = preferences.getInt(Letrang_NasulatA, 0);
        scoreEI = preferences.getInt(Letrang_NasulatEI, 0);
        scoreOU = preferences.getInt(Letrang_NasulatOU, 0);
        scoredara = preferences.getInt(Letrang_Nasulatdara, 0);
        scorega = preferences.getInt(Letrang_Nasulatga, 0);
        scoreha = preferences.getInt(Letrang_Nasulatha, 0);
        scoreka = preferences.getInt(Letrang_Nasulatka, 0);
        scorela = preferences.getInt(Letrang_Nasulatla, 0);
        scorema = preferences.getInt(Letrang_Nasulatma, 0);
        scorena = preferences.getInt(Letrang_Nasulatna, 0);
        scorenga = preferences.getInt(Letrang_Nasulatnga, 0);
        scorepa= preferences.getInt(Letrang_Nasulatpa, 0);
        scoresa = preferences.getInt(Letrang_Nasulatsa, 0);
        scoreta = preferences.getInt(Letrang_Nasulatta, 0);
        scorewa = preferences.getInt(Letrang_Nasulatwa, 0);
        scoreya = preferences.getInt(Letrang_Nasulatya, 0);
        yunit4Score = preferences.getInt(Yunit4DrawingScore, 0);

        score = scoreA + scoreEI + scoreOU + scoredara + scorega + scoreha + scoreka +
        scorela + scorema + scorena + scorenga + scorepa + scoresa + scoreta + scorewa + scoreya;

        yunit2DrawingScore = scoreA + scoreEI + scoreOU;
        yunit3DrawingScore = scoredara + scorega + scoreha + scoreka +
                scorela + scorema + scorena + scorenga + scorepa + scoresa + scoreta + scorewa + scoreya;

        editor.putInt(Yunit2DrawingScore, yunit2DrawingScore);
        editor.putInt(Yunit3DrawingScore, yunit3DrawingScore);
        editor.commit();




    yunit1 = preferences.getInt(Yunit1_Quiz_Score, 0);
    yunit2 = preferences.getInt(Yunit2_Quiz_Score, 0);
    yunit3_1 = preferences.getInt(Yunit3_Quiz_1_Score, 0);
    yunit3_2 = preferences.getInt(Yunit3_Quiz_2_Score, 0);
    yunit3_3 = preferences.getInt(Yunit3_Quiz_3_Score, 0);
    yunit3_4 = preferences.getInt(Yunit3_Quiz_4_Score, 0);
    yunit3_5 = preferences.getInt(Yunit3_Quiz_5_Score, 0);
    yunit3_6 = preferences.getInt(Yunit3_Quiz_6_Score, 0);
    yunit3_7 = preferences.getInt(Yunit3_Quiz_7_Score, 0);
    yunit3_8 = preferences.getInt(Yunit3_Quiz_8_Score, 0);

    quizScore = yunit1 + yunit2 + yunit3_1 + yunit3_2 + yunit3_3 + yunit3_4 + yunit3_5 + yunit3_6 + yunit3_7 + yunit3_8;
    aveQuizScore = ((quizScore * 100)/50)/2;
        aveDrawScore = ((score * 100)/16)/2;

        total = (aveQuizScore + aveDrawScore);
        float totalAsFloat = (float) total;

        totalAverage = totalAsFloat / 100;

        ImageView circle_1 = binding.circle1;
        ImageView circle_2 = binding.circle2;
        ImageView circle_3 = binding.circle3;

        if (yunit4Score != 0){
            yunit4_score = (float) (yunit4Score * 5) /100;
        }


        percentage = (score * 100 )/ 16;
        letrangNasulat.setText(score + " / 16");
        percent.setText(percentage + "%");

        if (totalAverage >= 0.01){
            circle_1.setBackgroundResource(R.drawable.circle_container_green);
        }
        if (totalAverage >=0.5){
            circle_2.setBackgroundResource(R.drawable.circle_container_green);
        }
        if (totalAverage >=1.0){
            circle_3.setBackgroundResource(R.drawable.circle_container_green);
        }



        to = pagsisimula+kahalagahan;
        yunit2_to = yunit2Intro + yunit2Patinig;
        yunit3_to = yunit3Intro + yunit3Baka + yunit3Daga + yunit3Hala + yunit3Mana + yunit3Ngapa + yunit3Rasa + yunit3Tawa + yunit3Ya;

        ProgressBar = binding.ProgressBar;
        Yunit1ProgressBar = binding.yunit1ProgressBar;
        Yunit2ProgressBar = binding.yunit2ProgressBar;
        Yunit3ProgressBar = binding.yunit3ProgressBar;
        ProgressBar yunit4ProgressBar = binding.yunit4ProgressBar;

       // Set your desired final progress (as a percentage)
        ProgressBarAnimation animation = new ProgressBarAnimation(ProgressBar, from, totalAverage);
        animation.setDuration(500); // Set the duration of the animation
        ProgressBar.startAnimation(animation);

        ProgressBarAnimation animation1 = new ProgressBarAnimation(Yunit1ProgressBar, from, to);
        animation1.setDuration(500); // Set the duration of the animation
        Yunit1ProgressBar.startAnimation(animation1);

        ProgressBarAnimation animation2 = new ProgressBarAnimation(Yunit2ProgressBar, from, yunit2_to);
        animation2.setDuration(500); // Set the duration of the animation
        Yunit2ProgressBar.startAnimation(animation2);

        ProgressBarAnimation animation3 = new ProgressBarAnimation(Yunit3ProgressBar, from, yunit3_to);
        animation3.setDuration(500); // Set the duration of the animation
        Yunit3ProgressBar.startAnimation(animation3);

        ProgressBarAnimation animation4 = new ProgressBarAnimation(yunit4ProgressBar, from, yunit4_score);
        animation4.setDuration(500); // Set the duration of the animation
        yunit4ProgressBar.startAnimation(animation4);

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new Home());
            }
        });

        return binding.getRoot();
    }

    private class ProgressBarAnimation extends Animation {
        private ProgressBar progressBar;
        private float from;
        private float to;

        ProgressBarAnimation(ProgressBar progressBar, float from, float to) {
            this.progressBar = progressBar;
            this.from = from;
            this.to = to;
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            float value = from + (to - from) * interpolatedTime;
            progressBar.setProgress((int) (value * progressBar.getMax()));
        }
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}
