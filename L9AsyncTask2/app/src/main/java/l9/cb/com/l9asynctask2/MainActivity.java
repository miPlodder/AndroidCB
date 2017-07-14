package l9.cb.com.l9asynctask2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//AsyncTask is like IntentService that means it works on only one thread
public class MainActivity extends AppCompatActivity {

    TextView tv1 , tv2 ;
    public static final String TAG = "MainActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run1: ");
            }
        });

        ((Button)findViewById(R.id.btn1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d(TAG, "onClick: 5 seconds");
                MultipleTask multipleTask = new MultipleTask(tv1);
                multipleTask.execute(5); //take 5s to execute the instruction

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "run2: ");
                    }
                });

            }
        });

        ((Button)findViewById(R.id.btn2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "run3: ");
                    }
                });
                Log.d(TAG, "onClick: 10 seconds");
                MultipleTask multipleTask = new MultipleTask(tv2);
                multipleTask.execute(10);

            }
        });
    }
}
