package com.example.shopinfo;
import android.media.Image;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class ChoiceModel {

    public ArrayList<ChoiceInfo> choiceList;
    private static ChoiceModel theModel= null;


    public static class ChoiceInfo {
        //public String choice;
        public int image;
        public String name, description;
        public ChoiceInfo(int image, String city, String name, String description) {

            this.image = image;
            this.name=name;
            this.description=description;
        }
    }

    public static ChoiceModel getSingleton() {
        if (theModel == null)
            theModel = new ChoiceModel();
        return theModel;
    }

    private ChoiceModel() {
        choiceList = new ArrayList<ChoiceInfo>();
        loadChoices();
    }


    private void loadChoices() {


            choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Maryville", "Maryville Shoes", "We sell all types"));
            choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Maryville", "Maryville Shoes", "We sell all types"));
            choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Maryville", "Maryville Shoes", "We sell all types"));
            choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Maryville", "Maryville Shoes", "We sell all types"));
            choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Maryville", "Maryville Shoes", "We sell all types"));
            choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp, "Maryville","Maryville Shoes", "We sell all types"));
            choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp, "Maryville","Maryville Shoes", "We sell all types"));
            choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp, "Maryville","Maryville Shoes", "We sell all types"));
            choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Maryville", "Maryville Shoes", "We sell all types"));
            choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Maryville", "Maryville Shoes", "We sell all types"));




    }

   public  void getChoiceData(String city){

       if(city.equals("kansas")){
           choiceList.clear();
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"kansas", "kansas Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"kansas", "kansas Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"kansas", "kansas Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"kansas", "kansas Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"kansas", "kansas Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"kansas", "kansas Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"kansas", "kansas Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"kansas", "kansas Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"kansas", "kansas Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"kansas", "kansas Shoes", "We sell all types"));
       }
       if(MainActivity.citySelected.equals("Maryville")){
           choiceList.clear();
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Maryville", "Maryville Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Maryville", "Maryville Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Maryville", "Maryville Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Maryville", "Maryville Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Maryville", "Maryville Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp, "Maryville","Maryville Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp, "Maryville","Maryville Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp, "Maryville","Maryville Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Maryville", "Maryville Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Maryville", "Maryville Shoes", "We sell all types"));
       }

       if(MainActivity.citySelected.equals("St.Joseph")){
           choiceList.clear();
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"St.Joseph", "St.Joseph Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"St.Joseph", "St.Joseph Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"St.Joseph", "St.Joseph Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"St.Joseph", "St.Joseph Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"St.Joseph", "St.Joseph Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp, "St.Joseph","St.Joseph Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp, "St.Joseph","St.Joseph Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp, "St.Joseph","St.Joseph Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"St.Joseph", "St.Joseph Shoes", "We sell all types"));
           choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"St.Joseph", "St.Joseph Shoes", "We sell all types"));
       }
    }

}