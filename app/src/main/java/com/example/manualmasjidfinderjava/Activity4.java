package com.example.manualmasjidfinderjava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//zakat calculator
public class Activity4 extends AppCompatActivity {
    private Button fourthactivitybutton;
    private EditText totalincome;
    private EditText totaldebts;
    private EditText totalproperties;
    private EditText totalassets;
    private TextView totalzakat;
    private TextView testedittext;
    private Button zakatbutton;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        fourthactivitybutton = findViewById(R.id.buttonformainactivityfeedback);
        totalincome = findViewById(R.id.income);
        totaldebts = findViewById(R.id.debts);
        totalproperties = findViewById(R.id.properties);
        totalassets = findViewById(R.id.assets);
        totalzakat = findViewById(R.id.zakat);
        testedittext = findViewById(R.id.textviewtest);
        zakatbutton = findViewById(R.id.zakatbutton);

        fourthactivitybutton.setOnClickListener((View.OnClickListener) v-> openActivity4());
        zakatbutton.setOnClickListener((View.OnClickListener) v-> calculatezakat());






    }
    public View.OnClickListener openActivity4() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        return null;
    }
    public View.OnClickListener calculatezakat() {
        String value = totalincome.getText().toString();
        int zakat = Integer.valueOf(value);
        totalzakat.setText(zakat);
        return null;

    }
}