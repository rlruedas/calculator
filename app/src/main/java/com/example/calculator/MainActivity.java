package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[] numbers;
    private TextView textView;
    private String currText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        numbers = new Button[10];
        numbers[0] = findViewById(R.id.btn0);
        numbers[1] = findViewById(R.id.btn1);
        numbers[2] = findViewById(R.id.btn2);
        numbers[3] = findViewById(R.id.btn3);
        numbers[4] = findViewById(R.id.btn4);
        numbers[5] = findViewById(R.id.btn5);
        numbers[6] = findViewById(R.id.btn6);
        numbers[7] = findViewById(R.id.btn7);
        numbers[8] = findViewById(R.id.btn8);
        numbers[9] = findViewById(R.id.btn9);

        for (int i = 0; i < 10; i++) {
            numbers[i].setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i < 10; i++) {
            if (v.getId() == numbers[i].getId()) {
                currText += String.valueOf(i);
                textView.setText(currText);
            }
        }
    }
}
