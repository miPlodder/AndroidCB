package l14.cb.com.l14permissions;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainACtivity";
    TextView tv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        Log.d(TAG, "onCreate: " + getFilesDir().getPath());
        Log.d(TAG, "onCreate: " + getExternalFilesDir(null));
        Log.d(TAG, "onCreate: " + Environment.getExternalStorageDirectory().getPath().toString());

       /* Log.d(TAG, "onCreate: "+getFilesDir().getAbsolutePath());
        Log.d(TAG, "onCreate: "+getFilesDir().getPath());*/

        /*
        //used to check for permissions
        int permCode = ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        );*/
        /*

        Log.d(TAG, "onCreate: " + permCode);
        Log.d(TAG, "onCreate: " + PackageManager.PERMISSION_GRANTED);
        Log.d(TAG, "onCreate: " + PackageManager.PERMISSION_DENIED);

        if (permCode == PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "Permission Granted --> " + PackageManager.PERMISSION_GRANTED);
            Log.d(TAG, "onCreate: permCode --> " + permCode);
        }
        if (permCode == PackageManager.PERMISSION_DENIED) {

            Log.d(TAG, "Permission Denied");
            Log.d(TAG, "onCreate: permCode --> " + permCode);
        }

        */
        //ContextCompat.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        //for api level more than 23, we need to manually add permissions
        /*
            Manifest.permission.WRITE_EXTERNAL_STORAGE;
        */
      /*

        ActivityCompat.requestPermissions(this,
                new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        //Manifest.permission.READ_EXTERNAL_STORAGE
                },
                345
        );
    */

        /*ActivityCompat.requestPermissions(this,
                new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.READ_SMS
                },
                345
        );*/

    /* Permission ek hi baar array mai request karte hai

        ActivityCompat.requestPermissions(this,
                new String[]{
                        Manifest.permission.BODY_SENSORS
                        //Manifest.permission.READ_EXTERNAL_STORAGE
                },
                322
        );*/
        // PermissionManager.onRequestPermissionResult(123,null,null);

        //-----------------------------------------------------------------------------------

        /*
         * saving my file to /data/ --> we have to root the phone to see the file
         * final File dataFolder = new File(getFilesDir(), "myFile.txt");
         *
        */

        /**
         *
         * saving my file inside sdcard --> no permission required to write the file here
         * final File dataFolder = new File(getExternalFilesDir("TextFilesFor Project"), "myFile.txt");
         *
         * */

        final File dataFolder = new File(Environment.getExternalStorageDirectory(), "myFile.txt");
        Log.d(TAG, "onCreate: "+dataFolder.getAbsolutePath());
        Log.d(TAG, "onCreate: "+dataFolder.getAbsolutePath());

        ((Button) findViewById(R.id.btnWrite)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                writeToFile(dataFolder, ((EditText) findViewById(R.id.et)).getText().toString());
            }
        });


        ((Button) findViewById(R.id.btnRead)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readFromFile(dataFolder);
            }
        });

    }

    //method called after OS PERMISSIONS DIALOG is used
    //grantResults will contain that if the permissions are granted(0) or not(-1)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        PermissionManager.onRequestPermissionResult(requestCode, permissions, grantResults);
    }

    public void write(File dataFolder, String textToWrite) throws IOException {

        Log.d(TAG, "write: " + dataFolder.getAbsolutePath());

        FileOutputStream fos = new FileOutputStream(dataFolder, true);
        fos.write(textToWrite.getBytes());
    }

    public void writeToFile(final File dataFolder, final String textToWrite) {

        PermissionManager.askForPermission(this,
                new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                },
                new PermissionManager.OnPermissionResultListener() {
                    @Override
                    public void onPermissionGranted(String permission) {

                        if (permission.equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                            try {
                                write(dataFolder, textToWrite);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onPermissionDenied(String permission) {

                        Log.d(TAG, "denied to Write"+permission);

                    }
                });


    }

    public String read(File dataFolder) throws IOException {

        FileInputStream fis = new FileInputStream(dataFolder);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        StringBuilder sb = new StringBuilder();
        String buffer = "";

        while (buffer != null) {

            sb.append(buffer);
            buffer = br.readLine();

        }

        return sb.toString();
    }

    public void readFromFile(final File dataFolder) {

        PermissionManager.askForPermission(
                this,
                new String[]{

                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE

                },
                new PermissionManager.OnPermissionResultListener() {
                    @Override
                    public void onPermissionGranted(String permission) {

                        try {
                            String str = read(dataFolder);
                            tv.setText(str);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onPermissionDenied(String permission) {

                        Log.d(TAG, "denied to read");

                    }
                }
        );


    }
}
