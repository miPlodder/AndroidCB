package l10.cb.com.l10runonuithreaddemo;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ip510 feih on 28-06-2017.
 */

public class DownloadTask extends AsyncTask<Void, Void, String> {

    Context context;
    TextView tv;

    public DownloadTask(Context context, TextView tv) {
        this.context = context;
        this.tv = tv;
    }

    public DownloadTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... voids) {
        ((Activity) context).runOnUiThread(new Runnable() {
            @Override
            public void run() {


                tv.setText("From do in background method");

            }
        });
        return "";
    }

    @Override
    protected void onPostExecute(String s) {

        ((Activity) context).runOnUiThread(new Runnable() {
            @Override
            public void run() {

                long startTime = System.currentTimeMillis();

                while ((startTime + 1000) > System.currentTimeMillis()) {

                    //do nothing
                }

                //tv.setText("From onPostExecute");

            }
        });
        super.onPostExecute(s);


    }
}
