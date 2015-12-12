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
    private Car selectedCar;
    private Site selectedSite;
    private CustomDate currentStartDate;
    private CustomDate currentEndDate;



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

    public Car getSelectedCar() {
        return selectedCar;
    }

    public List<Site> getSites() {
        return sites;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }

    public Site getSelectedSite() {
        return selectedSite;
    }

    public void setSelectedSite(Site selectedSite) {
        this.selectedSite = selectedSite;
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

    public boolean isCurrentStartDateEmpty(){
        return currentStartDate==null;
    }
    public boolean isCurrentEndDateEmpty(){
        return currentEndDate==null;
    }
    public boolean isSelectedSiteEmpty(){
        return selectedSite==null;
    }
    public CustomDate getCurrentStartDate() {
        return currentStartDate;
    }

    public void setCurrentStartDate(CustomDate currentStartDate) {
        this.currentStartDate = currentStartDate;
    }

    public CustomDate getCurrentEndDate() {
        return currentEndDate;
    }

    public void setCurrentEndDate(CustomDate currentEndDate) {
        this.currentEndDate = currentEndDate;
    }
}
