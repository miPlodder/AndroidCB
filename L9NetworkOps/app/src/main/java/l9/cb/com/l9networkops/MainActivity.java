package l9.cb.com.l9networkops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //do the work of fetching data from the internet using working thread
                //using AsyncTask
                DownloadTask downloadTask = new DownloadTask((TextView)(findViewById(R.id.tv)));
                if(!((EditText)findViewById(R.id.et)).getText().toString().isEmpty())
                    downloadTask.execute(((EditText)findViewById(R.id.et)).getText().toString());
                else
                    Toast.makeText(MainActivity.this, "Enter a URL", Toast.LENGTH_SHORT).show();
                //downloadTask.execute("http://www.example.com");

            }
        });


    }
}
