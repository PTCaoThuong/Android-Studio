package com.example.converttmp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
//khai bao bien tren giao dien
    EditText edt_cm, edt_inch;
    Button btn_cm, btn_inch, btn_clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Anh xa ID

        edt_cm = findViewById(R.id.IDcm);
        edt_inch = findViewById(R.id.IDinch);
        btn_cm = findViewById(R.id.btn_cm);
        btn_inch = findViewById(R.id.btn_inch);
        btn_clear = findViewById(R.id.btn_clear);

        btn_cm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a = Float.parseFloat(edt_cm.getText().toString());
                float b = (float) (a*0.3937);
                edt_inch.setText(b+"");
            }
        });

        btn_inch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a = Float.parseFloat(edt_inch.getText().toString());
                float b = (float) (a/0.3937);
                edt_cm.setText(b+"");
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt_cm.setText("");
                edt_inch.setText("");
            }
        });
    }
}