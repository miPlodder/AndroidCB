package l10.cb.com.l10runonuithreaddemo;

import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView tv ;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btn);
        tv = (TextView) findViewById(R.id.tv);

       /* runOnUiThread(new Runnable() {
            @Override
            public void run() {

                Log.d(TAG, "run: inside main thread");

            }
        });*/

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Log.d(TAG, "onClick: ");

                /*DownloadTask downloadTask = new DownloadTask(MainActivity.this,tv);
                downloadTask.execute();*/
                Handler handler = new Handler();
                Runnable r = new Runnable() {
                    @Override
                    public void run() {

                        long startTime = System.currentTimeMillis();


                        Log.d(TAG, "run: inside worker thread");
                        /*while ((startTime + 5000) > System.currentTimeMillis()) {

                            //do nothing
                        }*/
                        tv.setText("Text changed after 5 seconds");
                        Log.d(TAG, "run: outside worker thread");

                        //Toast.makeText(MainActivity.this, "Waited for 5 seconds", Toast.LENGTH_SHORT).show();

                    }

                };

                handler.postDelayed(r,10000);
            }
        });

    }
}


