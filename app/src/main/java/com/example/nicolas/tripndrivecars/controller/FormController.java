package com.example.nicolas.tripndrivecars.controller;

import android.graphics.AvoidXfermode;
import android.graphics.Color;

import com.example.nicolas.tripndrivecars.FormActivity;
import com.example.nicolas.tripndrivecars.R;
import com.example.nicolas.tripndrivecars.helper.TripndriveAPIHelperCars;
import com.example.nicolas.tripndrivecars.listener.DateListener;
import com.example.nicolas.tripndrivecars.model.Car;
import com.example.nicolas.tripndrivecars.model.CustomDate;
import com.example.nicolas.tripndrivecars.model.Model;
import com.example.nicolas.tripndrivecars.model.Site;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Nicolas on 06/12/2015.
 */
public class FormController implements TripndriveAPIHelperCars.TripndriveAPIListener{

    private FormActivity controlledActivity;

    public FormController(FormActivity formActivity){
        this.controlledActivity = formActivity;
    }

    public void onSearchButtonClick(){
        boolean doRequest = true;
        String error = "";


        if(!Model.getInstance().isCurrentStartDateEmpty()
                &&!Model.getInstance().isCurrentEndDateEmpty()
                &&!Model.getInstance().getCurrentEndDate().isAfter(Model.getInstance().getCurrentStartDate())){
            doRequest = false;
            controlledActivity.setEndDateBorderTo(Color.RED);
            error = controlledActivity.getResources().getString(R.string.error_end_date_before);
        }

        if(Model.getInstance().isCurrentEndDateEmpty()){
            doRequest = false;
            controlledActivity.setEndDateBorderTo(Color.RED);
            error = controlledActivity.getResources().getString(R.string.error_end_date);

        }

        if(Model.getInstance().isCurrentStartDateEmpty()){
            doRequest = false;
            controlledActivity.setStartDateBorderTo(Color.RED);
            error = controlledActivity.getResources().getString(R.string.error_start_date);

        }

        if(Model.getInstance().isSelectedSiteEmpty()){
            doRequest = false;
            controlledActivity.setLocationBorderTo(Color.RED);
            error = controlledActivity.getResources().getString(R.string.error_site);

        }


        if(doRequest) {
            controlledActivity.disableSearchButton();
            controlledActivity.displaySpinner();
            TripndriveAPIHelperCars tripndriveAPIHelperCars = new TripndriveAPIHelperCars(this);
            String startDate = Model.getInstance().getCurrentStartDate().getYear()+
                    "-"+Model.getInstance().getCurrentStartDate().getMonth()+"-"+
                    Model.getInstance().getCurrentStartDate().getDay();
            String endDate = Model.getInstance().getCurrentEndDate().getYear()+
                    "-"+Model.getInstance().getCurrentEndDate().getMonth()+"-"+
                    Model.getInstance().getCurrentEndDate().getDay();
            String siteCode = Model.getInstance().getSelectedSite().getCode();
            tripndriveAPIHelperCars.load(endDate, "19:30", 100, 0, siteCode, startDate, "10:30");
        }else{
            controlledActivity.displayError(error);
        }
    }

    public void onStartDateTouched(){
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                new DateListener(this, DateListener.TypeOfDate.start),
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.setAccentColor(Color.parseColor("#3F51B5"));
        dpd.show(controlledActivity.getFragmentManager(), "Datepickerdialog");
    }

    public void onEndDateTouched(){
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                new DateListener(this, DateListener.TypeOfDate.end),
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.setAccentColor(Color.parseColor("#3F51B5"));
        dpd.show(controlledActivity.getFragmentManager(), "Datepickerdialog");
    }


    @Override
    public void onCarsLoaded(List<Car> cars) {
        Model.getInstance().setCars(cars);
        controlledActivity.goToListCarsActivity();
        controlledActivity.enableSearchButton();


    }

    @Override
    public void onCarsFailed() {
        controlledActivity.enableSearchButton();
        controlledActivity.displayError("Cannot load cars");

    }




    public void onStartDateSet(int year, int month, int day) {
        Model.getInstance().setCurrentStartDate(new CustomDate(year,month,day));
        controlledActivity.setStartDateTo(day + "/" + month + "/" + year);

    }

    public void onEndDateSet(int year, int month, int day) {
        Model.getInstance().setCurrentEndDate(new CustomDate(year,month,day));
        controlledActivity.setEndDateTo(day + "/" + month + "/" + year);

    }

    public void onLocationTouched(Site site) {
        controlledActivity.hideKeyboard();
        Model.getInstance().setSelectedSite(site);
        controlledActivity.setLocationTextTo(site.toString());
    }


}
