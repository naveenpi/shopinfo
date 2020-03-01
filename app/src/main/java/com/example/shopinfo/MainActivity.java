package com.example.shopinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    public static final int HOME_PAGE_REQUEST=11;
    ImageButton navigation;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation=findViewById(R.id.navigation);
        login=findViewById(R.id.login);
    }

    public void menu(View v) {
        PopupMenu popup= new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.navigation_menu);
        popup.show();
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                return true;
            case R.id.item2:
                return true;
            case R.id.item3:
                return true;
            default:
                return true;
        }
    }

    public void login(View view) {
        if(login.getText().toString().equals("LOGIN")) {
            Intent login = new Intent(this, com.example.shopinfo.login.class);
            startActivityForResult(login, HOME_PAGE_REQUEST);
        }
        else if(login.getText().toString().equals("LOG OUT")){
            Toast.makeText(this, "User Logged out", Toast.LENGTH_SHORT).show();
            login.setText("LOGIN");
        }
    }
}
