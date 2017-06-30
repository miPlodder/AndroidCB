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
import l10.cb.com.l11restapicompleteapp.api.SingeltonAPIClass;
import l10.cb.com.l11restapicompleteapp.models.PostPOJO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostActivity extends AppCompatActivity {

    public static final String TAG = "PostActivity";
    RecyclerView rvPost;
    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        rvPost = (RecyclerView) findViewById(R.id.rvPost);
        //approach 2 for setting up data to the adapter via RETROFIT
        postAdapter = new PostAdapter(new ArrayList<PostPOJO>(), PostActivity.this);
        rvPost.setLayoutManager(new LinearLayoutManager(PostActivity.this));
        rvPost.setAdapter(postAdapter);
        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostAPI postAPI = retrofit.create(PostAPI.class);*/

        //using singelton class instead of above approach
        SingeltonAPIClass singeltonAPIClass = SingeltonAPIClass.createInstance();
        PostAPI postAPI = singeltonAPIClass.getPostAPI();


        //now enqueue the request
        // and give Callback in parameter (inside which I have to do my work with)
        Callback<ArrayList<PostPOJO>> callback = new Callback<ArrayList<PostPOJO>>() {
            @Override
            public void onResponse(Call<ArrayList<PostPOJO>> call, Response<ArrayList<PostPOJO>> response) {

                postAdapter.updatePostList(response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<PostPOJO>> call, Throwable t) {

                Toast.makeText(PostActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        };

        //by this we can use one activity for showing 2 lists
        int userId = getIntent().getIntExtra("userId",-1);

        if(userId == -1){

            postAPI.getPosts().enqueue(callback);

        }else{

            postAPI.getPostsByUserId(userId).enqueue(callback);
        }


    }
}
