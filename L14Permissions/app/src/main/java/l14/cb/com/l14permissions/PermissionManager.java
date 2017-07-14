package l14.cb.com.l14permissions;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by ip510 feih on 06-07-2017.
 */

public class PermissionManager {


    public static final String TAG = "PermissionManager";
    static ArrayList<OnPermissionResultListener> listenerList = new ArrayList<>();

    interface OnPermissionResultListener {

        void onPermissionGranted(String permission);
        void onPermissionDenied(String permission);

    }

    static void askForPermission(Activity act, String[] permissions, OnPermissionResultListener oprl) {

        int reqCode = listenerList.size();
        listenerList.add(reqCode, oprl);

        ActivityCompat.requestPermissions(act, permissions, reqCode);
    }

    static void onRequestPermissionResult(int reqCode, String[] permissions, int[] permGranted) {

        try {

            OnPermissionResultListener oprl = listenerList.get(reqCode);
            for (int i = 0; i < permissions.length; i++) {

                if (permGranted[i] == PackageManager.PERMISSION_GRANTED) {

                    oprl.onPermissionGranted(permissions[i]);
                } else {


                    oprl.onPermissionDenied(permissions[i]);
                }
            }
        }catch (IndexOutOfBoundsException ioobe){

            Log.d(TAG, "Index Out of Bound");

        }
    }
}
