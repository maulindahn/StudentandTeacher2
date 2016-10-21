package com.example.hana.studentandteacher2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user pc on 21/10/2016.
 */
public class TeacherAdapter extends ArrayAdapter<Teacher> {
    public TeacherAdapter(Context context, ArrayList<Teacher> teacher){
        super(context, 0, teacher);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Teacher teacher = getItem(position);
        if (convertView ==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.teacher_main, parent, false);
        }
        TextView no = (TextView) convertView.findViewById(R.id.no_teacher);
        TextView nip = (TextView) convertView.findViewById(R.id.nip_teacher);
        TextView name = (TextView) convertView.findViewById(R.id.name_teacher);
        TextView email = (TextView) convertView.findViewById(R.id.mail_teacher);
        TextView phone = (TextView) convertView.findViewById(R.id.phone_student);
        // Populate the data into the template view using the data object

        no.setText(teacher.getNo()+"");
        nip.setText(teacher.getNip());
        name.setText(teacher.getName());
        email.setText(teacher.getMail());
        phone.setText(teacher.getPhone());
        // Return the completed view to render on screen
        return convertView;
    }
}
