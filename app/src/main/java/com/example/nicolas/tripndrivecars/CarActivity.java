package com.example.nicolas.tripndrivecars;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nicolas.tripndrivecars.controller.CarController;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Callback;


public class CarActivity extends Activity {


    private ImageView carPhoto;
    private ProgressBar loadingProgressBar;
    private CarController myController;

    private TextView category;
    private TextView name;
    private TextView year;
    private TextView km;

    private TextView dailyPrice;
    private TextView kmInclued;
    private TextView pricePerKm;

    private Button rentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        carPhoto = (ImageView)findViewById(R.id.car_photo);
        loadingProgressBar = (ProgressBar)findViewById(R.id.loading_progress_bar);
        category = (TextView)findViewById(R.id.car_category_text);
        name = (TextView)findViewById(R.id.car_name_text);
        year = (TextView)findViewById(R.id.car_year_text);
        km = (TextView)findViewById(R.id.car_km_text);
        kmInclued = (TextView)findViewById(R.id.km_inclued);
        pricePerKm = (TextView)findViewById(R.id.price_km);
        dailyPrice = (TextView)findViewById(R.id.price_a_day);
        rentButton = (Button)findViewById(R.id.rent_button);
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

    public void setPrincipalCard(String category, String name, String year, String km){

        this.category.setText(category);
        this.name.setText(name);
        this.year.setText(year);
        this.km.setText(km);
    }

    public void setDailyPrice(String formatedDailyPrice) {
        dailyPrice.setText(formatedDailyPrice);
    }

    public void setKmInclued(int kmInclued, String pricePerKm){
        this.kmInclued.setText(kmInclued+getResources().getString(R.string.km_inclued));
        this.pricePerKm.setText(" + " + pricePerKm + getResources().getString(R.string.additionnal_price));
    }

    public void setPrice(String formatedPrice) {
        rentButton.setText(getResources().getString(R.string.rent_for)+" "+formatedPrice+" !");
        rentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CarActivity.this, "To be continued...", Toast.LENGTH_LONG).show();

            }
        });
    }
}
