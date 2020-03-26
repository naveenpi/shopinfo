package com.example.shopinfo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    public static final int HOME_PAGE_REQUEST=11;
    ImageButton navigation;
    Button login,editCustomer;
    private ChoiceAdapter choiceAdapter = null;
    private RecyclerView choiceRV= null;
    private GestureDetectorCompat choiceDetector = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation=findViewById(R.id.navigation);
        login=findViewById(R.id.login);
        editCustomer=findViewById(R.id.editCustomer);
        //editCustomer.setVisibility();
        editCustomer.setClickable(false);
        choiceAdapter= new ChoiceAdapter();
        choiceRV=findViewById(R.id.choiceRV);
        choiceRV.setAdapter(choiceAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        choiceRV.setLayoutManager(layoutManager);
        choiceDetector=new GestureDetectorCompat(this, new RecyclerViewOnGestureListener());
        choiceRV.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return choiceDetector.onTouchEvent(e);
            }
        });
    }

    public void editCustomer(View view) {
        if(login.getText().toString().equals("LOG OUT")) {
            Intent toEditCustomerActivity = new Intent(this, EditCustomerActivity.class);
            startActivity(toEditCustomerActivity);
        }
    }

    private class RecyclerViewOnGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            View view = choiceRV.findChildViewUnder(e.getX(), e.getY());
            if (view != null) {
                RecyclerView.ViewHolder holder = choiceRV.getChildViewHolder(view);
                if (holder instanceof ChoiceAdapter.ChoiceViewHolder && choiceAdapter.getItemCount()>1) {
                    int position = holder.getAdapterPosition();
                    ChoiceModel myModel =ChoiceModel.getSingleton();
//                    myModel.choiceList.remove(position);
//                    choiceAdapter.notifyItemRemoved(position);
                    Intent toDetails= new Intent(MainActivity.this,DetailsActivity.class);
                    startActivity(toDetails);
                    return true;
                }
            }
            return false;
        }
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
            editCustomer.setVisibility(View.VISIBLE);
            editCustomer.setClickable(true);
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
    public void subscribe(View view) {
        Toast.makeText(this,"you are subscribed",Toast.LENGTH_LONG).show();
    }
}
