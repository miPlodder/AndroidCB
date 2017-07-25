package l8.cb.com.l8br;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBRReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "POWER STATUS CHANGED", Toast.LENGTH_SHORT).show();

    }
}
