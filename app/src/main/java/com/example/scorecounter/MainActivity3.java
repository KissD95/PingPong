package com.example.scorecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    private TextView textViewJatekos1Nev,textViewJatekos2Nev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
    }
    public void init() {
        textViewJatekos1Nev=findViewById(R.id.textViewJatekos1Nev);
        textViewJatekos2Nev=findViewById(R.id.textViewJatekos2Nev);
        SharedPreferences sharedPreferences = getSharedPreferences("nevek", Context.MODE_PRIVATE);

        textViewJatekos1Nev.setText(sharedPreferences.getString("jatekos1", "Nincs ilyen adat"));
        textViewJatekos2Nev.setText(sharedPreferences.getString("jatekos2", "Nincs ilyen adat"));


    }
}