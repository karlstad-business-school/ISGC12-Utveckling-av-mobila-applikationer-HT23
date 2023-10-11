package com.example.hantera_data_v4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class StudentListAdapter extends ArrayAdapter<Student> {

    private int layout;
    private List<Student> students;
    public StudentListAdapter(@NonNull Context context, int resource, List<Student> objects){
        super(context, resource, objects);
        layout = resource;
        students = objects;
    }

    public void update(ArrayList<Student> students){
        this.students = students;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        ListItem main = null;
        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(layout, parent, false);

            ImageView image = view.findViewById(R.id.list_item_image);
            TextView text = view.findViewById(R.id.list_item_text);
            Button button = view.findViewById(R.id.list_item_button);


            ListItem item = new ListItem(image, text, button);
            set(item, position);
            view.setTag(item);
        }else{
            main = (ListItem)view.getTag();
            set(main, position);
        }


        return view;
    }

    public void set(ListItem li, int position){
        Student student = students.get(position);
        li.getText().setText(student.getName());

        li.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database.instance.remove(student.getId());
                update(Database.instance.getStudents());
            }
        });
    }
}
