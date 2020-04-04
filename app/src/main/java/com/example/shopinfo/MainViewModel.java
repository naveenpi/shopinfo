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


    public static MainViewModel.SellerShopDetails modelShop;
    public static class SellerShopDetails{

        String availability="YES";
        String product="phone";
        int quantity=2;

        public SellerShopDetails(String availability, String product, int quantity) {
            this.availability = availability;
            this.product = product;
            this.quantity = quantity;
        }

        public SellerShopDetails() {
        }

        private MutableLiveData<SellerShopDetails> theSellerShop=new MutableLiveData<>();
        private LiveData<String> sellerShopString = Transformations.map(theSellerShop, new Function<SellerShopDetails, String>() {
            @Override
            public String apply(SellerShopDetails data) {
                return "Availability: "+modelShop.availability+"\n"+"product: "+modelShop.product+"\n"+"quantity: "+modelShop.quantity;
            }
        });
        public LiveData<String> getSellerShopDetailsString() {

            return sellerShopString;
        }

        public void setSellerShoDetails(SellerShopDetails data){
            modelShop=data;
            theSellerShop.setValue(data);
        }

        public SellerShopDetails getSellerShoDetails(){
            return modelShop;
        }
    }
}
