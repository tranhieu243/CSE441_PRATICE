package com.example.ex08;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtKQ;
    Button btnRequest;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtKQ = findViewById(R.id.edtKQ);
        btnRequest = findViewById(R.id.btnRequest);

        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Kiểm tra giá trị nhập vào
                String strA = edtA.getText().toString();
                String strB = edtB.getText().toString();

                if (strA.isEmpty() || strB.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ 2 số!", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    int a = Integer.parseInt(strA);
                    int b = Integer.parseInt(strB);

                    // Tạo Intent và truyền dữ liệu
                    Intent myintent = new Intent(MainActivity.this, ResultActivity.class);
                    myintent.putExtra("soa", a);
                    myintent.putExtra("sob", b);
                    startActivityForResult(myintent, 99);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 99 && resultCode != RESULT_CANCELED && data != null) {
            int result = data.getIntExtra("kq", 0);
            String message = resultCode == 33 ? "Tổng 2 số là: " : "Hiệu hai số là: ";
            edtKQ.setText(message + result);
        }
    }
}
