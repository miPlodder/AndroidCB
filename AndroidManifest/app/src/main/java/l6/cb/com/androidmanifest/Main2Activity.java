package l6.cb.com.androidmanifest;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    public static final String TAG = "Main2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

     /*   Bundle extras = getIntent().getExtras();

        //----------------------------------------------------------if more than one intents
        if (extras != null) {

            Uri uri = getIntent().getData();
            Log.d(TAG, "onCreate: uri" + uri);
            String text = extras.getString(Intent.EXTRA_TEXT);
            ((TextView) findViewById(R.id.tvText)).setText(text);


        }*/

     Intent i=getIntent();
        ((TextView)findViewById(R.id.tvText)).setText(i.getData().toString());
    }
}
