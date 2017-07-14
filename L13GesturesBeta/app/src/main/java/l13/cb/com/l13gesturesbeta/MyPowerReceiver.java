package l13.cb.com.l13gesturesbeta;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyPowerReceiver extends BroadcastReceiver {

    public static final String TAG = "MyPOwerReceiver" ;

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "INSIDE BROADCAST RECEIVER onReceive: ");


    }
}
