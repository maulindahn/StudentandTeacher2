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
 * Created by user pc on 21/10/2016.
 */
public class TeacherActivity extends AppCompatActivity {
    private TeacherAdapter teacherAdapter;
    private ListView list_item2;
    private TextView empty_view2;
    static ArrayList<Teacher> teacherList;
    private FloatingActionButton button_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_teacher);
        if (teacherList == null) teacherList = new ArrayList<Teacher>();
        teacherAdapter = new TeacherAdapter(this, teacherList);
        list_item2 = (ListView) findViewById(R.id.list_item2);
        list_item2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Teacher teacherItem = teacherList.get(position);
                Intent i = new Intent(TeacherActivity.this, CustomTeacher.class);
                i.putExtra("teacher", (Serializable) teacherItem); // ini passing object
                i.putExtra("isEdit", true);
                i.putExtra("position", position);
                startActivity(i);
            }
        });
        button_add = (FloatingActionButton) findViewById(R.id.button_add);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TeacherActivity.this, CustomTeacher.class);
                i.putExtra("isEdit", false);
                startActivity(i);
            }
        });
    }

    public void refreshNO() {
        for (int i =0; i < teacherList.size();i++) {
            teacherList.get(i).setNo(i);
        }
    }

    private void populateTeacherDummies() {
        int i = teacherList.size();
        teacherList.add(new Teacher(i, "Drs. Mulyono", "1234 5678 1234 567 890", "mulyono@gmail.com", "081388888888"));
        teacherList.add(new Teacher(i+1, "M. Eka Suryana", "1985 1223 2012 121 002", "mekas@gmail.com", "082299999999"));
    }

    public void createDummy(){
        populateTeacherDummies();
        teacherAdapter = new TeacherAdapter(this, teacherList);
        list_item2.setAdapter(teacherAdapter);
    }

    public void clearData(){
        teacherList.clear();
        teacherAdapter = new TeacherAdapter(this, teacherList);
        list_item2.setAdapter(teacherAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list_teacher, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        empty_view2 = (TextView) findViewById(R.id.empty_view2);
        if(teacherList.size() == 0) {
            teacherAdapter = new TeacherAdapter(this, new ArrayList<Teacher>());
            list_item2.setEmptyView(empty_view2);
            empty_view2.setText("Teacher Not Found");
        } else {
            teacherAdapter = new TeacherAdapter(this, teacherList);
            empty_view2.setText("");
        }
        refreshNO();
        list_item2.setAdapter(teacherAdapter);
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
