package com.example.shopinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class CustomerRegestration extends AppCompatActivity {
    EditText firstName, lastName, mailId, userName, password, confirmPassword;
    ImageButton profilePic;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_regestration);
    }
}
