package l10.cb.com.l10restapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {

    public static final String TAG = "RetroFit Library" ;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //0 stands for default value if string parsing fails
        int postId = getIntent().getIntExtra("postId",0);
        tv = (TextView) findViewById(R.id.tvPostId);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostAPI postAPI = retrofit.create(PostAPI.class);

        postAPI.getPostComments(1).enqueue(new Callback<ArrayList<PostComment>>() {
            @Override
            public void onResponse(Call<ArrayList<PostComment>> call, Response<ArrayList<PostComment>> response) {

                Log.d(TAG, "onResponse: "+response);
                //response.body() gives us the arraylist
                Log.d(TAG, "onResponse: "+response.body().get(1));
                tv.setText(response.body().get(1).getId());//+"");
            }

            @Override
            public void onFailure(Call<ArrayList<PostComment>> call, Throwable t) {

                Log.d(TAG, "onFailure: ");

            }
        });



    }
}
