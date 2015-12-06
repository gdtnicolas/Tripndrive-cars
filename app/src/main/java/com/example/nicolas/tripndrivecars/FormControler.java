package com.example.nicolas.tripndrivecars;

import com.example.nicolas.tripndrivecars.model.Car;
import com.example.nicolas.tripndrivecars.model.Model;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Nicolas on 06/12/2015.
 */
public class FormControler implements TripndriveAPIHelperCars.TripndriveAPIListener {

    private FormActivity controlledActivity;

    public FormControler(FormActivity formActivity){
        this.controlledActivity = formActivity;
    }

    public void onSearchButtonClick(){
        controlledActivity.disableSearchButton();
        controlledActivity.displaySpinner();
        TripndriveAPIHelperCars tripndriveAPIHelperCars = new TripndriveAPIHelperCars(this);
        tripndriveAPIHelperCars.load("2015-12-28","10:30",100,0,"ory","2015-12-27","10:30");
    }


    @Override
    public void onCarsLoaded() {
        Model.getInstance().displayCars();

    }

    @Override
    public void onCarsFailed() {
        controlledActivity.DisplayError("Cannot load cars");

    }
}
