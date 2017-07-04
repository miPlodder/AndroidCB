package l11.cb.com.l11picassogridlayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        Intent i = getIntent();
        if(i != null){

            String url = i.getStringExtra("url");
            Picasso.with(this)
                    .load(url)
             /*       .resize(800,1000)*/
                    .into(((ImageView)findViewById(R.id.fbIv)));


        }

        ((FloatingActionButton)findViewById(R.id.fabUndo)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(FullscreenActivity.this, "Floating Action Button Clicked", Toast.LENGTH_SHORT).show();

            }
        });

        ((ImageView)findViewById(R.id.fbIv)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Snackbar snackbar;
                snackbar = Snackbar.make((LinearLayout)findViewById(R.id.cl),"Hello World",Snackbar.LENGTH_SHORT)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Toast.makeText(FullscreenActivity.this, "UNDO CLICKED", Toast.LENGTH_SHORT).show();

                            }
                        });
                snackbar.setActionTextColor(Color.GRAY);
                snackbar.show();
                Toast.makeText(FullscreenActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
