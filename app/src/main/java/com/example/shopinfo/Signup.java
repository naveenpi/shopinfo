package com.example.shopinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class Signup extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
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
    public void sellerSignUp(View v){
        Intent seller= new Intent(this, SellerRegestration.class);
        startActivity(seller);
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
