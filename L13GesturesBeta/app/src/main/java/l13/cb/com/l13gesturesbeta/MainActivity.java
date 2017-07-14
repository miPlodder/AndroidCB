package l13.cb.com.l13gesturesbeta;

import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    public static final String TAG = "MainActivity";
    TextView tvAcc;
    AudioManager audioManager;
    SensorManager sm;
    Button btnMode, btnVibrate, btnRing, btnSilent;
    private int alarmVolume, musicVolume, ringVolume;
    MyPowerReceiver myPowerReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        btnMode = (Button) findViewById(R.id.btnCurrMode);
        btnRing = (Button) findViewById(R.id.btnRing);
        btnVibrate = (Button) findViewById(R.id.btnVibrate);
        btnSilent = (Button) findViewById(R.id.btnSilent);
        tvAcc = (TextView) findViewById(R.id.tvAcc);


        //adding service
        Intent i = new Intent(this,MyBroadcastReceiverService.class);
        startService(i);

        //using telephony manager to detect the state of the call
        TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

        alarmVolume = audioManager.getStreamVolume(AudioManager.STREAM_ALARM);
        musicVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        ringVolume = audioManager.getStreamVolume(AudioManager.STREAM_RING);

        PhoneStateListener psl = new PhoneStateListener() {

            @Override
            public void onCallStateChanged(int state, String incomingNumber) {

                if (state == TelephonyManager.CALL_STATE_RINGING) {

                    Log.d(TAG, "onCallStateChanged: call is ringing");

                } else if (state == TelephonyManager.CALL_STATE_OFFHOOK) {

                    Log.d(TAG, "onCallStateChanged: call is on");

                } else if (state == TelephonyManager.CALL_STATE_IDLE) {

                    Log.d(TAG, "onCallStateChanged: no call");

                }

            }
        };

        tm.listen(psl, PhoneStateListener.LISTEN_CALL_STATE);

        Log.d(TAG, "======================================");
        audioManager.adjustVolume(1, 10);
        Log.d(TAG, "onCreate: audioManager.isMusicActive() -->" + audioManager.isMusicActive());
        Log.d(TAG, "onCreate: audioManager.getMode() --> " + audioManager.getMode());
        audioManager.setSpeakerphoneOn(true); //speaker on

        Log.d(TAG, "======================================");

        //now working with ACCELEROMETER SENSOR
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, sensor, 1000000);


        //setting on click listener
        btnRing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                Log.d(TAG, "onClick: Ringer Mode Enabled");

            }
        });


        btnSilent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                Log.d(TAG, "onClick: Silent Mode Enabled");

            }
        });

        btnVibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                Log.d(TAG, "onClick: Vibrate Mode Enabled");

            }
        });

        btnMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d(TAG, "onClick: " + AudioManager.MODE_CURRENT);
                Log.d(TAG, "onClick: " + SystemClock.uptimeMillis());

                int mode = audioManager.getRingerMode();

                if (mode == AudioManager.RINGER_MODE_NORMAL) {

                    Toast.makeText(MainActivity.this, "NORMAL MODE " + mode, Toast.LENGTH_SHORT).show();

                } else if (mode == AudioManager.RINGER_MODE_SILENT) {

                    Toast.makeText(MainActivity.this, "SILENT MODE " + mode, Toast.LENGTH_SHORT).show();

                } else if (mode == AudioManager.RINGER_MODE_VIBRATE) {

                    Toast.makeText(MainActivity.this, "VIBRATE MODE " + mode, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        // Log.d(TAG, "onSensorChanged: -->"+Math.ceil(sensorEvent.values[0])+"/"+Math.ceil(sensorEvent.values[1])+"/"+Math.ceil(sensorEvent.values[2]));
        tvAcc.setText(Math.ceil(sensorEvent.values[0]) + "/" + Math.ceil(sensorEvent.values[1]) + "/" + Math.ceil(sensorEvent.values[2]));

        if (sensorEvent.values[2] <= -8) {
            //means that the screen is upside down
            //audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);

            Log.d(TAG, "onSensorChanged: -> " + alarmVolume + ", not the volume -> " + audioManager.getStreamVolume(AudioManager.STREAM_ALARM));
            Log.d(TAG, "onSensorChanged: VOLUME ON UPSIDE DOWN -> " + audioManager.getStreamVolume(AudioManager.STREAM_ALARM));
            audioManager.setStreamVolume(AudioManager.STREAM_ALARM, 0, 0);


        } else if (sensorEvent.values[2] >= 2) {
            //means that the screen is up
            //audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);

            Log.d(TAG, "onSensorChanged: VOLUME ON UPSIDE" + alarmVolume + ", not the volume -> " + audioManager.getStreamVolume(AudioManager.STREAM_ALARM));
            //index = volume you want to keep
            audioManager.setStreamVolume(AudioManager.STREAM_ALARM, 15, alarmVolume);
        } else {

            //do nothing
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
