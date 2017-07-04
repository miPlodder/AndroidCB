package l12.cb.com.l13hardwaresensors;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    TextView tvX, tvY, tvZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvX = (TextView) findViewById(R.id.tvX);
        tvY = (TextView) findViewById(R.id.tvY);
        tvZ = (TextView) findViewById(R.id.tvZ);

        /*
        //setting color using transparency
        tvX.setBackgroundColor(Color.argb(255,0,0,255));
        tvY.setBackgroundColor(Color.argb(100,0,0,255));*/
        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        SensorEventListener sel = new SensorEventListener() {


            @Override
            //whenever there is change in the value of sensor
            //onSensorChanged method is called
            public void onSensorChanged(SensorEvent sensorEvent) {
/*

                //used for accelerometer
                if (Math.ceil(sensorEvent.values[0]) > 10) {

                    findViewById(R.id.ll).setBackgroundColor(Color.GREEN);

                }

                if (Math.ceil(sensorEvent.values[1]) > 10) {

                    findViewById(R.id.ll).setBackgroundColor(Color.RED);

                }

                if (Math.ceil(sensorEvent.values[2]) > 10) {

                    findViewById(R.id.ll).setBackgroundColor(Color.YELLOW);

                }*/

/*

                //code for proximity light sensor
                if((Math.ceil(sensorEvent.values[0]) == 0)){

                    findViewById(R.id.ll).setBackgroundColor(Color.BLACK);

                }
                else{
                    findViewById(R.id.ll).setBackgroundColor(Color.YELLOW);
                }


            }

*/
/*

                //used for light sensor, value[0] more for more light
                //value[0] lesser, for more dark

                if((Math.ceil(sensorEvent.values[0]) < 50)){

                    findViewById(R.id.ll).setBackgroundColor(Color.WHITE);

                }
                else{
                    findViewById(R.id.ll).setBackgroundColor(Color.BLACK);
                }*/


                tvX.setText(String.valueOf(Math.ceil(sensorEvent.values[0])));
                tvY.setText(String.valueOf(Math.ceil(sensorEvent.values[1])));
                tvZ.setText(String.valueOf(Math.ceil(sensorEvent.values[2])));
            }

            @Override
            //whenever sensor ki accuracy is changed
            //or data is changed
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        //list have for each loop
        List<Sensor> list = sm.getSensorList(Sensor.TYPE_ALL);
        /*List<Sensor> list = sm.getSensorList(Sensor.TYPE_GYROSCOPE)*/
        ;

        /*
        //OS changes the list at runtime as per the availability of the sensors
        //the list logged will always be the same
        sm.getDynamicSensorList(Sensor.TYPE_ALL);
        */
        Log.d(TAG, "onCreate: " + Arrays.asList(list));
        int counter = 0;

        //this sensor list is not all hardware
        //some are hardware and some are software
        //software sensors are wrapper over the hardware sensors
        for (Sensor item : list) {

            counter++;
            Log.d(TAG, "onCreate: Sensor Name -> " + item.getName());
            Log.d(TAG, "onCreate: Sensor Vendor -> " + item.getVendor());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
                Log.d(TAG, "onCreate: Sensor String Type -> " + item.getStringType());
            }

            Log.d(TAG, "========================================");
        }

        Log.d(TAG, "onCreate: counter -> " + counter);
        Log.d(TAG, "onCreate: list size" + list.size());

        //getDefaultSensor as per the phone mode
        //Sensor accelSensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Sensor accelSensor = sm.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        //Sensor accelSensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        Sensor accelSensor = sm.getDefaultSensor(Sensor.TYPE_LIGHT);

        //like broadcast receiver we have to register a LISTENER
        //such that we want to start measuring the changes in the values
        //Us means in microSeconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            //handler gaming
            sm.registerListener(sel, accelSensor, SensorManager.SENSOR_DELAY_NORMAL, 10000);

        }

    }
}
