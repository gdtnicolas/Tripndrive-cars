package com.example.nicolas.tripndrivecars.controller;

import com.example.nicolas.tripndrivecars.helper.TripndriveAPIHelperSites;
import com.example.nicolas.tripndrivecars.WelcomeActivity;
import com.example.nicolas.tripndrivecars.model.Model;
import com.example.nicolas.tripndrivecars.model.Site;

import java.util.List;

/**
 * Created by Nicolas on 06/12/2015.
 */
public class WelcomeController implements TripndriveAPIHelperSites.TripndriveAPIListener {

    private WelcomeActivity controlledActivity;

    public WelcomeController(WelcomeActivity welcomeActivity){
        this.controlledActivity = welcomeActivity;
    }

    public void onActivityInitialized(){
        TripndriveAPIHelperSites tripndriveAPIHelperSites = new TripndriveAPIHelperSites(this);
        tripndriveAPIHelperSites.load();
    }



    @Override
    public void onSitesLoaded(List<Site> sites) {
        Model.getInstance().setSites(sites);
        controlledActivity.goToFormActivity();
        controlledActivity.finish();

    }

    @Override
    public void onSitesFailed() {
        controlledActivity.displayError("Could not connect to internet");
    }
}
