package com.example.tablelayout;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Khai bao cac bien giao dien
    EditText edt_year;
    Button btn_convert;
    TextView text_name;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_year = findViewById(R.id.edt_year);
        btn_convert = findViewById(R.id.btn_cvt);
        text_name = findViewById(R.id.text_name);

        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String can = "", chi = "";
                int year = 0;
                try {
                    year = Integer.parseInt(edt_year.getText().toString());
                } catch (NumberFormatException e) {
                    text_name.setText("Invalid value");
                }
                if (!edt_year.getText().toString().isEmpty()) {

                    switch (year % 10) {
                        case 0:
                            can = "Canh";
                            break;
                        case 1:
                            can = "Tân";
                            break;
                        case 2:
                            can = "Nhâm";
                            break;
                        case 3:
                            can = "Quý";
                            break;
                        case 4:
                            can = "Giáp";
                            break;
                        case 5:
                            can = "Ất";
                            break;
                        case 6:
                            can = "Bính";
                            break;
                        case 7:
                            can = "Đinh";
                            break;
                        case 8:
                            can = "Mậu";
                            break;
                        case 9:
                            can = "Kỷ";
                            break;
                        default:
                            can = " ";
                    }

                    switch (year % 12) {
                        case 0:
                            chi = "Thân";
                            break;
                        case 1:
                            chi = "Dậu";
                            break;
                        case 2:
                            chi = "Tuất";
                            break;
                        case 3:
                            chi = "Hợi";
                            break;
                        case 4:
                            chi = "Tí";
                            break;
                        case 5:
                            chi = "Sửu";
                            break;
                        case 6:
                            chi = "Dần";
                            break;
                        case 7:
                            chi = "Mão";
                            break;
                        case 8:
                            chi = "Thìn";
                            break;
                        case 9:
                            chi = "Tị";
                            break;
                        case 10:
                            chi = "Ngọ";
                            break;
                        case 11:
                            chi = "Mùi";
                            break;
                        default:
                            chi = " ";
                    }
                    text_name.setText(can + " " + chi);


                } else {
                    text_name.setText("Invalid value" + chi + can);
                }

            }
        });


        // ... Khởi tạo các thành phần giao diện khác

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Xử lý khi nút Back được nhấn
                AlertDialog.Builder mydialog = new AlertDialog.Builder(MainActivity.this);
                mydialog.setTitle("Exit Window");
                mydialog.setMessage("Are you sure you want to exit ?");
                mydialog.setIcon(R.drawable.warning_4201973);
                mydialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                mydialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                mydialog.show(); // Hiển thị hộp thoại
            }
        };

        getOnBackPressedDispatcher().addCallback(this, callback);


    }
}
