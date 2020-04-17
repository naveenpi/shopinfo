package com.example.shopinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustomerRegestration extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {


    FirebaseDatabase database;
    DatabaseReference myRef;
    EditText firstName, lastName, mailId, userName, password, confirmPassword;
    ImageButton profilePic;
    Button register;
    String lastNameString,firstNameString,mailIdString, userNameString,passwordString, confirmPasswordString;
    MainViewModel.CustomerData modelCustomer;
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

        lastNameString=lastName.getText().toString();
    }

    public void registerCustomer(View view) {

        if(lastName.getText().toString().isEmpty()){
            lastName.setError("Enter lastName");
        }
        if(firstName.getText().toString().isEmpty()){
            firstName.setError("Enter firstName");
        }
        if(mailId.getText().toString().isEmpty()){
            mailId.setError("Enter mailId");
        }
        if(userName.getText().toString().isEmpty()){
            userName.setError("Enter userName");
        }
        if(password.getText().toString().isEmpty()){
            password.setError("Enter password");
        }
        if(confirmPassword.getText().toString().isEmpty()){
            confirmPassword.setError("Enter confirmPassword");
        }
        if(!(lastName.getText().toString().isEmpty() || firstName.getText().toString().isEmpty() || mailId.getText().toString().isEmpty() || userName.getText().toString().isEmpty() || password.getText().toString().isEmpty() || confirmPassword.getText().toString().isEmpty())) {
            lastNameString=lastName.getText().toString();
            Log.d("Customer last name",lastNameString);
            firstNameString=firstName.getText().toString();
            Log.d("Customer first name", firstNameString);
            mailIdString=mailId.getText().toString();
            Log.d("customer mail id", mailIdString);
            userNameString=userName.getText().toString();
            Log.d("customer user name", userNameString);
            passwordString=password.getText().toString();
            Log.d("Customer password",passwordString);
            confirmPasswordString=confirmPassword.getText().toString();
            Log.d("Cust confirm password",confirmPasswordString);
            if(confirmPasswordString.equals(passwordString)) {

                modelCustomer=new MainViewModel.CustomerData(firstNameString,lastNameString,mailIdString,userNameString,passwordString);
                modelCustomer.setCustomerData(modelCustomer);

                CustomerModelClass cm=new CustomerModelClass(mailIdString,passwordString,userNameString,firstNameString,lastNameString);
                database = FirebaseDatabase.getInstance();
                myRef = database.getReference("customers");
                myRef.setValue(cm);



                Toast.makeText(this, "User Successfully registered as a customer", Toast.LENGTH_LONG).show();
                Intent i = new Intent(this, login.class);
                startActivity(i);
            }
            else{
                Toast.makeText(this, "re enter the password", Toast.LENGTH_LONG).show();
            }
        }
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
