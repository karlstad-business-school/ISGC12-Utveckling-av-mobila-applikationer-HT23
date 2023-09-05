package com.example.exempel_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_test1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);


        Button backBtn = findViewById(R.id.btn_back);
        Button btnActivity2 = findViewById(R.id.btn_activity_2);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btnActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity2();
            }
        });
    }


    private void startActivity2(){
        Intent i = new Intent(this, activity_test2.class);
        startActivity(i);
    }
}