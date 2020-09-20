package com.example.dinoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private int count = 0;
    ImageView left, middle, right;
    List<Integer> cards;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        right = (ImageView) findViewById(R.id.right);
        left = (ImageView) findViewById(R.id.left);
        middle = (ImageView) findViewById(R.id.middle);



        cards = new ArrayList<>();
        cards.add(107);
        cards.add(207);
        cards.add(407);

        Collections.shuffle(cards);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //card assignments
                if(cards.get(0) == 107) {
                    left.setImageResource(R.drawable.spade);
                    Toast.makeText(GameActivity.this, "You Won!", Toast.LENGTH_SHORT).show();
                } else if (cards.get(0) == 207) {
                    left.setImageResource(R.drawable.happy);
                } else if (cards.get(0) == 407) {
                    left.setImageResource(R.drawable.pokemon_card);
                }

                if(cards.get(1) == 107) {
                    middle.setImageResource(R.drawable.spade);
                } else if (cards.get(1) == 207) {
                    middle.setImageResource(R.drawable.happy);
                } else if (cards.get(1) == 407) {
                    middle.setImageResource(R.drawable.pokemon_card);
                }

                if(cards.get(2) == 107) {
                    right.setImageResource(R.drawable.spade);
                } else if (cards.get(2) == 207) {
                    right.setImageResource(R.drawable.happy);
                } else if (cards.get(2) == 407) {
                    right.setImageResource(R.drawable.pokemon_card);
                }
            }
        });

        middle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //card assignments
                if(cards.get(1) == 107) {
                    middle.setImageResource(R.drawable.spade);
                    Toast.makeText(GameActivity.this, "You Won!", Toast.LENGTH_SHORT).show();
                } else if (cards.get(1) == 207) {
                    middle.setImageResource(R.drawable.happy);
                } else if (cards.get(1) == 407) {
                    middle.setImageResource(R.drawable.pokemon_card);
                }

                if(cards.get(0) == 107) {
                    left.setImageResource(R.drawable.spade);
                } else if (cards.get(0) == 207) {
                    left.setImageResource(R.drawable.happy);
                } else if (cards.get(0) == 407) {
                    left.setImageResource(R.drawable.pokemon_card);
                }
                if(cards.get(2) == 107) {
                    right.setImageResource(R.drawable.spade);
                    Toast.makeText(GameActivity.this, "You Won!", Toast.LENGTH_SHORT).show();
                } else if (cards.get(2) == 207) {
                    right.setImageResource(R.drawable.happy);
                } else if (cards.get(2) == 407) {
                    right.setImageResource(R.drawable.pokemon_card);
                }
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //card assignments
                if(cards.get(2) == 107) {
                    right.setImageResource(R.drawable.spade);
                    Toast.makeText(GameActivity.this, "You Won!", Toast.LENGTH_SHORT).show();
                } else if (cards.get(2) == 207) {
                    right.setImageResource(R.drawable.happy);
                } else if (cards.get(2) == 407) {
                    right.setImageResource(R.drawable.pokemon_card);
                }
                if(cards.get(1) == 107) {
                    middle.setImageResource(R.drawable.spade);
                } else if (cards.get(1) == 207) {
                    middle.setImageResource(R.drawable.happy);
                } else if (cards.get(1) == 407) {
                    middle.setImageResource(R.drawable.pokemon_card);
                }
                if(cards.get(0) == 107) {
                    left.setImageResource(R.drawable.spade);
                } else if (cards.get(0) == 207) {
                    left.setImageResource(R.drawable.happy);
                } else if (cards.get(0) == 407) {
                    left.setImageResource(R.drawable.pokemon_card);
                }
            }
        });

    }
    public void assignImages ()
    {

    }
}