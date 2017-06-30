package l10.cb.com.l11restapicompleteapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import l10.cb.com.l11restapicompleteapp.R;

public class PhotoActivity extends AppCompatActivity {

    ImageView ivUrl;
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        String url = "", title = "";

        Intent i = getIntent();
        if( i != null){

            url = i.getStringExtra("url");
            title = i.getStringExtra("title");

        }

        ((TextView)findViewById(R.id.tvTitle)).setText(title);
        Picasso.with(this).load(url).into((ImageView)findViewById(R.id.ivUrl));

    }
}
