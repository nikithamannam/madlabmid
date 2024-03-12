package com.example.versions_toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view) {
        Button button = (Button) view;
        String versionName = button.getText().toString();

        // Get icon resource ID dynamically
        int iconResId = getResources().getIdentifier("ic_" + versionName.toLowerCase(), "drawable", getPackageName());

        Toast toast = Toast.makeText(this, versionName, Toast.LENGTH_SHORT);
        toast.show();
        // Set icon to the toast
        toast.getView().setBackgroundResource(iconResId);
    }
}
