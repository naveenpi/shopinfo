package com.example.shopinfo;

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
        startActivity(toSellerActivity);
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