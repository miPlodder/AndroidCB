package l15.cb.com.l16googlemaps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    String[] languages = {"C", "C++", "JAVA", "JS", "Python"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_dropdown_item_1line, languages
        );

        AutoCompleteTextView et = (AutoCompleteTextView) findViewById(R.id.et);
        et.setThreshold(1);
        et.setAdapter(adapter);

    }
}
