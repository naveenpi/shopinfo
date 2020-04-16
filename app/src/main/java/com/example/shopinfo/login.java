package com.example.shopinfo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class login extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    public static final int EXTRA_KEY = 0;
    public static final int LOGIN_PAGE = 12;
    Button loginbtn, signbtn;
    EditText username, password;
    String userNameString="",passwordString="";
    String customerUserName="",customerPasswordString="";
    MainViewModel.SellerData modelSeller=new MainViewModel.SellerData();
    MainViewModel.CustomerData modelCustomer=new MainViewModel.CustomerData();
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
        if (validate()){
            modelCustomer=modelCustomer.getCustomerData();
            if(modelCustomer!=null) {
                modelCustomer.getCustomerDataString().observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        String str=s;
                        Log.d("customer message ", s);
                        String[] array=str.split(",");
                        customerUserName=array[3];
                        customerPasswordString=array[4];
                    }
                });
                if(username.getText().toString().equals(customerUserName) && password.getText().toString().equals(customerPasswordString)) {
                    Log.d("username", username.getText().toString());
                    Intent toMainActivity = new Intent();
                    setResult(EXTRA_KEY, toMainActivity);
                    finish();
                }
                else{
                    Toast.makeText(this, "wrong credentials", Toast.LENGTH_SHORT).show();

                }
            }
            else{
                Toast.makeText(this, "please register as customer to login", Toast.LENGTH_SHORT).show();
                modelCustomer=new MainViewModel.CustomerData();
            }
         }
    }

    public void signup(View view) {
            Intent signup = new Intent(this, Signup.class);
            startActivity(signup);
    }

    public void loginSeller(View view) {
        if(validate()) {
            modelSeller=modelSeller.getSellerData();
            if(modelSeller!=null) {
                modelSeller.getSellerDataString().observe(this, new androidx.lifecycle.Observer<String>() {
                    @Override
                    public void onChanged(String s) {

                        String str = s;
                        Log.d("seller message ", s);
                        String[] array = str.split(",");
                        userNameString = array[4];
                        passwordString = array[5];

                    }
                });
                Log.d("user name", userNameString + "hi");
                Log.d("password", passwordString);

                if (username.getText().toString().equals(userNameString) && password.getText().toString().equals(passwordString)) {
                    Intent toSellerActivity = new Intent(this, SellerActivity.class);
                    toSellerActivity.putExtra("username",userNameString);
                    toSellerActivity.putExtra("password",passwordString);
                    startActivityForResult(toSellerActivity, LOGIN_PAGE);
                } else {
                    Toast.makeText(this, "wrong credentials", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(this, "please register as seller to login", Toast.LENGTH_SHORT).show();
                modelSeller=new MainViewModel.SellerData();
            }
        }
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

    public boolean validate(){
        boolean valid=true;
        if(username.getText().toString().isEmpty()){
            username.setError("enter the username");
            valid=false;
        }
        if(password.getText().toString().isEmpty()){
            password.setError("enter the password");
            valid=false;
        }
        return valid;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this,"please use navigation to go to home",Toast.LENGTH_SHORT).show();

    }
}