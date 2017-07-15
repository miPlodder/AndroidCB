package l15.cb.com.l16googlemaps;

import android.graphics.Color;
import android.location.Address;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

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
 * Created by ip510 feih on 15-07-2017.
 */

public class ParserTask extends AsyncTask<Void, Void, JSONObject> {

    ArrayList<Address> addresses;
    Address startLocation, endLocation;
    GoogleMap map;
    public static final String TAG = "ParserTask";
    static Polyline prevRoute;

    public ParserTask(ArrayList<Address> addresses, GoogleMap map) {

        this.addresses = addresses;
        startLocation = addresses.get(0);
        endLocation = addresses.get(1);
        this.map = map;

        if (prevRoute != null) {
            prevRoute.remove();
        }
    }

    private String urlGenerator() {

        String origin = "origin=" + startLocation.getLatitude() + "," + startLocation.getLongitude();
        String destination = "destination=" + endLocation.getLatitude() + "," + endLocation.getLongitude();

        return "https://maps.googleapis.com/maps/api/directions/json?" + origin + "&" + destination;

    }

    @Override
    protected JSONObject doInBackground(Void... params) {
        URL url = null;
        JSONObject jsonObject = null;
        try {
            Log.d(TAG, "URL" + urlGenerator());
            url = new URL(urlGenerator());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String buffer = "";
            StringBuilder sb = new StringBuilder();

            while (buffer != null) {

                sb.append(buffer);
                buffer = br.readLine();
            }

            Log.d(TAG, "RESULT " + sb.toString());
            jsonObject = new JSONObject(sb.toString());


        } catch (IOException | JSONException e) {
            Log.d(TAG, "JSONEXCEPTION -> " + e.getMessage());
        }

        Log.d(TAG, "doInBackground: " + jsonObject);
        return jsonObject;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);

        //ArrayList<LatLng> points = new ArrayList<>();
        PolylineOptions points = new PolylineOptions();

        Log.d(TAG, "onPostExecute: " + jsonObject);

        try {
            JSONArray routes = jsonObject.getJSONArray("routes");
            JSONArray steps = routes.getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONArray("steps");


            for (int i = 0; i < steps.length(); i++) {


                LatLng point1 = new LatLng(steps.getJSONObject(i).getJSONObject("start_location").getDouble("lat"),
                        steps.getJSONObject(i).getJSONObject("start_location").getDouble("lng"));

                LatLng point2 = new LatLng(steps.getJSONObject(i).getJSONObject("end_location").getDouble("lat"),
                        steps.getJSONObject(i).getJSONObject("end_location").getDouble("lng"));

                points.add(point1);
                points.add(point2);

            }

            points.width(2).color(Color.BLACK);
            prevRoute = map.addPolyline(points);

            Log.d(TAG, "onPostExecute: " + points.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
