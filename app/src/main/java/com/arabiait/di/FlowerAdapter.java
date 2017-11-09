package com.arabiait.di;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arabiait.di.Constant.Constant;
import com.arabiait.di.Model.FlowerResponse;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Ahmed El-Mahdi on 11/9/2017.
 */

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.Holder> {

    public FlowerAdapter(List<FlowerResponse> mFlower) {
        this.mFlower = mFlower;
    }

    private List<FlowerResponse> mFlower;
    @Override
    public FlowerAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flower,parent,false));
    }

    @Override
    public void onBindViewHolder(FlowerAdapter.Holder holder, int position) {

        final FlowerResponse response = mFlower.get(position);
        holder.mName.setText(response.getName());
        holder.mPrice.setText(String.format("$%.2f", response.getPrice()));

        Glide.with(holder.itemView.getContext()).load(Constant.PHOTO_URL + response.getPhoto()).into(holder.mPhoto);
    }

    @Override
    public int getItemCount() {
        return mFlower.size();
    }
    public void addFlowers(List<FlowerResponse> flowerResponses) {
        mFlower.addAll(flowerResponses);
        notifyDataSetChanged();
    }
    public class Holder extends RecyclerView.ViewHolder {
        private ImageView mPhoto;
        private TextView mName, mPrice;
        public Holder(View itemView) {
            super(itemView);
            mPhoto = (ImageView) itemView.findViewById(R.id.flowerPhoto);
            mName = (TextView) itemView.findViewById(R.id.flowerName);
            mPrice = (TextView) itemView.findViewById(R.id.flowerPrice);
        }
    }
}
