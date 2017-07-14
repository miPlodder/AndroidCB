package l16.cb.com.l16location;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvLat, tvLong, tvAlt, tvAcc, tvSpeed, tvProv;
    LocationManager lm;
    LocationListener ll;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLat = (TextView) findViewById(R.id.tvLat);
        tvLong = (TextView) findViewById(R.id.tvLong);
        tvAlt = (TextView) findViewById(R.id.tvAlt);
        tvAcc = (TextView) findViewById(R.id.tvAcc);
        tvSpeed = (TextView) findViewById(R.id.tvSpeed);
        tvProv = (TextView) findViewById(R.id.tvProv);

        lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        ll = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                Log.d(TAG, "onLocationChanged: " + location.getLongitude());

                tvLat.setText("Latitude -> " + String.valueOf(location.getLatitude()));
                tvLong.setText("Longitude -> " + String.valueOf(location.getLongitude()));
                tvAlt.setText("Altitude -> " + String.valueOf(location.getAltitude()));
                tvAcc.setText("Accuracy -> " + location.getAccuracy());
                tvSpeed.setText("Speed -> " + location.getSpeed());
                tvProv.setText("Provider -> " + location.getProvider());

                //location.distanceTo(new Location(""));

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };
        startLocationTracking();

    }

    @SuppressWarnings("MissingPermission")
    public void startLocationTracking() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            lm.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    10000,
                    10,
                    ll
            );

        } else {

            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION
                    },
                    123);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        startLocationTracking();
    }
}
