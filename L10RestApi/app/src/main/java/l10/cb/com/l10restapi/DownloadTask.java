package l10.cb.com.l10restapi;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by ip510 feih on 27-06-2017.
 */

public class DownloadTask extends AsyncTask<String, Void, ArrayList<Post>> {

    public static final String TAG = "DownloadTask";
    private OnDownloadListener odl ;

    //using CALLBACK approach to send arraylist of post to the MainActivity.java class
    interface OnDownloadListener{
        void setOnDownloadListener(ArrayList<Post> postList);
    }

    public DownloadTask(OnDownloadListener odl) {

        this.odl = odl;

    }

    @Override
    //works on worker thread
    protected ArrayList<Post> doInBackground(String... strings) {

        ArrayList<Post> postList = null;

        URL url = null;

        try {
            url = new URL(strings[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);

            //we can parse through line using buffered reader
            BufferedReader br = new BufferedReader(isr);
            //string overriding is OK, but string appending is costlier operation
            String buffer = "";
            StringBuilder sb = new StringBuilder();
            while (buffer != null) {

                sb.append(buffer);
                buffer = br.readLine();

            }

            JSONArray jsonArr = new JSONArray(sb.toString());

            postList = new ArrayList<>(jsonArr.length());

            //if size is know then give size in parameter while initialising
            for (int i = 0; i < jsonArr.length(); i++) {

                JSONObject jsonObj = jsonArr.getJSONObject(i); //jsonArr.get(i) will also work

                Post post = new Post(
                        jsonObj.getInt("userId"),
                        jsonObj.getInt("id"),
                        jsonObj.getString("title"),
                        jsonObj.getString("body")

                );

                postList.add(post);

            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
            //do nothing
        }

        //Log.d(TAG, "doInBackground: "+postList);

        return postList;
    }

    @Override
    protected void onPostExecute(ArrayList<Post> posts) {

        //Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
       /*
       Log.d(TAG, "onPostExecute: size is " + posts.size());
       Log.d(TAG, "onPostExecute: is " + posts);
       */
       odl.setOnDownloadListener(posts);
        super.onPostExecute(posts);

    }
}
