package l12.cb.com.l12unusedwidgets.activities;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import l12.cb.com.l12unusedwidgets.R;

public class ProgressBarActivity extends AppCompatActivity {

    Button btnStart;
    ProgressBar pb;
    int progress;
    public static final String TAG = "ProgressBar Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        //finding resources
        Log.d(TAG, "onCreate: ");
        btnStart = (Button) findViewById(R.id.btnStart);
        pb = (ProgressBar) findViewById(R.id.pb);

        btnStart.setOnClickListener(new View.OnClickListener() {

            int counter = 0;

            @Override
            public void onClick(View view) {

                pb.setProgress(0);

                Log.d(TAG, "onClick: ");
              /*  ProgressTask progressTask = new ProgressTask();
                progressTask.execute();
*/
                for (int i = 0; i < 100; i++) {

                    Log.d(TAG, "onClick: "+ i );

                    (new Handler()).postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            progress++;
                            Log.d(TAG, "run: " + progress);
                            pb.setProgress(progress);
                        }
                    }, 5000);
/*

                    long startTime = System.currentTimeMillis();
                    while (startTime + 500 > System.currentTimeMillis()) {

                        progress = i;
                        Log.d(TAG, "run: " + progress);
                        pb.setProgress(progress);

                    }
*/

                }
                Log.d(TAG, "onClick: EXITED");
            }
            
        });

        Log.d(TAG, "onCreate: EXITED");
    }

    class ProgressTask extends AsyncTask<Void, Integer, String> {

        @Override
        protected String doInBackground(Void... voids) {

            Log.d(TAG, "doInBackground: ");
            for (int i = 0; i <= 100; i++) {

                Log.d(TAG, "doInBackground counter " + i);
                long startTime = System.currentTimeMillis();
                while (startTime + 500 > System.currentTimeMillis()) {
                    //waiting here
                }
                publishProgress(i);
            }
            Log.d(TAG, "DOWNLOAD FINISHED");
            return "DOWNLOAD COMPLETED";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            pb.setProgress(values[0]);
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(ProgressBarActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }


}

