package com.example.manualmasjidfinderjava;

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
//settings
public class Activity2test extends AppCompatActivity {
    private Button secondactivitybutton;
    private View github;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2test);
        secondactivitybutton = findViewById(R.id.buttonformainactivity);
        github = findViewById(R.id.github);

        secondactivitybutton.setOnClickListener((View.OnClickListener)v-> openActivity3());
        github.setOnClickListener((View.OnClickListener)v-> openGituhb());





    }
    public View.OnClickListener openActivity3() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        return null;
    }
    public View.OnClickListener openGituhb() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ChampionYusuf1/masjidfinderapptest"));
        startActivity(browserIntent);
        return null;
    }


}