package l8.cb.com.l8intentservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by ip510 feih on 26-06-2017.
 */

public class MyService extends Service {

    public static final String TAG = "MyService";

    public MyService() {

        Log.d(TAG, "MyService: ");
        
    }

    @Override
    public void startActivity(Intent intent) {
        Log.d(TAG, "startActivity: ");
        super.startActivity(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        onDestroy();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }


    @Override
    public IBinder onBind(Intent intent) {

        Log.d(TAG, "onBind: ");
        return null;
    }
}
