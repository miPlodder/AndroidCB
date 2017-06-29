package l10.cb.com.l11restapicompleteapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import l10.cb.com.l11restapicompleteapp.R;
import l10.cb.com.l11restapicompleteapp.models.TodoPOJO;

/**
 * Created by ip510 feih on 30-06-2017.
 */

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

    Context context;
    ArrayList<TodoPOJO> todos;
    public static final String TAG = "TodoAdapter";

    public TodoAdapter(Context context, ArrayList<TodoPOJO> todos) {

        this.context = context;
        this.todos = todos;

    }

    public void updateTodo(ArrayList<TodoPOJO> todos){

        this.todos = todos;
        notifyDataSetChanged();
    }


    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = li.inflate(R.layout.todo_list_item,parent,false);

        return new TodoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {

        holder.tvTitle.setText(todos.get(position).getTitle());
        Log.d(TAG, "onBindViewHolder: isCheckedValue"+todos.get(position).getCompleted());
        holder.cb.setChecked(todos.get(position).getCompleted());

    }

    @Override
    public int getItemCount() {

        return todos.size();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {

        CheckBox cb;
        TextView tvTitle;

        public TodoViewHolder(View itemView) {
            super(itemView);

            cb = (CheckBox) itemView.findViewById(R.id.cb);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);

        }
    }
}
