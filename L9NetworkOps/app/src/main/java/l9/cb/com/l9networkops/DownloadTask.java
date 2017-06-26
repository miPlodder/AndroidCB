package l9.cb.com.l9networkops;

import android.os.AsyncTask;
import android.provider.DocumentsContract;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ip510 feih on 26-06-2017.
 */

public class DownloadTask extends AsyncTask<String, Void, String> {

    TextView tv;
    public static final String TAG = "DownloadTask" ;

    public DownloadTask(TextView tv) {
        this.tv = tv;
    }
    protected String checkURL(String url){

        String rv = "";

        if(url.substring(0,7).equals("http://")){
            //correct url
            return url;
        }else if(url.substring(0,8).equals("https://")){
            //correct
            return url;
        }else{

            rv = "https://"+url ;

        }

        return rv;
    }

    @Override
    protected String doInBackground(String... strings) {

        String result = "";
        URL url = null;

        try {

            url = new URL(checkURL(strings[0]));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.d(TAG, "doInBackground: "+e.getMessage());
        }

        //try https connection
        try {

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = connection.getInputStream();

            InputStreamReader isr = new InputStreamReader(inputStream);

            BufferedReader br = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();
            String buffer = "";

            do {

                buffer = br.readLine();
                sb.append(buffer);

                Log.d(TAG, "doInBackground: buffer = "+buffer);
            } while (buffer != null);


            result = sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }


        String title = "";


            //Document doc = Jsoup.connect("http://www.example.com").get();
            Document doc = Jsoup.parse(result);
            title = doc.title();

        return title;
    }

    @Override
    protected void onPostExecute(String s) {



        tv.setText(s);
        super.onPostExecute(s);
    }
}
