package l12.cb.com.l13broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyPowerReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {

            /*context.startActivity(new Intent(context,OnReceiveActivity.class));*/
            Toast.makeText(context, "POWER CONNECTED", Toast.LENGTH_SHORT).show();

        }
        if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){

            Toast.makeText(context, "POWER DISCONNECTED", Toast.LENGTH_SHORT).show();

        }

    }
}
