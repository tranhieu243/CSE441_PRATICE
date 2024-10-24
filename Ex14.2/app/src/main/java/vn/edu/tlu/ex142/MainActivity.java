package vn.edu.tlu.ex142;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edttim;
    ListView lv1, lv2, lv3;
    TabHost tab;
    ArrayList<Item> list1, list2, list3;
    MyArrayAdapter myArray1, myArray2, myArray3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }
    private void addEvent(){
        tab.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if (tabId.equalsIgnoreCase("t1")){
                    list1.clear();
                    list1.add(new Item("52300", "Em là ai Tôi là ai", 0));
                    list1.add(new Item("52600", "Chén Đắng", 1));
                    myArray1.notifyDataSetChanged();
                }
                if (tabId.equalsIgnoreCase("t2")){
                    list2.clear();
                    list2.add(new Item("57236", "Anh yeeu em ", 0));
                    list2.add(new Item("51548", "Anh yeu em rat nhieu", 0));
                    myArray2.notifyDataSetChanged();
                }
                if (tabId.equalsIgnoreCase("t3")){
                    list3.clear();
                    list3.add(new Item("57689","Don gian anh yeu em", 1));
                    list3.add(new Item("58716","Anh chiu em roi", 0));
                    myArray3.notifyDataSetChanged();
                }
            }
        });
    }
    private void addControl(){
        tab = findViewById(android.R.id.tabhost);
        tab.setup();
        TabHost.TabSpec tab1 = tab.newTabSpec("t1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("", ContextCompat.getDrawable(this, R.drawable.search));
        tab.addTab(tab1);
        TabHost.TabSpec tab2 = tab.newTabSpec("t2");
        tab2.setContent(R.id.tab2);
        tab2.setIndicator("", ContextCompat.getDrawable(this, R.drawable.list));
        tab.addTab(tab2);
        TabHost.TabSpec tab3 = tab.newTabSpec("t3");
        tab3.setContent(R.id.tab3);
        tab3.setIndicator("", ContextCompat.getDrawable(this, R.drawable.favourite));
        tab.addTab(tab3);
        edttim = (EditText) findViewById(R.id.edttim);
        lv1 = (ListView) findViewById(R.id.lv1);
        lv2 = (ListView) findViewById(R.id.lv2);
        lv3 = (ListView) findViewById(R.id.lv3);
        list1 = new ArrayList<Item>();
        list2 = new ArrayList<Item>();
        list3 = new ArrayList<Item>();
        myArray1 = new MyArrayAdapter(MainActivity.this, list1, R.layout.listitem);
        myArray2 = new MyArrayAdapter(MainActivity.this, list2, R.layout.listitem);
        myArray3 = new MyArrayAdapter(MainActivity.this, list3, R.layout.listitem);

        lv1.setAdapter(myArray1);
        lv2.setAdapter(myArray2);
        lv3.setAdapter(myArray3);
    }
}