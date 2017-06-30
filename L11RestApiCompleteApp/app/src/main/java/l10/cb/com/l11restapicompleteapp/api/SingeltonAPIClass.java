package l10.cb.com.l11restapicompleteapp.api;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ip510 feih on 30-06-2017.
 */

public class SingeltonAPIClass {

    private static SingeltonAPIClass singeltonAPI;
    public static final String TAG = "SingeltonAPIClass";

    private AlbumAPI albumAPI;
    private UserAPI userAPI;
    private TodoAPI todoAPI;
    private PostAPI postAPI;
    private ImageListAPI imageListAPI;
    private PostAPI.CommentAPI commentAPI;

    private SingeltonAPIClass() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.albumAPI = retrofit.create(AlbumAPI.class);
        this.userAPI = retrofit.create(UserAPI.class);
        this.todoAPI = retrofit.create(TodoAPI.class);
        this.postAPI = retrofit.create(PostAPI.class);
        this.commentAPI = retrofit.create(PostAPI.CommentAPI.class);
        this.imageListAPI = retrofit.create(ImageListAPI.class);

    }

    public static SingeltonAPIClass createInstance() {

        if (singeltonAPI == null)
            singeltonAPI = new SingeltonAPIClass();

        return singeltonAPI;
    }

    public AlbumAPI getAlbumAPI() {
        return albumAPI;
    }

    public UserAPI getUserAPI() {
        return userAPI;
    }

    public TodoAPI getTodoAPI() {
        return todoAPI;
    }

    public PostAPI getPostAPI() {
        return postAPI;
    }

    public ImageListAPI getImageListAPI() {
        return imageListAPI;
    }

  public PostAPI.CommentAPI getCommentAPI() {
        return commentAPI;
    }
}
