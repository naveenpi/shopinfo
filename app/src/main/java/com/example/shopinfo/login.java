package com.example.shopinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {
    public static final int EXTRA_KEY = 0;
    Button loginbtn, signbtn;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginbtn = findViewById(R.id.loginbtn);
        signbtn = findViewById(R.id.signbtn);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
    }

    public void login(View view) {
        Intent toMainActivity = new Intent();
        setResult(EXTRA_KEY, toMainActivity);
        finish();
    }

    public void signup(View view) {
        Intent signup = new Intent(this, Signup.class);
        startActivity(signup);


    }
}