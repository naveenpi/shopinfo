package com.example.shopinfo;

public class SellerModelClass {

    String shopNameString,categoryString,addressString,phoneNumberString,userNameString,passwordString;

    public SellerModelClass(String addressString, String categoryString, String passwordString, String phoneNumberString, String shopNameString, String userNameString) {

        this.shopNameString = shopNameString;
        this.categoryString = categoryString;
        this.addressString = addressString;
        this.phoneNumberString = phoneNumberString;
        this.userNameString = userNameString;
        this.passwordString = passwordString;
    }

    public String getShopNameString() {
        return shopNameString;
    }

    public void setShopNameString(String shopNameString) {
        this.shopNameString = shopNameString;
    }

    public String getCategoryString() {
        return categoryString;
    }

    public void setCategoryString(String categoryString) {
        this.categoryString = categoryString;
    }

    public String getAddressString() {
        return addressString;
    }

    public void setAddressString(String addressString) {
        this.addressString = addressString;
    }

    public String getPhoneNumberString() {
        return phoneNumberString;
    }

    public void setPhoneNumberString(String phoneNumberString) {
        this.phoneNumberString = phoneNumberString;
    }

    public String getUserNameString() {
        return userNameString;
    }

    public void setUserNameString(String userNameString) {
        this.userNameString = userNameString;
    }

    public String getPasswordString() {
        return passwordString;
    }

    public void setPasswordString(String passwordString) {
        this.passwordString = passwordString;
    }
}
