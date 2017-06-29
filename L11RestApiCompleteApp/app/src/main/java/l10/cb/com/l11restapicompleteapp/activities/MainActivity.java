package l10.cb.com.l11restapicompleteapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import l10.cb.com.l11restapicompleteapp.R;
import l10.cb.com.l11restapicompleteapp.api.TodoAPI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvPost, tvUser, tvTodo, tvAlbum;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");
        //initialise the views
        this.initialiser();
      
    }

    private void initialiser(){

        Log.d(TAG, "initialiser: ");

        tvPost = (TextView) findViewById(R.id.tvPost);
        tvPost.setOnClickListener(this);

        tvAlbum = (TextView) findViewById(R.id.tvAlbum);
        tvAlbum.setOnClickListener(this);

        tvUser = (TextView) findViewById(R.id.tvUser);
        tvUser.setOnClickListener(this);

        tvTodo = (TextView) findViewById(R.id.tvTodo);
        tvTodo.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Log.d(TAG, "onClick: ");
        Intent i ;

        switch (view.getId()){


            case R.id.tvUser:

                 i = new Intent(this,UserActivity.class);
                startActivity(i);
                break;

            case R.id.tvPost:

                i = new Intent(this,PostActivity.class);
                startActivity(i);
                break;

            case R.id.tvAlbum:
                i = new Intent(this,AlbumActivity.class);
                startActivity(i);
                break;

            case R.id.tvTodo:
                i = new Intent(this,TodoActivity.class);
                startActivity(i);
                break;
        }


    }
}
