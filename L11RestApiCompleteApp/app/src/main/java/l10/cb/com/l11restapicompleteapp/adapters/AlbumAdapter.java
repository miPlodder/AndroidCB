package l10.cb.com.l11restapicompleteapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import l10.cb.com.l11restapicompleteapp.R;
import l10.cb.com.l11restapicompleteapp.activities.ImageListActivity;
import l10.cb.com.l11restapicompleteapp.models.AlbumPOJO;

/**
 * Created by ip510 feih on 30-06-2017.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    ArrayList<AlbumPOJO> albums;
    Context context;

    public AlbumAdapter(ArrayList<AlbumPOJO> albums, Context context) {
        this.albums = albums;
        this.context = context;
    }

    public void updateAlbumList(ArrayList<AlbumPOJO> albums){

        this.albums = albums;
        notifyDataSetChanged();
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = li.inflate(R.layout.album_list_item,parent,false);

        return new AlbumViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, final int position) {

        holder.tvTitle.setText(this.albums.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, ImageListActivity.class);
     /*           i.putExtra("title",albums.get(position).getTitle());*/
                  i.putExtra("albumId",albums.get(position).getId());
                context.startActivity(i);


            }
        });

    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        View itemView;

        public AlbumViewHolder(View itemView) {
            super(itemView);

            this.itemView = itemView;
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);

        }
    }
}