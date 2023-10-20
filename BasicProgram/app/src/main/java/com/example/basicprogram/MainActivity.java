package com.example.basicprogram;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, id, more;
    Button send;
    RadioGroup id_group;
    CheckBox ball, code, swim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.edt_name);
        id = findViewById(R.id.edt_id);
        more = findViewById(R.id.edt_more);
        send = findViewById(R.id.btn_send);
        id_group = findViewById(R.id.id_group);
        ball = findViewById(R.id.ck_ball);
        code = findViewById(R.id.ck_code);
        swim = findViewById(R.id.ck_swim);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = name.getText().toString();
                if(ten.length() < 3){
                    Toast.makeText(MainActivity.this, "More than 3 character", Toast.LENGTH_LONG).show();
                    name.requestFocus();
                    name.selectAll();
                    return;
                }
                String cmnd = id.getText().toString();
                if(cmnd.length() != 9){
                    Toast.makeText(MainActivity.this, "Must be 9 numbers", Toast.LENGTH_LONG).show();
                    id.requestFocus();
                    id.selectAll();
                    return;
                }

                int id_select = id_group.getCheckedRadioButtonId();
                RadioButton rad = findViewById(id_select);
                String degree = rad.getText().toString();

                String hobby ="";
                if(ball.isChecked()){
                    hobby += ball.getText().toString() + " - ";
                }
                if(code.isChecked()){
                    hobby += code.getText().toString() + " - ";
                }
                if(swim.isChecked()){
                    hobby += swim.getText().toString()+ " - ";
                }
                String new_hobby = hobby.substring(0, hobby.length() - 3);
                String text_more = more.getText().toString();

                String full = ten + "\n" + cmnd + "\n" + degree + "\n" + new_hobby + "\n";
                    full += "-------More Information-----\n";
                    full+= text_more;
                    full+="--------------------";

                    //make dialog and display infor

                AlertDialog.Builder mydialog = new AlertDialog.Builder(MainActivity.this);
                mydialog.setTitle("INFORMATION");
                mydialog.setMessage(full);
                mydialog.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                         dialogInterface.cancel();
                    }
                });
                mydialog.create().show();
            }
        });
    }
}