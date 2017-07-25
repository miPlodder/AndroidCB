package l8.cb.com.l18mediaplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * It's Asynchronous in nature
         mp = MediaPlayer.create(this, R.raw.audio);
         mp.start();*/

        mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {

            mp.setDataSource(this, Uri.parse("android.resource://l8.cb.com.l18mediaplayer/raw/audio"));
            //mp.setDataSource("https://github.com/the-dagger/sample-media/blob/master/audio.mp3?raw=true");
            mp.prepareAsync();

            mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {

                    mp.start();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        ((Button)findViewById(R.id.bck)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(2000);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mp.start();
    }
}
