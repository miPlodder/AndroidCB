package l10.cb.com.l11restapicompleteapp.api;

import java.util.ArrayList;

import l10.cb.com.l11restapicompleteapp.models.CommentPOJO;
import l10.cb.com.l11restapicompleteapp.models.PostPOJO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ip510 feih on 30-06-2017.
 */

public interface PostAPI {

    @GET("/posts")
    Call<ArrayList<PostPOJO>> getPosts();

    //by indicates that we are filtering the data
    @GET("/posts")
    Call<ArrayList<PostPOJO>> getPostsByUserId(
            @Query("userId") int userId
    );

    interface CommentAPI {
        //of indicates that i'm using different resources of my API
        @GET("/posts/{id}/comments")
        Call<ArrayList<CommentPOJO>> getCommentsByPostId(

                @Path("id") int postId

        );
    }

}
