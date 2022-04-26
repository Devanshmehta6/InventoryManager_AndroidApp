package com.example.mad_mp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddProduct extends AppCompatActivity {

    EditText ed1,ed2;
    Button s;
    private DB_Helper db_helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        ed1 = findViewById(R.id.name);
        ed2 = findViewById(R.id.quantity);
        s = findViewById(R.id.addprod);
        getSupportActionBar().hide();
        db_helper = new DB_Helper(AddProduct.this);

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ed1.getText().toString();
                String qty = ed2.getText().toString();


                db_helper.addProduct(name,qty);
                Toast.makeText(AddProduct.this,"Product has been added",Toast.LENGTH_SHORT).show();
                ed1.setText("");
                ed2.setText("");
                ed1.clearFocus();
                ed2.clearFocus();


            }
        });

    }

}