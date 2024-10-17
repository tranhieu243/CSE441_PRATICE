package com.example.ex072;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Result extends AppCompatActivity {
    EditText edtResult;
    Button btnBack;
    private static final String TAG = "ResultActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        edtResult = findViewById(R.id.edtResult);
        btnBack = findViewById(R.id.btnBack);

        Intent yourintent = getIntent();
        Bundle yourbundle = yourintent.getBundleExtra("mybackage");

        if (yourbundle != null) {
            int a = yourbundle.getInt("soa", -1); // Giá trị mặc định là -1 nếu không có
            int b = yourbundle.getInt("sob", -1); // Giá trị mặc định là -1 nếu không có

            // In ra log để kiểm tra giá trị nhận được
            Log.d(TAG, "Nhận được giá trị a: " + a + ", b: " + b);

            String kq = "";

            if (a == -1 || b == -1) {
                edtResult.setText("Lỗi khi nhận giá trị a hoặc b.");
                Log.e(TAG, "Không nhận được giá trị hợp lệ từ Intent.");
            } else {
                if (a == 0 && b == 0) {
                    kq = "Vô số nghiệm";
                } else if (a == 0 && b != 0) {
                    kq = "Vô nghiệm";
                } else {
                    DecimalFormat dcf = new DecimalFormat("0.##");
                    kq = dcf.format(-b * 1.0 / a);
                }

                edtResult.setText(kq);
            }

        } else {
            edtResult.setText("Không có dữ liệu truyền vào.");
            Log.e(TAG, "Không nhận được Bundle từ Intent");
        }

        // Nút quay lại
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
