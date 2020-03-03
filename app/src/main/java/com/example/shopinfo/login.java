package com.example.shopinfo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;

public class login extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    public static final int EXTRA_KEY = 0;
    public static final int LOGIN_PAGE = 12;
    Button loginbtn, signbtn;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginbtn = findViewById(R.id.loginbtn);
        signbtn = findViewById(R.id.signbtn);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
    }

    public void login(View view) {
        Intent toMainActivity = new Intent();
        setResult(EXTRA_KEY, toMainActivity);
        finish();
    }

    public void signup(View view) {
        Intent signup = new Intent(this, Signup.class);
        startActivity(signup);


    }

    public void loginSeller(View view) {
        Intent toSellerActivity= new Intent(this,SellerActivity.class);
        startActivityForResult(toSellerActivity,LOGIN_PAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==LOGIN_PAGE){
            if(resultCode== SellerActivity.EXTRA_LOGIN_KEY){

            }

        }
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

}