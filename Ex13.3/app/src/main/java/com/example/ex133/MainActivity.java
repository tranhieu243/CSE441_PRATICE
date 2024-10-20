package com.example.ex133;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] namePhone = {"Điện thoại Iphone 14prm", "Điện thoại Samsung S23", "Điện thoại Huawei", "Điện thoại HTC", "Điện thoại Xiaomi"};
    int[] imagePhone = {R.drawable.ip, R.drawable.ss, R.drawable.hw, R.drawable.htc, R.drawable.xm};


    ArrayList<Phone> myList;
    MyArrayAdapter myAdapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        myList = new ArrayList<>();
        for (int i = 0; i < namePhone.length; i++) {
            myList.add(new Phone(namePhone[i], imagePhone[i]));
        }
        myAdapter = new MyArrayAdapter(this, R.layout.layout_listview, myList);
        lv.setAdapter(myAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position >= 0 && position < namePhone.length) {
                    Intent myIntent = new Intent(MainActivity.this, SubActivity.class);
                    myIntent.putExtra("name", namePhone[position]);
                    startActivity(myIntent);
                }
            }
        });
    }
}
