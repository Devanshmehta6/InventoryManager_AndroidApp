package com.example.mad_mp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class edit_product extends AppCompatActivity {

    TextView quantity;
    private DB_Helper db_helper;
    EditText name,quantityEd;
    Button b,update;
    String nameS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);

        getSupportActionBar().hide();
        db_helper = new DB_Helper(edit_product.this);
        quantity = findViewById(R.id.quantity);
        name = findViewById(R.id.name);
        update = findViewById(R.id.update);
        quantityEd = findViewById(R.id.new_quantity);
        b = findViewById(R.id.submit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameS = name.getText().toString().trim();
                String quantity_get = db_helper.getQuantity(nameS);
                quantity.setText(""+quantity_get);
                name.clearFocus();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String new_quantity = quantityEd.getText().toString().trim();
                Boolean res = db_helper.updateData(nameS,new_quantity);
                if(res){
                    Toast.makeText(edit_product.this,"Data updated successfully" , Toast.LENGTH_SHORT).show();
                    name.setText("");
                    quantityEd.setText("");
                    quantityEd.clearFocus();
                }else{
                    Toast.makeText(edit_product.this,"Data cannot be updated" , Toast.LENGTH_SHORT).show();

                }
            }
        });







    }
}