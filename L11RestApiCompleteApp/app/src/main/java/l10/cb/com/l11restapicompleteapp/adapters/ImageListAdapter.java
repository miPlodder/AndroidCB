package l10.cb.com.l11restapicompleteapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import l10.cb.com.l11restapicompleteapp.R;
import l10.cb.com.l11restapicompleteapp.activities.PhotoActivity;
import l10.cb.com.l11restapicompleteapp.models.ImageListPOJO;

/**
 * Created by ip510 feih on 30-06-2017.
 */

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ImageListViewHolder> {

    ArrayList<ImageListPOJO> imageList;
    Context context;

    public ImageListAdapter(ArrayList<ImageListPOJO> imageList, Context context) {
        this.imageList = imageList;
        this.context = context;
    }

    public void updateImageList(ArrayList<ImageListPOJO> imageList){

        this.imageList = imageList;
        notifyDataSetChanged();
    }

    @Override
    public ImageListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.image_list_item, parent, false);

        return new ImageListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ImageListViewHolder holder, int position) {

        final ImageListPOJO thisItem = imageList.get(position);

        holder.tvTitle.setText(thisItem.getTitle());
        Picasso.with(context).load(thisItem.getThumbnailUrl()).into(holder.ivThumbnail);

        //add a set onclick listener here
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, PhotoActivity.class);
                i.putExtra("title",thisItem.getTitle());
                i.putExtra("url",thisItem.getUrl());
                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return this.imageList.size();
    }


    class ImageListViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        ImageView ivThumbnail;
        View itemView;

        public ImageListViewHolder(View itemView) {
            super(itemView);

            this.itemView = itemView;
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            ivThumbnail = (ImageView) itemView.findViewById(R.id.ivThumbnail);

        }
    }

}
