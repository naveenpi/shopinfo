package com.example.shopinfo;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

public class MainViewModel {

    public static MainViewModel.SellerData modelSeller;

    public static class SellerData{

        String shopName="shop name";
        String category="category";
        String address="kansas";
        String sellerPhoneNumber="+1 6605280748";
        String sellerUserName="mcd";
        String sellerPassword="mcd";

        public SellerData() {
        }

        public SellerData(String shopName, String category, String address, String sellerPhoneNumber, String sellerUserName, String sellerPassword) {
            this.shopName = shopName;
            this.category = category;
            this.address = address;
            this.sellerPhoneNumber = sellerPhoneNumber;
            this.sellerUserName = sellerUserName;
            this.sellerPassword = sellerPassword;
        }

        private MutableLiveData<SellerData> theSellerData=new MutableLiveData<>();
        private LiveData<String> sellerDataString = Transformations.map(theSellerData, new Function<SellerData, String>() {
            @Override
            public String apply(SellerData data) {
                return modelSeller.shopName+","+modelSeller.category+","+modelSeller.address+","+modelSeller.sellerPhoneNumber+","+modelSeller.sellerUserName+","+modelSeller.sellerPassword;
            }
        });
        public LiveData<String> getSellerDataString() {

            return sellerDataString;
        }

        public void setSellerData(SellerData data){
            modelSeller=data;
            theSellerData.setValue(data);
        }

        public SellerData getSellerData(){
            return modelSeller;
        }
    }
}
