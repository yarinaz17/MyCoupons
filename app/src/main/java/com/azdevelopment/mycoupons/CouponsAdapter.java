package com.azdevelopment.mycoupons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azdevelopment.mycoupons.data.Coupon;
import com.bumptech.glide.Glide;

import java.util.List;

public class CouponsAdapter extends RecyclerView.Adapter<CouponsAdapter.CouponViewHolder> {

    private List<Coupon> mCouponsList;

    public CouponsAdapter(List<Coupon> mCouponsList) {
        this.mCouponsList = mCouponsList;
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
        private TextView mTitle, mDescription;
        private ImageView mImage;
        public CouponViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.cpn_title);
            mDescription = itemView.findViewById(R.id.cpn_description);
            mImage = itemView.findViewById(R.id.cpn_image);
        }

        void bind(final Coupon cpn){
            mTitle.setText(cpn.getFirm());
            mDescription.setText(cpn.getShort_description());
            Glide.with(itemView.getContext()).
                    load(cpn.getUrl()).into(mImage);
        }
    }
}
