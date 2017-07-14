package l13.cb.com.l13gesturesbeta;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyBroadcastReceiverService extends Service {

    MyPowerReceiver myPowerReceiver;
    public static final String TAG = "MBRS";

    public MyBroadcastReceiverService() {

    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        IntentFilter ifilter = new IntentFilter();
        ifilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        //ifilter.addAction(Intent.ACTION_ANSWER);
        ifilter.addAction(Intent.ACTION_POWER_CONNECTED);
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
/*

        myPowerReceiver = new MyPowerReceiver();
        registerReceiver(myPowerReceiver,ifilter);
*/

        //Intent i = new Intent()


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {

        Log.d(TAG, "onDestroy: ");
        //unregisterReceiver(myPowerReceiver);
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}

