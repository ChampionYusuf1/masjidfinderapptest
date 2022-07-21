package com.example.manualmasjidfinderjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//feedback
public class Activity4 extends AppCompatActivity {
private Button fourthactivitybutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        fourthactivitybutton = findViewById(R.id.buttonformainactivityfeedback);

        fourthactivitybutton.setOnClickListener((View.OnClickListener) v-> openActivity4());



    }
    public View.OnClickListener openActivity4() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        return null;
    }
}