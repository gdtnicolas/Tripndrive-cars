package com.example.nicolas.tripndrivecars;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nicolas.tripndrivecars.adapter.SiteAdapter;
import com.example.nicolas.tripndrivecars.controller.FormController;
import com.example.nicolas.tripndrivecars.model.Model;
import com.example.nicolas.tripndrivecars.model.Site;



public class FormActivity extends Activity{


    private FormController myController;
    private AutoCompleteTextView locationText;
    private ImageView startDateImage;
    private ImageView endDateImage;
    private ImageView locationImage;
    private Button searchCarsButton;
    private EditText startDateText;
    private EditText endDateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        myController = new FormController(this);
        startDateImage = (ImageView)findViewById(R.id.start_date_button);
        endDateImage = (ImageView)findViewById(R.id.end_date_button);
        locationImage = (ImageView)findViewById(R.id.location_button);
        searchCarsButton = (Button)findViewById(R.id.search_cars_button);
        startDateText = (EditText)findViewById(R.id.start_date_text);
        endDateText = (EditText)findViewById(R.id.end_date_text);

        startDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myController.onStartDateTouched();

            }
        });

        endDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myController.onEndDateTouched();
            }
        });

        locationText = (AutoCompleteTextView)findViewById(R.id.location_text);

        locationText.setAdapter(new SiteAdapter(this, Model.getInstance().getSites()));
        locationText.setThreshold(1);
        locationText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                locationText.showDropDown();
                return false;
            }
        });
        locationText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Site site = (Site)locationText.getAdapter().getItem(position);
                myController.onLocationTouched(site);

            }
        });

        startDateImage.setImageResource(R.drawable.ic_date_range_black_24dp);
        endDateImage.setImageResource(R.drawable.ic_date_range_black_24dp);
        locationImage.setImageResource(R.drawable.ic_room_black_24dp);
        searchCarsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myController.onSearchButtonClick();
            }
        });



    }

    public void hideKeyboard(){
        InputMethodManager imm = (InputMethodManager) getSystemService(
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);    }

    public void goToListCarsActivity(){
        Intent intent = new Intent(FormActivity.this, ListCarsActivity.class);
        startActivity(intent);
    }

    public void disableSearchButton() {
        searchCarsButton.setEnabled(false);
    }

    public void enableSearchButton() {
        searchCarsButton.setEnabled(true);
    }

    public void displaySpinner() {

    }

    public void displayError(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();

    }


    public void setStartDateTo(String date) {
        startDateText.setText(date);
    }

    public void setEndDateTo(String date) {
        endDateText.setText(date);
    }

    public void setLocationTextTo(String s){
        locationText.setText(s.toString());
    }

    public void setLocationBorderTo(int color) {
        //Pas encore implémenté
    }

    public void setStartDateBorderTo(int color) {
        //Pas encore implémenté
    }

    public void setEndDateBorderTo(int color) {
        //Pas encore implémenté
    }


    @Override
    public void onResume() {
        super.onResume();
        enableSearchButton();
    }

}
