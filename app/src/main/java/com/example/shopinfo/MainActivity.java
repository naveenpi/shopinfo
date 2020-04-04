package com.example.shopinfo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, AdapterView.OnItemSelectedListener {

    public static final int HOME_PAGE_REQUEST=11;
    ImageButton navigation;
    Button login,editCustomer;
    private ChoiceAdapter choiceAdapter = null;
    private RecyclerView choiceRV= null;
    private GestureDetectorCompat choiceDetector = null;
    String[] cities = { "Maryville", "kansas", "St.Joseph"};
    Spinner city;
    RecyclerView.LayoutManager layoutManager;
    public static String citySelected="Maryville";

    MainViewModel.SellerShopDetails modelShop=new MainViewModel.SellerShopDetails();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation=findViewById(R.id.navigation);
        login=findViewById(R.id.login);
        city=findViewById(R.id.spinnerMainActivity);
        city.setOnItemSelectedListener(this);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        city.setAdapter(adapter);
        editCustomer=findViewById(R.id.editCustomer);
        editCustomer.setClickable(false);


        choiceAdapter= new ChoiceAdapter();
        choiceRV=findViewById(R.id.choiceRV);
        choiceRV.setAdapter(choiceAdapter);
        layoutManager = new LinearLayoutManager(this);
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
        else if(login.getText().toString().equals("LOGIN")){
            editCustomer.setVisibility(View.INVISIBLE);
            editCustomer.setClickable(false);
            Toast.makeText(this,"Please login to edit",LENGTH_SHORT).show();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        citySelected=cities[position];
        Toast.makeText(getApplicationContext(),citySelected , Toast.LENGTH_LONG).show();
        Log.d("city",citySelected);
        //if(position>=0 && position < cities.length){
            ChoiceModel model=ChoiceModel.getSingleton();
            model.getChoiceData(citySelected);
            choiceAdapter.notifyDataSetChanged();
        //}
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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

                    if(login.getText().equals("LOG OUT")) {
                        modelShop=modelShop.getSellerShoDetails();
                        if(modelShop!=null) {
                            Intent toDetails = new Intent(MainActivity.this, DetailsActivity.class);
                            startActivity(toDetails);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Seller did not update",Toast.LENGTH_LONG).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Please login to proceed",Toast.LENGTH_LONG).show();
                    }
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
            Toast.makeText(this, "User Logged out", LENGTH_SHORT).show();
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
