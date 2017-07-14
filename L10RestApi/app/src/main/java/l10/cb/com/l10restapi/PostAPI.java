package l10.cb.com.l10restapi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

    @GET("/posts/")
    Call<ArrayList<Post>> getPosts(

    );

    @GET("/users")
    Call<ArrayList<UserDetail>> getUserDetails();


    //not work as it will return JSONOBJECT
    //whereas RETROFIT is used to get only JSONARRAY
    @GET("/users/{id}")
    Call<ArrayList<UserDetail>> getUserDetail(

            @Path("id") int id

    );

    @GET("/posts/{id}")
    Call<Post> getPost(
            @Path("id") int postId
    );


}
