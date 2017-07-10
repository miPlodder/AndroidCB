package l15.cb.com.l15brwithservices;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyPowerReceiver extends BroadcastReceiver {

    public static final String TAG = "MyPowerReceiverBR" ;

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "POWER STATUS CHANGED", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onReceive: ");
        context.startService(new Intent(context,MyDownloadService.class));

    }
}
