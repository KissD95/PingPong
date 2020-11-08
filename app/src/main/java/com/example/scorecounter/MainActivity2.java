package com.example.scorecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    private Button buttonStartGame;
    private EditText editTextJatekos1, editTextJatekos2;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();

        buttonStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String jatekosNev1 = editTextJatekos1.getText().toString();
                    String jatekosNev2= editTextJatekos2.getText().toString();
                    editor.putString("jatekos1",jatekosNev1);
                    editor.putString("jatekos2",jatekosNev2);
                    editor.commit();
                    Intent harmadik= new Intent(MainActivity2.this, MainActivity3.class);
                    startActivity(harmadik);
                    finish();
            }
        });

    }
    public void init() {
        buttonStartGame=findViewById(R.id.buttonStartGame);
        editTextJatekos1=findViewById(R.id.editTextJatekos1);
        editTextJatekos2=findViewById(R.id.editTextJatekos2);
        sharedPreferences = getSharedPreferences("nevek", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }
}