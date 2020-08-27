package com.azdevelopment.mycoupons.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CouponsHolder {

    @SerializedName("records")
    private List<Coupon> coupons = null;

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }
}
