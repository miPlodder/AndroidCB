package l8.cb.com.l18firebaseui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DBFirebaseBasicActivity extends AppCompatActivity {

    EditText et;
    Button btn;
    public static final String TAG = "DBFirebaseBasicActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.et);
        btn = (Button) findViewById(R.id.btn);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference currDb = database.getReference("msg");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currDb.push().setValue(et.getText().toString());

            }
        });


        currDb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Toast.makeText(DBFirebaseBasicActivity.this, "data changed", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onDataChange: " + dataSnapshot.toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(DBFirebaseBasicActivity.this, "some error", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onCancelled: " + databaseError.getMessage());

            }
        });

    }
}
