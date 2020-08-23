package com.azdevelopment.mycoupons.data;

public class Coupon {
    private String url;
    private String firm;
    private String coupon;
    private String short_description;
    private String long_description;
    private String disclaimer;

    public Coupon(String url, String firm, String description) {
        this.url = url;
        this.firm = firm;
        this.short_description = description;
    }

    public Coupon(String url, String firm, String coupon, String short_description, String long_description, String disclaimer) {
        this.url = url;
        this.firm = firm;
        this.coupon = coupon;
        this.short_description = short_description;
        this.long_description = long_description;
        this.disclaimer = disclaimer;
    }

    public String getUrl() {
        return url;
    }

    public String getFirm() {
        return firm;
    }

    public String getCoupon() {
        return coupon;
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
