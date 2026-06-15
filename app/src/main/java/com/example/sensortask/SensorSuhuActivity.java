package com.example.sensortask;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SensorSuhuActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensorSuhu;
    private TextView textViewSuhu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_suhu);

        textViewSuhu = (TextView) findViewById(R.id.textViewSuhu);

        // Inisialisasi Sensor Manager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        // Mendapatkan Sensor Suhu (Ambient Temperature)
        sensorSuhu = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        if (sensorSuhu == null) {
            textViewSuhu.setText("Sensor Suhu tidak tersedia pada perangkat ini");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sensorSuhu != null) {
            sensorManager.registerListener(this, sensorSuhu,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            float suhu = event.values[0];
            textViewSuhu.setText("Suhu: " + suhu + " °C");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Tidak digunakan
    }
}
