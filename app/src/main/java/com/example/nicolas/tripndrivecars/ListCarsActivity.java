package com.example.nicolas.tripndrivecars;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.nicolas.tripndrivecars.adapter.CarAdapter;
import com.example.nicolas.tripndrivecars.model.Model;


public class ListCarsActivity extends Activity {

    private ListView mListCarsView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cars);

        mListCarsView = (ListView)findViewById(R.id.list_cars_view);
        CarAdapter adapter = new CarAdapter(ListCarsActivity.this, Model.getInstance().getCars());
        mListCarsView.setAdapter(adapter);

    }


}
