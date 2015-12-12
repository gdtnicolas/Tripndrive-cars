package com.example.nicolas.tripndrivecars.controller;

import android.view.View;

import com.example.nicolas.tripndrivecars.ListCarsActivity;
import com.example.nicolas.tripndrivecars.model.Car;
import com.example.nicolas.tripndrivecars.model.Model;

/**
 * Created by Nicolas on 10/12/2015.
 */
public class ListCarsController {
    ListCarsActivity controlledActivity;

    public ListCarsController(ListCarsActivity listCarsActivity){
        controlledActivity = listCarsActivity;
    }

    public void onTouchedCar(Car car){
        Model.getInstance().setSelectedCar(car);
        controlledActivity.goToCarActivity();
    }

    public void onStartedActivity() {
        if(Model.getInstance().getCars().isEmpty()){
            controlledActivity.setListCarsVisibilityTo(View.GONE);
            controlledActivity.setPlaceHolderVisibilityTo(View.VISIBLE);
        }else {
            controlledActivity.setListCarsView(Model.getInstance().getCars());
        }
    }
}
