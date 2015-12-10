package com.example.nicolas.tripndrivecars.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nicolas.tripndrivecars.R;
import com.example.nicolas.tripndrivecars.model.Car;

import java.util.List;

/**
 * Created by Nicolas on 08/12/2015.
 */
public class CarAdapter extends ArrayAdapter<Car> {


        //tweets est la liste des models à afficher
        public CarAdapter(Context context, List<Car> cars) {
            super(context, 0, cars);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.car_cell,parent, false);
            }

            CarViewHolder viewHolder = (CarViewHolder) convertView.getTag();
            if(viewHolder == null){
                viewHolder = new CarViewHolder();
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



                convertView.setTag(viewHolder);
            }

            //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
            Car car = getItem(position);

            //il ne reste plus qu'à remplir notre vue

            viewHolder.carPrice.setText(String.valueOf(car.getFormatedPrice()));
            viewHolder.carName.setText(car.getCarName());
            viewHolder.doorsIcon.setImageResource(R.drawable.ic_directions_car_black_24dp);
            viewHolder.doorsNumber.setText(String.valueOf(car.getDoorNumber()));
            viewHolder.placeIcon.setImageResource(R.drawable.ic_airline_seat_recline_normal_black_24dp);
            viewHolder.placeNumber.setText(String.valueOf(car.getPlaceNumber()));
            viewHolder.transIcon.setImageResource(R.drawable.ic_nature_black_24dp);
            viewHolder.transType.setText(car.getTransmission());
            viewHolder.gazIcon.setImageResource(R.drawable.ic_local_gas_station_black_24dp);
            viewHolder.gazType.setText(car.getGazLabel());
            if(car.isGps()) {
                viewHolder.gpsIcon.setImageResource(R.drawable.ic_room_black_24dp);
            }
            if(car.isAirconditionning()) {
                viewHolder.climIcon.setImageResource(R.drawable.ic_ac_unit_black_24dp);
            }

            return convertView;
        }

        private class CarViewHolder{
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



        }
    
}
