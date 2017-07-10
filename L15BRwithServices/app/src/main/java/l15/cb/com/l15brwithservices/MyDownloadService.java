package l15.cb.com.l15brwithservices;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;
import android.widget.Toast;

public class MyDownloadService extends Service {

    public static final String TAG = "MyDownloadService";

    public MyDownloadService() {

        Log.d(TAG, "MyDownloadService: ");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {

        Log.d(TAG, "onStartCommand: ");

        if(intent != null)
            Log.d(TAG, "onStartCommand: " + "NON NULL INTENT");
        else
            Log.d(TAG, "onStartCommand: " + "NULL INTENT");
        (new Handler()).postDelayed(new Runnable() {
            @Override
            public void run() {

                Toast.makeText(MyDownloadService.this, " Waited for 5 Seconds ", Toast.LENGTH_LONG).show();

            }
        },5000);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }
}
