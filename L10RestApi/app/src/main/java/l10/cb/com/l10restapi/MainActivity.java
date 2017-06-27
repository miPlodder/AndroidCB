package l10.cb.com.l10restapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

/* compile 'com.squareup.retrofit2:convertor-gson:2.3.0'*/
public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn);
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);

        final PostAdapter postAdapter = new PostAdapter(
                new ArrayList<Post>(),
                this
        );

        postAdapter.setOnItemClickListener(new PostAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {

                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("postId",position);
                startActivity(i);



            }
        });

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(postAdapter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DownloadTask downloadTask = new DownloadTask(new DownloadTask.OnDownloadListener() {
                    @Override
                    public void setOnDownloadListener(ArrayList<Post> postList) {

                        Toast.makeText(MainActivity.this, "Size of AL is "+postList.size(), Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "setOnDownloadListener: "+postList);

                        //notifyDataSetChanged ka fayda in resources release karne mai
                        postAdapter.updateData(postList);
                    }
                });

                downloadTask.execute("http://jsonplaceholder.typicode.com/posts");

            }
        });






















    }
}
