package com.example.dinoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    ImageView right_down, right_up, left_down, left_up;
    List<Integer> cards;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        right_down = (ImageView) findViewById(R.id.right_down);
        right_up = (ImageView) findViewById(R.id.right_up);
        left_down = (ImageView) findViewById(R.id.left_down);
        left_up = (ImageView) findViewById(R.id.left_up);

        cards = new ArrayList<>();
        cards.add(107);
        cards.add(207);
        cards.add(307);
        cards.add(407);

        Collections.shuffle(cards);

        right_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //card assignments
                if(cards.get(0) == 107) {
                    right_down.setImageResource(R.drawable.spade);
                } else if (cards.get(0) == 207) {
                    right_down.setImageResource(R.drawable.spade);
                } else if (cards.get(0) == 307) {
                    right_down.setImageResource(R.drawable.happy);
                } else if (cards.get(0) == 407) {
                    right_down.setImageResource(R.drawable.pokemon_card);
                }
            }
        });

        right_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //card assignments
                if(cards.get(0) == 107) {
                    right_up.setImageResource(R.drawable.spade);
                } else if (cards.get(0) == 207) {
                    right_up.setImageResource(R.drawable.spade);
                } else if (cards.get(0) == 307) {
                    right_up.setImageResource(R.drawable.happy);
                } else if (cards.get(0) == 407) {
                    right_up.setImageResource(R.drawable.pokemon_card);
                }
            }
        });

        left_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //card assignments
                if(cards.get(0) == 107) {
                    left_down.setImageResource(R.drawable.spade);
                } else if (cards.get(0) == 207) {
                    left_down.setImageResource(R.drawable.spade);
                } else if (cards.get(0) == 307) {
                    left_down.setImageResource(R.drawable.happy);
                } else if (cards.get(0) == 407) {
                    left_down.setImageResource(R.drawable.pokemon_card);
                }
            }
        });

        left_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //card assignments
                if(cards.get(0) == 107) {
                    left_up.setImageResource(R.drawable.spade);
                } else if (cards.get(0) == 207) {
                    left_up.setImageResource(R.drawable.spade);
                } else if (cards.get(0) == 307) {
                    left_up.setImageResource(R.drawable.happy);
                } else if (cards.get(0) == 407) {
                    left_up.setImageResource(R.drawable.pokemon_card);
                }
            }
        });

    }
    public void assignImages ()
    {

    }
}