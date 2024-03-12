package com.example.secbq;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;



public class MainActivity extends AppCompatActivity {

    CheckBox checkBoxA, checkBoxB, checkBoxC, checkBoxD;
    Button moreOptionsButton, nextButton;
    private void showMoreOptionsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("More Options");
        builder.setItems(new CharSequence[]{"Export", "Clear"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        StringBuilder selectedOptions = new StringBuilder();

                        if (checkBoxA.isChecked()) {
                            selectedOptions.append("A ");
                        }
                        if (checkBoxB.isChecked()) {
                            selectedOptions.append("B ");
                        }
                        if (checkBoxC.isChecked()) {
                            selectedOptions.append("C ");
                        }
                        if (checkBoxD.isChecked()) {
                            selectedOptions.append("D ");
                        }

                        if (selectedOptions.length() > 0) {
                            Toast.makeText(MainActivity.this, "Export selected: " + selectedOptions.toString(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "No options selected", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 1:
                        checkBoxA.setChecked(false);
                        checkBoxB.setChecked(false);
                        checkBoxC.setChecked(false);
                        checkBoxD.setChecked(false);
                        break;
                }
            }
        });
        builder.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxA = findViewById(R.id.checkbox_a);
        checkBoxB = findViewById(R.id.checkbox_b);
        checkBoxC = findViewById(R.id.checkbox_c);
        checkBoxD = findViewById(R.id.checkbox_d);

        moreOptionsButton = findViewById(R.id.button_more_options);
        nextButton = findViewById(R.id.button_next);

        moreOptionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMoreOptionsDialog();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = getSelectedCheckBoxCount();
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                intent.putExtra("selected_count", count);
                startActivity(intent);
            }
        });

    }



    private int getSelectedCheckBoxCount() {
        int count = 0;
        if (checkBoxA.isChecked()) {
            count++;
        }
        if (checkBoxB.isChecked()) {
            count++;
        }
        if (checkBoxC.isChecked()) {
            count++;
        }
        if (checkBoxD.isChecked()) {
            count++;
        }
        return count;
    }

}
