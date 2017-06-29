package l8.cb.com.l8intentservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


//by default services runs on UIThread
//we have to explicitly make it work on some WorkerThread

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d(TAG, "onClick: ");
                MyService service = new MyService();
                Intent i = new Intent(MainActivity.this,MyService.class);
                //Intent i = new Intent(MainActivity.this,MyIntentService.class);
                startService(i);


            }
        });

    }
}
