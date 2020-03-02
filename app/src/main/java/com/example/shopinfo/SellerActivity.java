package com.example.shopinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class SellerActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

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

    public void menu(View view) {
        PopupMenu popup= new PopupMenu(this,view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.navigation_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Intent toHome=new Intent(this,MainActivity.class);
                startActivity(toHome);
                return true;
            case R.id.item2:
                return true;
            case R.id.item3:
                return true;
            default:
                return true;
        }
    }
}
