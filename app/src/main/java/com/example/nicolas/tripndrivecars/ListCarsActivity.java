package com.example.nicolas.tripndrivecars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nicolas.tripndrivecars.adapter.CarAdapter;
import com.example.nicolas.tripndrivecars.controller.ListCarsController;
import com.example.nicolas.tripndrivecars.model.Car;
import com.example.nicolas.tripndrivecars.model.Model;

import java.util.List;


public class ListCarsActivity extends Activity {

    private TextView placeHolder;
    private ListView mListCarsView;
    private ListCarsController myController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cars);

        myController = new ListCarsController(this);
        mListCarsView = (ListView)findViewById(R.id.list_cars_view);
        placeHolder = (TextView)findViewById(R.id.no_car_place_holder);
        myController.onStartedActivity();


    }


    public void setListCarsView(List<Car> cars){
        CarAdapter adapter = new CarAdapter(ListCarsActivity.this, cars);
        mListCarsView.setAdapter(adapter);

        mListCarsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Car touchedCar = (Car) mListCarsView.getAdapter().getItem(position);
                myController.onTouchedCar(touchedCar);
            }
        });
    }
    public void goToCarActivity() {
        Intent intent = new Intent(ListCarsActivity.this, CarActivity.class);
        startActivity(intent);
    }

    public void setListCarsVisibilityTo(int visibility) {
        mListCarsView.setVisibility(visibility);
    }

    public void setPlaceHolderVisibilityTo(int visibility) {
        placeHolder.setVisibility(visibility);
    }
}
