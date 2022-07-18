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
    private Button LocationButton;
    private LocationRequest locationRequest;
    private DBHandler dbHandler;
    private SQLiteDatabase db;

    double icwslong = -88.1840428154465; //entered
    double icwslat = 41.944271719952326; //entered
    double iielong = -88.2404171354376; //entered
    double iielat = 42.01908492194405; //entered
    double darulong = -88.0452914577771;
    double darulat = 41.903242194423456;
    double alhudalong = -88.1187362844016;
    double alhudalat = 41.99772729955197;
    double msilong = -88.0806877256787;
    double msilat = 41.924248920493966;
    double baitulIlmacademylat = 42.0251286038466;
    double baitulIlmacademylong= -88.1808935012285;
    double wbccsaburlat = 42.01122752736403;
    double wbccsaburlong = -88.1506811014002;
    double islamiccommunitycenterlat = 42.04566499596798;
    double islamiccommunitycenterlong = -88.3124475524246;
    double islamiccenterofkanecountylat = 41.921563195103964;
    double islamiccenterofkanecountylong = -88.3438628618128;
    double islamicsocietyofnorthwestsuburbslat = 42.09867216457004;
    double islamicsocietyofnorthwestsuburbslong = -88.0306084692998;
    double islamiccenterofwheatonlat = 41.89032086920186;
    double islamiccenterofwheatonlong = -88.0940111021456;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddressText = findViewById(R.id.textView);
        LocationButton = findViewById(R.id.button);

        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(5000);
        locationRequest.setFastestInterval(2000);

        //Start database initialization**********************************************************************
        dbHandler = new DBHandler(MainActivity.this);
        dbHandler.onCreate(db); // <- db never gets intialized

        //End database initialization************************************************************************

        //SQLiteDatabase myDatabase;
        
        //myDatabase = openOrCreateDatabase("masjidcoordiantes.db",SQLiteDatabase.hashCode(), null);
        


        LocationButton.setOnClickListener((View.OnClickListener)v-> getCurrentLocation());
       
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){

                if (isGPSEnabled()) {

                    getCurrentLocation();

                }else {

                    turnOnGPS();
                }
            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {

                getCurrentLocation();
            }
        }
    }

    private void getCurrentLocation() {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                if (isGPSEnabled()) {

                    LocationCallback callback = new LocationCallback() {
                        @Override
                        public void onLocationResult(@NonNull LocationResult locationResult) {
                            super.onLocationResult(locationResult);


                            if (locationResult != null && locationResult.getLocations().size() > 0) {

                                int index = locationResult.getLocations().size() - 1;
                                double latitude = locationResult.getLocations().get(index).getLatitude();
                                double longitude = locationResult.getLocations().get(index).getLongitude();
                              // double icwslong = longitude + -88.1840428154465;// double icwslat = latitude - 41.944271719952326;// double icwstotal= icwslat + icwslong;// double iielong = longitude + -88.2404171354376;//  double iielat = latitude - 42.01908492194405;//  double iietotal = iielong + iielat;



                                //if (icwstotal > iietotal){
                                double totaldistanceicws = getDistance(latitude, longitude, icwslat, icwslong);
                                double totaldistanceiie = getDistance(latitude, longitude, iielat, iielong);
                                double totaldistancedaru = getDistance(latitude, longitude, darulat, darulong);
                                double totaldistancemsi = getDistance(latitude, longitude, msilat, msilong);
                                double totaldistancealhuda = getDistance(latitude, longitude, alhudalat, alhudalong);
                                double totaldistancebaitulIlmAcademy = getDistance(latitude, longitude, baitulIlmacademylat, baitulIlmacademylong);
                                double totaldistancewbccsabur = getDistance(latitude, longitude, wbccsaburlat, wbccsaburlong);
                                double totaldistanceislamiccommunitycenter = getDistance(latitude, longitude, islamiccommunitycenterlat, islamiccommunitycenterlong);
                                double totaldistanceislamiccenterofkanecounty = getDistance(latitude, longitude, islamiccenterofkanecountylat, islamiccenterofkanecountylong);
                                double totaldistanceislamicsocietyofnorthwestsuburbs = getDistance(latitude, longitude, islamicsocietyofnorthwestsuburbslat, islamicsocietyofnorthwestsuburbslong);
                                double totaldistanceislamiccenterofwheaton = getDistance(latitude, longitude, islamiccenterofwheatonlat, islamiccenterofwheatonlong);





                                //AddressText.setText(String.valueOf(getDistance(latitude, longitude, icwslat, icwslong)));
                                // put all the total distance variables into an array list
                                //sort the array list
                                //display the arraylist from lowest value to highest value

                                HashMap<String, Double> distances = new HashMap<>();
                                distances.put("Islamic Center of Western Suburbs", totaldistanceicws);
                                distances.put("Institute of Islamic Education", totaldistanceiie);
                                distances.put("Darusalam", totaldistancedaru);
                                distances.put("Muslim Society Inc.", totaldistancemsi);
                                distances.put("Masjid Al-Huda", totaldistancealhuda);
                                distances.put("Baitul Ilm Academy", totaldistancebaitulIlmAcademy);
                                distances.put("WBCC Sabur", totaldistancewbccsabur);
                                distances.put("Islamic Community Center", totaldistanceislamiccommunitycenter);
                                distances.put("Islamic Center Of Kane County", totaldistanceislamiccenterofkanecounty);
                                distances.put("Islamic Society of Northwest Suburbs", totaldistanceislamicsocietyofnorthwestsuburbs);
                                distances.put("Islamic Center Of Wheaton", totaldistanceislamiccenterofwheaton);


                                Map<Double, String> reversedDistances = new HashMap<>();
                                        for (Map.Entry<String, Double> entry : distances.entrySet()){
                                            reversedDistances.put(entry.getValue(), entry.getKey());
                                        }

                                ArrayList<Double> distanceValues = new ArrayList<>(distances.values());
                                AddressText.setText((reversedDistances.get((BubbleSort(distanceValues).get(0)))));


                                // }

                            }
                        }
                    };
                    LocationServices.getFusedLocationProviderClient(MainActivity.this)
                            .requestLocationUpdates(locationRequest, callback, Looper.getMainLooper());

                } else {
                    turnOnGPS();
                }
            } else {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }
    }

    private void turnOnGPS() {
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);
        builder.setAlwaysShow(true);

        Task<LocationSettingsResponse> result = LocationServices.getSettingsClient(getApplicationContext())
                .checkLocationSettings(builder.build());

        result.addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {
            @Override
            public void onComplete(@NonNull Task<LocationSettingsResponse> task) {
                try {
                    LocationSettingsResponse response = task.getResult(ApiException.class);
                    Toast.makeText(MainActivity.this, "GPS is already tured on", Toast.LENGTH_SHORT).show();
                } catch (ApiException e) {
                    switch (e.getStatusCode()) {
                        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                            try {
                                ResolvableApiException resolvableApiException = (ResolvableApiException) e;
                                resolvableApiException.startResolutionForResult(MainActivity.this, 2);
                            } catch (IntentSender.SendIntentException ex) {
                                ex.printStackTrace();
                            }
                            break;
                        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                            //Device does not have location
                            break;
                    }
                }
            }
        });

    }
    private boolean isGPSEnabled() {
        LocationManager locationManager = null;
        boolean isEnabled = false;
        if (locationManager == null) {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        }
        isEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        return isEnabled;

    }



    private double getDistance(double userLat, double userLong, double locLat, double locLong){
        return Math.pow(Math.pow(userLat - locLat, 2) + Math.pow(userLong - locLong, 2), 0.5);
    }

    public static ArrayList<Double> BubbleSort(ArrayList<Double> nums) {
        int x = 0;
        while (x < nums.size()) {
            for (int i = 0; i < nums.size() - 1; i++) {
                if (nums.get(i + 1) < nums.get(i)) {
                    double y = nums.get(i);
                    double z = nums.get(i + 1);
                    nums.set(i, z);
                    nums.set(i + 1, y);
                }
            }
            x++;
        }
        return nums;
    }
}