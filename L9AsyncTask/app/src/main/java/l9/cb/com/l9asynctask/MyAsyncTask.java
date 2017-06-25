package l9.cb.com.l9asynctask;

import android.content.Intent;
import android.os.AsyncTask;
import android.provider.Settings;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by ip510 feih on 26-06-2017.
 */

public class MyAsyncTask extends AsyncTask<Integer, Float, String> {

    TextView tv;
    public static final String TAG = "MyAsyncTask";

    public MyAsyncTask(TextView tv) {
        this.tv = tv;
    }

    @Override
    protected void onPreExecute() {

        Log.d(TAG, "onPreExecute: ");
        tv.setText("WAIT START");
        super.onPreExecute();
    }

    @Override
    //by default our async task work on only one worker thread
    //so if we use multiple operations on AsyncTask, then also we have ONE THREAD only
    protected String doInBackground(Integer[] objects) {

        int upperCount = objects[0];

        Log.d(TAG, "doInBackground: ");
        for (int i = 0; (2 * upperCount) > i; i++) {

            Log.d(TAG, "doInBackground: inside for");
            long startTime = System.currentTimeMillis();

            while (System.currentTimeMillis() < (startTime + 500)) {

                //do nothing
                Log.d(TAG, "doInBackground: inside while");
            }


            publishProgress(((float)i)/2);

        }


        return "WAIT OVER";
    }

    @Override
    protected void onProgressUpdate(Float... values) {

        Log.d(TAG, "onProgressUpdate: ");
        tv.setText(values[0].toString());
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {

        Log.d(TAG, "onPostExecute: ");
        tv.setText(s);
        super.onPostExecute(s);
    }
}
