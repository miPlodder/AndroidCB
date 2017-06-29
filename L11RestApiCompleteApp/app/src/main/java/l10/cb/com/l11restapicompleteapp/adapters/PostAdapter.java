package l10.cb.com.l11restapicompleteapp.adapters;

import android.content.Context;
import android.sax.TextElementListener;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import l10.cb.com.l11restapicompleteapp.R;
import l10.cb.com.l11restapicompleteapp.models.PostPOJO;

/**
 * Created by ip510 feih on 29-06-2017.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    ArrayList<PostPOJO> posts;
    Context context;

    public PostAdapter(ArrayList<PostPOJO> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.post_list_item,parent,false);

        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {

        holder.tvTitle.setText(this.posts.get(position).getTitle());
        holder.tvBody.setText(this.posts.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvBody;

        public PostViewHolder(View itemView) {

            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvBody = (TextView)itemView.findViewById(R.id.tvBody);


        }
    }

}
