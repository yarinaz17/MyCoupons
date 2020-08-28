package com.azdevelopment.mycoupons;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.azdevelopment.mycoupons.data.Coupon;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


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
        setUpToolbar(view);

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

    private void setUpToolbar(View view) {
        Toolbar toolbar = view.findViewById(R.id.app_bar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.setSupportActionBar(toolbar);
        }
    }
}