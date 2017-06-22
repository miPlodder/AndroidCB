package l6.cb.com.l9timerchangetext;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    
    public static final String TAG = "MyService";

    public MyService() {

        Log.d(TAG, "MyService: ");
        
    }

    @Override
    //annotations can add
    //onCreate means new service created
    //onStart means whenever the service is started
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG, "onStartCommand: ");
        Toast.makeText(this, "onStartCommand", Toast.LENGTH_SHORT).show();
        stopSelf();
        return START_STICKY;
        //return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {

        Log.d(TAG, "onBind: ");
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
