package com.azdevelopment.mycoupons.data;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class CouponsRepo {
    private MutableLiveData<CouponsHolder> allCoupons = new MutableLiveData<CouponsHolder>();

    public CouponsRepo(){
        retrieveData();
    }

    public LiveData<CouponsHolder> getAllCoupons() {
        return allCoupons;
    }

    public void retrieveData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://mycoupons2.000webhostapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CouponsAPI couponsAPI = retrofit.create(CouponsAPI.class);

        Call<CouponsHolder> call = couponsAPI.getCoupons();
        call.enqueue(new Callback<CouponsHolder>() {
            @Override
            public void onResponse(Call<CouponsHolder> call, Response<CouponsHolder> response) {
                if(!response.isSuccessful())
                {
                    Log.e(TAG, "onResponse: Response failed ! Code = " + response.code());
                    return;
                }
                else{
                    allCoupons.postValue(response.body());
                }

            }

            @Override
            public void onFailure(Call<CouponsHolder> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

    }
}
