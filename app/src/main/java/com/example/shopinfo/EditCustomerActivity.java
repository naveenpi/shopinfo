package com.example.shopinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class EditCustomerActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_customer);
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

    public void profilePicCustomer(View view) {
        Toast.makeText(this, "Upload profile picture of customer", Toast.LENGTH_LONG).show();
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(takePictureIntent);
    }

    public void updateCustomerDetails(View view) {
        Toast.makeText(this, "User Successfully updated the details", Toast.LENGTH_LONG).show();
        Intent i= new Intent(this, login.class);
        startActivity(i);
    }
}
