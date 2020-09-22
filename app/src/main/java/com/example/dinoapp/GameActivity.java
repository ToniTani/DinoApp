package com.example.dinoapp;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dinoapp.model.Score;
import com.example.dinoapp.util.Prefs;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    private int count = 0;
    ImageView left, middle, right;
    List<Integer> cards;
    private int scoreCounter = 0;
    private Score score;
    private TextView scoreTextView;
    private Prefs prefs;

    Button newGame;
    Button refreshGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        scoreTextView = findViewById(R.id.score_text);
        score = new Score(); // score object
        prefs = new Prefs(GameActivity.this); // preferences
        TextView highScoreTextView = findViewById(R.id.high_scoretext);

        right = findViewById(R.id.right); // image buttons
        left = findViewById(R.id.left); // image buttons
        middle = findViewById(R.id.middle); // image buttons

        newGame = findViewById(R.id.newGameButton); // action buttons
        refreshGame = findViewById(R.id.refresh_btn); // action button

        cards = new ArrayList<>();
        cards.add(107);
        cards.add(207);
        cards.add(407);
        Collections.shuffle(cards);

        highScoreTextView.setText(MessageFormat.format("High Score ${0}", String.valueOf(prefs.getHighScore())));

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.shuffle(cards);

                left.setImageResource(R.drawable.card_back);
                middle.setImageResource(R.drawable.card_back);
                right.setImageResource(R.drawable.card_back);

                Animation anim_left = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left);
                Animation anim_middle = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.middle);
                Animation anim_right = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right);

                left.startAnimation(anim_left);
                middle.startAnimation(anim_middle);
                right.startAnimation(anim_right);
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //card assignments
                if(cards.get(0) == 107) {
                    left.setImageResource(R.drawable.spade);
                    addPoints();
                    Toast.makeText(GameActivity.this, "You Won 200$!", Toast.LENGTH_SHORT).show();
                } else if (cards.get(0) == 207) {
                    left.setImageResource(R.drawable.happy);
                    deductPoints();
                    Toast.makeText(GameActivity.this, "You lost 100$ :(", Toast.LENGTH_SHORT).show();
                } else if (cards.get(0) == 407) {
                    left.setImageResource(R.drawable.pokemon_card);
                    deductPoints();
                    Toast.makeText(GameActivity.this, "You lost 100$ :(", Toast.LENGTH_SHORT).show();
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
                    addPoints();
                    Toast.makeText(GameActivity.this, "You Won 200$!", Toast.LENGTH_SHORT).show();
                } else if (cards.get(1) == 207) {
                    middle.setImageResource(R.drawable.happy);
                    deductPoints();
                    Toast.makeText(GameActivity.this, "You lost 100$ :(", Toast.LENGTH_SHORT).show();
                } else if (cards.get(1) == 407) {
                    middle.setImageResource(R.drawable.pokemon_card);
                    deductPoints();
                    Toast.makeText(GameActivity.this, "You lost 100$ :(", Toast.LENGTH_SHORT).show();
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
                    addPoints();
                    Toast.makeText(GameActivity.this, "You Won 200$!", Toast.LENGTH_SHORT).show();
                } else if (cards.get(2) == 207) {
                    right.setImageResource(R.drawable.happy);
                    deductPoints();
                    Toast.makeText(GameActivity.this, "You lost 100$ :(", Toast.LENGTH_SHORT).show();
                } else if (cards.get(2) == 407) {
                    right.setImageResource(R.drawable.pokemon_card);
                    deductPoints();
                    Toast.makeText(GameActivity.this, "You lost 100$ :(", Toast.LENGTH_SHORT).show();
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
        refreshGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                startActivity(getIntent());
            }
        });
    }
    private void addPoints() {
        scoreCounter += 200;
        score.setScore(scoreCounter);
        scoreTextView.setText(MessageFormat.format("Money ${0}", String.valueOf(score.getScore())));

        // Log.d("SCORE", "addpoints" + score.getScore());
    }
    private void deductPoints() {
        scoreCounter -= 100;
        if (scoreCounter <= 0) {
            scoreCounter = 0;
        }
        score.setScore(scoreCounter);
        scoreTextView.setText(MessageFormat.format("Money ${0}", String.valueOf(score.getScore())));

    }

    @Override
    protected void onPause() {
        prefs.saveHighScore(score.getScore());
        super.onPause();
    }

}