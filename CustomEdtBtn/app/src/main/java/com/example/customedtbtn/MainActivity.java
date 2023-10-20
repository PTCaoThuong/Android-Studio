package com.example.customedtbtn;

import static com.example.customedtbtn.R.id.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText acc, pass;
    TextView process;
    Button log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //anh xa
        process = findViewById(R.id.textView2);
        acc = findViewById(R.id.edt_acc);
        pass = findViewById(R.id.edt_pass);
        log = findViewById(R.id.login);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a,b;
                a = acc.getText().toString();
                b = pass.getText().toString();
                if(!acc.getText().toString().isEmpty()){
                    if(!pass.getText().toString().isEmpty()){
                        process.setText("Successfully");
                    }
                    else{
                        process.setText("Need enter Password");
                    }
                }
                else{
                    process.setText("Need enter account");
                }

            }
        });

    }
}