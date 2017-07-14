package l10.cb.com.l10restapi;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
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

                //----------------------------------------------------------------------------------ERROR HERE
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostAPI postAPI = retrofit.create(PostAPI.class);

        //Log.d(TAG, "onCreate: "+retrofit.baseUrl().toString());

        // Getting data from another webpage

        //function 1 in PostAPI class
       /* postAPI.getPostComments(1).enqueue(new Callback<ArrayList<PostComment>>() {

            @Override
            public void onResponse(Call<ArrayList<PostComment>> call, Response<ArrayList<PostComment>> response) {

                Log.d(TAG, "onResponse: "+response);
                //response.body() gives us the arraylist
                Log.d(TAG, "onResponse: "+response.body().toString());

                long startTime = System.currentTimeMillis();
                while(startTime + 5000 > System.currentTimeMillis()){

                    //do nothing

                }

                tv.setText(response.body().get(1).getBody());


            }

            @Override
            public void onFailure(Call<ArrayList<PostComment>> call, Throwable t) {

                Log.d(TAG, "onFailure: ");

            }
        });*/


       //if POJO CLASS field name is not matched then, null are returned to that variables
     /*   try {
            postAPI.getUserDetails().execute();

        } catch (IOException e) {
            Log.d(TAG, "onCreate: inside catch");
            e.printStackTrace();
        }*/

        postAPI.getUserDetails().enqueue(new Callback<ArrayList<UserDetail>>() {
           @Override
           public void onResponse(Call<ArrayList<UserDetail>> call, Response<ArrayList<UserDetail>> response) {

               tv.setText(response.body().get(1).toString());
               Log.d(TAG, "onResponse: after setting the text");

           }

           @Override
           public void onFailure(Call<ArrayList<UserDetail>> call, Throwable t) {

               Log.d(TAG, "onFailure: "+t.getMessage());
           }
       });

        //------------------------------------------------------------------------------------------

     /* postAPI.getPosts().enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                Log.d(TAG, "onResponse: " + response.body());
                tv.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

                Log.d(TAG, "onFailure: ");
            }
        });*/


     //---------------------------------------------------------------------------------------------

     //function 2 in PostAPI class
        //Not working as JSONObject is returned
      /* postAPI.getUserDetails(1).enqueue(new Callback<ArrayList<UserDetail>>() {
           @Override
           public void onResponse(Call<ArrayList<UserDetail>> call, Response<ArrayList<UserDetail>> response) {

               Log.d(TAG, "onResponse: "+call.toString());
               Log.d(TAG, "onResponse");

               //body() method is used to get the arraylist from the Response object
               tv.setText(response.body().toString());

           }

           @Override
           public void onFailure(Call<ArrayList<UserDetail>> call, Throwable t) {

               Log.d(TAG, "onFailure: "+call.toString());
               Log.d(TAG, "onFailure: "+t.getMessage());

           }
       });*/


      //------------------------------------------------------------------------------------------
      //function 3 in PostAPI class
        /*
        postAPI.getPosts(1).enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {

                Log.d(TAG, "onResponse: ");
                
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

                Log.d(TAG, "onFailure: ");
                
            }
        });*/
     

   
    }
}
