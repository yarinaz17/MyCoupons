package com.azdevelopment.mycoupons.data;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CouponsAPI {
    @GET("api/coupon/read.php")
    public Call<CouponsHolder> getCoupons();
}
