package com.example.mad_mp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class delete_product extends AppCompatActivity {

    private DB_Helper db_helper;
    Button del;
    EditText ed1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_product);
        del = findViewById(R.id.delProd);
        ed1 = findViewById(R.id.name);
        getSupportActionBar().hide();

        db_helper = new DB_Helper(delete_product.this);

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ed1.getText().toString();
                Boolean b = db_helper.deleteProduct(name);
                ed1.setText("");
                if(b){
                    Toast.makeText(delete_product.this,"Product has been deleted.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(delete_product.this,"Product does not exists.",Toast.LENGTH_SHORT).show();
                }
                ed1.clearFocus();
            }
        });
    }
}