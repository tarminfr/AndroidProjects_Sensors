package com.cnam.tarmin.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class AccelerometerSensorActivity extends AppCompatActivity {

    SensorManager sensorManager;
    SensorEventListener accelerometerListener;
    Sensor accelerometer;
    TextView gx, gy, gz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        gx = (TextView) findViewById(R.id.gx_textView);
        gy = (TextView) findViewById(R.id.gy_textView);
        gz = (TextView) findViewById(R.id.gz_textView);

    }

    @Override
    protected void onResume() {
        super.onResume();

        accelerometerListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

                gx.setText("gx = " + event.values[0] + " m/s2");
                gy.setText("gy = " + event.values[1] + " m/s2");
                gz.setText("gz = " + event.values[2] + " m/s2");

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };

        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(accelerometerListener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();

        sensorManager.unregisterListener(accelerometerListener);
    }
}
