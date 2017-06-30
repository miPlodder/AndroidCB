package l10.cb.com.l11restapicompleteapp.api;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

import l10.cb.com.l11restapicompleteapp.models.UserPOJO;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ip510 feih on 30-06-2017.
 */

public interface UserAPI {

    @GET("/users")
    Call<ArrayList<UserPOJO>> getUsers();

}
