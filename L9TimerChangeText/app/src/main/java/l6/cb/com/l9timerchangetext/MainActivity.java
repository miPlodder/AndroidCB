package l6.cb.com.l9timerchangetext;

import android.content.Intent;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    Button btn1, btn2;


    @Override
    //savedInstanceState is called every time orientatyion of the screen changes
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        if (savedInstanceState != null) {
            Log.d(TAG, "onCreate: " + savedInstanceState.toString());
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Handler h = new Handler();
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        ((TextView) findViewById(R.id.tv)).setText("After 10 s");
                    }
                };

                h.postDelayed(r, 5000);


             /*   long startTime = System.currentTimeMillis();
                while (System.currentTimeMillis() < startTime + 10000) {

                    //do nothing
                    ((TextView)findViewById(R.id.tv)).setText("After 10 s");
                }
*/
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,MyService.class);
                startService(i);
                ((TextView) findViewById(R.id.tv)).setText("WOW");


            }
        });
    }
}
