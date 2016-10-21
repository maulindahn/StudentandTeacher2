package com.example.hana.studentandteacher2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by user pc on 21/10/2016.
 */
public class CustomTeacher extends AppCompatActivity {
    private EditText edit_no_t, edit_nip, edit_nama_t, edit_mail_t, edit_phone_t;
    private FloatingActionButton button_done, button_cancel;
    private boolean isEdit = false;
    ArrayList<Teacher> teacherList;
    private int position;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_teacher);
        teacherList = TeacherActivity.teacherList;

        edit_no_t = (EditText) findViewById(R.id.edit_no_t);
        edit_nip = (EditText) findViewById(R.id.edit_nip);
        edit_nama_t = (EditText) findViewById(R.id.edit_nama_t);
        edit_mail_t = (EditText) findViewById(R.id.edit_mail_t);
        edit_phone_t = (EditText) findViewById(R.id.edit_phone_t);

        Intent i = getIntent();
        if(i.getBooleanExtra("isEdit", true)) {
            isEdit = true;
            Teacher teacher = (Teacher) i.getSerializableExtra("teacher");
            edit_no_t.setText(String.valueOf(teacher.getNo()));
            edit_nip.setText(teacher.getNip());
            edit_nama_t.setText(teacher.getName());
            edit_mail_t.setText(teacher.getMail());
            edit_phone_t.setText(teacher.getPhone());
            position = i.getIntExtra("position", 0);
        }

        button_done = (FloatingActionButton) findViewById(R.id.button_done);
        button_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTeacher();
            }
        });

        button_cancel = (FloatingActionButton) findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void saveTeacher(){

        if (isEdit){
            Teacher tmpTeacher = new Teacher(Integer.parseInt(edit_no_t.getText().toString()), edit_nip.getText().toString(), edit_nama_t.getText().toString(), edit_mail_t.getText().toString(), edit_phone_t.getText().toString());
            teacherList.set(position, tmpTeacher);
            finish();
        } else {
            Teacher tmpTeacher = new Teacher(Integer.parseInt(edit_no_t.getText().toString()), edit_nip.getText().toString(), edit_nama_t.getText().toString(), edit_mail_t.getText().toString(), edit_phone_t.getText().toString());
            teacherList.add(tmpTeacher);
            finish();
        }
    }
}
