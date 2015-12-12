package com.example.nicolas.tripndrivecars.controller;

import com.example.nicolas.tripndrivecars.CarActivity;
import com.example.nicolas.tripndrivecars.model.Model;

/**
 * Created by Nicolas on 10/12/2015.
 */
public class CarController {
    private CarActivity controlledActivity;

    public CarController(CarActivity carActivity){
        controlledActivity = carActivity;
    }
    public void onActivityStarted() {
        if (!Model.getInstance().getSelectedCar().getImages().isEmpty()) {
            controlledActivity.loadCarPhoto(Model.getInstance().getSelectedCar().getImages().get(0).getLargeUrl());
        }
    }
}
