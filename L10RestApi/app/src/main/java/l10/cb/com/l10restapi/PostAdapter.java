package l10.cb.com.l10restapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ip510 feih on 27-06-2017.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    ArrayList<Post> postList;
    Context context;
    private OnItemClickListener oicl;

    interface OnItemClickListener {

        void OnItemClick(int position);

    }

    public void setOnItemClickListener(OnItemClickListener oicl) {

        this.oicl = oicl;
    }

    void updateData(ArrayList<Post> postList){

        this.postList = postList ;
        notifyDataSetChanged();

    }

    public PostAdapter(ArrayList<Post> postList, Context context) {

        this.postList = postList;
        this.context = context;

    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.post_item, parent, false);
        PostViewHolder postViewHolder = new PostViewHolder(view);


        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, final int position) {

        final Post thisPost = postList.get(position);

        holder.title.setText(thisPost.getTitle());
        holder.body.setText(thisPost.getBody());

        View item = holder.itemView ;
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                oicl.OnItemClick(thisPost.getId());

            }
        });

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    //used so that fvbi methods is not called again and again as its a costly operation
    class PostViewHolder extends RecyclerView.ViewHolder {

        TextView title, body;

        public PostViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.tvtitle);
            body = (TextView) itemView.findViewById(R.id.tvbody);


        }
    }
}
