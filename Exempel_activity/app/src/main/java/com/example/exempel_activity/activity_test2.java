package com.example.exempel_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class activity_test2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        Button backBtn = findViewById(R.id.btn_back);
        Button btnActivity1 = findViewById(R.id.btn_activity_1);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btnActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity1();
            }
        });
    }


    private void startActivity1(){
        Intent i = new Intent(this, activity_test1.class);
        startActivity(i);
    }
}