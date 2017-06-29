package l10.cb.com.l11restapicompleteapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import l10.cb.com.l11restapicompleteapp.R;
import l10.cb.com.l11restapicompleteapp.adapters.TodoAdapter;
import l10.cb.com.l11restapicompleteapp.api.TodoAPI;
import l10.cb.com.l11restapicompleteapp.models.TodoPOJO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TodoActivity extends AppCompatActivity {

    RecyclerView rvTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        rvTodo = (RecyclerView) findViewById(R.id.rvTodo);
        rvTodo.setLayoutManager(new LinearLayoutManager(this));

        final TodoAdapter todoAdapter = new TodoAdapter(this,new ArrayList<TodoPOJO>());

        rvTodo.setAdapter(todoAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TodoAPI todoAPI = retrofit.create(TodoAPI.class);

        //now enqueue the api inside the RETROFIT
        todoAPI.getPosts().enqueue(new Callback<ArrayList<TodoPOJO>>() {
            @Override
            public void onResponse(Call<ArrayList<TodoPOJO>> call, Response<ArrayList<TodoPOJO>> response) {

                todoAdapter.updateTodo(response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<TodoPOJO>> call, Throwable t) {

            }
        });

    }
}
