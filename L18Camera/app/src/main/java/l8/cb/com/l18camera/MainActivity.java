package l8.cb.com.l18camera;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    FrameLayout container ;
    public static final String TAG = "MainActivity";
    Camera c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c = Camera.open();
        container = (FrameLayout) findViewById(R.id.container);


        List<Camera.Size> picSize = c.getParameters().getSupportedPictureSizes();

        for (Camera.Size s : picSize) {

            Log.d(TAG, "picture width " + s.width + ", height " + s.height);
        }

        List<Camera.Size> vidSize = c.getParameters().getSupportedVideoSizes();

        for (Camera.Size s : vidSize) {

            Log.d(TAG, "video width " + s.width + ", height " + s.height);
        }


        //preview size is always lesser
        List<Camera.Size> previewSize = c.getParameters().getSupportedPreviewSizes();

        for (Camera.Size s : previewSize) {

            Log.d(TAG, "preview width " + s.width + ", height " + s.height);
        }

        //getWindowManager().getDefaultDisplay().getOrientation();

        c.setDisplayOrientation(90);
        CameraView cv = new CameraView(this, c);
        container.addView(cv);

    }

    void takePic(View v) {

        //shutter is used to create animation
        c.takePicture(null, null,
                new Camera.PictureCallback() {
                    @Override
                    public void onPictureTaken(byte[] bytes, Camera camera) {

                        c.stopPreview();
                        Log.d(TAG, "size = " + bytes.length);
                        c.startPreview();

                    }
                });

    }
}
