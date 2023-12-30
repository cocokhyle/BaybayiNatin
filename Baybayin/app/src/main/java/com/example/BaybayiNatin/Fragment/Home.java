package com.example.BaybayiNatin.Fragment;

import static android.content.Context.MODE_PRIVATE;

import static com.example.BaybayiNatin.Fragment.Profile.Yunit2DrawingScore;
import static com.example.BaybayiNatin.Fragment.Profile.Yunit3DrawingScore;
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

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.BaybayiNatin.Lessons.Yunit1_Lesson_Kahalagahan;
import com.example.BaybayiNatin.Lessons.Yunit1_Lesson_Pagsisimula;
import com.example.BaybayiNatin.Lessons.Yunit2_Lesson_Introduction;
import com.example.BaybayiNatin.Lessons.Yunit2_Lesson_Patinig;
import com.example.BaybayiNatin.Lessons.Yunit3_Lesson_Ba_Ka;
import com.example.BaybayiNatin.Lessons.Yunit3_Lesson_Da_Ga;
import com.example.BaybayiNatin.Lessons.Yunit3_Lesson_Ha_La;
import com.example.BaybayiNatin.Lessons.Yunit3_Lesson_Introduction;
import com.example.BaybayiNatin.Lessons.Yunit3_Lesson_Ma_Na;
import com.example.BaybayiNatin.Lessons.Yunit3_Lesson_Nga_Pa;
import com.example.BaybayiNatin.Lessons.Yunit3_Lesson_Ra_Sa;
import com.example.BaybayiNatin.Lessons.Yunit3_Lesson_Ta_Wa;
import com.example.BaybayiNatin.Lessons.Yunit3_Lesson_Ya;
import com.example.BaybayiNatin.Quiz.Yunit3_Pagsulat;
import com.example.BaybayiNatin.Quiz.Yunit4_Identify_baybayin;
import com.example.BaybayiNatin.R;
import com.example.BaybayiNatin.databinding.FragmentHomeBinding;


public class Home extends Fragment {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    FragmentHomeBinding binding;
    public static final String SHARED_PREF_NAME= "MyPreferences";
    public static final String Quiz_Note = "Quiz_Note";
    public static final String Key = "Kahalagahan";
    public static final String Yunit2_Intro = "intro";
    public static final String Yunit2_Patinig = "patinig";
    public static final String Yunit2_Pagsulat = "Pagsulat";
    public static final String Yunit3_intro = "Yunit3_intro";
    public static final String Yunit3_baka = "Yunit3_baka";
    public static final String Yunit3_daga = "daga";
    public static final String Yunit3_hala = "hala";
    public static final String Yunit3_mana = "mana";
    public static final String Yunit3_ngapa = "ngapa";
    public static final String Yunit3_rasa = "rasa";
    public static final String Yunit3_tawa = "tawa";
    public static final String Yunit3_ya = "ya";
    public static final String Yunit3_pagsulat = "Yunit3Pagsulat";
    public static final String Yunit4_pagkilala = "Yunit4_pagkilala";

    private String key;
    private String Yunit2_intro;

    private String Yunit2_patinig;
    private String Yunit2_pagsulat;
    private String Yunit3_introduction;
    private String Yunit3_Baka;
    private String Yunit3_Daga;
    private String Yunit3_Hala;
    private String Yunit3_Mana;
    private String Yunit3_Ngapa;
    private String Yunit3_Rasa;
    private String Yunit3_Tawa;
    private String Yunit3_Ya;
    private String Yunit3Pagsulat;
    private String Yunit4Pagkilala;
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

    private int Yunit2_DrawingScore;
    private int Yunit3_DrawingScore;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        preferences = getContext().getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        editor = preferences.edit();

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

        Yunit2_DrawingScore = preferences.getInt(Yunit2DrawingScore, 0);
        Yunit3_DrawingScore = preferences.getInt(Yunit3DrawingScore, 0);



        View alertCustomDialog = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_warning, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(requireContext());
        alertDialog.setView(alertCustomDialog);
        Button w_magpatuloy = (Button) alertCustomDialog.findViewById(R.id.w_magpatuloy);
        TextView w_message = (TextView) alertCustomDialog.findViewById(R.id.w_message);
        final AlertDialog w_dialog = alertDialog.create();

        key = preferences.getString(Key, null);
        Yunit2_intro = preferences.getString(Yunit2_Intro, null);
        Yunit2_patinig = preferences.getString(Yunit2_Patinig, null);
        Yunit2_pagsulat = preferences.getString(Yunit2_Pagsulat, null);
        Yunit3_introduction = preferences.getString(Yunit3_intro, null);
        Yunit3_Baka = preferences.getString(Yunit3_baka, null);
        Yunit3_Daga = preferences.getString(Yunit3_daga, null);
        Yunit3_Hala = preferences.getString(Yunit3_hala, null);
        Yunit3_Mana = preferences.getString(Yunit3_mana, null);
        Yunit3_Ngapa = preferences.getString(Yunit3_ngapa, null);
        Yunit3_Rasa = preferences.getString(Yunit3_rasa, null);
        Yunit3_Tawa = preferences.getString(Yunit3_tawa, null);
        Yunit3_Ya = preferences.getString(Yunit3_ya, null);
        Yunit3Pagsulat = preferences.getString(Yunit3_pagsulat, null);
        Yunit4Pagkilala = preferences.getString(Yunit4_pagkilala, null);


        final FrameLayout kahalagahan = binding.Kahalagahan;
        final FrameLayout yunit2_into = binding.yunit2Intro;
        final FrameLayout yunit2_patinig = binding.yunit2Patinig;
        final FrameLayout yunit2_Pagsulat = binding.yunit2PagsulatPatinig;
        final FrameLayout yunit3Intro = binding.yunit3Intro;
        final FrameLayout yunit3Baka = binding.yunit3Baka;
        final FrameLayout yunit3Daga = binding.yunit3Daga;
        final FrameLayout yunit3Hala = binding.yunit3Hala;
        final FrameLayout yunit3Mana = binding.yunit3Mana;
        final FrameLayout yunit3Ngapa = binding.yunit3Ngapa;
        final FrameLayout yunit3Rasa = binding.yunit3Rasa;
        final FrameLayout yunit3Tawa = binding.yunit3Tawa;
        final FrameLayout yunit3Ya = binding.yunit3Ya;
        final FrameLayout yunit3Pagsulat = binding.yunit3PagsulatKatinig;
        final FrameLayout yunit4Pagkilala = binding.yunit4PagsulatBaybayin;

        TextView yunit1_score = binding.yunit1Score;
        TextView yunit2_score = binding.yunit2Score;
        TextView yunit3_1_score = binding.yunit31Score;
        TextView yunit3_2_score = binding.yunit32Score;
        TextView yunit3_3_score = binding.yunit33Score;
        TextView yunit3_4_score = binding.yunit34Score;
        TextView yunit3_5_score = binding.yunit35Score;
        TextView yunit3_6_score = binding.yunit36Score;
        TextView yunit3_7_score = binding.yunit37Score;
        TextView yunit3_8_score = binding.yunit38Score;

        if (yunit1 != 0){
            yunit1_score.setText(yunit1 + " / 5");
        }else {
            yunit1_score.setText("- / 5");
        }
        if (yunit2 != 0){
            yunit2_score.setText(yunit2 + " / 5");
        }else {
            yunit2_score.setText("- / 5");
        }
        if (yunit3_1 != 0){
            yunit3_1_score.setText(yunit3_1 + " / 5");
        }else {
            yunit3_1_score.setText("- / 5");
        }
        if (yunit3_2 != 0){
            yunit3_2_score.setText(yunit3_2 + " / 5");
        }else {
            yunit3_2_score.setText("- / 5");
        }
        if (yunit3_3 != 0){
            yunit3_3_score.setText(yunit3_3 + " / 5");
        }else {
            yunit3_3_score.setText("- / 5");
        }
        if (yunit3_3 != 0){
            yunit3_3_score.setText(yunit3_3 + " / 5");
        }else {
            yunit3_3_score.setText("- / 5");
        }
        if (yunit3_4 != 0){
            yunit3_4_score.setText(yunit3_4 + " / 5");
        }else {
            yunit3_4_score.setText("- / 5");
        }
        if (yunit3_5 != 0){
            yunit3_5_score.setText(yunit3_5 + " / 5");
        }else {
            yunit3_5_score.setText("- / 5");
        }
        if (yunit3_6 != 0){
            yunit3_6_score.setText(yunit3_6 + " / 5");
        }else {
            yunit3_6_score.setText("- / 5");
        }
        if (yunit3_7 != 0){
            yunit3_7_score.setText(yunit3_7 + " / 5");
        }else {
            yunit3_7_score.setText("- / 5");
        }
        if (yunit3_8 != 0){
            yunit3_8_score.setText(yunit3_8 + " / 5");
        }else {
            yunit3_8_score.setText("- / 5");
        }



        if (key != null){
            kahalagahan.setBackgroundResource(R.drawable.container_green);
        }else {
            kahalagahan.setBackgroundResource(R.drawable.container_grey);
        }
        if (Yunit2_intro != null){
            yunit2_into.setBackgroundResource(R.drawable.container_green);
        }else {
            yunit2_into.setBackgroundResource(R.drawable.container_grey);
        }
        if (Yunit2_patinig != null){
            yunit2_patinig.setBackgroundResource(R.drawable.container_green);
        }else {
            yunit2_patinig.setBackgroundResource(R.drawable.container_grey);
        }
        if (Yunit2_pagsulat != null){
            yunit2_Pagsulat.setBackgroundResource(R.drawable.container_green);
        }else {
            yunit2_Pagsulat.setBackgroundResource(R.drawable.container_grey);
        }
        if (Yunit3_introduction != null){
            yunit3Intro.setBackgroundResource(R.drawable.container_green);
        }else {
            yunit3Intro.setBackgroundResource(R.drawable.container_grey);
        }
        if (Yunit3_Baka != null){
            yunit3Baka.setBackgroundResource(R.drawable.container_green);
        }else {
            yunit3Baka.setBackgroundResource(R.drawable.container_grey);
        }
        if (Yunit3_Daga != null){
            yunit3Daga.setBackgroundResource(R.drawable.container_green);
        }else {
            yunit3Daga.setBackgroundResource(R.drawable.container_grey);
        }
        if (Yunit3_Hala != null){
            yunit3Hala.setBackgroundResource(R.drawable.container_green);
        }else {
            yunit3Hala.setBackgroundResource(R.drawable.container_grey);
        }
        if (Yunit3_Mana != null){
            yunit3Mana.setBackgroundResource(R.drawable.container_green);
        }else {
            yunit3Mana.setBackgroundResource(R.drawable.container_grey);
        }
        if (Yunit3_Ngapa != null){
            yunit3Ngapa.setBackgroundResource(R.drawable.container_green);
        }else {
            yunit3Ngapa.setBackgroundResource(R.drawable.container_grey);
        }
        if (Yunit3_Rasa != null){
            yunit3Rasa.setBackgroundResource(R.drawable.container_green);
        }else {
            yunit3Rasa.setBackgroundResource(R.drawable.container_grey);
        }
        if (Yunit3_Tawa != null){
            yunit3Tawa.setBackgroundResource(R.drawable.container_green);
        }else {
            yunit3Tawa.setBackgroundResource(R.drawable.container_grey);
        }
        if (Yunit3_Ya != null){
            yunit3Ya.setBackgroundResource(R.drawable.container_green);
        }else {
            yunit3Ya.setBackgroundResource(R.drawable.container_grey);
        }
        if (Yunit3Pagsulat != null){
            yunit3Pagsulat.setBackgroundResource(R.drawable.container_green);
        }else {
            yunit3Pagsulat.setBackgroundResource(R.drawable.container_grey);
        }
        if (Yunit4Pagkilala != null){
            yunit4Pagkilala.setBackgroundResource(R.drawable.container_green);
        }else {
            yunit4Pagkilala.setBackgroundResource(R.drawable.container_grey);
        }


        View.OnClickListener clickListener = v -> {
            if (v == binding.Pagsisimula){
                Intent intent = new Intent(requireContext(), Yunit1_Lesson_Pagsisimula.class);
                startActivity(intent);
            }
            else if (v == kahalagahan){
                if (key != null){
                    Intent intent = new Intent(requireContext(), Yunit1_Lesson_Kahalagahan.class);
                    startActivity(intent);
                }else {
                    w_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    w_dialog.show();
                }
            }
            else if (v == yunit2_into){
                if (key != null){
                    Intent intent = new Intent(requireContext(), Yunit2_Lesson_Introduction.class);
                    startActivity(intent);
                }else {
                    w_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    w_dialog.show();
                }
            }
            else if (v == yunit2_patinig){
                if (key != null){
                    Intent intent = new Intent(requireContext(), Yunit2_Lesson_Patinig.class);
                    startActivity(intent);
                }else {
                    w_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    w_dialog.show();
                }
            }
            else if (v == yunit2_Pagsulat){
                if (key != null){
                    Intent intent = new Intent(requireContext(), com.example.BaybayiNatin.Quiz.Yunit2_Pagsulat.class);
                    startActivity(intent);
                }else {
                    w_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    w_dialog.show();
                }
            }
            else if (v == yunit3Intro){
                if (Yunit3_introduction != null){
                    Intent intent = new Intent(requireContext(), Yunit3_Lesson_Introduction.class);
                    startActivity(intent);
                }else {
                    w_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    w_dialog.show();
                }
            }
            else if (v == yunit3Baka){
                if (Yunit3_Baka != null){
                    Intent intent = new Intent(requireContext(), Yunit3_Lesson_Ba_Ka.class);
                    startActivity(intent);
                }else {
                    w_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    w_dialog.show();
                }
            }
            else if (v == yunit3Daga){
                if (Yunit3_Baka != null){
                    Intent intent = new Intent(requireContext(), Yunit3_Lesson_Da_Ga.class);
                    startActivity(intent);
                }else {
                    w_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    w_dialog.show();
                }
            }
            else if (v == yunit3Hala){
                if (Yunit3_Hala != null){
                    Intent intent = new Intent(requireContext(), Yunit3_Lesson_Ha_La.class);
                    startActivity(intent);
                }else {
                    w_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    w_dialog.show();
                }
            }
            else if (v == yunit3Mana){

                if (Yunit3_Mana != null){
                    Intent intent = new Intent(requireContext(), Yunit3_Lesson_Ma_Na.class);
                    startActivity(intent);
                }else {
                    w_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    w_dialog.show();
                }
            }
            else if (v == yunit3Ngapa){
                if (Yunit3_Ngapa != null){
                    Intent intent = new Intent(requireContext(), Yunit3_Lesson_Nga_Pa.class);
                    startActivity(intent);
                }else {
                    w_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    w_dialog.show();
                }
            }
            else if (v == yunit3Rasa){
                if (Yunit3_Rasa != null){
                    Intent intent = new Intent(requireContext(), Yunit3_Lesson_Ra_Sa.class);
                    startActivity(intent);
                }else {
                    w_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    w_dialog.show();
                }
            }
            else if (v == yunit3Tawa){
                if (Yunit3_Tawa != null){
                    Intent intent = new Intent(requireContext(), Yunit3_Lesson_Ta_Wa.class);
                    startActivity(intent);
                }else {
                    w_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    w_dialog.show();
                }
            }
            else if (v == yunit3Ya){
                if (Yunit3_Ya != null){
                    Intent intent = new Intent(requireContext(), Yunit3_Lesson_Ya.class);
                    startActivity(intent);
                }else {
                    w_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    w_dialog.show();
                }
            }
            else if (v == yunit3Pagsulat){
                if (Yunit3Pagsulat != null){
                    Intent intent = new Intent(requireContext(), Yunit3_Pagsulat.class);
                    startActivity(intent);
                }else {
                    w_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    w_dialog.show();
                }
            }
            else if (v == yunit4Pagkilala){
                if (Yunit4Pagkilala != null){
                    Intent intent = new Intent(requireContext(), Yunit4_Identify_baybayin.class);
                    startActivity(intent);
                }else {
                    w_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    w_dialog.show();
                }
            }
        };
        binding.Pagsisimula.setOnClickListener(clickListener);
        kahalagahan.setOnClickListener(clickListener);
        yunit2_into.setOnClickListener(clickListener);
        yunit2_patinig.setOnClickListener(clickListener);
        yunit2_Pagsulat.setOnClickListener(clickListener);
        yunit3Intro.setOnClickListener(clickListener);
        yunit3Baka.setOnClickListener(clickListener);
        yunit3Daga.setOnClickListener(clickListener);
        yunit3Hala.setOnClickListener(clickListener);
        yunit3Mana.setOnClickListener(clickListener);
        yunit3Ngapa.setOnClickListener(clickListener);
        yunit3Rasa.setOnClickListener(clickListener);
        yunit3Tawa.setOnClickListener(clickListener);
        yunit3Ya.setOnClickListener(clickListener);
        yunit3Pagsulat.setOnClickListener(clickListener);
        yunit4Pagkilala.setOnClickListener(clickListener);

        w_magpatuloy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w_dialog.cancel();
            }
        });

        binding.profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new Profile());
            }
        });


    return binding.getRoot();


    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}