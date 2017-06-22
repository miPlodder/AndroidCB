package l6.cb.com.l6fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


//this class is example of static fragment that means that the fragment is not changing

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_testing);
    }
}
