package com.example.shopinfo;

public class CustomerModelClass {

    String lastNameString,firstNameString,mailIdString, userNameString,passwordString;

    public CustomerModelClass(String mailIdString, String passwordString, String userNameString, String firstNameString, String lastNameString) {
        this.lastNameString = lastNameString;
        this.firstNameString = firstNameString;
        this.mailIdString = mailIdString;
        this.userNameString = userNameString;
        this.passwordString = passwordString;
    }

    public String getLastNameString() {
        return lastNameString;
    }

    public void setLastNameString(String lastNameString) {
        this.lastNameString = lastNameString;
    }

    public String getFirstNameString() {
        return firstNameString;
    }

    public void setFirstNameString(String firstNameString) {
        this.firstNameString = firstNameString;
    }

    public String getMailIdString() {
        return mailIdString;
    }

    public void setMailIdString(String mailIdString) {
        this.mailIdString = mailIdString;
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
