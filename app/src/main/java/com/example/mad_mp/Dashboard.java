package com.example.mad_mp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {
    FirebaseAuth mAuth;
    Button btn;
    CardView add,delete,viewItems,viewInventory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        mAuth = FirebaseAuth.getInstance();
        add = findViewById(R.id.addItems);
        delete = findViewById(R.id.deleteItems);
        viewItems = findViewById(R.id.viewItems);
        viewInventory = findViewById(R.id.viewInventory);
        getSupportActionBar().hide();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, AddProduct.class);
                startActivity(intent);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, delete_product.class);
                startActivity(intent);
            }
        });
        viewInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, ViewData.class);
                startActivity(intent);
            }
        });

        viewItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, edit_product.class);
                startActivity(intent);            }
        });



//        btn = findViewById(R.id.btnlogout);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mAuth.signOut();
//                startActivity(new Intent( Dashboard.this , Activity2.class));
//            }
//        });

    }
}