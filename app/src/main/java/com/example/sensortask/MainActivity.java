package com.example.sensortask;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnKamera = (Button) findViewById(R.id.btnKamera);
        Button btnGps = (Button) findViewById(R.id.btnGps);
        Button btnSensorSuhu = (Button) findViewById(R.id.btnSensorSuhu);

        btnKamera.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, KameraActivity.class);
            startActivity(intent);
        });

        btnGps.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, GpsActivity.class);
            startActivity(intent);
        });

        btnSensorSuhu.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SensorSuhuActivity.class);
            startActivity(intent);
        });
    }
}