package com.example.hana.studentandteacher2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by user pc on 20/10/2016.
 */
public class StudentActivity extends AppCompatActivity {
    private StudentAdapter studentAdapter;
    private ListView list_item;
    private TextView empty_view;
    static ArrayList<Student> studentList;
    private FloatingActionButton button_Add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_student);
        if (studentList == null) studentList = new ArrayList<Student>();
        studentAdapter = new StudentAdapter(this, studentList);
        list_item = (ListView) findViewById(R.id.list_item);
        list_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student studentItem = studentList.get(position);
                Intent i = new Intent(StudentActivity.this, CustomStudent.class);
                i.putExtra("student", (Serializable) studentItem); // ini passing object
                i.putExtra("isEdit", true);
                i.putExtra("position", position);
                startActivity(i);
            }
        });
        button_Add = (FloatingActionButton) findViewById(R.id.button_Add);
        button_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StudentActivity.this, CustomStudent.class);
                i.putExtra("isEdit", false);
                startActivity(i);
            }
        });


    }

    private void populateStudentDummies() {
        int i = studentList.size();
        studentList.add(new Student(i, "Hana Maulinda", "3145136193", "hanamaulinda@gmail.com", "081318400299"));
        studentList.add(new Student(i+1, "Bestian Fangaro", "3145136194", "dianrakasiwi@gmail.com", "082233344555"));
    }

    public void createDummy(){
        populateStudentDummies();
        studentAdapter = new StudentAdapter(this, studentList);
        list_item.setAdapter(studentAdapter);
    }

    public void clearData(){
        studentList.clear();
        studentAdapter = new StudentAdapter(this, studentList);
        list_item.setAdapter(studentAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list_student, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        empty_view = (TextView) findViewById(R.id.empty_view);
        if(studentList.size() == 0) {
            studentAdapter = new StudentAdapter(this, new ArrayList<Student>());
            list_item.setEmptyView(empty_view);
            empty_view.setText("Student Not Found");
        } else {
            studentAdapter = new StudentAdapter(this, studentList);
            empty_view.setText("");
        }
        list_item.setAdapter(studentAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.create_dummy:
                createDummy();
                return true;
            case R.id.clear_list:
                clearData();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
