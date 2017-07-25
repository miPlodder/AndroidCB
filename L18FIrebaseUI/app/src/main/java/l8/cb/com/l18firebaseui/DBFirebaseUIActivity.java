package l8.cb.com.l18firebaseui;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseIndexRecyclerAdapter;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 *
 * Creating list using FIREBASEUI
 *
 */

public class DBFirebaseUIActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbfirebase_ui);

        lv = (ListView) findViewById(R.id.lv);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mRef = database.getReference("msg");

        FirebaseListAdapter<String> adapter = new FirebaseListAdapter<String>(

                this,
                String.class,
                android.R.layout.simple_list_item_1,
                mRef) {
            @Override
            protected void populateView(View v, String model, int position) {

                TextView tv = (TextView) v.findViewById(android.R.id.text1);
                tv.setText(model);

            }
        };


        lv.setAdapter(adapter);
    }
}
