package com.example.nicolas.tripndrivecars;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.nicolas.tripndrivecars.model.Model;
import com.example.nicolas.tripndrivecars.model.Site;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class FormActivity extends Activity{

    private ImageView startDateImage;
    private ImageView endDateImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        startDateImage = (ImageView)findViewById(R.id.start_date_button);
        endDateImage = (ImageView)findViewById(R.id.end_date_button);

        startDateImage.setImageResource(R.drawable.ic_date_range_black_24dp);
        endDateImage.setImageResource(R.drawable.ic_date_range_black_24dp);



    }

}
