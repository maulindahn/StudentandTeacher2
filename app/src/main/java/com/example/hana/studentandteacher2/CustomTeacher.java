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
    private int edit_nos_t, position;
    private int state = 0;
    ArrayList<Teacher> teacherList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_teacher);
        teacherList = TeacherActivity.teacherList;
        edit_no_t = (EditText) findViewById(R.id.edit_no_t);
        edit_no_t.setEnabled(false);
        edit_nip = (EditText) findViewById(R.id.edit_nip);
        edit_nama_t = (EditText) findViewById(R.id.edit_nama_t);
        edit_mail_t = (EditText) findViewById(R.id.edit_mail_t);
        edit_phone_t = (EditText) findViewById(R.id.edit_phone_t);
        Intent i = getIntent();
        String manipulate = i.getStringExtra("manipulate");
        String isAdd = i.getStringExtra(manipulate);
        String isEdit = i.getStringExtra(manipulate);
        if(manipulate == isAdd) {
            setTitle("Add Teacher");
            edit_nos_t = i.getIntExtra("currentNO", 0);
            edit_no_t.setText(String.valueOf(edit_nos_t));
        } else if(manipulate == isEdit){
            setTitle("Edit Teacher");
            state = 1;
            Teacher teacher = (Teacher) i.getSerializableExtra("teacherData");
            edit_no_t.setText(String.valueOf(teacher.getNo()));
            edit_nos_t = teacher.getNo();
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

    public void saveTeacher() {
        int No = Integer.parseInt(this.edit_no_t.getText().toString());
        String Name = this.edit_nama_t.getText().toString();
        String Mail = this.edit_mail_t.getText().toString();
        String Nip = this.edit_nip.getText().toString();
        String Phone = this.edit_phone_t.getText().toString();
        Teacher tmp = new Teacher(No, Nip, Name, Mail, Phone);
        Intent i = new Intent();
        switch (this.state) {
            case 0:
                i.putExtra("manipulate", "isAdd");
                teacherList.set(position, tmp);
                finish();
            case 1:
                i.putExtra("manipulate", "isEdit");
                i.putExtra("edit_no_t", edit_nos_t);
                setResult(position, i);
                finish();
        }
    }
}
