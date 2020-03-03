package com.example.shopinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SellerActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener ,  AdapterView.OnItemSelectedListener{

    public static final int EXTRA_LOGIN_KEY=1;
    TextView shopName, categoText, adderessText, phoneText;
    ImageView Image;
    RadioGroup yesNo;

    Spinner product;
    EditText messageEditText, discountEditText, quantity;
    Button subscribers, discounts, update;

    String[] products = { "phone", "tablet", "laptop", "x-box", "play-station"};
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

        product.setOnItemSelectedListener(this);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,products);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        product.setAdapter(adapter);
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
                Intent toAbout=new Intent(this,About.class);
                startActivity(toAbout);
                return true;
            case R.id.item3:
                Intent toShare=new Intent(this,Share.class);
                startActivity(toShare);
                return true;
            default:
                return true;
        }
    }

    public void logout(View view) {
        Intent toLogin= new Intent();
        setResult(EXTRA_LOGIN_KEY,toLogin);
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),products[position] , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void update(View view) {
        Toast.makeText(this, "Updated Quantity", Toast.LENGTH_LONG).show();
    }

    public void toSubscribers(View view) {
        Toast.makeText(this, "Message sent to Subscribers", Toast.LENGTH_LONG).show();
    }

    public void toDiscount(View view) {
        Toast.makeText(this, "Discount information updated", Toast.LENGTH_LONG).show();
    }
}
