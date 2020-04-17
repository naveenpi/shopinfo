package com.example.shopinfo;
import android.media.Image;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.lifecycle.LifecycleOwner;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class ChoiceModel {

    public ArrayList<ChoiceInfo> choiceList;
    public ArrayList<ChoiceInfo> kansasList;
    public ArrayList<ChoiceInfo> maryvilleList;
    public ArrayList<ChoiceInfo> stList;
    private static ChoiceModel theModel= null;
    String details="";


    MainViewModel.SellerShopDetails modelShop=new MainViewModel.SellerShopDetails();



    public static class ChoiceInfo {
        //public String choice;
        public int image;
        public String name, category,city,phoneNumberString,userNameString,passwordString, shopDetails;
        public ChoiceInfo(int image, String city, String name, String category, String phoneNumberString,String userNameString,String passwordString,String shopDetails) {
            this.city=city;
            this.image = image;
            this.name=name;
            this.category=category;
            this.phoneNumberString=phoneNumberString;
            this.userNameString=userNameString;
            this.passwordString=passwordString;
            this.shopDetails=shopDetails;
        }

        public int getImage() {
            return image;
        }

        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }

        public String getCity() {
            return city;
        }

        public String getPhoneNumberString() {
            return phoneNumberString;
        }

        public String getUserNameString() {
            return userNameString;
        }

        public String getPasswordString() {
            return passwordString;
        }

        public String getShopDetails() {
            return shopDetails;
        }
    }


    public static ChoiceModel getSingleton() {
        if (theModel == null)
            theModel = new ChoiceModel();
        return theModel;
    }

    private ChoiceModel() {
        choiceList = new ArrayList<ChoiceInfo>();
        kansasList=new ArrayList<ChoiceInfo>();
        maryvilleList=new ArrayList<ChoiceInfo>();
        stList=new ArrayList<ChoiceInfo>();
        loadChoices();
    }

    public void add(int ic_image_black_24dp, String addressString, String name, String category, String phoneNumberString,String userNameString, String passwordString) {

        if(addressString.equals("kansas")) {
            kansasList.add(new ChoiceInfo(ic_image_black_24dp, addressString, name, category, phoneNumberString, userNameString, passwordString, ""));
            choiceList.addAll(kansasList);
        }
        if(addressString.equals("Maryville")) {
            maryvilleList.add(new ChoiceInfo(ic_image_black_24dp, addressString, name, category, phoneNumberString, userNameString, passwordString, ""));
            choiceList.addAll(maryvilleList);
        }
        if(addressString.equals("St.Joseph")) {
            stList.add(new ChoiceInfo(ic_image_black_24dp, addressString, name, category, phoneNumberString, userNameString, passwordString, ""));
            choiceList.addAll(stList);
        }
    }
    public void addShopDetails(String userNameString, String passwordString, String productString, int quantityValue, String discountsText) {

        for(int i=0;i<choiceList.size();){
            Log.d("size",choiceList.size()+"");
            ChoiceInfo choiceInfo=choiceList.get(i);
            if (choiceInfo.getUserNameString().equals(userNameString) && choiceInfo.getPasswordString().equals(passwordString)) {
                choiceInfo.shopDetails = "products :\n"+productString  + "\n" + "Discounts: "+discountsText;
                choiceList.set(i, choiceInfo);
                Log.d("all the details 2", choiceInfo.category);
                //break;
            }
            i++;
        }
    }

    private void loadChoices() {
            choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Maryville", "Maryville Shoes", "We sell all types of shoes","+1 6607897890","naveen","naveen","details"));

    }

   public  void getChoiceData(String city){

       if(city.equals("kansas")){
           choiceList.clear();
           //kansasList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"kansas", "kansas wines", "We sell all types"));
//           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"kansas", "kansas Shoes", "We sell all types"));
//           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"kansas", "kansas Shoes", "We sell all types"));
//           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"kansas", "kansas Shoes", "We sell all types"));
           choiceList.addAll(kansasList);
          }
       if(city.equals("Maryville")){
           choiceList.clear();
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Maryville", "Maryville Shoes", "We sell all types of shoes","+1 6607897890","naveen","naveen","details"));
//           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp, "Maryville","Maryville Shoes", "We sell all types"));
//           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp, "Maryville","Maryville Shoes", "We sell all types"));
//           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Maryville", "Maryville Shoes", "We sell all types"));
//           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Maryville", "Maryville Shoes", "We sell all types"));
           choiceList.addAll(maryvilleList);
       }

       if(city.equals("St.Joseph")){
           choiceList.clear();

//           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp, "St.Joseph","St.Joseph Shoes", "We sell all types"));
//           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp, "St.Joseph","St.Joseph Shoes", "We sell all types"));
//           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"St.Joseph", "St.Joseph Shoes", "We sell all types"));
//           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"St.Joseph", "St.Joseph Shoes", "We sell all types"));
           choiceList.addAll(stList);
       }
    }

}