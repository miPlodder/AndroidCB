package l8.cb.com.l18horizontallistrv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    HorizontalRV adapter;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> data = new ArrayList<>();
        data.add("Pandora");
        data.add("CRUX");
        data.add("Elixir");
        data.add("CRUX");
        data.add("Pandora");
        data.add("CRUX");
        data.add("Elixir");
        data.add("CRUX");
        data.add("Pandora");
        data.add("Elixir");
        data.add("Elixir");

        adapter = new HorizontalRV(data,this);
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv.setLayoutManager(manager);


    }
}
