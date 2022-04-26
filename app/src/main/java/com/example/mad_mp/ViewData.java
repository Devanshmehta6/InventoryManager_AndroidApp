package com.example.mad_mp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewData extends AppCompatActivity {

    TextView tv;
    DB_Helper db;
    ArrayList<String> listItem;
    ArrayAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        db = new DB_Helper(this);
        listView = findViewById(R.id.prod_listview);
        tv = findViewById(R.id.error);
        getSupportActionBar().hide();

        listItem = new ArrayList<>();

        viewData();
    }

    public void viewData() {
        Cursor cursor = db.viewData();
        if(cursor.getCount()==0){
            tv.setText("No products!");
        }else{
            while(cursor.moveToNext()){
                    String temp = cursor.getString(1);
                    String temp2 = cursor.getString(2);
                    String temp3 = "Product: "+temp + "\nQuantity: "+temp2;
                    listItem.add(temp3);

            }
            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listItem);
            listView.setAdapter(adapter);
        }

    }
}