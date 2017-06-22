package l6.cb.com.l6intent;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ImplicitIntent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        ((Button) findViewById(R.id.btnOpen)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String goTo = ((EditText) findViewById(R.id.etUri)).getText().toString();

                //this is implicit intent
                //where OS finds out which Activity to open
                try {
                    Intent i = new Intent(Intent.ACTION_CALL);
                    i.setData(Uri.parse("tel: 9790723379" ));
                    i.putExtra("tag","tag");
                    startActivity(i);

                }catch (ActivityNotFoundException e){

                    Toast.makeText(ImplicitIntent.this, "Activity not found", Toast.LENGTH_SHORT).show();
                }catch (SecurityException e){

                    Toast.makeText(ImplicitIntent.this, "Permission Denied", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
