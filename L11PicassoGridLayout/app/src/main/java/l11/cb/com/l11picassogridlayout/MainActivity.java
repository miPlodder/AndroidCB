package l11.cb.com.l11picassogridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvGridImage;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvGridImage = (RecyclerView) findViewById(R.id.ivImageGridList);
        rvGridImage.setLayoutManager(new GridLayoutManager(this, 2));


        File file = new File("/file");
        Log.d(TAG, "onCreate: " + file.toString());
        Log.d(TAG, "onCreate: " + file.getName());
        Log.d(TAG, "onCreate: filelist" + fileList());
        Log.d(TAG, "onCreate: " + file.getAbsolutePath());

        ArrayList<ImagePOJO> images = generator();

        final GridImageAdapter gridImageAdapter = new GridImageAdapter(images, this);
        rvGridImage.setAdapter(gridImageAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ImageAPI imageAPI = retrofit.create(ImageAPI.class);

        imageAPI.getImageUrl().enqueue(new Callback<ArrayList<ImagePOJO>>() {
            @Override
            public void onResponse(Call<ArrayList<ImagePOJO>> call, Response<ArrayList<ImagePOJO>> response) {

                // gridImageAdapter.updateGrid(response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<ImagePOJO>> call, Throwable t) {

            }
        });

    }

    public static ArrayList<ImagePOJO> generator() {
        ArrayList<ImagePOJO> images = new ArrayList<ImagePOJO>();
        images.add(new ImagePOJO("http://vignette1.wikia.nocookie.net/marveldatabase/images/e/e1/The_Marvel_Universe.png/revision/latest?cb=20110513164401"));
        images.add(new ImagePOJO("https://vignette3.wikia.nocookie.net/marveldatabase/images/9/94/Marvel_Legacy_poster_003.jpg/revision/latest?cb=20170423030558"));
        images.add(new ImagePOJO("http://static.srcdn.com/wp-content/uploads/Marvel-Movies-marvel-comics-13616861-2560-1600-e1447801448947.jpg"));
        images.add(new ImagePOJO("http://i.annihil.us/u/prod/marvel/html_pages_assets/mmc-landing/images/cards/card-2-e4ef818a6a.jpg"));

        return images;
    }
}
