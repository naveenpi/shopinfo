package com.example.shopinfo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==HOME_PAGE_REQUEST){
            if(resultCode== com.example.shopinfo.login.EXTRA_KEY)
                login.setText("LOG OUT");
        }
    }

    public void call(View view) {
        Toast.makeText(this,"Making call",Toast.LENGTH_LONG).show();
        Intent toPhone=new Intent(Intent.ACTION_DIAL);
        toPhone.setData(Uri.parse("tel:2345671089"));
        startActivity(toPhone);
    }
    public void details(View view) {
        Toast.makeText(this,"Details not uploaded yet",Toast.LENGTH_LONG).show();
    }
}
