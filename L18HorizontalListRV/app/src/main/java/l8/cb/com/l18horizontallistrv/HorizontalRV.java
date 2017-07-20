package l8.cb.com.l18horizontallistrv;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class HorizontalRV extends RecyclerView.Adapter<HorizontalRV.mViewHolder> {


    ArrayList<String> data = new ArrayList<>();
    Context context;

    public HorizontalRV(ArrayList<String> data, Context context) {

        this.data = data;
        this.context = context;

    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = li.inflate(R.layout.horizontal_layout_item,parent,false);

        return new mViewHolder(v);
    }

    @Override
    public void onBindViewHolder(mViewHolder holder, int position) {

        holder.tv.setText(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class mViewHolder extends RecyclerView.ViewHolder {

        EditText et1, et2;
        TextView tv;

        public mViewHolder(View itemView) {
            super(itemView);

            et1 = (EditText) itemView.findViewById(R.id.et1);
            et2 = (EditText) itemView.findViewById(R.id.et2);
            tv = (TextView) itemView.findViewById(R.id.tv);

        }
    }
}
