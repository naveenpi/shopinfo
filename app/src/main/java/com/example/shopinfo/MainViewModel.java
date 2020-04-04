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


    public static MainViewModel.SellerShopDetails modelShop=null;
    public static class SellerShopDetails{

        String availability="YES";
        String product="phone";
        int quantity=2;
        String discounts="10% off on all products";

        public SellerShopDetails(String availability, String product, int quantity) {
            this.availability = availability;
            this.product = product;
            this.quantity = quantity;
        }

        public SellerShopDetails(String discounts) {
            this.discounts = discounts;
        }

        public SellerShopDetails() {
        }


        private MutableLiveData<SellerShopDetails> theSellerShop=new MutableLiveData<>();
        private LiveData<String> sellerShopString = Transformations.map(theSellerShop, new Function<SellerShopDetails, String>() {
            @Override
            public String apply(SellerShopDetails data) {
                return "Availability: "+modelShop.availability+"\n"+"product: "+modelShop.product+"\n"+"quantity: "+modelShop.quantity+"\n"+"discounts: "+modelShop.discounts;
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



    public static MainViewModel.CustomerData modelCustomer;
    public static class CustomerData{

        String customerFirstName="naveen";
        String customerLastName="gajavalli";
        String customerEmailId="fwecujw@gmail.com";
        String customerUserName="navv";
        String customerPassword="dcwe";

        public CustomerData(String customerFirstName, String customerLastName, String customerEmailId, String customerUserName, String customerPassword) {
            this.customerFirstName = customerFirstName;
            this.customerLastName = customerLastName;
            this.customerEmailId = customerEmailId;
            this.customerUserName = customerUserName;
            this.customerPassword = customerPassword;
        }

        public CustomerData() {
        }

        private MutableLiveData<CustomerData> theCustomerData=new MutableLiveData<>();
        private LiveData<String> customerDataString = Transformations.map(theCustomerData, new Function<CustomerData, String>() {
            @Override
            public String apply(CustomerData data) {
                return modelCustomer.customerFirstName+","+modelCustomer.customerLastName+","+modelCustomer.customerEmailId+","+modelCustomer.customerUserName+","+modelCustomer.customerPassword;
            }
        });
        public LiveData<String> getCustomerDataString() {

            return customerDataString;
        }

        public void setCustomerData(CustomerData data){
            modelCustomer=data;
            theCustomerData.setValue(data);
        }

        public CustomerData getCustomerData(){
            return modelCustomer;
        }

    }
}
