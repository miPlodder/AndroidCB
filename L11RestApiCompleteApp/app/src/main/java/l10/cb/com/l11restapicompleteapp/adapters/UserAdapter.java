package l10.cb.com.l11restapicompleteapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import l10.cb.com.l11restapicompleteapp.R;
import l10.cb.com.l11restapicompleteapp.activities.PostActivity;
import l10.cb.com.l11restapicompleteapp.activities.TodoActivity;
import l10.cb.com.l11restapicompleteapp.models.UserPOJO;

/**
 * Created by ip510 feih on 29-06-2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    //data
    ArrayList<UserPOJO> users;
    //context to get layout inflator object
    Context context;
    public static final String TAG = "UserAdapter";

    public UserAdapter(ArrayList<UserPOJO> users, Context context) {

        this.users = users;
        this.context = context;

    }

    public void updateList(ArrayList<UserPOJO> users) {

        this.users = users;
        Log.d(TAG, "updateList: ");
        notifyDataSetChanged();

    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.user_list_item, parent, false);

        return new UserViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: holder -> " + holder);
        Log.d(TAG, "onBindViewHolder: useral ->" + this.users);

        holder.tvUserName.setText(this.users.get(position).getUsername());
        holder.tvName.setText(this.users.get(position).getName());
        holder.tvEmail.setText(this.users.get(position).getEmail());
        holder.tvTel.setText(this.users.get(position).getPhone());

        holder.btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, PostActivity.class);
                i.putExtra("userId", users.get(position).getId());
                context.startActivity(i);

            }
        });

        holder.btnTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, TodoActivity.class);
                i.putExtra("userId", users.get(position).getId());
                context.startActivity(i);

            }
        });


    }


    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: ");
        return this.users.size();
    }

   /* @Override
    public void onClick(View view) {

        Intent i ;

        switch (view.getId()){

            case R.id.btnPost :
                i = new Intent(context, PostActivity.class);
                Button b = (Button)view;
                i.putExtra("userId","");
                context.startActivity(i);
                Toast.makeText(context, "BTNPOST", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnTodo :
                Toast.makeText(context, "BTNPOST", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cvUserItem :
                Toast.makeText(context,"You just clicked on Item" , Toast.LENGTH_SHORT).show();
                break;
        }



    }*/

    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView tvUserName, tvName, tvTel, tvEmail;
        View itemView;
        Button btnPost, btnTodo;

        public UserViewHolder(View itemView) {

            super(itemView);

            this.itemView = itemView;
            Log.d(TAG, "UserViewHolder: ");
            tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvTel = (TextView) itemView.findViewById(R.id.tvPhone);
            tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);

            btnPost = (Button) itemView.findViewById(R.id.btnPost);
            btnTodo = (Button) itemView.findViewById(R.id.btnTodo);

        }
    }
}
