package com.example.nicolas.tripndrivecars.controller;

import android.renderscript.Sampler;

import com.example.nicolas.tripndrivecars.CarActivity;
import com.example.nicolas.tripndrivecars.model.Car;
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

        Car selectedCar = Model.getInstance().getSelectedCar();
        controlledActivity.setPrincipalCard(selectedCar.getModelCategoryLabel(),
                selectedCar.getModelBrand()+" "+selectedCar.getModelName(),
                String.valueOf(selectedCar.getCarYear()),
                selectedCar.getKilometerLabel());
        controlledActivity.setDailyPrice(selectedCar.getFormatedDailyPrice());
        controlledActivity.setKmInclued(selectedCar.getKmIncluded(),selectedCar.getExtraKmFormatedPrice());
        controlledActivity.setPrice(selectedCar.getFormatedPrice());
    }
}
