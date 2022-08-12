package com.example.manualmasjidfinderjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Activity5 extends AppCompatActivity {

    private TextView mTextViewResult;

    //prayer timings
    //edd356d0455a3dc83f18c0c46495fe65

    private Button returntohome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        returntohome = findViewById(R.id.returntohome);
        mTextViewResult = findViewById(R.id.testtext);
        returntohome.setOnClickListener((View.OnClickListener) v-> openActivity5());

        OkHttpClient client = new OkHttpClient();

        String url = "https://muslimsalat.com/code/mstimes.php?key=edd356d0455a3dc83f18c0c46495fe65&location=Bartlett&style=panel-compact&color=dark&header=yes";

        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
            e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()){
                    final String myResponse = response.body().string();

                    Activity5.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTextViewResult.setText(myResponse);
                        }
                    });
                }
            }

        });
    }
    public View.OnClickListener openActivity5() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        return null;
    }
}