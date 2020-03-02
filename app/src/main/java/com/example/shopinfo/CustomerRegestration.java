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

public class CustomerRegestration extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
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

    public void registerCustomer(View view) {

        Toast.makeText(this, "User Successfully registered as a customer", Toast.LENGTH_LONG).show();
        Intent i= new Intent(this, login.class);
        startActivity(i);
    }

    public void profilePicCustomer(View view) {
        Toast.makeText(this, "Upload profile picture of customer", Toast.LENGTH_LONG).show();
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
