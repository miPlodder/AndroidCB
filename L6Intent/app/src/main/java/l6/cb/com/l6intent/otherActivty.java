package l6.cb.com.l6intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class otherActivty extends AppCompatActivity {

    public static final String TAG = "otherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_activty);

        //cannot be used because we are sending int from the 1st activity
        //Integer num1 = Integer.valueOf(getIntent().getStringExtra("num1"));
        //Integer num2 = Integer.valueOf(getIntent().getStringExtra("num2"));

        int numb1 = getIntent().getIntExtra("num1",0);
        int numb2 = getIntent().getIntExtra("num2",0);

        ((TextView)findViewById(R.id.tvSum)).setText(numb1+numb2+"");
    }
}
