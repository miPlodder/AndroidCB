package l8.cb.com.l18camera;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by ip510 feih on 20-07-2017.
 */

public class CameraView extends SurfaceView implements SurfaceHolder.Callback {

    Camera c;

    public CameraView(Context context, Camera c) {

        super(context);
        this.c = c;
        getHolder().addCallback(this);

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

        try {
            c.setPreviewDisplay(surfaceHolder);
            c.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

        c.stopPreview();

        try {
            c.setPreviewDisplay(surfaceHolder);
            c.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

        c.release();

    }
}
