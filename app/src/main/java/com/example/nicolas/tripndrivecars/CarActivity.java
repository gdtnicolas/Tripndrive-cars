package com.example.nicolas.tripndrivecars;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.nicolas.tripndrivecars.controller.CarController;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Callback;


public class CarActivity extends Activity {


    private ImageView carPhoto;
    private ProgressBar loadingProgressBar;
    private CarController myController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        carPhoto = (ImageView)findViewById(R.id.car_photo);
        loadingProgressBar = (ProgressBar)findViewById(R.id.loading_progress_bar);
        myController = new CarController(this);
        myController.onActivityStarted();





    }

    public void loadCarPhoto(String imageUrl) {
        Picasso.with(getBaseContext())
                .load(imageUrl)
                .into(carPhoto, new Callback() {
                    @Override
                    public void onSuccess() {
                        loadingProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {
                        //carPhoto.setImageResource(R.drawable.car_place_holder);
                    }
                });
    }
}
