package com.azdevelopment.mycoupons.data;
import com.google.gson.annotations.SerializedName;

public class Coupon {
    @SerializedName("id")
    private String id;
    @SerializedName("url")
    private String url;
    @SerializedName("firm")
    private String firm;
    @SerializedName("image")
    private String couponImg;
    @SerializedName("short_description")
    private String short_description;
    @SerializedName("long_description")
    private String long_description;
    @SerializedName("disclaimer")
    private String disclaimer;

    public Coupon(String url, String firm, String description) {
        this.url = url;
        this.firm = firm;
        this.short_description = description;
    }

    public Coupon(String url, String firm, String couponImg, String short_description, String long_description, String disclaimer) {
        this.url = url;
        this.firm = firm;
        this.couponImg = couponImg;
        this.short_description = short_description;
        this.long_description = long_description;
        this.disclaimer = disclaimer;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getFirm() {
        return firm;
    }

    public String getCouponImg() {
        return couponImg;
    }

    public String getShort_description() {
        return short_description;
    }

    public String getLong_description() {
        return long_description;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

}
