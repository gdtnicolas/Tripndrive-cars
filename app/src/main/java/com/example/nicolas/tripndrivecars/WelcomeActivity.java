package com.example.nicolas.tripndrivecars;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class WelcomeActivity extends Activity{

    private WelcomeControler myControler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        myControler = new WelcomeControler(this);
        myControler.onActivityInitialized();


    }

    public void goToFormActivity(){
        Intent intent = new Intent(WelcomeActivity.this, FormActivity.class);
        startActivity(intent);
    }


    public void DisplayError(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();

    }
}
