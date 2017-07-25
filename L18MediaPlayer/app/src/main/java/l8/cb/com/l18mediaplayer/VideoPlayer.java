package l8.cb.com.l18mediaplayer;

import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

import java.io.IOException;

public class VideoPlayer extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        final VideoView vv = (VideoView) findViewById(R.id.vv);
        vv.setVideoPath("android.resource://l8.cb.com.l18mediaplayer/raw/videos");
        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setVolume(50,50);
                vv.start();
            }
        });

        android.widget.MediaController mediaController = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            mediaController = new android.widget.MediaController(this);
            vv.setMediaController(mediaController);
        }


    }
}
