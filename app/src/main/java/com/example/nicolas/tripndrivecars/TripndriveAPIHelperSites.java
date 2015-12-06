package com.example.nicolas.tripndrivecars;

import android.util.Log;

import com.example.nicolas.tripndrivecars.model.Car;
import com.example.nicolas.tripndrivecars.model.Model;
import com.example.nicolas.tripndrivecars.model.Site;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Nicolas on 04/12/2015.
 */
public class TripndriveAPIHelperSites implements Callback<List<Site>> {

    private Retrofit retrofit;
    private TripndriveService tripndriveService;
    private TripndriveAPIListener listener;

    public TripndriveAPIHelperSites(TripndriveAPIListener listener){

        this.listener=listener;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.tripndrive.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // prepare call in Retrofit 2.0
        tripndriveService = retrofit.create(TripndriveService.class);

    }

    public void load(){
        Call<List<Site>> call = tripndriveService.getListSites();
        //asynchronous call
        call.enqueue(this);
    }



    @Override
    public void onResponse(Response<List<Site>> response, Retrofit retrofit) {
        Model.getInstance().addSites(response.body());
        Log.d("REST", "Success");
        this.listener.onSitesLoaded();

        //Model.getInstance().display();

    }

    @Override
    public void onFailure(Throwable throwable) {
        Log.d("REST","Fail");
        this.listener.onSitesFailed();
    }

    public interface TripndriveAPIListener{
        public void onSitesLoaded();
        public void onSitesFailed();
    }
}
