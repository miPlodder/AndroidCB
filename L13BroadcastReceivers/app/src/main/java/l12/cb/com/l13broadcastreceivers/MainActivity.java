package l12.cb.com.l13broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout fl;
    IntentFilter ifilter;
    MyReciever myReciever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myReciever = new MyReciever();
        fl = (FrameLayout) findViewById(R.id.fl);
        ifilter = new IntentFilter();
        ifilter.addAction(Intent.ACTION_POWER_CONNECTED);
        ifilter.addAction(Intent.ACTION_POWER_DISCONNECTED);

    }


    @Override
    protected void onResume() {
        super.onResume();

        registerReceiver(myReciever, ifilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myReciever);

    }

    class MyReciever extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {

                fl.setBackgroundColor(Color.RED);

            }

            if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {

                fl.setBackgroundColor(Color.GREEN);

            }

        }

    }

}
