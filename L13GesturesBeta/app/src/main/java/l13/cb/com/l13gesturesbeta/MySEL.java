package l13.cb.com.l13gesturesbeta;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/**
 * Created by ip510 feih on 05-07-2017.
 */

public class MySEL implements SensorEventListener {

    Context context ;

    public MySEL(Context context) {
        this.context = context;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {




    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
