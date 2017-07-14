package l15.cb.com.l15sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button btn;
    TextView tv;
    SharedPreferences preferences;
    public static final String PREF_KEY = "text";
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.et);
        btn = (Button) findViewById(R.id.btn);
        tv = (TextView) findViewById(R.id.tv);
        preferences = getPreferences(MODE_PRIVATE);

        String savedText = preferences.getString(PREF_KEY, null);
        Log.d(TAG, "onCreate: " + savedText);
        if (savedText != null) {

            Log.d(TAG, "onCreate: inside IF " + savedText);

            tv.setText(savedText);

        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tv.setText(et.getText().toString());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(PREF_KEY, et.getText().toString());
                editor.commit();

            }
        });


    }
}
