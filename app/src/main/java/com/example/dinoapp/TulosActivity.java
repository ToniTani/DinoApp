package com.example.dinoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TulosActivity extends AppCompatActivity {

    private TextView results;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tulos);

       // back = findViewById(R.id.backButton);
       // results = findViewById(R.id.resultText2);

      //  String result = getIntent().getStringExtra("tulos");
    //    results.setText(result);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (TulosActivity.this, TenttiActivity.class);
                startActivity(intent);
            }
        });

    }
}