package com.example.secbq;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Intent intent = getIntent();
        int count = intent.getIntExtra("selected_count", 0);

        TextView countTextView = findViewById(R.id.text_view_count);
        countTextView.setText("Count of selected checkboxes: " + count);
    }
}
