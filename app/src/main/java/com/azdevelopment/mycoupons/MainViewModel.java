package com.azdevelopment.mycoupons;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.azdevelopment.mycoupons.data.Coupon;
import com.azdevelopment.mycoupons.data.CouponsHolder;
import com.azdevelopment.mycoupons.data.CouponsRepo;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel{
    private MutableLiveData<CouponsHolder> couponHolder;
    private CouponsRepo couponsRepo;
    private MutableLiveData<Coupon> selected = new MutableLiveData<Coupon>();
    public MainViewModel() {
        couponsRepo = new CouponsRepo();
    }

    public LiveData<CouponsHolder> getCoupons(){
        return couponsRepo.getAllCoupons();
    }

    public void setCoupons(CouponsHolder holder){
        couponHolder.postValue(holder);
    }

    public MutableLiveData<Coupon> getSelected() {
        return selected;
    }

    public void setSelected(Coupon selected) {
        this.selected.postValue(selected);
    }


}
