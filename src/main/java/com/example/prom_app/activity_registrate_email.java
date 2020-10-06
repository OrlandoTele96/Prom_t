package com.example.prom_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class activity_registrate_email extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrate_email);

        Bundle bundle = new Bundle();

        bundle = getIntent().getExtras();
    }
}