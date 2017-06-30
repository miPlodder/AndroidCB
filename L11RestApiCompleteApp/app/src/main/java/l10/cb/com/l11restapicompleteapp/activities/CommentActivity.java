package l10.cb.com.l11restapicompleteapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import l10.cb.com.l11restapicompleteapp.R;
import l10.cb.com.l11restapicompleteapp.adapters.CommentAdapter;
import l10.cb.com.l11restapicompleteapp.api.PostAPI;
import l10.cb.com.l11restapicompleteapp.api.SingeltonAPIClass;
import l10.cb.com.l11restapicompleteapp.models.CommentPOJO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentActivity extends AppCompatActivity {

    RecyclerView rvCommentList;
    public static final String TAG = "CommentActiivty" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        Intent i = getIntent();
        Integer postId = 1;

        if (i != null) {

            Log.d(TAG, "onCreate: ");
            postId = i.getIntExtra("postId", 1);

        }

        rvCommentList = (RecyclerView) findViewById(R.id.rvComment);
        rvCommentList.setLayoutManager(new LinearLayoutManager(this));

        final CommentAdapter commentAdapter = new CommentAdapter(new ArrayList<CommentPOJO>(), this);

        rvCommentList.setAdapter(commentAdapter);


        Callback<ArrayList<CommentPOJO>> callback = new Callback<ArrayList<CommentPOJO>>() {
            @Override
            public void onResponse(Call<ArrayList<CommentPOJO>> call, Response<ArrayList<CommentPOJO>> response) {

                commentAdapter.updateCommentList(response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<CommentPOJO>> call, Throwable t) {

                Log.d(TAG, "onFailure: "+t.getMessage());

            }
        };

        if (postId == -1) {

            Toast.makeText(this, "Invalid PostId", Toast.LENGTH_SHORT).show();

        } else {

            Log.d(TAG, "onCreate: postId -> "+postId);

            SingeltonAPIClass singeltonAPIClass = SingeltonAPIClass.createInstance();
            PostAPI postAPI = singeltonAPIClass.getPostAPI();
            PostAPI.CommentAPI commentAPI = singeltonAPIClass.getCommentAPI();
            commentAPI.getCommentsByPostId(postId).enqueue(callback);


        }
    }
}
