package l11.cb.com.l11picassogridlayout;

import android.os.AsyncTask;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.BatchingListUpdateCallback;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThreadOnBackgroundThread extends AppCompatActivity {

    Thread t;
    public static final String TAG = "ThreadOnBackground" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_on_background_thread);
        t = new Thread(new Runnable() {
            @Override
            public void run() {


               long startTime = System.currentTimeMillis();

                while(startTime+5000 > System.currentTimeMillis()){
                    //do nothing
                }

            }
        });

        ((Button)findViewById(R.id.btnWorkerThread)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    t.run();
                Toast.makeText(ThreadOnBackgroundThread.this, "After 5 seconds", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
