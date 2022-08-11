package com.example.manualmasjidfinderjava;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import com.google.android.gms.location.LocationRequest;


public class MainActivity extends AppCompatActivity {

    private TextView AddressText;
    private LocationRequest locationRequest;
    private View settings;
    private View calculatelocation;
    private View prayertimings;
    private View zakatcalc;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        AddressText = findViewById(R.id.textviewtest);

        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(5000);
        locationRequest.setFastestInterval(2000);


        prayertimings = findViewById(R.id.Prayertiming);
        calculatelocation = findViewById(R.id.calculatelocation);
        zakatcalc = findViewById(R.id.zakatcalculator);
        settings = findViewById(R.id.settings);
        
//activity 2 is settings
        //activity 3 is calculate location
        //activity 4 is settings

        settings.setOnClickListener((View.OnClickListener)v-> openActivity2());
        calculatelocation.setOnClickListener((View.OnClickListener)v-> openActivity3());
        zakatcalc.setOnClickListener((View.OnClickListener)v-> openActivity4());
        prayertimings.setOnClickListener((View.OnClickListener)v-> openActivity5());


       
    }

    public View.OnClickListener openActivity2() {
        Intent intent = new Intent(this, Activity2test.class);
        startActivity(intent);
        return null;
    }
    public View.OnClickListener openActivity3() {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
        return null;
    }
    public View.OnClickListener openActivity4() {
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
        return null;
    }
    public View.OnClickListener openActivity5(){
        Intent intent = new Intent(this, Activity5.class);
        startActivity(intent);
        return null;
    }
}