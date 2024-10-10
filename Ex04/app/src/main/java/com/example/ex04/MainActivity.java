package com.example.ex04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edtFar, edtCel;
    Button btnFtoC, btnCtoF, btnClear; // Khai báo nút Clear

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtFar = findViewById(R.id.edtFar);
        edtCel = findViewById(R.id.edtCel);
        btnFtoC = findViewById(R.id.btnFtoC);
        btnCtoF = findViewById(R.id.btnCtoF);
        btnClear = findViewById(R.id.btnClear); // Khởi tạo nút Clear

        btnFtoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    DecimalFormat dcf = new DecimalFormat("#.00");
                    String doC = edtCel.getText().toString();
                    double C = Double.parseDouble(doC);
                    edtFar.setText(dcf.format(C * 1.8 + 32));
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập giá trị Celsius hợp lệ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCtoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    DecimalFormat dcf = new DecimalFormat("#.00");
                    String doF = edtFar.getText().toString();
                    double F = Double.parseDouble(doF);
                    edtCel.setText(dcf.format((F - 32) / 1.8));
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập giá trị Fahrenheit hợp lệ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Thiết lập chức năng cho nút Clear
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xóa nội dung của hai EditText
                edtFar.setText("");
                edtCel.setText("");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
