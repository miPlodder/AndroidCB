package l6.cb.com.l9morefragments;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

//creating viewpager using new > activity tabbed
public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if(savedInstanceState != null){

            Log.d(TAG, "onCreate: "+savedInstanceState.toString());

        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ((Button)findViewById(R.id.btnVP)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,TabbedActivity.class);
                startActivity(i);

            }
        });

        viewPager.setAdapter(new MyFragmentPagerAdapter(
                getSupportFragmentManager(),
                10
        ));

        //increase the number of fragments in cache by below function
        //viewPager.setOffscreenPageLimit(2);

    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }
}
