package com.example.mad_mp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Activity2 extends AppCompatActivity {


    Button sub;
    EditText u,p;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        sub= findViewById(R.id.submit);
        getSupportActionBar().hide();
        u = findViewById(R.id.username);
        p = findViewById(R.id.password);
        pb = findViewById(R.id.progressbars);
        pb.setVisibility(View.GONE);
        DB_Helper db = new DB_Helper(this);

        sub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email = u.getText().toString().trim();
                String password = p.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    u.setError("Email cannot be empty");
                    u.requestFocus();
                }else if(TextUtils.isEmpty(password)){
                    p.setError("Password cannot be empty");
                    p.requestFocus();
                }else{
                    String user = u.getText().toString().trim();
                    String pass = p.getText().toString().trim();
                    Boolean checkUsername = db.checkUsername(user);
                    if(checkUsername){
                        Boolean matchUser = db.matchuserpass(user,pass);
                        if(matchUser){
                            Intent intent = new Intent(Activity2.this, Dashboard.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(Activity2.this,"Username and password does not match" , Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(Activity2.this,"User does not exists" , Toast.LENGTH_SHORT).show();
                        u.setText("");
                        p.setText("");

                    }


                }

            }

       });
    }


}
