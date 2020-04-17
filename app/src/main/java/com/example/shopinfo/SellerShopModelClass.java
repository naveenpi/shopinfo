package com.example.shopinfo;

import android.util.Log;

public class SellerShopModelClass {
    String available,product, discount,phone;

    public SellerShopModelClass(String available, String discount, String phone, String product) {
        this.available=available;
        Log.d("avilable in ssm",available);
        this.discount = discount;
        Log.d("discount in ssm",discount);
        this.phone=phone;
        this.product = product;
    }
}
