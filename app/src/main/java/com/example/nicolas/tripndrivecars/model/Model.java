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
    private Model() {
        super();
        sites = new ArrayList<>();
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

    public void display(){
        for(int i = 0; i<this.sites.size();i++){
            Log.d("Model", this.sites.get(i).toSring());
        }
    }


}
