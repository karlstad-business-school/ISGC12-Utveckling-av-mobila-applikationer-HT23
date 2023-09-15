package com.example.exempel_broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, intent.getStringExtra("msg") + " from myBroadcastReceiver!", Toast.LENGTH_LONG).show();

        Log.d("MyBroadcastReceiver", "A toast in receiver");
    }
}
