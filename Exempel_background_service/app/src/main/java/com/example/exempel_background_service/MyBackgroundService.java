package com.example.exempel_background_service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyBackgroundService extends IntentService {

    public MyBackgroundService() {
        super("MyBackgroundService");
    }


    public MyBackgroundService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        for (int i = 0; i < 10; i++) {
            synchronized (this) {
                try {
                    Log.d("MyBackgroundService", "Waiting: " + i);
                    wait(1000);
                } catch (Exception e) {
                    Log.e("MyBackgroundService","Error: ",e);
                }
            }
        }
    }
}