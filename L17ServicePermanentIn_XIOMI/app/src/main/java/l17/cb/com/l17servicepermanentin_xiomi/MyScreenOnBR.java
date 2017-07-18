package l17.cb.com.l17servicepermanentin_xiomi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyScreenOnBR extends BroadcastReceiver {

    public static final String TAG = "BR" ;
    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF) || intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            Toast.makeText(context, "SCREEN STATUS CHANGED", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onReceive: "+ context.getApplicationContext().toString());
            Log.d(TAG, "context: "+ context.toString());
            Log.d(TAG, "intent: "+ intent.toString());

            Log.d(TAG, "onReceive: Starting Service from BR");
            //Intent serviceIntent = new Intent();
            context.startService(new Intent(context,MyShakingSensorService.class));
            //context.startActivity(new Intent(context, MainActivity.class));
        }else{
            Toast.makeText(context, "POWER STATUS CHANGED", Toast.LENGTH_SHORT).show();
        }
        //context.startActivity(new Intent(context, MainActivity.class));
    }
}
