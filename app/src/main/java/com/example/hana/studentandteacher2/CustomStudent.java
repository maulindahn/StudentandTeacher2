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
    private int edit_nos, position;
    private int state = 0;
    ArrayList<Student> studentList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_student);
        studentList = StudentActivity.studentList;
        edit_no = (EditText) findViewById(R.id.edit_no);
        edit_no.setEnabled(false);
        edit_noreg = (EditText) findViewById(R.id.edit_noreg);
        edit_nama = (EditText) findViewById(R.id.edit_nama);
        edit_mail = (EditText) findViewById(R.id.edit_mail);
        edit_phone = (EditText) findViewById(R.id.edit_phone);
        Intent i = getIntent();
        String manipulate = i.getStringExtra("manipulate");
        String isAdd = i.getStringExtra(manipulate);
        String isEdit = i.getStringExtra(manipulate);
        if(manipulate == isAdd) {
            setTitle("Add Student");
            edit_nos = i.getIntExtra("currentNO", 0);
            edit_no.setText(String.valueOf(edit_nos));
        } else if(manipulate == isEdit){
            setTitle("Edit Student");
            state = 1;
            Student student = (Student) i.getSerializableExtra("studentData");
            edit_no.setText(String.valueOf(student.getNo()));
            edit_nos = student.getNo();
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
        int No = Integer.parseInt(this.edit_no.getText().toString());
        String Name = this.edit_nama.getText().toString();
        String Mail = this.edit_mail.getText().toString();
        String Noreg = this.edit_noreg.getText().toString();
        String Phone = this.edit_phone.getText().toString();
        Student tmp = new Student(No, Noreg, Name, Mail, Phone);
        Intent i = new Intent();
        switch (this.state) {
            case 0:
                i.putExtra("manipulate", "isAdd");
                studentList.set(position, tmp);
                finish();
            case 1:
                i.putExtra("manipulate", "isEdit");
                i.putExtra("edit_no", edit_nos);
                setResult(position, i);
                finish();
        }
    }
}