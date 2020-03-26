package com.example.shopinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
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

    public void call(View view) {
        Toast.makeText(this,"Making call",Toast.LENGTH_LONG).show();
        Intent toPhone=new Intent(Intent.ACTION_DIAL);
        toPhone.setData(Uri.parse("tel:2345671089"));
        startActivity(toPhone);
    }

    public void subscribe(View view) {
        Toast.makeText(this,"you are subscribed",Toast.LENGTH_LONG).show();
    }

    public void details(View view) {
        Toast.makeText(this,"Details not uploaded yet",Toast.LENGTH_LONG).show();
    }
}
