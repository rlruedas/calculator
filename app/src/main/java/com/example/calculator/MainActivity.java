package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[] numbers, operators;
    private TextView textView;
    private String currText = "", tempOne = "",tempTwo = "",tempThree = "", oper = "";
    private Button clear, equals, decimal;
    private Float first, second, total;
    private int k = 0;
    DecimalFormat df;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());

        clear = findViewById(R.id.clear);
        equals = findViewById(R.id.equals);
        decimal = findViewById(R.id.decimal);

        clear.setOnClickListener(this);
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
                if(!textView.getText().equals("")){
                    oper = String.valueOf(i);
                    k = Integer.parseInt(oper);
                    tempOne = currText;
                    if(i == 0){
                        currText += "+";
                        textView.setText(currText);
                        currText = "";
                    }else if(i == 1){
                        tempThree += "-";
                        textView.setText(currText);
                        currText = "";
                    }else if(i == 2){
                        currText += "×";
                        textView.setText(currText);
                        currText = "";
                    }else if(i == 3){
                        currText += "÷";
                        textView.setText(currText);
                        currText = "";
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            if (v.getId() == numbers[i].getId()) {
                if (i == 0) {
                    if(!currText.equals("0")){
                        currText += String.valueOf(i);
                        textView.setText(currText);
                    }
                } else {
                    currText += String.valueOf(i);
                    textView.setText(currText);
                }
            }
        }
        if(v.getId() == decimal.getId()){
            currText += ".";
            textView.setText(currText);
        }

        if(v.getId() == equals.getId()) {
            tempTwo = currText;
            if (!tempOne.equals("") && !tempTwo.equals("")) {
                if (k == 0) {
                    first = Float.parseFloat(tempOne);
                    second = Float.parseFloat(tempTwo);
                    total = first + second;
                    textView.setText(String.format("%.0f", total));
                } else if (k == 1) {
                    first = Float.parseFloat(tempOne);
                    second = Float.parseFloat(tempTwo);
                    total = first - second;
                    textView.setText(String.format("%.0f", total));
                } else if (k == 2) {
                    first = Float.parseFloat(tempOne);
                    second = Float.parseFloat(tempTwo);
                    total = first * second;
                    textView.setText(String.format("%.0f", total));
                } else if (k == 3) {
                    first = Float.parseFloat(tempOne);
                    second = Float.parseFloat(tempTwo);
                    total = first / second;
                    textView.setText(String.format("%.0f", total));
                }
            }
        }
        if(v.getId() == clear.getId()){
            tempOne = "";
            tempTwo = "";
            currText = "";
            textView.setText("0");
        }
    }
}
