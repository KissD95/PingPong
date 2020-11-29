package com.example.scorecounter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity  {
    //osztályváltozók---------------------------------------------------------------------------
    private TextView textViewJatekos1Nev,textViewJatekos2Nev,textViewScoreP1,textViewScoreP2;
    private Button buttonMinusP1,buttonPlusP1,buttonMinusP2,buttonPlusP2;
    private int scoreP1,scoreP2;
    private AlertDialog.Builder builder ;
    //main metódus -----------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        init();
        whoWin();
        clickListeners();


    }

    //Vizsgálat----------------------------------------------------------------------------------
    //ki nyert?
    private void whoWin() {
        if (scoreP2>=11 && (scoreP2-scoreP1>=2)){
            builder.setTitle(textViewJatekos2Nev.getText()+" nyert!");
            AlertDialog dialog = builder.create();
            dialog.show();
        }else if (scoreP1>=11 && (scoreP1-scoreP2>=2)){
            builder.setTitle(textViewJatekos1Nev.getText()+" nyert!");
            AlertDialog dialog = builder.create();
            dialog.show();
        }

    }

    //Componensek inicializálása------------------------------------------------------------------------------------
    public void init() {
        textViewJatekos1Nev=findViewById(R.id.textViewJatekos1Nev);
        textViewJatekos2Nev=findViewById(R.id.textViewJatekos2Nev);
        textViewScoreP1=findViewById(R.id.jatekos1Score);
        textViewScoreP2=findViewById(R.id.jatekos2Score);

        SharedPreferences sharedPreferences = getSharedPreferences("nevek", Context.MODE_PRIVATE);
        textViewJatekos1Nev.setText(sharedPreferences.getString("jatekos1", "Nincs ilyen adat"));
        textViewJatekos2Nev.setText(sharedPreferences.getString("jatekos2", "Nincs ilyen adat"));

        buttonMinusP1=findViewById(R.id.buttonMinusP1);
        buttonPlusP1=findViewById(R.id.buttonPlusP1);
        buttonMinusP2=findViewById(R.id.buttonMinusP2);
        buttonPlusP2=findViewById(R.id.buttonPlusP2);

        builder = new AlertDialog.Builder(MainActivity3.this);
        builder.setCancelable(false).setMessage("Szeretne új játékot játszani?")
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent fomenu = new Intent(MainActivity3.this,MainActivity.class);
                        startActivity(fomenu);
                        finish();
                    }
                })
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
    }

    //Click listeners
    public void clickListeners() {
        //Player 1 minus button
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
        //Player 1 plus button
        buttonPlusP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreP1+=1;
                textViewScoreP1.setText(String.valueOf(scoreP1));
                whoWin();

            }
        });
        //Player 2 minus button
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
        //Player 2 plus button
        buttonPlusP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreP2+=1;
                textViewScoreP2.setText(String.valueOf(scoreP2));
                whoWin();
            }
        });
    }
}
