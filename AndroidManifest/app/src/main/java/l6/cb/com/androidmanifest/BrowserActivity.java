package l6.cb.com.androidmanifest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import java.net.URL;

public class BrowserActivity extends AppCompatActivity {

    String url ;
    public static final String TAG = "BrowserActivity";
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);


        webView = (WebView) findViewById(R.id.wv);
        webView.setWebViewClient(new MyBrowser());

        ((Button)findViewById(R.id.btnView)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //www.example.com"
                url = ((EditText)findViewById(R.id.etURL)).getText().toString();
                Log.d(TAG, "onClick: "+url);
                /*webView.getSettings().setLoadsImagesAutomatically(true);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                */
                webView.loadUrl("http://www."+url);

            }
        });
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
