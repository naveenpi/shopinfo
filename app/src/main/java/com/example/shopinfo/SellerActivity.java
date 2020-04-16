package com.example.shopinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Observer;

public class SellerActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener ,  AdapterView.OnItemSelectedListener{




    public static final int EXTRA_LOGIN_KEY=1;
    TextView shopName, categoText, adderessText, phoneText;
    int quantityValue;
    ImageView Image;
    RadioGroup yesNo;
    RadioButton radio;
    int radioId;
    String radioText,discountsText,sellerMeassage,userNameString,passwordString;
    Spinner product;
    EditText messageEditText, discountEditText, quantity;
    Button subscribers, discounts, update;
    MainViewModel.SellerData modelSeller=new MainViewModel.SellerData();

    MainViewModel.SellerShopDetails modelShop;
    String productString;

    String[] products = { "phone", "tablet", "laptop", "x-box", "play-station"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);

        Intent toSellerActivity=getIntent();
        userNameString=toSellerActivity.getStringExtra("username");
        Log.d("username seller",userNameString);
        passwordString=toSellerActivity.getStringExtra("password");
        Log.d("password seller",passwordString);
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
        //subscribers=findViewById(R.id.sendToSubscribers);
        update=findViewById(R.id.update);
        //discounts=findViewById(R.id.discounts);

        modelSeller=modelSeller.getSellerData();

        modelSeller.getSellerDataString().observe(this, new androidx.lifecycle.Observer<String>() {
            @Override
            public void onChanged(String s) {

                String str=s;
                Log.d("message ",s);
                String[] array=str.split(",");
                shopName.setText(array[0]);
                categoText.setText(array[1]);
                adderessText.setText(array[2]);
                phoneText.setText(array[3]);

            }});

        radioId=yesNo.getCheckedRadioButtonId();
        radio=(RadioButton) findViewById(radioId);
        radioText=radio.getText().toString();
        Log.d("radio",radioText);

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
        productString=products[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void update(View view) {

        quantityValue=Integer.parseInt(quantity.getText().toString());
        modelShop=new MainViewModel.SellerShopDetails(radioText,productString,quantityValue);
        modelShop.setSellerShoDetails(modelShop);
        discountsText=discountEditText.getText().toString();
        modelShop=new MainViewModel.SellerShopDetails(discountsText);
        modelShop.setSellerShoDetails(modelShop);

        ChoiceModel myModel=ChoiceModel.getSingleton();
        myModel.addShopDetails(userNameString,passwordString,productString,quantityValue,discountsText);
        Toast.makeText(this, "Updated Quantity and discount", Toast.LENGTH_LONG).show();
    }

    public void toSubscribers(View view) {
        Toast.makeText(this, "Message sent to Subscribers", Toast.LENGTH_LONG).show();
    }

    public void toDiscount(View view) {
        discountsText=discountEditText.getText().toString();
        modelShop=new MainViewModel.SellerShopDetails(discountsText);
        modelShop.setSellerShoDetails(modelShop);
        Toast.makeText(this, "Discount information updated", Toast.LENGTH_LONG).show();
    }

    public void editSeller(View view) {
        Intent toEditSeller=new Intent(this,EditSelllerActivity.class);
        startActivity(toEditSeller);
    }


}
