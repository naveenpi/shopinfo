package com.example.shopinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SellerRegestration extends AppCompatActivity {
    EditText shopName, category, address, phoneNumber, userName, password, confirmPassword;
    ImageButton profilePicSeller;
    Button registerSeller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_regestration);

        shopName=findViewById(R.id.shopName);
        category=findViewById(R.id.category);
        address=findViewById(R.id.address);
        phoneNumber=findViewById(R.id.phone);
        userName=findViewById(R.id.userNameSeller);;
        password=findViewById(R.id.passwordSeller);
        confirmPassword=findViewById(R.id.confirmPasswordSeller);
    }

    public void registerCustomer(View view) {

        Toast.makeText(this, "User Successfully registered as a Seller", Toast.LENGTH_LONG).show();
        Intent i= new Intent(this, login.class);
        startActivity(i);
    }


}
