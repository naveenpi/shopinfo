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
        firstName=findViewById(R.id.editText);
        lastName=findViewById(R.id.editText2);
        mailId=findViewById(R.id.editText3);
        userName=findViewById(R.id.editText4);
        password=findViewById(R.id.editText5);
        confirmPassword=findViewById(R.id.editText6);

        profilePic=findViewById(R.id.profile);
        register=findViewById(R.id.button);
    }
}
