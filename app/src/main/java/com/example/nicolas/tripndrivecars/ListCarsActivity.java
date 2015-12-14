package com.example.nicolas.tripndrivecars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nicolas.tripndrivecars.adapter.RecyclerCarAdapter;
import com.example.nicolas.tripndrivecars.controller.ListCarsController;
import com.example.nicolas.tripndrivecars.model.Car;

import java.util.List;


public class ListCarsActivity extends Activity implements RecyclerCarAdapter.RecyclerCarAdapterListener{

    private TextView placeHolder;
    private RecyclerView mCarsRecyclerView;
    private ListCarsController myController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cars);

        myController = new ListCarsController(this);
        mCarsRecyclerView = (RecyclerView)findViewById(R.id.list_cars_view);
        placeHolder = (TextView)findViewById(R.id.no_car_place_holder);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mCarsRecyclerView.setLayoutManager(mLayoutManager);
        myController.onStartedActivity();


    }


    public void setListCarsView(List<Car> cars){
        RecyclerCarAdapter adapter = new RecyclerCarAdapter(this,cars);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mCarsRecyclerView.setHasFixedSize(true);


        mCarsRecyclerView.setAdapter(adapter);

        mCarsRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int itemPosition = mCarsRecyclerView.getChildPosition(v);
                Log.d("Clicked", "position : " +String.valueOf(itemPosition));

                Car touchedCar = (Car)((RecyclerCarAdapter)mCarsRecyclerView.getAdapter()).getItem(itemPosition);
                myController.onTouchedCar(touchedCar);

            }
        });
        /*mCarsRecyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Car touchedCar = (Car) mCarsRecyclerView.getAdapter().getItem(position);
                myController.onTouchedCar(touchedCar);
            }
        });*/
    }
    public void goToCarActivity() {
        Intent intent = new Intent(ListCarsActivity.this, CarActivity.class);
        startActivity(intent);
    }

    public void setListCarsVisibilityTo(int visibility) {
        mCarsRecyclerView.setVisibility(visibility);
    }

    public void setPlaceHolderVisibilityTo(int visibility) {
        placeHolder.setVisibility(visibility);
    }

    @Override
    public void onRecyclerCarClick(Car car) {
        myController.onTouchedCar(car);
    }
}
