package com.example.dinoapp.ui.notifications;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dinoapp.R;

public class NotificationsFragment extends Fragment {

    public long START_TIME_IN_MILLIS = 600000;
    TextView timerTextView;
    SeekBar timerSeekBar;
    CountDownTimer countDownTimer;
    boolean timerIsActive;

    public long timeLeft = START_TIME_IN_MILLIS;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        timerSeekBar = view.findViewById(R.id.timerSeekBar);
        timerTextView = view.findViewById(R.id.timerTextView);




        final ImageButton playImgButton = view.findViewById(R.id.playImgButton);
        playImgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerSeekBar.setEnabled(false);
                countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {

                    @Override
                    public void onTick(long millisUntilFinished) {
                       // timerTextView.setText((int) millisUntilFinished);
                        timeLeft = millisUntilFinished;
                        updateTimer((int) + millisUntilFinished / 1000);
                    }
                    @Override
                    public void onFinish() {
                        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity().getApplicationContext(),R.raw.tollbell);
                        mediaPlayer.start();
                        resetTimer();
                        playImgButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                playImgButton.setVisibility(View.INVISIBLE);

            }
        });

        ImageButton pauseImgButton = view.findViewById(R.id.pauseImgButton);
        pauseImgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                countDownTimer.cancel();
                playImgButton.setVisibility(View.VISIBLE);
                //timerTextView.setText((int) millisUntilFinished);
                //updateTimer(timerSeekBar.getProgress());

            }
        });

        ImageButton stopImgButton = view.findViewById(R.id.stopImgButton);
        stopImgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        timerSeekBar.setMax(60);


        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        return view;
    }
    public void updateTimer(int secondsLeft) {
        int minutes = secondsLeft / 60; // number of seconds divided by 60, converts int
        int seconds = secondsLeft - (minutes * 60); // to find seconds

        String secondString = Integer.toString(seconds);

                if (seconds <= 9) {
                secondString = "0" + secondString; }
                timerTextView.setText(Integer.toString(minutes) + ":" + secondString);
    }
    public void resetTimer() {
        timerTextView.setText("0:30");
        timerSeekBar.setProgress(30);
        timerSeekBar.setEnabled(true);
        timerIsActive = false;

    }

}