package l12.cb.com.l12unusedwidgets.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;
import com.john.waveview.WaveView;

import l12.cb.com.l12unusedwidgets.R;

public class SeekbarActivity extends AppCompatActivity {

    TextView tvVolumeDisplay ;
    public static final String TAG = "SeekbarActivity" ;
    WaveView wv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);
        
        tvVolumeDisplay = (TextView) findViewById(R.id.tvDisplayVolume);
        wv = (WaveView) findViewById(R.id.wave_view);

        ((SeekBar)findViewById(R.id.sbVolume)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                //Log.d(TAG, "onProgressChanged: ");
                tvVolumeDisplay.setText(String.valueOf(i));
                wv.setProgress(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                Log.d(TAG, "onStartTrackingTouch: ");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                Log.d(TAG, "onStopTrackingTouch: ");

            }
        });
    }
}
