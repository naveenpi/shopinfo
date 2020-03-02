package com.example.shopinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

public class SellerRegestration extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
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


    public void profilePicSeller(View view) {
        Toast.makeText(this, "Upload profile picture of seller", Toast.LENGTH_LONG).show();
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(takePictureIntent);
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
