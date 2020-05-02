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
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditSelllerActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{


    EditText shopName, category, address, phoneNumber, userName, password, confirmPassword;
    //ImageButton profilePicSeller;
    Button registerSeller;
    MainViewModel.SellerData modelSeller;
    static String phoneNumberString="";
    String shopNameString="",categoryString="",addressString=""/*,phoneNumberString=""*/,userNameString,passwordString, confirmPasswordString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_selller);


        shopName=findViewById(R.id.shopName_edit);
        category=findViewById(R.id.category_edit);
        address=findViewById(R.id.address_edit);
        phoneNumber=findViewById(R.id.phone_edit);
        userName=findViewById(R.id.userNameSeller_edit);;
        password=findViewById(R.id.passwordSeller_edit);
        confirmPassword=findViewById(R.id.confirmPasswordSeller_edit);
        registerSeller=findViewById(R.id.registerSeller_edit);
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



    public void updateSeller(View view) {

        if(shopName.getText().toString().isEmpty()){
            shopName.setError("Enter shop name");
        }
        if(category.getText().toString().isEmpty()){
            category.setError("Enter category");
        }
        if(address.getText().toString().isEmpty()){
            address.setError("Enter address");
        }
        if(phoneNumber.getText().toString().isEmpty()){
            phoneNumber.setError("Enter phone number");
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

        if(!(shopName.getText().toString().isEmpty() || phoneNumber.getText().toString().isEmpty() ||category.getText().toString().isEmpty() || address.getText().toString().isEmpty() || userName.getText().toString().isEmpty() || password.getText().toString().isEmpty() || confirmPassword.getText().toString().isEmpty())) {
            shopNameString=shopName.getText().toString();
            Log.d("shop name",shopNameString);
            categoryString=category.getText().toString();
            Log.d("category", categoryString);
            addressString=address.getText().toString();
            Log.d("address", addressString);
            phoneNumberString=phoneNumber.getText().toString();
            Log.d("seller phone number", phoneNumberString);
            userNameString=userName.getText().toString();
            Log.d("Seller user name", userNameString);
            passwordString=password.getText().toString();
            Log.d("Seller password",passwordString);
            confirmPasswordString=confirmPassword.getText().toString();
            Log.d("seller confirm password",confirmPasswordString);
            if(confirmPasswordString.equals(passwordString)) {
                Toast.makeText(this, "User Successfully registered as a Seller", Toast.LENGTH_LONG).show();

                modelSeller=new MainViewModel.SellerData(shopNameString,categoryString,addressString,phoneNumberString,userNameString,passwordString);
                modelSeller.setSellerData(modelSeller);

                SellerModelClass sm=new SellerModelClass(addressString,categoryString,passwordString,phoneNumberString,shopNameString,userNameString);

                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference myRef=database.getReference("seller");
                myRef.setValue(sm);

                ChoiceModel model= ChoiceModel.getSingleton();
                model.add(R.drawable.ic_image_black_24dp,addressString,shopNameString,categoryString,phoneNumberString,userNameString,passwordString);
                Intent i= new Intent(this, login.class);
                startActivity(i);
            }
            else{
                Toast.makeText(this, "re enter the password", Toast.LENGTH_LONG).show();
            }
        }
    }
}
