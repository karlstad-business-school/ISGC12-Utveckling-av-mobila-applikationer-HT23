package com.example.exempel_implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_a = findViewById(R.id.button1);
        Button btn_b = findViewById(R.id.button2);
        Button btn_c = findViewById(R.id.button3);


        //Implicit
        btn_a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:2125551212"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });


        btn_b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                startActivity(Intent.createChooser(emailIntent, "Send your email in:"));
            }
        });

        //Custom Implicit
        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String CUSTOM_ACTION = "abc.test.123456789";

                Intent i = new Intent();
                i.setAction(CUSTOM_ACTION);
                startActivity(i);
            }
        });
    }
}