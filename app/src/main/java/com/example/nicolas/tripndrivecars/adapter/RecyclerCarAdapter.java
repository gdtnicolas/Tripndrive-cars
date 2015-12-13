package com.example.nicolas.tripndrivecars.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nicolas.tripndrivecars.CarViewHolder;
import com.example.nicolas.tripndrivecars.R;
import com.example.nicolas.tripndrivecars.model.Car;

import java.util.List;

/**
 * Created by Nicolas on 13/12/2015.
 */
public class RecyclerCarAdapter extends RecyclerView.Adapter<CarViewHolder> implements CarViewHolder.CarViewHolderListener{
    private List<Car> cars;

    private RecyclerCarAdapterListener mListener;

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecyclerCarAdapter(RecyclerCarAdapterListener recyclerCarAdapterListener, List<Car> cars) {
        this.cars = cars;
        mListener = recyclerCarAdapterListener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View convertView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.car_cell, parent, false);
        // set the view's size, margins, paddings and layout parameters

        CarViewHolder viewHolder = new CarViewHolder(convertView,this);
        viewHolder.carPrice = (TextView) convertView.findViewById(R.id.car_price);
        viewHolder.carName = (TextView) convertView.findViewById(R.id.car_name);
        viewHolder.doorsIcon = (ImageView) convertView.findViewById(R.id.doors_icon);
        viewHolder.doorsNumber = (TextView) convertView.findViewById(R.id.doors_number);

        viewHolder.placeIcon = (ImageView) convertView.findViewById(R.id.place_icon);
        viewHolder.placeNumber = (TextView) convertView.findViewById(R.id.place_number);

        viewHolder.transIcon = (ImageView) convertView.findViewById(R.id.trans_icon);
        viewHolder.transType = (TextView) convertView.findViewById(R.id.trans_type);

        viewHolder.gazIcon = (ImageView) convertView.findViewById(R.id.gaz_icon);
        viewHolder.gazType = (TextView) convertView.findViewById(R.id.gaz_type);

        viewHolder.gpsIcon = (ImageView) convertView.findViewById(R.id.gps_icon);
        viewHolder.climIcon = (ImageView) convertView.findViewById(R.id.clim_icon);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(CarViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Car car = cars.get(position);
        holder.carPrice.setText(String.valueOf(car.getFormatedPrice()));
        holder.carName.setText(car.getCarName());
        holder.doorsIcon.setImageResource(R.drawable.ic_directions_car_black_24dp);
        holder.doorsNumber.setText(String.valueOf(car.getDoorNumber()));
        holder.placeIcon.setImageResource(R.drawable.ic_airline_seat_recline_normal_black_24dp);
        holder.placeNumber.setText(String.valueOf(car.getPlaceNumber()));
        holder.transIcon.setImageResource(R.drawable.ic_nature_black_24dp);
        holder.transType.setText(car.getTransmission());
        holder.gazIcon.setImageResource(R.drawable.ic_local_gas_station_black_24dp);
        holder.gazType.setText(car.getGazLabel());
        if(car.isGps()) {
            holder.gpsIcon.setImageResource(R.drawable.ic_room_black_24dp);
        }
        if(car.isAirconditionning()) {
            holder.climIcon.setImageResource(R.drawable.ic_ac_unit_black_24dp);
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return cars.size();
    }

    public Car getItem(int position){
        return cars.get(position);
    }

    @Override
    public void onCarViewHolderClick(int position) {
        mListener.onRecyclerCarClick(cars.get(position));
    }

    public interface RecyclerCarAdapterListener{
        public void onRecyclerCarClick(Car car);
    }
}