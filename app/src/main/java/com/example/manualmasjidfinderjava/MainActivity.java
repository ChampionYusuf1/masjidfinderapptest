package com.example.manualmasjidfinderjava;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.*;


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

        AddressText = findViewById(R.id.textView);

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