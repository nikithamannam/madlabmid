package com.example.xyzinstitute;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView coursesIcon, admissionIcon, facultyIcon;
    TextView coursesContent, admissionContent, facultyContent;
    ScrollView contentScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        coursesIcon = findViewById(R.id.coursesIcon);
        admissionIcon = findViewById(R.id.admissionIcon);
        facultyIcon = findViewById(R.id.facultyIcon);
        coursesContent = findViewById(R.id.coursesContent);
        admissionContent = findViewById(R.id.admissionContent);
        facultyContent = findViewById(R.id.facultyContent);
        contentScrollView = findViewById(R.id.contentScrollView);
    }

    // Method to show Courses content
    public void showCourses(View view) {
        coursesContent.setVisibility(View.VISIBLE);
        admissionContent.setVisibility(View.GONE);
        facultyContent.setVisibility(View.GONE);
        contentScrollView.setVisibility(View.VISIBLE);
    }

    // Method to show Admission content
    public void showAdmission(View view) {
        coursesContent.setVisibility(View.GONE);
        admissionContent.setVisibility(View.VISIBLE);
        facultyContent.setVisibility(View.GONE);
        contentScrollView.setVisibility(View.VISIBLE);
    }

    // Method to show Faculty content
    public void showFaculty(View view) {
        coursesContent.setVisibility(View.GONE);
        admissionContent.setVisibility(View.GONE);
        facultyContent.setVisibility(View.VISIBLE);
        contentScrollView.setVisibility(View.VISIBLE);
    }
}

