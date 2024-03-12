package com.example.vehicleparkingregistration;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerVehicleType;
    private EditText editTextVehicleNumber;
    private EditText editTextRCNumber;
    private Button buttonSubmit;

    private String selectedVehicleType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerVehicleType = findViewById(R.id.spinner_vehicle_type);
        editTextVehicleNumber = findViewById(R.id.edit_text_vehicle_number);
        editTextRCNumber = findViewById(R.id.edit_text_rc_number);
        buttonSubmit = findViewById(R.id.button_submit);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.vehicle_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVehicleType.setAdapter(adapter);

        spinnerVehicleType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedVehicleType = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedVehicleType = "";
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationScreen();
            }
        });
    }

    private void showConfirmationScreen() {
        setContentView(R.layout.activity_confirmation);

        TextView textViewVehicleType = findViewById(R.id.text_view_vehicle_type);
        TextView textViewVehicleNumber = findViewById(R.id.text_view_vehicle_number);
        TextView textViewRCNumber = findViewById(R.id.text_view_rc_number);
        Button buttonConfirm = findViewById(R.id.button_confirm);
        Button buttonEdit = findViewById(R.id.button_edit);

        textViewVehicleType.setText("Vehicle Type: " + selectedVehicleType);
        textViewVehicleNumber.setText("Vehicle Number: " + editTextVehicleNumber.getText().toString());
        textViewRCNumber.setText("RC Number: " + editTextRCNumber.getText().toString());

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayToastWithSerialNumber();
            }
        });

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main);
            }
        });
    }

    private void displayToastWithSerialNumber() {
        // Generate a serial number (you can replace this with your own logic)
        String serialNumber = "ABC123";

        Toast.makeText(this, "Parking Allotment Confirmed. Serial Number: " + serialNumber, Toast.LENGTH_SHORT).show();
    }
}
