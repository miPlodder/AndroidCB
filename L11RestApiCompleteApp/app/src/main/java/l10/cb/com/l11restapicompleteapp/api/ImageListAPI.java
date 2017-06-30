package l10.cb.com.l11restapicompleteapp.api;

import java.util.ArrayList;

import l10.cb.com.l11restapicompleteapp.models.ImageListPOJO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ip510 feih on 30-06-2017.
 */

public interface ImageListAPI {

    //"by" is used for different use of API's
    //"of" is used when we have query, that is we are filtering the data

    @GET("/albums/{id}/photos")
        //id is albumId
    Call<ArrayList<ImageListPOJO>> getImageListById(

            @Path("id") int id

    );


}
