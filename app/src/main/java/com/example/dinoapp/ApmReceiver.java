package com.example.dinoapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class ApmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
            boolean state = intent.getBooleanExtra("state", false);
            if (state) {
                Toast.makeText(context, "AIRPLANE OFF", Toast.LENGTH_SHORT).show();
            } else { Toast.makeText(context, "AIRPLANE ON", Toast.LENGTH_SHORT).show();
                }
            }
        }
