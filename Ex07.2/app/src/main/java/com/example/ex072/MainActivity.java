package com.example.ex072;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB;
    Button btnResult;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        btnResult = findViewById(R.id.btnResult);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String inputA = edtA.getText().toString().trim();
                    String inputB = edtB.getText().toString().trim();

                    // Kiểm tra nếu ô nhập trống
                    if (inputA.isEmpty() || inputB.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập giá trị", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // Chuyển đổi giá trị từ EditText thành số nguyên
                    int a = Integer.parseInt(inputA);
                    int b = Integer.parseInt(inputB);

                    // In ra log để kiểm tra giá trị
                    Log.d(TAG, "Giá trị a: " + a + ", Giá trị b: " + b);

                    // Tạo Intent và Bundle để truyền dữ liệu
                    Intent myintent = new Intent(MainActivity.this, Result.class);
                    Bundle bundle1 = new Bundle();
                    bundle1.putInt("soa", a);
                    bundle1.putInt("sob", b);
                    myintent.putExtra("mybackage", bundle1);

                    // Khởi động Activity Result
                    startActivity(myintent);

                } catch (NumberFormatException e) {
                    // In ra log lỗi
                    Log.e(TAG, "Lỗi định dạng số: " + e.getMessage());
                    Toast.makeText(MainActivity.this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    // Bắt tất cả ngoại lệ khác
                    Log.e(TAG, "Lỗi không xác định: " + e.getMessage());
                }
            }
        });
    }
}
