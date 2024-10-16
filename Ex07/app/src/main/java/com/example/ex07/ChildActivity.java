package com.example.ex07;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ChildActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_child); // Sửa lỗi này

        Button btn = (Button) findViewById(R.id.btn_backToMain);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ChildActivity.this, MainActivity.class);
                startActivity(intent1); // Bổ sung lệnh startActivity để chuyển sang MainActivity
            }
        });
    }
}
