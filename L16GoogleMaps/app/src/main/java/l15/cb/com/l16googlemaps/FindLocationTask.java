package l15.cb.com.l16googlemaps;

import android.content.Context;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by ip510 feih on 14-07-2017.
 */

public class FindLocationTask extends AsyncTask<String, Void, ArrayList<Address>> {

    public static final String TAG = "FindLocationTask";
    Context context;
    EditText etStartLocation, etEndLocation;
    Geocoder geocoder;
    GoogleMap map;
    String startLocation, endLocation;
    Marker prevStartMarker, prevEndMarker;

    public FindLocationTask(Context context, EditText etLocation, EditText etEndLocation, Geocoder geocoder, GoogleMap map) {

        this.context = context;
        this.etStartLocation = etLocation;
        this.etEndLocation = etEndLocation;
        this.geocoder = geocoder;
        this.map = map;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        this.startLocation = etStartLocation.getText().toString();
        this.endLocation = etEndLocation.getText().toString();

    }

    @Override
    protected ArrayList<Address> doInBackground(String... strings) {

        ArrayList<Address> rv = new ArrayList<>();
        List<Address> addressListStart = null;
        List<Address> addressListEnd = null;

        try {
            Log.d(TAG, "doInBackground: TRY");
            addressListStart = geocoder.getFromLocationName(startLocation, 1);
            addressListEnd = geocoder.getFromLocationName(endLocation, 1);

            rv.add(addressListStart.get(0));
            rv.add(addressListEnd.get(0));


        } catch (IOException e) {

            Log.d(TAG, "doInBackground: CATCH " + e.getMessage());
        }

        return rv;
    }

    @Override
    protected void onPostExecute(ArrayList<Address> addresses) {
        super.onPostExecute(addresses);

        if (prevStartMarker != null || prevEndMarker != null) {

            Log.d(TAG, "onPostExecute: areNotNullREMOVED");
            prevStartMarker.remove();
            prevEndMarker.remove();
        }
        Log.d(TAG, "onPostExecute: After remove" + prevStartMarker + prevEndMarker);
        //animate is better than move camera as it moves from current location to the entered location
        //map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 10));

        Address startAdd = addresses.get(0);
        Address endAdd = addresses.get(1);

        LatLng startLL = new LatLng(startAdd.getLatitude()
                , startAdd.getLongitude());

        LatLng endLL = new LatLng(endAdd.getLatitude()
                , endAdd.getLongitude());


        //zooming
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(startLL, 3));
        prevStartMarker = map.addMarker(new MarkerOptions().
                title(startAdd.getLocality()).
                position(startLL));

        prevEndMarker = map.addMarker(new MarkerOptions()
                .title(endAdd.getLocality())
                .position(endLL));

        Log.d(TAG, "onPostExecute: " + prevStartMarker + ", " + prevEndMarker);

      /*  map.addCircle(new CircleOptions()
                .center(new LatLng(address.getLatitude(), address.getLongitude()))
                .radius(1000)
                .fillColor(Color.argb(50, 50, 100, 255))
                .strokeColor(Color.BLACK)
                .strokeWidth(5));*/

        map.addPolyline(new PolylineOptions()
                .add(startLL)
                .add(endLL)
                .width(5)
                .color(Color.BLACK)
        );
    }
}

/**
 * More of Markers
 * <p>
 * prevMarker = map.addMarker(new MarkerOptions().
 * position(new LatLng(lat, lng)).
 * title(address.getLocality()).
 * snippet("I'm here").
 * icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).
 * draggable(true));
 * }
 */
