package com.example.hanteradatav2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Database database;

    private EditText id_ET, namn_ET, pnr_ET;
    private TextView stundet_list_TV;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = Database.getInstance();


        id_ET = findViewById(R.id.student_id);
        namn_ET = findViewById(R.id.student_namn);
        pnr_ET = findViewById(R.id.student_pnr);
        stundet_list_TV = findViewById(R.id.student_list);
        addBtn = findViewById(R.id.add_btn);





        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(id_ET.getText().toString());
                String namn = namn_ET.getText().toString();
                String pnr = pnr_ET.getText().toString();
                saveStudent(id, namn, pnr);
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        updateStudentList();
    }


    public void searchStudent(View view){
        EditText sId = (EditText)findViewById(R.id.search_id);
        int id = Integer.parseInt(sId.getText().toString());
        Intent intent = new Intent(MainActivity.this, student_view.class);
        intent.putExtra("student_id", id);
        startActivity(intent);
    }

    public void removeStudent(View view){
        EditText rId = (EditText)findViewById(R.id.search_id);
        database.remove(Integer.parseInt(rId.getText().toString()));
        updateStudentList();
    }


    private  void saveStudent(int id, String namn, String pnr){
        Student s = new Student(id, namn, pnr);
        database.add(s);

        updateStudentList();
    }


    private void updateStudentList(){
        String students = database.printStudents();
        stundet_list_TV.setText(students);
    }
}