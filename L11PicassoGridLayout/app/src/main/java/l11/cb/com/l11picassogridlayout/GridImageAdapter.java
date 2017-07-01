package l11.cb.com.l11picassogridlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ip510 feih on 01-07-2017.
 */

public class GridImageAdapter extends RecyclerView.Adapter<GridImageAdapter.GridViewHolder>{

    ArrayList<ImagePOJO> images;
    Context context;
    public static final String TAG = "GridImageAdapter";

    public GridImageAdapter(ArrayList<ImagePOJO> images, Context context) {

        this.images = images;
        this.context = context;

    }

    public void updateGrid(ArrayList<ImagePOJO> images){

        this.images = images;
        notifyDataSetChanged();

    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.grid_layout_item,parent,false);

        return new GridViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {

        Picasso.with(context).load(images.get(position).getUrl())
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .resize(1000,200)
                .rotate(90)
                .into(holder.iv);

        Log.d(TAG, "onBindViewHolder: "+images);



    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder{

        ImageView iv;

        public GridViewHolder(View itemView) {
            super(itemView);

            iv = (ImageView) itemView.findViewById(R.id.ivImage);
        }
    }
}
