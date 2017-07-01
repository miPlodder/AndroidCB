package l11.cb.com.l11picassogridlayout;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ip510 feih on 01-07-2017.
 */

public interface ImageAPI {

    @GET("/photos")
    Call<ArrayList<ImagePOJO>> getImageUrl();


}
