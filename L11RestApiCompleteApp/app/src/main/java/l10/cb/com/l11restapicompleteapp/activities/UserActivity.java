package l10.cb.com.l11restapicompleteapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import l10.cb.com.l11restapicompleteapp.R;
import l10.cb.com.l11restapicompleteapp.adapters.PostAdapter;
import l10.cb.com.l11restapicompleteapp.adapters.UserAdapter;
import l10.cb.com.l11restapicompleteapp.api.SingeltonAPIClass;
import l10.cb.com.l11restapicompleteapp.api.UserAPI;
import l10.cb.com.l11restapicompleteapp.models.UserPOJO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserActivity extends AppCompatActivity {

    RecyclerView rvUser;
    public static final String TAG = "UserActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        rvUser = (RecyclerView) findViewById(R.id.rvUser);
        final UserAdapter userAdapter = new UserAdapter(new ArrayList<UserPOJO>(), this);
        rvUser.setLayoutManager(new LinearLayoutManager(this));
        rvUser.setAdapter(userAdapter);

        Log.d(TAG, "onCreate: ");

        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //creating object of
        UserAPI userAPI = retrofit.create(UserAPI.class);*/

        SingeltonAPIClass singeltonAPIClass = SingeltonAPIClass.createInstance();
        UserAPI userAPI = singeltonAPIClass.getUserAPI();

        //creating Callback method of retrofit
        //callback method will contain the body that what will I do
        // after getting the data
        userAPI.getUsers().enqueue(new Callback<ArrayList<UserPOJO>>() {
            @Override
            public void onResponse(Call<ArrayList<UserPOJO>> call, Response<ArrayList<UserPOJO>> response) {

                Log.d(TAG, "onResponse: postlist ->"+response.body());
                userAdapter.updateList(response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<UserPOJO>> call, Throwable t) {

                Log.d(TAG, "onFailure: ");

            }
        });



    }
}
