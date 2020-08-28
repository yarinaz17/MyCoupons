package com.azdevelopment.mycoupons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.azdevelopment.mycoupons.data.Coupon;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

public class CouponsAdapter extends RecyclerView.Adapter<CouponsAdapter.CouponViewHolder> {

    private List<Coupon> mCouponsList = new ArrayList<Coupon>();
    private OnCouponClickListener onCouponClickListener;

    public CouponsAdapter(OnCouponClickListener onCouponClickListener){
        this.onCouponClickListener = onCouponClickListener;
    }

    public void setDataSet(List<Coupon> dataSet){
        this.mCouponsList = dataSet;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CouponViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cpn_item,parent,false);
        return new CouponViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CouponViewHolder holder, int position) {
        holder.bind(mCouponsList.get(position));
    }

    @Override
    public int getItemCount() {
        return mCouponsList.size();
    }

    class CouponViewHolder extends RecyclerView.ViewHolder{
        private MaterialCardView mCouponItem;
        private TextView mTitle, mDescription;
        private ImageView mImage;
        public CouponViewHolder(@NonNull View itemView) {
            super(itemView);
            mCouponItem = itemView.findViewById(R.id.coupon_item_mainList);
            mTitle = itemView.findViewById(R.id.cpn_title);
            mDescription = itemView.findViewById(R.id.cpn_description);
            mImage = itemView.findViewById(R.id.cpn_image);
        }

        void bind(final Coupon cpn){
            mTitle.setText(cpn.getFirm());
            mDescription.setText(cpn.getShort_description());
            Glide.with(itemView.getContext()).
                    load(cpn.getCouponImg()).
                    diskCacheStrategy(DiskCacheStrategy.DATA).
                    into(mImage);
            mCouponItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    onCouponClickListener.onCouponClick(cpn);
                    ((NavigationHost)activity).navigateTo(new CouponDetailsFragment(),true);
                }
            });
        }
    }
}
