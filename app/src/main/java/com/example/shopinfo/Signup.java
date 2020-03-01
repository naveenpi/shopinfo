package com.example.shopinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class Signup extends AppCompatActivity {
    Button customer, seller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        customer=findViewById(R.id.csignup);
        seller=findViewById(R.id.sesignup);
    }
}
