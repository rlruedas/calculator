package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[] numbers, operators;
    private TextView firstNo, secondNo, textView;
    private String firstText = "", secondText = "", oper = "";
    private Button clear, add, multiply, subtract, divide, equals, decimal;
    private Double first, second, total;
    private int k = 0, c = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());

        firstNo = findViewById(R.id.firstNo);
        secondNo = findViewById(R.id.secondNo);
        clear = findViewById(R.id.clear);
        add = findViewById(R.id.add);
        subtract = findViewById(R.id.subtract);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        equals = findViewById(R.id.equals);
        decimal = findViewById(R.id.decimal);

        clear.setOnClickListener(this);
        firstNo.setOnClickListener(this);
        secondNo.setOnClickListener(this);
        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        equals.setOnClickListener(this);
        decimal.setOnClickListener(this);

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

        operators = new Button[4];
        operators[0] = findViewById(R.id.add);
        operators[1] = findViewById(R.id.subtract);
        operators[2] = findViewById(R.id.multiply);
        operators[3] = findViewById(R.id.divide);

        for (int i = 0; i < 4; i++){
            operators[i].setOnClickListener(this);
        }

    }


    @Override
    public void onClick(View v) {

        for (int i = 0; i < 4; i++){
            if(v.getId() == operators[i].getId()){
                if(!firstNo.getText().equals("Enter First Number")){
                    c = 1;
                    oper = String.valueOf(i);
                    k = Integer.parseInt(oper);
                }
            }
        }

            if(c == 0){
                for (int i = 0; i < 10; i++) {
                    if (v.getId() == numbers[i].getId()) {
                        if (i == 0) {
                            if (!firstText.equals("0")) {
                                firstText += String.valueOf(i);
                                firstNo.setText(firstText);
                            }
                        } else {
                            firstText += String.valueOf(i);
                            firstNo.setText(firstText);
                        }
                    }
                }
                if(v.getId() == decimal.getId()){
                    firstText += ".";
                    firstNo.setText(firstText);
                }
            }else if (c == 1){

                for (int i = 0; i < 10; i++) {
                    if (v.getId() == numbers[i].getId()) {
                        if (i == 0) {
                            if (!secondText.equals("0")) {
                                secondText += String.valueOf(i);
                                secondNo.setText(secondText);
                            }
                        } else {
                            secondText += String.valueOf(i);
                            secondNo.setText(secondText);
                        }
                    }
                }
                if(v.getId() == decimal.getId()){
                    secondText += ".";
                    secondNo.setText(secondText);
                }
            }

        if(v.getId() == equals.getId()){
            if(!secondNo.getText().equals("Enter Second Number")){
                if(k == 0){
                    first = Double.parseDouble(firstText);
                    second = Double.parseDouble(secondText);
                    total = first + second;
                    textView.setText(Double.toString(Math.floor(total)));
                } else if(k == 1) {
                    first = Double.parseDouble(firstText);
                    second = Double.parseDouble(secondText);
                    total = first - second;
                    textView.setText(Double.toString(Math.floor(total)));
                }else if(k == 2) {
                    first = Double.parseDouble(firstText);
                    second = Double.parseDouble(secondText);
                    total = first * second;
                    textView.setText(Double.toString(Math.floor(total)));
                }else if(k == 3) {
                    first = Double.parseDouble(firstText);
                    second = Double.parseDouble(secondText);
                    total = first / second;
                    textView.setText(Double.toString(Math.floor(total)));
                }
            }
        }

        if(v.getId() == clear.getId()){
            firstText = "";
            secondText = "";
            textView.setText("");
            firstNo.setText("Enter First Number");
            secondNo.setText("Enter Second Number");
            c = 0;
        }
    }
}
