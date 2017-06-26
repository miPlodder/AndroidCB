package l9.cb.com.l9asynctask2;

import android.os.AsyncTask;
import android.provider.Settings;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by ip510 feih on 26-06-2017.
 */

public class MultipleTask extends AsyncTask<Integer, Void, Integer> {

    TextView tv;
    int counter ;
    public static final String TAG = "MultipleTask";

    public MultipleTask(TextView tv) {

        this.counter = 0 ;
        this.tv = tv;

    }

    @Override
    protected Integer doInBackground(Integer... integers) {

        long startTime = System.currentTimeMillis();
        long waitTime = (integers[0] * 1000);


        while ((startTime + waitTime) > System.currentTimeMillis()) {


            publishProgress();
        }


        return integers[0];

    }

    @Override
    protected void onProgressUpdate(Void... values) {

        tv.setText(counter+"");
        counter++;
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Integer integer) {

        tv.setText("Waited for " + integer + " seconds");
        Log.d(TAG, "onPostExecute: " + integer + "");
        super.onPostExecute(integer);
    }
}
