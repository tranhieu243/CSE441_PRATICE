package com.example.ex06;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edt_name, edt_identityCard, edt_addNew;
    RadioButton rad_intermediate, rad_college, rad_university;
    CheckBox chk_new, chk_book, chk_code;
    Button btn_send;
    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edt_name = findViewById(R.id.edt_name);
        edt_identityCard = findViewById(R.id.edt_identityCard);
        edt_addNew = findViewById(R.id.edt_addNew);
        rad_intermediate = findViewById(R.id.rad_intermediate);
        rad_college = findViewById(R.id.rad_college);
        rad_university = findViewById(R.id.rad_university);
        chk_new = findViewById(R.id.chk_new);
        chk_book = findViewById(R.id.chk_book);
        chk_code = findViewById(R.id.chk_code);
        btn_send = findViewById(R.id.btn_send);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doShowInformation();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Phương thức doShowInformation cần được di chuyển ra ngoài onCreate
    public void doShowInformation() {
        String ten = edt_name.getText().toString().trim();
        if (ten.length() < 3) {
            edt_name.requestFocus();
            edt_name.selectAll();
            Toast.makeText(this, "Tên phải >= 3 ký tự", Toast.LENGTH_SHORT).show();
            return;
        }

        String cmnd = edt_identityCard.getText().toString().trim();
        if (cmnd.length() != 12) {
            edt_identityCard.requestFocus();
            edt_identityCard.selectAll();
            Toast.makeText(this, "CMND phải đúng 12 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        String bang = "";
        group = findViewById(R.id.group);
        int id = group.getCheckedRadioButtonId();
        if (id == -1) {
            Toast.makeText(this, "Phải chọn bằng cấp", Toast.LENGTH_LONG).show();
            return;
        }

        RadioButton rad = findViewById(id);
        bang = rad.getText().toString();

        String sothich = "";
        if (chk_new.isChecked()) sothich += chk_new.getText() + "\n";
        if (chk_book.isChecked()) sothich += chk_book.getText() + "\n";
        if (chk_code.isChecked()) sothich += chk_code.getText() + "\n";

        // Kiểm tra nếu không có sở thích nào được chọn
        if (sothich.isEmpty()) {
            Toast.makeText(this, "Phải chọn ít nhất một sở thích", Toast.LENGTH_SHORT).show();
            return;
        }

        String bosung = edt_addNew.getText().toString();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        String msg = ten + "\n" + cmnd + "\n" + bang + "\n" + sothich;
        msg += "--------\n";
        msg += "Thông tin bổ sung: \n" + bosung;
        msg += "---------";
        builder.setMessage(msg);
        builder.create().show();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
        b.setTitle("Question");
        b.setMessage("Are you sure you want to exit?");
        // Bạn có thể loại bỏ dòng này nếu không có drawable icon
        // b.setIcon(R.drawable.inform);
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        b.create().show();
    }
}
