package l10.cb.com.l11restapicompleteapp.api;

import java.util.ArrayList;

import l10.cb.com.l11restapicompleteapp.models.AlbumPOJO;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ip510 feih on 30-06-2017.
 */

public interface AlbumAPI {

    @GET("/photos")
    Call<ArrayList<AlbumPOJO>> getAlbums();


}
