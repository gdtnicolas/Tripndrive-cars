package com.example.nicolas.tripndrivecars;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nicolas.tripndrivecars.controller.WelcomeController;


public class WelcomeActivity extends Activity{

    private WelcomeController myControler;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        logo = (ImageView)findViewById(R.id.logo_tripndrive);
        logo.setImageResource(R.drawable.logo_tripndrive);
        myControler = new WelcomeController(this);
        myControler.onActivityInitialized();


    }

    public void goToFormActivity(){
        Intent intent = new Intent(WelcomeActivity.this, FormActivity.class);
        startActivity(intent);
    }


    public void displayError(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();

    }
    
}
