package l10.cb.com.l10restapi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ip510 feih on 28-06-2017.
 */


//this class contains all of my modified annotations
public interface PostAPI {

    @GET("/posts/{id}/comments")
    Call<ArrayList<PostComment>> getPostComments(

            @Path("id") int postId

    );


}
