package l10.cb.com.l11restapicompleteapp.api;

import java.util.ArrayList;

import l10.cb.com.l11restapicompleteapp.models.TodoPOJO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ip510 feih on 30-06-2017.
 */

public interface TodoAPI {

    @GET("/todos")
    Call<ArrayList<TodoPOJO>> getTodos();


    @GET("/todos")
    //by is used here because we are filtering a particular API
    Call<ArrayList<TodoPOJO>> getTodosByUserId(
        @Query("userId") int userId
    );


}
