package com.example.manualmasjidfinderjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity2test extends AppCompatActivity {
    private Button firstactivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2test);
        firstactivityButton = findViewById(R.id.buttonformainactivity);

        firstactivityButton.setOnClickListener((View.OnClickListener)v-> openActivity3());




    }
    public View.OnClickListener openActivity3() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        return null;
    }

}