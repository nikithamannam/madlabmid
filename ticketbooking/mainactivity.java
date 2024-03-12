package com.example.ticketbooking;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerSource, spinnerDestination;
    private DatePicker datePicker;
    private NumberPicker hourPicker, minutePicker;
    private ToggleButton toggleButton;
    private Button buttonSubmit, buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerSource = findViewById(R.id.spinner_source);
        spinnerDestination = findViewById(R.id.spinner_destination);
        datePicker = findViewById(R.id.date_picker);
        hourPicker = findViewById(R.id.hour_picker);
        minutePicker = findViewById(R.id.minute_picker);
        toggleButton = findViewById(R.id.toggle_button);
        buttonSubmit = findViewById(R.id.button_submit);
        buttonClear = findViewById(R.id.button_clear);

        // Set up hour picker
        hourPicker.setMinValue(0);
        hourPicker.setMaxValue(23);

        // Set up minute picker
        minutePicker.setMinValue(0);
        minutePicker.setMaxValue(59);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitBookingDetails();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });
    }

    private void submitBookingDetails() {
        String source = spinnerSource.getSelectedItem().toString();
        String destination = spinnerDestination.getSelectedItem().toString();

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        int hour = hourPicker.getValue();
        int minute = minutePicker.getValue();

        String ticketType = toggleButton.isChecked() ? "Tatkal" : "General";

        // Perform validations
        if (toggleButton.isChecked()) {
            // If Tatkal ticket, check if time is after 11:00 AM
            if (hour < 11 || (hour == 11 && minute < 0)) {
                Toast.makeText(this, "Tatkal booking available after 11:00 AM", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        // Display entered details and available trains (you can implement this part)

        // Display toast with booking confirmation
        Toast.makeText(this, "Booking confirmed. Source: " + source + ", Destination: " + destination + ", Date: " +
                day + "/" + (month + 1) + "/" + year + ", Time: " + hour + ":" + minute + ", Ticket Type: " +
                ticketType, Toast.LENGTH_LONG).show();
    }

    private void clearFields() {
        // Clear all fields and reset date picker to current time
        spinnerSource.setSelection(0);
        spinnerDestination.setSelection(0);

        Calendar calendar = Calendar.getInstance();
        datePicker.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        hourPicker.setValue(calendar.get(Calendar.HOUR_OF_DAY));
        minutePicker.setValue(calendar.get(Calendar.MINUTE));

        toggleButton.setChecked(false);
    }
}
