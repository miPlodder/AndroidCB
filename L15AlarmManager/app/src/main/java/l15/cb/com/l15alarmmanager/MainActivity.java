package l15.cb.com.l15alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(this, MainActivity.class);
        //getIntent().putExtra("key2", "value2");

        Log.d(TAG, "onCreate: " + i + "," + getIntent());
        Log.d(TAG, "onCreate: " + getIntent().getStringExtra("sdsa"));

        if (i != null) {

            getIntent().putExtra("key2", "value2");


        } else {

            Log.d(TAG, "onCreate: First Time");
            i = new Intent(this, MainActivity.class);
            i.putExtra("key", "value");

        }

        Log.d(TAG, "rtc " + System.currentTimeMillis());
        Log.d(TAG, "elapsedtime " + SystemClock.elapsedRealtime());

        Log.d(TAG, "onCreate: " + getIntent().getStringExtra("key") + ", " + getIntent().getStringExtra("key2"));

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);

        PendingIntent pi = PendingIntent.getActivity(
                this,
                111,
                i,
                PendingIntent.FLAG_ONE_SHOT);

        //am.setInexactRepeating(1,1,1,pi);


        //set keeps on repeating the alarm
        am.set(AlarmManager.ELAPSED_REALTIME,
                SystemClock.elapsedRealtime() + 5000,
                pi);
/*

        am.setRepeating(AlarmManager.RTC,
                System.currentTimeMillis(),
                5000,
                pi);
*/


        /*

        //added on API Level 19 and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            am.setExact(1,1,pi);
        }*/

        /*    am.setRepeating(AlarmManager.ELAPSED_REALTIME,
                SystemClock.elapsedRealtime() + 60000,
                60000,pi);
        */


    }
}