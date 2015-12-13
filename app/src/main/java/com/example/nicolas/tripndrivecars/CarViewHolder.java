package com.example.nicolas.tripndrivecars;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Nicolas on 13/12/2015.
 */
public class CarViewHolder extends RecyclerView.ViewHolder{

    private CarViewHolderListener mListener;

    public TextView carPrice;
    public TextView carName;
    public ImageView doorsIcon;
    public TextView doorsNumber;
    public ImageView placeIcon;
    public TextView placeNumber;
    public ImageView transIcon;
    public TextView transType;
    public ImageView gazIcon;
    public TextView gazType;
    public ImageView gpsIcon;
    public ImageView climIcon;

    public CarViewHolder(View itemView, CarViewHolderListener carViewHolderListener) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onCarViewHolderClick(getPosition());

            }
        });
        mListener = carViewHolderListener;

    }

    public interface CarViewHolderListener{
        public void onCarViewHolderClick(int position);
    }
}
