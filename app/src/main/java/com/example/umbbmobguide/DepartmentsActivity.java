package com.example.umbbmobguide;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class DepartmentsActivity extends AppCompatActivity {
    
    private String facultyName;
    private ArrayList<Department> departments;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments);
        
        // Get faculty name from intent
        facultyName = getIntent().getStringExtra("FACULTY_NAME");
        String departmentCount = getIntent().getStringExtra("DEPARTMENT_COUNT");
        
        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbarDepartments);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(facultyName);
        toolbar.setNavigationOnClickListener(v -> finish());
        
        // Set faculty header
        TextView tvFacultyNameHeader = findViewById(R.id.tvFacultyNameHeader);
        TextView tvDepartmentCount = findViewById(R.id.tvDepartmentCount);
        tvFacultyNameHeader.setText(facultyName);
        tvDepartmentCount.setText(departmentCount != null ? departmentCount : "");
        
        // Load departments
        departments = DataManager.getDepartmentsForFaculty(facultyName);
        
        // Setup ListView
        ListView lvDepartments = findViewById(R.id.lvDepartments);
        DepartmentWithSpecialtiesAdapter adapter = new DepartmentWithSpecialtiesAdapter(this, departments);
        lvDepartments.setAdapter(adapter);
        
        // Setup bottom navigation
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavDepartments);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                startActivity(new Intent(this, MainActivity.class));
                finish();
                return true;
            } else if (id == R.id.nav_faculties) {
                startActivity(new Intent(this, FacultyActivity.class));
                finish();
                return true;
            } else if (id == R.id.nav_search) {
                startActivity(new Intent(this, SearchActivity.class));
                finish();
                return true;
            }
            return false;
        });
    }
}
