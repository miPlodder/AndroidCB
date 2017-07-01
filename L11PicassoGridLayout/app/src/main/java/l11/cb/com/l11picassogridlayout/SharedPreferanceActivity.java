package l11.cb.com.l11picassogridlayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPreferanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferance);

        ((Button)findViewById(R.id.btnSave)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",((EditText)findViewById(R.id.etName)).getText().toString());
                editor.putString("password",((EditText)findViewById(R.id.etPass)).getText().toString());

                editor.commit();
            }
        });

        final StringBuffer buffer = new StringBuffer();

        ((Button)findViewById(R.id.btnLoad)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences("MyData",Context.MODE_PRIVATE);

                buffer.append(sharedPreferences.getString("name","nothing"));
                buffer.append(sharedPreferences.getString("password","nothing"));

                ((TextView)findViewById(R.id.tvSavedText)).setText(buffer.toString());

            }
        });
    }
}
