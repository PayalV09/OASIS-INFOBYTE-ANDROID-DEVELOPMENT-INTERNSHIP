package com.example.unitconvertoraplicationoasisinfobyte;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.unitconvertoraplicationoasisinfobyte.R;

public class MainActivity extends AppCompatActivity {

    private EditText inputValue;
    private Spinner unitTypeSpinner;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValue = findViewById(R.id.inputValue);
        unitTypeSpinner = findViewById(R.id.unitTypeSpinner);
        resultTextView = findViewById(R.id.resultTextView);
        Button convertButton = findViewById(R.id.convertButton);

        // Set up the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.unit_types,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitTypeSpinner.setAdapter(adapter);

        convertButton.setOnClickListener(v -> performConversion());
    }

    private void performConversion() {
        String selectedConversion = unitTypeSpinner.getSelectedItem().toString();
        String input = inputValue.getText().toString();

        if (input.isEmpty()) {
            resultTextView.setText("Please enter a value to convert");
            return;
        }

        double value = Double.parseDouble(input);
        double result;

        switch (selectedConversion) {
            case "Centimeters to Meters":
                result = value / 100;
                break;
            case "Meters to Centimeters":
                result = value * 100;
                break;
            case "Grams to Kilograms":
                result = value / 1000;
                break;
            case "Kilograms to Grams":
                result = value * 1000;
                break;
            default:
                resultTextView.setText("Invalid conversion type selected");
                return;
        }

        resultTextView.setText("Result: " + result);
    }
}
