package com.cnam.tarmin.sensors;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    static final String APP_TAG = "Sensors.MainActivity";
    ListView listView;
    Intent accelerometerSensorActivity, magnetometerSensorActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<Sensor> adapterListView = new ArrayAdapter<Sensor>(this,
                android.R.layout.simple_list_item_1, sensorList);
        listView.setAdapter(adapterListView);

    }

    public void accelerometerSensorButton(View v) {
        accelerometerSensorActivity = new Intent(this, AccelerometerSensorActivity.class);
        startActivity(accelerometerSensorActivity);
    }

    public void magnetometerSensorButton(View v) {
        magnetometerSensorActivity = new Intent(this, MagnetometerSensorActivity.class);
        startActivity(magnetometerSensorActivity);
    }

}
