package l15.cb.com.l15threadstartandrunmethoddifference;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Wait begins", Toast.LENGTH_SHORT).show();

                //the start is just what I wanted,
                //it creates a new thread and works on it(executes the run method inside the new thread)

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        long startTime = System.currentTimeMillis();
                        Log.d(TAG, "run1: ");
                        while (startTime + 5000 > System.currentTimeMillis()) {
                            //do nothing, but wait
                        }

                        //the run method is working fine, but runs on the current Thread (which is my Worker Thread created by start METHOD OF THREAD CLASS)
                        new Thread(new Runnable() {
                            @Override
                            public void run() {

                                Log.d(TAG, "run2: ");
                                long startTime = System.currentTimeMillis();

                                while (startTime + 10000 > System.currentTimeMillis()) {
                                    //do nothing, but wait
                                }

                            }
                        }).run();
                    }
                });

                Toast.makeText(MainActivity.this, "Wait is over", Toast.LENGTH_SHORT).show();
                t.start();

            }
        });
    }
}
