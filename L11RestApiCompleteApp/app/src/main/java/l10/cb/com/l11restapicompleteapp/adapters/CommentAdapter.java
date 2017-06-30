package l10.cb.com.l11restapicompleteapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import l10.cb.com.l11restapicompleteapp.R;
import l10.cb.com.l11restapicompleteapp.models.CommentPOJO;

/**
 * Created by ip510 feih on 30-06-2017.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    ArrayList<CommentPOJO> comments ;
    Context context ;

    public CommentAdapter(ArrayList<CommentPOJO> comments, Context context) {
        this.comments = comments;
        this.context = context;
    }

    public void updateCommentList(ArrayList<CommentPOJO> comments ){

        this.comments = comments;
        notifyDataSetChanged();
    }
    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.comment_list_item,parent,false);

        return new CommentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {

        CommentPOJO thisItem = comments.get(position);

        holder.tvName.setText(thisItem.getName());
        holder.tvBody.setText(thisItem.getBody());
        holder.tvEmail.setText(thisItem.getEmail());

    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    class CommentViewHolder extends RecyclerView.ViewHolder{

        TextView tvName, tvEmail, tvBody;

        public CommentViewHolder(View itemView) {
            super(itemView);

            this.tvName = (TextView) itemView.findViewById(R.id.tvName);
            this.tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);
            this.tvBody = (TextView) itemView.findViewById(R.id.tvBody);
        }
    }

}
