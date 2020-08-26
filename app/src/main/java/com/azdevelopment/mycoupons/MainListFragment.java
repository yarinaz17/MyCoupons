package com.azdevelopment.mycoupons;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.azdevelopment.mycoupons.data.Coupon;

import java.util.ArrayList;
import java.util.List;


public class MainListFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_main_list, container, false);

        setUpToolbar(view);

        Coupon cpn = new Coupon("https://static.wixstatic.com/media/1c768d_bd93258087f748588d7c5a64f47b65ee.jpg","Tnuva","20% OFF all our products");
        Coupon cpn2 = new Coupon("https://s3.eu-central-1.amazonaws.com/prod-prog-site-s3/data/attachments/331/331445-281b216fcb217907dd2bf15dbb504b3b.jpg","Tara","10% OFF milk");
        Coupon cpn3 = new Coupon("https://upload.wikimedia.org/wikipedia/he/f/f0/%D7%96%D7%95%D7%92%D7%9C%D7%95%D7%91%D7%A7.png","Zoglovek","25% OFF meat products");
        List<Coupon> couponList = new ArrayList<Coupon>();
        couponList.add(cpn);
        couponList.add(cpn2);
        couponList.add(cpn3);

        //Set up the RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        CouponsAdapter adapter = new CouponsAdapter(couponList);
        recyclerView.setAdapter(adapter);
        int largePadding = getResources().getDimensionPixelSize(R.dimen.grid_spacing_large);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.grid_spacing_small);
        recyclerView.addItemDecoration(new CouponGridItemDecoration(largePadding, smallPadding));

        return view;
    }

    private void setUpToolbar(View view) {
        Toolbar toolbar = view.findViewById(R.id.app_bar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.setSupportActionBar(toolbar);
        }
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.toolbar_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }
}