package com.example.nicolas.tripndrivecars.helper;

import android.util.Log;

import com.example.nicolas.tripndrivecars.TripndriveService;
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
 * Created by Nicolas on 06/12/2015.
 */
public class TripndriveAPIHelperCars implements Callback<List<Car>> {

    private Retrofit retrofit;
    private TripndriveService tripndriveService;
    private TripndriveAPIListener listener;

    public TripndriveAPIHelperCars(TripndriveAPIListener listener){

        this.listener=listener;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.tripndrive.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // prepare call in Retrofit 2.0
        tripndriveService = retrofit.create(TripndriveService.class);

    }

    public void load(String endDate, String endTime, int max, int offset, String siteCode,
                          String startDate, String startTime){
        Call<List<Car>> call = tripndriveService.getListCars(endDate,endTime,max,offset,siteCode,
        startDate, startTime);
        //asynchronous call
        call.enqueue(this);
    }



    @Override
    public void onResponse(Response<List<Car>> response, Retrofit retrofit) {
        Log.d("REST", "Success cars");

        this.listener.onCarsLoaded(response.body());

        //Model.getInstance().display();

    }

    @Override
    public void onFailure(Throwable throwable) {
        Log.d("REST","Fail cars");
        this.listener.onCarsFailed();
    }

    public interface TripndriveAPIListener{
        public void onCarsLoaded(List<Car> cars);
        public void onCarsFailed();
    }
}
