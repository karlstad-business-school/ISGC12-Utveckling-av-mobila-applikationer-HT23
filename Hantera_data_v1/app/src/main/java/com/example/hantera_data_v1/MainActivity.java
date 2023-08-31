package com.example.hantera_data_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText idET, nameET, pnrET;
    private Button addBtn;
    private TextView studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Database();
        idET = findViewById(R.id.student_id);
        nameET = findViewById(R.id.student_namn);
        pnrET = findViewById(R.id.student_pnr);
        addBtn = findViewById(R.id.add_btn);
        studentList = findViewById(R.id.student_list);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(idET.getText().toString());
                String namn = nameET.getText().toString();
                String pnr = pnrET.getText().toString();
                Student s = new Student(id, namn, pnr);

                Database.instance.add(s);

                studentList.setText(Database.instance.printStudents());
            }
        });

    }
}