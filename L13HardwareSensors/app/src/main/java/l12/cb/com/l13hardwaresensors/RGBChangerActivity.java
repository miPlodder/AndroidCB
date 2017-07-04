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
import android.widget.FrameLayout;
import android.widget.TextView;

public class RGBChangerActivity extends AppCompatActivity {

    FrameLayout fl;
    TextView tv ;
    public static final String TAG = "RGBChangerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rgbchanger);

        fl = (FrameLayout) findViewById(R.id.fl);
        tv = (TextView) findViewById(R.id.tvX);

        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        SensorEventListener sel = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {

                Log.d(TAG, "onSensorChanged: RANDOM VALUE-> "+Math.random());
                tv.setText(Math.ceil(sensorEvent.values[0])+"/"+Math.ceil(sensorEvent.values[1])+"/"+Math.ceil(sensorEvent.values[2])+"/");

                fl.setBackgroundColor(
                        Color.argb(r2c(Math.random()),
                                a2c(sensorEvent.values[0]),
                                a2c(sensorEvent.values[1]),
                                a2c(sensorEvent.values[2])
                        )
                );

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

                //doing nothing inside this method
            }
        };

        Sensor sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            sm.registerListener(sel, sensor, SensorManager.SENSOR_DELAY_NORMAL, 10000);
        }
    }

    //accelerometer to color convertor
    int a2c(float a){

        return (int)(((a+15)/30)*255);
    }

    //random to color generator
    int r2c(double val){

        return (int)(val * 255) ;

    }
}
