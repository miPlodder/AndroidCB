package l6.cb.com.androidmanifest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

//activity 3

public class Main3Activity extends AppCompatActivity {

    public static final String TAG = "Main3Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

       /* Bundle extras = getIntent().getExtras();
        //Uri uri = getIntent().getData();
        //String action = getIntent().getAction();

        if (extras != null) {

            //other application ke liye what will be the KEY
            //"com.android.browser.application_id"

            ((TextView) findViewById(R.id.tvBrowse)).setText(extras.getString(Intent.EXTRA_TEXT));
            //((TextView) findViewById(R.id.tvBrowse)).setText(String.valueOf(uri));
            //Log.d(TAG, "onCreate: +uri"+uri);
            //Log.d(TAG, "onCreate: action"+action);
            Log.d(TAG, "onCreate: " + extras.toString());
        }*/

        Intent i=getIntent();
        ((TextView)findViewById(R.id.tvText)).setText(i.getData().toString());
    }
}
