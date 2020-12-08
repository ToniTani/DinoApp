package com.example.dinoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.dinoapp.model.Score;

import java.text.MessageFormat;

public class TenttiActivity extends AppCompatActivity {

    ProgressBar prg;
    Button prince, queen, king, spade, joker, tulos;
    TextView oikein;
    TextView points;
    private int pointsCounter = 0;
    private Score score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentti);

        score = new Score();

        prg = (ProgressBar)findViewById(R.id.progressBar);
        prince = findViewById(R.id.buttonJatka);
        queen = findViewById(R.id.buttonQueen);
        king = findViewById(R.id.buttonKing);
        spade = findViewById(R.id.buttonSpade);
        joker = findViewById(R.id.buttonJoker);
        tulos = findViewById(R.id.buttonTulos);

        oikein = findViewById(R.id.textCorrect);
        oikein.setVisibility(View.INVISIBLE);
        points = findViewById(R.id.pointsText);


        prince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prg.setProgress(prg.getProgress()+20);
                prince.setVisibility(View.INVISIBLE);
                plusPoints();
            }
        });
        queen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prg.setProgress(prg.getProgress()+20);
                queen.setVisibility(View.INVISIBLE);
                plusPoints();
            }

        });
        king.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prg.setProgress(prg.getProgress()+20);
                king.setVisibility(View.INVISIBLE);
                plusPoints();
            }
        });
        spade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prg.setProgress(prg.getProgress()+20);
                prince.setVisibility(View.INVISIBLE);
                queen.setVisibility(View.INVISIBLE);
                king.setVisibility(View.INVISIBLE);
                joker.setVisibility(View.INVISIBLE);
                spade.setClickable(false);
                plusPoints();

                TextView textView = findViewById(R.id.textCorrect);
                if (textView.getVisibility() == View.INVISIBLE)
                   textView.setVisibility(View.VISIBLE);
                else
                    textView.setVisibility(View.INVISIBLE);
            }
        });
        joker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prg.setProgress(prg.getProgress()+20);
                joker.setVisibility(View.INVISIBLE);
                plusPoints();
            }
        });

        tulos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent (TenttiActivity.this, TulosActivity.class); // Tämä nappi ei jostain syystä suostu toimimaan ja hajoitti tämän jostain syystä vaikka on ihan perus onClick
//          //      intent.putExtra("tulos", pointsCounter);
               startActivity(intent);
            }
        });


    }
    private void plusPoints() {
            pointsCounter += 1;
            score.setScore2(pointsCounter);
            points.setText(MessageFormat.format("Pisteet: {0}", String.valueOf(score.getScore2())));
    }
}