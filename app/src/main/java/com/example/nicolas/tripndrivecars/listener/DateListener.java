package com.example.nicolas.tripndrivecars.listener;

import com.example.nicolas.tripndrivecars.controller.FormController;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

/**
 * Created by Nicolas on 12/12/2015.
 */
public class DateListener implements DatePickerDialog.OnDateSetListener {
    private FormController myController;
    private TypeOfDate myTypeOfDate;

    public DateListener(FormController formController, TypeOfDate typeOfDate){
        myTypeOfDate = typeOfDate;
        myController = formController;
    }
    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int i, int i1, int i2) {
        if(myTypeOfDate== TypeOfDate.start) {
            //+1 because month begins at 0
            myController.onStartDateSet(i, i1+1, i2);
        }else if(myTypeOfDate== TypeOfDate.end){
            //+1 because month begins at 0
            myController.onEndDateSet(i,i1+1,i2);
        }
    }

    public enum TypeOfDate {
        start,
        end
    }
}
