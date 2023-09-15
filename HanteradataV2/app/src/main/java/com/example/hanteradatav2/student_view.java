package com.example.hanteradatav2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class student_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view);


        Intent intent = getIntent();
        if(intent.hasExtra("student_id")){
            int id = intent.getIntExtra("student_id", -1);
            Student student = Database.getInstance().get(id);

            if(student != null){
                return;
            }

            TextView idTV = findViewById(R.id.student_text);
            idTV.setText(student.getName());

            Button b = findViewById(R.id.remove_btn);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Database.getInstance().remove(id);
                    finish();
                }
            });
        }
    }
}