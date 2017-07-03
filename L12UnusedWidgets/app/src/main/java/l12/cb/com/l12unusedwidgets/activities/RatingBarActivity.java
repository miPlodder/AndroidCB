package l12.cb.com.l12unusedwidgets.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.Toast;

import l12.cb.com.l12unusedwidgets.R;

public class RatingBarActivity extends AppCompatActivity {

    RatingBar rb;
    public static final String TAG = "RatingBarActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);
        rb = (RatingBar) findViewById(R.id.rbApp);

        Log.d(TAG, "onCreate: "+rb.getNumStars());
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                Toast.makeText(RatingBarActivity.this, "Rating Changed to "+ v, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
