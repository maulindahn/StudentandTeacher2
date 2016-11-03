package com.example.hana.studentandteacher2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by user pc on 20/10/2016.
 */
public class CustomStudent extends AppCompatActivity{
    private EditText edit_no, edit_noreg, edit_nama, edit_mail, edit_phone;
    private FloatingActionButton button_Done, button_Cancel;
    private int position;
    private boolean isEdit = false;
    ArrayList<Student> studentList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_student);
        studentList = StudentActivity.studentList;
        edit_no = (EditText) findViewById(R.id.edit_no);
        edit_noreg = (EditText) findViewById(R.id.edit_noreg);
        edit_nama = (EditText) findViewById(R.id.edit_nama);
        edit_mail = (EditText) findViewById(R.id.edit_mail);
        edit_phone = (EditText) findViewById(R.id.edit_phone);

        Intent i = getIntent();
        if(i.getBooleanExtra("isEdit", true)) {
            isEdit = true;
            Student student = (Student) i.getSerializableExtra("student");
            edit_no.setText(String.valueOf(student.getNo()));
            edit_noreg.setText(student.getNoreg());
            edit_nama.setText(student.getName());
            edit_mail.setText(student.getMail());
            edit_phone.setText(student.getPhone());
            position = i.getIntExtra("position", 0);
        }

        button_Done = (FloatingActionButton) findViewById(R.id.button_Done);
        button_Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveStudent();
            }
        });

        button_Cancel = (FloatingActionButton) findViewById(R.id.button_Cancel);
        button_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void saveStudent() {
        if (isEdit){
            Student tmpStudent = new Student(Integer.parseInt(edit_no.getText().toString()), edit_noreg.getText().toString(), edit_nama.getText().toString(), edit_mail.getText().toString(), edit_phone.getText().toString());
            studentList.set(position, tmpStudent);
            finish();
        } else {
            Student tmpStudent = new Student(Integer.parseInt(edit_no.getText().toString()), edit_noreg.getText().toString(), edit_nama.getText().toString(), edit_mail.getText().toString(), edit_phone.getText().toString());
            studentList.add(tmpStudent);
            finish();
        }
    }
}