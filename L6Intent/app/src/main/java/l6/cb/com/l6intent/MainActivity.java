package l6.cb.com.l6intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity"; 
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");
        
        ((Button) findViewById(R.id.btnAdd)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              /*  int num1 = Integer.valueOf(((EditText)findViewById(R.id.etNum1)).getText().toString());
                int num2 = Integer.valueOf(((EditText)findViewById(R.id.etNum2)).getText().toString());

                Intent i = new Intent(MainActivity.this, otherActivty.class);

                //used to send text from one Activity to another
                i.putExtra("num1",num1);
                i.putExtra("num2",num2);
                startActivity(i);
*/
                //current activity gets destroyed
                //not able to come back
                //not called synchronously

                Intent i = new Intent(MainActivity.this,ImplicitIntent.class);
                startActivity(i);
                //finish();
                Toast.makeText(MainActivity.this, "This is MainActivity Toast", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onClick: This is main Activity Toast");

                Toast.makeText(MainActivity.this, "This is MainActivity Toast", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onClick: This is main Activity Toast");


            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }
}
