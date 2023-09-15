package com.example.exempel_broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private String BROADCAST_ACTION = "com.test.exempel_r5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void send(View view){
        Intent intent = new Intent();
        intent.setAction(BROADCAST_ACTION);
        intent.putExtra("msg", "Hello world!");
        sendBroadcast(intent);
    }
}