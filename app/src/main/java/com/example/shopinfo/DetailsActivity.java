package com.example.shopinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    TextView text;
    String s="";
    String detailsArray[];
    MainViewModel.SellerShopDetails modelShop=new MainViewModel.SellerShopDetails();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent toDetails=getIntent();
        s=toDetails.getStringExtra("description");
        detailsArray=s.split(" ");
        String toPrint="Available: "+detailsArray[0]+"\n"+"Phone number: "+detailsArray[1]+"\n"+"products: "+detailsArray[2]+"\n"+"Discounts: "+detailsArray[3];
        text=findViewById(R.id.detailsText);
        text.setText(toPrint);
//
//        modelShop=modelShop.getSellerShoDetails();
//
//        modelShop.getSellerShopDetailsString().observe(this, new androidx.lifecycle.Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//
//
//                Log.d("message ",s);
//
//                text.setText(s);
//
//            }});
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
                Intent toMain=new Intent(this,MainActivity.class);
                startActivity(toMain);
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

    public void callInDetailsActivity(View view) {
        Toast.makeText(this,"Making call in details activity",Toast.LENGTH_LONG).show();


        String phone="";
        Log.d("phone details activity",phone);
        phone=detailsArray[1];
        phone="tel:"+phone;
        Intent toPhone=new Intent(Intent.ACTION_DIAL,Uri.parse(phone));
        //toPhone.setData(Uri.parse(phone.toString()));
        startActivity(toPhone);
    }

    public void subscribe(View view) {
        Toast.makeText(this,"you are subscribed",Toast.LENGTH_LONG).show();
    }

    public void details(View view) {
        Toast.makeText(this,"Details not uploaded yet",Toast.LENGTH_LONG).show();
    }
}
