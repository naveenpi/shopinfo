package com.example.shopinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
    public void customerSignUp(View v){
        Intent customer= new Intent(this, CustomerRegestration.class);
        startActivity(customer);
    }
}
