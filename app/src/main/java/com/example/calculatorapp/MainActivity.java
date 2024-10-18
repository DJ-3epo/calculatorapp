package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etNumber1, etNumber2;
    private TextView tvResult;
    private String currentOperation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        tvResult = findViewById(R.id.tvResult);

        // Кнопки чисел
        findViewById(R.id.button0).setOnClickListener(v -> appendNumber("0"));
        findViewById(R.id.button1).setOnClickListener(v -> appendNumber("1"));
        findViewById(R.id.button2).setOnClickListener(v -> appendNumber("2"));
        findViewById(R.id.button3).setOnClickListener(v -> appendNumber("3"));
        findViewById(R.id.button4).setOnClickListener(v -> appendNumber("4"));
        findViewById(R.id.button5).setOnClickListener(v -> appendNumber("5"));
        findViewById(R.id.button6).setOnClickListener(v -> appendNumber("6"));
        findViewById(R.id.button7).setOnClickListener(v -> appendNumber("7"));
        findViewById(R.id.button8).setOnClickListener(v -> appendNumber("8"));
        findViewById(R.id.button9).setOnClickListener(v -> appendNumber("9"));

        // Кнопки операций
        findViewById(R.id.buttonAdd).setOnClickListener(v -> setOperation("+"));
        findViewById(R.id.buttonSubtract).setOnClickListener(v -> setOperation("-"));
        findViewById(R.id.buttonMultiply).setOnClickListener(v -> setOperation("*"));
        findViewById(R.id.buttonDivide).setOnClickListener(v -> setOperation("/"));
        findViewById(R.id.buttonClear).setOnClickListener(v -> clearFields());
    }

    private void appendNumber(String number) {
        if (etNumber1.hasFocus()) {
            etNumber1.append(number);
        } else if (etNumber2.hasFocus()) {
            etNumber2.append(number);
        }
    }

    private void setOperation(String operation) {
        currentOperation = operation;
        if (!etNumber1.getText().toString().isEmpty() && !etNumber2.getText().toString().isEmpty()) {
            calculateResult();
        }
    }

    private void calculateResult() {
        double number1 = Double.parseDouble(etNumber1.getText().toString());
        double number2 = Double.parseDouble(etNumber2.getText().toString());
        double result;

        switch (currentOperation) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number2 != 0 ? number1 / number2 : 0; // Обработка деления на ноль
                break;
            default:
                return;
        }

        tvResult.setText(String.valueOf(result));
    }

    private void clearFields() {
        etNumber1.setText("");
        etNumber2.setText("");
        tvResult.setText("");
        currentOperation = "";
    }
}



