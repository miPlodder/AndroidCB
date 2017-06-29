package l10.cb.com.l11restapicompleteapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import l10.cb.com.l11restapicompleteapp.R;
import l10.cb.com.l11restapicompleteapp.adapters.PostAdapter;
import l10.cb.com.l11restapicompleteapp.api.PostAPI;
import l10.cb.com.l11restapicompleteapp.models.PostPOJO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostActivity extends AppCompatActivity {

    public static final String TAG = "PostActivity" ;
    RecyclerView rvPost;
    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        rvPost = (RecyclerView) findViewById(R.id.rvPost);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostAPI postAPI = retrofit.create(PostAPI.class);

        //now enqueue the request
        // and give Callback in parameter (inside which I have to do my work with)
        postAPI.getPosts().enqueue(new Callback<ArrayList<PostPOJO>>() {
            @Override
            public void onResponse(Call<ArrayList<PostPOJO>> call, Response<ArrayList<PostPOJO>> response) {

                //approach 2 for setting up data to the adapter via RETROFIT
                postAdapter = new PostAdapter(response.body(), PostActivity.this);
                rvPost.setLayoutManager(new LinearLayoutManager(PostActivity.this));
                rvPost.setAdapter(postAdapter);

            }

            @Override
            public void onFailure(Call<ArrayList<PostPOJO>> call, Throwable t) {

                Toast.makeText(PostActivity.this, "Please check your INTERNET CONNECTION", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
