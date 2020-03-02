package com.example.shopinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class SellerActivity extends AppCompatActivity {

    TextView shopName, categoText, adderessText, phoneText;
    ImageView Image;
    RadioGroup yesNo;

    Spinner product;
    EditText messageEditText, discountEditText, quantity;
    Button subscribers, discounts, update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);

        shopName=findViewById(R.id.shopNameText);
        categoText=findViewById(R.id.categoryText);
        adderessText=findViewById(R.id.addressText);
        phoneText=findViewById(R.id.phoneText);
        Image=findViewById(R.id.imageView);
        yesNo=findViewById(R.id.radioAvailable);
        product=findViewById(R.id.spinner);
        messageEditText=findViewById(R.id.message);
        discountEditText=findViewById(R.id.discountInfo);
        quantity=findViewById(R.id.quantity);
        subscribers=findViewById(R.id.sendToSubscribers);
        update=findViewById(R.id.update);
        discounts=findViewById(R.id.discounts);
    }
}
