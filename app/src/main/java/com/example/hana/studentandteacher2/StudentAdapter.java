package com.example.hana.studentandteacher2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user pc on 20/10/2016.
 */
public class StudentAdapter extends ArrayAdapter<Student> {
    public StudentAdapter(Context context, ArrayList<Student> student){
        super(context, 0, student);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Student student = getItem(position);
        if (convertView ==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.student_main, parent, false);
        }
        TextView no = (TextView) convertView.findViewById(R.id.no_student);
        TextView noreg = (TextView) convertView.findViewById(R.id.noreg_student);
        TextView name = (TextView) convertView.findViewById(R.id.name_student);
        TextView email = (TextView) convertView.findViewById(R.id.mail_student);
        TextView phone = (TextView) convertView.findViewById(R.id.phone_student);
        // Populate the data into the template view using the data object

        no.setText(student.getNo()+"");
        noreg.setText(student.getNoreg());
        name.setText(student.getName());
        email.setText(student.getMail());
        phone.setText(student.getPhone());
        // Return the completed view to render on screen
        return convertView;
    }
}
