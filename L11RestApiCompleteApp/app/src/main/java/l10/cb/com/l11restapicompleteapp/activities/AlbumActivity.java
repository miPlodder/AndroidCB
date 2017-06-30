package l10.cb.com.l11restapicompleteapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import l10.cb.com.l11restapicompleteapp.R;
import l10.cb.com.l11restapicompleteapp.adapters.AlbumAdapter;
import l10.cb.com.l11restapicompleteapp.api.AlbumAPI;
import l10.cb.com.l11restapicompleteapp.api.SingeltonAPIClass;
import l10.cb.com.l11restapicompleteapp.models.AlbumPOJO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlbumActivity extends AppCompatActivity {

    RecyclerView rvAlbum ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        rvAlbum = (RecyclerView) findViewById(R.id.rvAlbum);
        final AlbumAdapter albumAdapter = new AlbumAdapter(new ArrayList<AlbumPOJO>(), this);
        rvAlbum.setLayoutManager(new LinearLayoutManager(this));
        rvAlbum.setAdapter(albumAdapter);

        //using singelton method to create only one RetroFit instance

        SingeltonAPIClass singeltonAPIClass = SingeltonAPIClass.createInstance();
        AlbumAPI albumAPI = singeltonAPIClass.getAlbumAPI();

        albumAPI.getAlbums().enqueue(new Callback<ArrayList<AlbumPOJO>>() {
            @Override
            public void onResponse(Call<ArrayList<AlbumPOJO>> call, Response<ArrayList<AlbumPOJO>> response) {

                albumAdapter.updateAlbumList(response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<AlbumPOJO>> call, Throwable t) {

            }
        });


    }
}
