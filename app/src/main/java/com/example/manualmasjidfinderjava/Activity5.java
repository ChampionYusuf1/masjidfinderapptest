package com.example.manualmasjidfinderjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity5 extends AppCompatActivity {

    //prayer timings

    private Button returntohome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        returntohome = findViewById(R.id.returntohome);
        returntohome.setOnClickListener((View.OnClickListener) v-> openActivity5());
    }
    public View.OnClickListener openActivity5() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        return null;
    }
}