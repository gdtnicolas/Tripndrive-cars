package com.example.nicolas.tripndrivecars.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 03/12/2015.
 */
public final class Model {

    private static volatile Model instance = null;

    private List<Site> sites;
    private List<Car> cars;



    private Model() {

        super();
        sites = new ArrayList<>();
        cars = new ArrayList<>();
    }

    public final static Model getInstance() {
        if (Model.instance == null) {
            synchronized(Model.class) {
                if (Model.instance == null) {
                    Model.instance = new Model();
                }
            }
        }
        return Model.instance;
    }

    public void addSite(Site site){
        this.sites.add(site);
    }

    public void addSites(List<Site> sites){
        this.sites.addAll(sites);
    }

    public void addCars(List<Car> cars){
        this.cars.addAll(cars);
    }
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void displayCars(){
        for(int i = 0; i<this.cars.size();i++){
            Log.d("Model", this.cars.get(i).toString());
        }
    }public void displaySites(){
        for(int i = 0; i<this.sites.size();i++){
            Log.d("Model", this.sites.get(i).toString());
        }
    }


}
