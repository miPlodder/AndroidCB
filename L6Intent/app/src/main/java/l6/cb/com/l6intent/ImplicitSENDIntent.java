package l6.cb.com.l6intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ImplicitSENDIntent extends AppCompatActivity {

    EditText etText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_implicit_sendintent);


        etText = (EditText) findViewById(R.id.etText);

        ((Button)findViewById(R.id.btnSend)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text2Send = etText.getText().toString();
                Intent i = new Intent();
                i.setAction(Intent.ACTION_CAMERA_BUTTON);
                i.putExtra(Intent.EXTRA_TEXT,text2Send);
                i.setType("text/plain");
                startActivity(i);

            }
        });

    }
}

//