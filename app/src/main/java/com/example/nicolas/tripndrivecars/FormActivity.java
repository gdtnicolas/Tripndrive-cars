package com.example.nicolas.tripndrivecars;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nicolas.tripndrivecars.model.Model;
import com.example.nicolas.tripndrivecars.model.Site;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class FormActivity extends Activity{

    private FormControler myControler;
    private ImageView startDateImage;
    private ImageView endDateImage;
    private Button searchCarsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        myControler = new FormControler(this);
        startDateImage = (ImageView)findViewById(R.id.start_date_button);
        endDateImage = (ImageView)findViewById(R.id.end_date_button);
        searchCarsButton = (Button)findViewById(R.id.search_cars_button);

        startDateImage.setImageResource(R.drawable.ic_date_range_black_24dp);
        endDateImage.setImageResource(R.drawable.ic_date_range_black_24dp);
        searchCarsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myControler.onSearchButtonClick();
            }
        });



    }

    public void disableSearchButton() {
    }

    public void displaySpinner() {
    }

    public void DisplayError(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();

    }
}
