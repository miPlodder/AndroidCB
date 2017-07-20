package l17.cb.com.l17firebase;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    EditText et;
    Button btn;
    ListView lv;
    TextView tv;
    FirebaseDatabase database;
    DatabaseReference myRef;
    ArrayList<String> msgs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.et);
        btn = (Button) findViewById(R.id.btn);
        lv = (ListView) findViewById(R.id.lv);
        tv = (TextView) findViewById(R.id.tv);


            database = FirebaseDatabase.getInstance(); //gives the firebase database reference
            Log.d(TAG, "database " + database);

            myRef = database.getReference("MSGS");
            Log.d(TAG, "myRef " + myRef);

        //DatabaseReference ref = FirebaseDatabase.getInstance().getReferenceFromUrl("MSGS");

        //Firebase ref = new Firebase("https://l17firebase.firebaseio.com/MSGS");

        //-----------------------------PROBLEM HERE ------------------------------------------------
       FirebaseListAdapter<String> adapter = new FirebaseListAdapter<String>
                (this, String.class, android.R.layout.simple_list_item_1, myRef) {

            @Override
            protected void populateView(View view, String s, int i) {

                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                tv.setText(s);


            }
        };

        lv.setAdapter(adapter);

        /*
        myRef.addValueEventListener(new ValueEventListener() {
`            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is " + value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Log.w(TAG, "Failed to read value ", databaseError.toException());

            }
        });
        */


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Firebase mRefChild ;
                //myRef.child()

                myRef.push().setValue(et.getText().toString());
                //push means to give name - setvalue means to give value

                /**
                 * myRef.setValue("DELETE");
                 * DatabaseReference myChild = myRef.child("NAME");
                 * myChild.setValue("VALUE");
                 *
                 */

            }
        });

        /**
         * myRef.addValueEventListener(new ValueEventListener() {
        @Override public void onDataChange(DataSnapshot dataSnapshot) {

        //get all the data inside a HASHMAP
        HashMap<String,String> hashmap = (HashMap<String, String>) dataSnapshot.getValue();

        String value =  hashmap.get("-KpJdP2pl3XyOOrYaJQx");
        Toast.makeText(MainActivity.this, "Value = " + value, Toast.LENGTH_SHORT).show();
        tv.setText(value);
        Log.d(TAG, "onDataChange: "+dataSnapshot.toString());
        }

        @Override public void onCancelled(DatabaseError databaseError) {

        Toast.makeText(MainActivity.this, "So Error Occured", Toast.LENGTH_SHORT).show();
        }
        });
         *
         *
         */


        /**
         *
         *
         *
         * myRef.addChildEventListener(new ChildEventListener() {
        @Override public void onChildAdded(DataSnapshot dataSnapshot, String s) {

        Toast.makeText(MainActivity.this, "ADDED NEWLY", Toast.LENGTH_SHORT).show();
        msgs.add(dataSnapshot.getValue(String.class));
        adapter.notifyDataSetChanged();

        }

        @Override public void onChildChanged(DataSnapshot dataSnapshot, String s) {

        }

        @Override public void onChildRemoved(DataSnapshot dataSnapshot) {

        }

        @Override public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override public void onCancelled(DatabaseError databaseError) {

        }
        });
         */

    }
}