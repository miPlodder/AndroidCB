package l6.cb.com.todolist;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    EditText etTopic, etDetail;
    RecyclerView rv;
    ArrayList<MyPojo> data = generator();
    RVAdapter rvAdapter;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTopic = (EditText) findViewById(R.id.etTopic);
        etDetail = (EditText) findViewById(R.id.etDetail);
        rv = (RecyclerView) findViewById(R.id.rvList);

        ((Button) findViewById(R.id.btnAdd)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                add();

            }
        });

        ((Button) findViewById(R.id.btnDel)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                delete();

            }
        });
        rv.setLayoutManager(new LinearLayoutManager(this));
        rvAdapter = new RVAdapter(data, this);
        rv.setAdapter(rvAdapter);

    }

    private void add() {

        String topic = etTopic.getText().toString();
        String detail = etDetail.getText().toString();

        this.data.add(new MyPojo(topic, detail));

        rvAdapter.notifyDataSetChanged();

        etTopic.setText("");
        etDetail.setText("");

        for(MyPojo myPojo : this.data){

            myPojo.setChecked(false);

        }

    }

    private void delete() {

        Iterator<MyPojo> i = this.data.iterator();

        while (i.hasNext()) {

            MyPojo next = i.next();
            if (next.getChecked()) {

                i.remove();

            }
        }

        for(MyPojo myPojo : this.data){

                myPojo.setChecked(false);
        }

        Log.d(TAG, "delete: " + data);
        rvAdapter.notifyDataSetChanged();
    }

    static ArrayList<MyPojo> generator() {

        ArrayList<MyPojo> al = new ArrayList<>();

        al.add(new MyPojo("Topic", "Detail"));

        return al;
    }
}