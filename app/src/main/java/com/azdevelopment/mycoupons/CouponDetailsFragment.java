package com.azdevelopment.mycoupons;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.azdevelopment.mycoupons.data.Coupon;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ceylonlabs.imageviewpopup.ImagePopup;


public class CouponDetailsFragment extends Fragment {
    private MainViewModel mainViewModel;

    public CouponDetailsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coupon_details, container, false);
        //setUpToolbar(view);


        Button btn = view.findViewById(R.id.details_cpn_backBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) getActivity();
                ((NavigationHost)activity).goBack();
            }
        });
        ImageView couponImg = view.findViewById(R.id.details_cpn_image);
        TextView firm,description,disclaimer;
        firm = view.findViewById(R.id.details_cpn_firm);
        description = view.findViewById(R.id.details_cpn_description);
        disclaimer = view.findViewById(R.id.details_cpn_disclaimer);


        mainViewModel.getSelected().observe(getViewLifecycleOwner(), new Observer<Coupon>() {
            @Override
            public void onChanged(Coupon coupon) {
                Glide.with(view.getContext()).
                        load(coupon.getUrl()).
                        diskCacheStrategy(DiskCacheStrategy.DATA).
                        into(couponImg);
                ImagePopup imagePopup = new ImagePopup(view.getContext());
                imagePopup.setBackgroundColor(Color.TRANSPARENT);
                imagePopup.setHideCloseIcon(true);
                imagePopup.setImageOnClickClose(true);
                DisplayMetrics metrics = new DisplayMetrics();
                ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(metrics);
                int width = metrics.widthPixels;
                int height = metrics.heightPixels;
                imagePopup.setWindowWidth(width);
                imagePopup.setWindowHeight(height);
                imagePopup.initiatePopupWithGlide(coupon.getUrl());
                couponImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imagePopup.viewPopup();
                    }
                });
                firm.setText(coupon.getFirm());
                description.setText(coupon.getLong_description());
                disclaimer.setText(coupon.getDisclaimer());
            }
        });


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
//
//    private void setUpToolbar(View view) {
//        Toolbar toolbar = view.findViewById(R.id.app_bar);
//        AppCompatActivity activity = (AppCompatActivity) getActivity();
//        if (activity != null) {
//            activity.setSupportActionBar(toolbar);
//        }
//    }
}