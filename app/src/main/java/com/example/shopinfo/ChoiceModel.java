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
        public ChoiceInfo(int image, String name, String description) {

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

    public void add(String msg){
       // choiceList.add(new ChoiceInfo(msg));
    }
    private void loadChoices() {

        choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Nike Shoes","We sell all types"));
        choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Reebok Shoes","We sell all types"));
        choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"puma Shoes","We sell all types"));
        choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Reebok Shoes","We sell all types"));
        choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Nike Shoes","We sell all types"));
        choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Reebok Shoes","We sell all types"));
        choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Nike Shoes","We sell all types"));
        choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Reebok Shoes","We sell all types"));
        choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Nike Shoes","We sell all types"));
        choiceList.add(new ChoiceInfo(R.drawable.ic_image_black_24dp,"Reebok Shoes","We sell all types"));


    }


}