package com.example.hantera_data_v4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentView extends AppCompatActivity {


    private Button removeBtn;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view);

        TextView idText = findViewById(R.id.student_id);
        TextView nameText = findViewById(R.id.student_name);
        TextView pnrText = findViewById(R.id.student_pnr);
        removeBtn = findViewById(R.id.singleViewRemoveBtn);


        Intent intent = getIntent();

        if(intent.hasExtra("id")){
            Log.e("TAG", "Student id exists!");
        }

        id = intent.getIntExtra("id", -1);

        if(id != -1){
            Student student = Database.instance.get(id);

            if(student != null){
                idText.setText(String.valueOf(student.getId()));
                nameText.setText(student.getName());
                pnrText.setText(student.getpNr());
            }
        }


        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database.instance.remove(id);
                finish();
            }
        });

    }
}