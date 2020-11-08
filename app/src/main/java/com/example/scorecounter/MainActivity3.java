package com.example.scorecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    private TextView textViewJatekos1Nev,textViewJatekos2Nev,textViewScoreP1,textViewScoreP2;
    private Button buttonMinusP1,buttonPlusP1,buttonMinusP2,buttonPlusP2;
    private int scoreP1,scoreP2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
        clickListeners();



    }
    public void init() {
        textViewJatekos1Nev=findViewById(R.id.textViewJatekos1Nev);
        textViewJatekos2Nev=findViewById(R.id.textViewJatekos2Nev);
        SharedPreferences sharedPreferences = getSharedPreferences("nevek", Context.MODE_PRIVATE);
        textViewScoreP1=findViewById(R.id.jatekos1Score);
        textViewScoreP2=findViewById(R.id.jatekos2Score);
        buttonMinusP1=findViewById(R.id.buttonMinusP1);
        buttonPlusP1=findViewById(R.id.buttonPlusP1);
        buttonMinusP2=findViewById(R.id.buttonMinusP2);
        buttonPlusP2=findViewById(R.id.buttonPlusP2);
        textViewJatekos1Nev.setText(sharedPreferences.getString("jatekos1", "Nincs ilyen adat"));
        textViewJatekos2Nev.setText(sharedPreferences.getString("jatekos2", "Nincs ilyen adat"));
    }
    public void clickListeners() {
        buttonMinusP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (scoreP1==0){
                    scoreP1=0;
                }else {
                    scoreP1 -= 1;
                    textViewScoreP1.setText(String.valueOf(scoreP1));
                }
            }
        });

        buttonPlusP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreP1+=1;
                textViewScoreP1.setText(String.valueOf(scoreP1));
            }
        });

        buttonMinusP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (scoreP2==0){
                    scoreP2=0;
                }else {
                    scoreP2 -= 1;
                    textViewScoreP2.setText(String.valueOf(scoreP2));
                }
            }
        });

        buttonPlusP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreP2+=1;
                textViewScoreP2.setText(String.valueOf(scoreP2));
            }
        });
    }
}