package com.example.temperaturecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    EditText et_value;
    RadioButton btn_celsius;
    RadioButton btn_fahrenheit;
    Button btn_calculate;
    TextView tv_displayAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_value = findViewById(R.id.et_value);
        btn_celsius = findViewById(R.id.btn_celsius);
        btn_fahrenheit = findViewById(R.id.btn_fehrenheit);
        btn_calculate = findViewById(R.id.btn_calculate);
        tv_displayAnswer = findViewById(R.id.tv_displayAnswer);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }

    private void calculateAnswer() {
        Calculations culations = new Calculations();
        String temp_value = et_value.getText().toString();

        if (TextUtils.isEmpty(temp_value)) {
            Toast.makeText(this, "Please enter a temperature value!", Toast.LENGTH_LONG).show();
        } else {
            Float temp = Float.parseFloat(temp_value);
            if (btn_celsius.isChecked()) {
                temp = culations.convertCelciusToFahrenheit(temp);
            } else if (btn_fahrenheit.isChecked()) {
                temp = culations.convertFahrenheitToCelcius(temp);
            } else {
                Toast.makeText(this,"Please select a radio!", Toast.LENGTH_LONG).show();
            }
            tv_displayAnswer.setText(new Float(temp).toString());
        }
    }
}


