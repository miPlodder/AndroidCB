package l10.cb.com.l11restapicompleteapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import l10.cb.com.l11restapicompleteapp.R;
import l10.cb.com.l11restapicompleteapp.adapters.ImageListAdapter;
import l10.cb.com.l11restapicompleteapp.api.ImageListAPI;
import l10.cb.com.l11restapicompleteapp.api.SingeltonAPIClass;
import l10.cb.com.l11restapicompleteapp.models.ImageListPOJO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImageListActivity extends AppCompatActivity {

    RecyclerView rvImageList;
    Integer albumId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);

        //getIdFrom the Previous Intent
        Intent i = getIntent();
        if( i != null){

            albumId = i.getIntExtra("albumId",-1);

        }

        rvImageList = (RecyclerView) findViewById(R.id.rvImageList);
        rvImageList.setLayoutManager(new LinearLayoutManager(this));

        final ImageListAdapter imageListAdapter = new ImageListAdapter(new ArrayList<ImageListPOJO>(), this);
        rvImageList.setAdapter(imageListAdapter);

        //now using retrofit to fetch data from the internet
        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ImageListAPI imageListAPI = retrofit.create(ImageListAPI.class);
        */

        //instead of above approach we use, singelton class
        SingeltonAPIClass singeltonAPIClass = SingeltonAPIClass.createInstance();
        ImageListAPI imageListAPI = singeltonAPIClass.getImageListAPI();

        imageListAPI.getImageListById(albumId).enqueue(new Callback<ArrayList<ImageListPOJO>>() {
            @Override
            public void onResponse(Call<ArrayList<ImageListPOJO>> call, Response<ArrayList<ImageListPOJO>> response) {

                imageListAdapter.updateImageList(response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<ImageListPOJO>> call, Throwable t) {

            }
        });

    }
}
