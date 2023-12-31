package com.example.hantera_data_v4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText idET, nameET, pnrET;
    private Button addBtn;
    //private TextView studentList;
    private ListView studentList;

    private StudentListAdapter sla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Database();
        new DataManager();
        idET = findViewById(R.id.student_id);
        nameET = findViewById(R.id.student_namn);
        pnrET = findViewById(R.id.student_pnr);
        addBtn = findViewById(R.id.add_btn);
        studentList = findViewById(R.id.student_list);

        Database.instance.setStudents(DataManager.instance.readFromFile(this));

        sla = new StudentListAdapter(this, R.layout.list_item, Database.instance.getStudents());
        studentList.setAdapter(sla);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(idET.getText().toString());
                String namn = nameET.getText().toString();
                String pnr = pnrET.getText().toString();
                Student s = new Student(id, namn, pnr);

                Database.instance.add(s);
                DataManager.instance.writeToFile(MainActivity.this, Database.instance.getStudents());

                //studentList.setText(Database.instance.printStudents());
                sla.update(Database.instance.getStudents());
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        //studentList.setText(Database.instance.printStudents());
    }

    public void removeStudent(View view) {
        EditText rID = findViewById(R.id.remove_id);
        int id = Integer.parseInt(rID.getText().toString());
        Database.instance.remove(id);

        //studentList.setText(Database.instance.printStudents());
        DataManager.instance.writeToFile(MainActivity.this, Database.instance.getStudents());
    }


    public void searchStudent(View view){
        EditText searchID = findViewById(R.id.search_id);
        int id = Integer.parseInt(searchID.getText().toString());

        showStudentInformation(id);
    }

    private void showStudentInformation(int id){
        Intent intent = new Intent(MainActivity.this, StudentView.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}