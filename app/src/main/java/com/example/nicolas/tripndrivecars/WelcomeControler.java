package com.example.nicolas.tripndrivecars;

/**
 * Created by Nicolas on 06/12/2015.
 */
public class WelcomeControler implements TripndriveAPIHelper.TripndriveAPIListener{

    private WelcomeActivity controledActivity;

    public WelcomeControler(WelcomeActivity welcomeActivity){
        this.controledActivity = welcomeActivity;
    }

    public void onActivityInitialized(){
        TripndriveAPIHelper tripndriveAPIHelper = new TripndriveAPIHelper(this);
        tripndriveAPIHelper.loadSites();
    }



    @Override
    public void onSitesLoaded() {
        controledActivity.goToFormActivity();

    }

    @Override
    public void onSitesFailed() {
        controledActivity.DisplayConnectionError();

    }
}
