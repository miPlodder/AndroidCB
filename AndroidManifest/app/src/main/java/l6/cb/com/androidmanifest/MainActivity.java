package l6.cb.com.androidmanifest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.btnSend)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String string2Send = ((EditText) findViewById(R.id.etText2Send)).getText().toString();

                Intent i = new Intent();

                i.setAction(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_TEXT, string2Send);
                i.setType("text/plain");
                startActivity(i);
            }
        });

        ((Button) findViewById(R.id.btnURI)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String string2View = ((EditText) findViewById(R.id.etText2Send)).getText().toString();

                Intent i = new Intent();

                i.setAction(Intent.ACTION_VIEW);

                //putextra''s key
      /*          i.putExtra("key", string2View);
                i.setData(Uri.parse(string2View));*/
                startActivity(i);

            }
        });
    }
}
