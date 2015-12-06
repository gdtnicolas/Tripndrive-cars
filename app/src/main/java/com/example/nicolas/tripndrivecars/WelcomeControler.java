package com.example.nicolas.tripndrivecars;

/**
 * Created by Nicolas on 06/12/2015.
 */
public class WelcomeControler implements TripndriveAPIHelperSites.TripndriveAPIListener{

    private WelcomeActivity controledActivity;

    public WelcomeControler(WelcomeActivity welcomeActivity){
        this.controledActivity = welcomeActivity;
    }

    public void onActivityInitialized(){
        TripndriveAPIHelperSites tripndriveAPIHelperSites = new TripndriveAPIHelperSites(this);
        tripndriveAPIHelperSites.load();
    }



    @Override
    public void onSitesLoaded() {
        controledActivity.goToFormActivity();

    }

    @Override
    public void onSitesFailed() {
        controledActivity.DisplayError("Could not connect to internet");

    }
}
