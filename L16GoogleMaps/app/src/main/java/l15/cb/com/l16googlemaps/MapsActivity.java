package l15.cb.com.l16googlemaps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import java.io.IOException;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap map;
    GoogleApiClient gac;
    EditText etStartLocation, etEndLocation;
    public static final String TAG = "MapsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        etStartLocation = (EditText) findViewById(R.id.etStartLocation);
        etEndLocation = (EditText) findViewById(R.id.etEndLocation);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragMap);

       /* gac = new GoogleApiClient.Builder(this).addApi(Loca);*/

        mapFragment.getMapAsync(this); //google starts to download the map ASYNCRONOUSLY
        ActivityCompat.requestPermissions(this,
                new String[]{

                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION

                },
                123);
    }

    //called when map is ready
    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;
        // Add a marker in Sydney and move the camera
        /*LatLng delhi = new LatLng(28.69, 77);
        map.addMarker(new MarkerOptions().position(delhi).title("MARKER"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(delhi, 5));*/

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            Log.d(TAG, "PERMISSION DENIED ");

        } else {

            Log.d(TAG, "PERMISSION GRANTED ");
            map.setMyLocationEnabled(true);
        }

    }

    public void geoLocate(View view) throws IOException {

        Geocoder gc = new Geocoder(MapsActivity.this);
        FindLocationTask findLocationTask
                = new FindLocationTask(this,
                etStartLocation,
                etEndLocation,
                gc,
                map);

        findLocationTask.execute();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.map_types, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.mapTypeNone:

                map.setMapType(GoogleMap.MAP_TYPE_NONE);
                break;
            case R.id.mapTypeNormal:

                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case R.id.mapTypeTerrain:

                map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            case R.id.mapTypeSatellite:

                map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.mapTypeHybrid:

                map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;


        }
        return super.onOptionsItemSelected(item);
    }*/