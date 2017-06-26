package l9.cb.com.l9networkops;

import android.os.AsyncTask;
import android.provider.DocumentsContract;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
    public static final String TAG = "DownloadTask";

    public DownloadTask(TextView tv) {
        this.tv = tv;
    }

    protected String checkURL(String url) {

        String rv = "";

        if (url.length() > 7) {
            if (url.substring(0, 7).equals("http://")) {
                //correct url
                return url;
            } else if (url.substring(0, 8).equals("https://")) {
                //correct
                return url;
            } else {

                rv = "https://" + url;

            }
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
            Log.d(TAG, "doInBackground: " + e.getMessage());
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

                Log.d(TAG, "doInBackground: buffer = " + buffer);
            } while (buffer != null);


            result = sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "doInBackground: "+e.getMessage());
        }


        String rv = "";


        //Document doc = Jsoup.connect("http://www.example.com").get();
        Document doc = Jsoup.parse(result);
        Elements links = doc.select("a");

        /*
        //grtting the href tag
        StringBuffer sbuffer = new StringBuffer();
        for (Element e : links) {

            sbuffer.append(e.attr("abs:href") + "\n");
        }


        rv = sbuffer.toString();

        return rv;*/

        /*rv = doc.title()*/

        /*getting the img src from the html page source code*/

        Elements images = doc.getElementsByTag("img");
        StringBuffer mySb = new StringBuffer();
        for(Element image : images){

            mySb.append(image);
            //Log.d(TAG, "doInBackground: "+image);


        }

        Log.d(TAG, "doInBackground: "+mySb.toString());
        return mySb.toString();

    }

    @Override
    protected void onPostExecute(String s) {

        Log.d(TAG, "onPostExecute: "+s+"here");
        tv.setText(s);
        super.onPostExecute(s);
    }
}
