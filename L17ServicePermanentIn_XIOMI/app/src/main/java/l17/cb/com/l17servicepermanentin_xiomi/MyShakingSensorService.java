package l17.cb.com.l17servicepermanentin_xiomi;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;


public class MyShakingSensorService extends Service {

    public static final String TAG = "MyService";

    public MyShakingSensorService() {
        super();
    }


    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onHandleIntent: SERVICE 1");
        Toast.makeText(MyShakingSensorService.this, "INSIDE SERVICE ", Toast.LENGTH_SHORT).show();

        SensorManager manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        SensorEventListener sel = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {


                if (sensorEvent.values[0] > 9) {

                    Log.d(TAG, "onHandleIntent: SERVICE 2");
                    // Toast.makeText(MyShakingSensorService.this, "Back in mainactivity", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onSensorChanged: ");
                    //--------------------------------------------------------------------------------
                    startActivity((new Intent(MyShakingSensorService.this, MainActivity.class)).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        Sensor sensor = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            Log.d(TAG, "onHandleIntent: SERVICE 3");
            Toast.makeText(MyShakingSensorService.this, "Registered the Service", Toast.LENGTH_SHORT).show();
            manager.registerListener(sel, sensor, 10000, 1000);
        }

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}