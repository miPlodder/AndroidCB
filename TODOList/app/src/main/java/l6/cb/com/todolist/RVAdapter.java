package l6.cb.com.todolist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//counter toast of number of items that have to be selected and position inside ViewHolder class
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {

    public static final String TAG = "RVAdapter";
    ArrayList<MyPojo> data;
    Context context;


    public RVAdapter(ArrayList<MyPojo> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = (ViewGroup) li.inflate(R.layout.tuple_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        myViewHolder.setFirstTime(true);
        Log.d(TAG, "onCreateViewHolder: ");
        return myViewHolder;
    }


    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        if (holder.getIsFirstTime()) {

            //this is first time when the object is created
            holder.setFirstTime(false);
            Log.d(TAG, "onBindViewHolder: INSIDE IF CONDITION" + position);

        }

        MyPojo myPojo = this.data.get(position);
        myPojo.setViewHolder(holder);
        holder.tvTopic.setText(myPojo.getTopic());
        holder.cbDel.setVisibility(View.INVISIBLE);
        holder.tvDetail.setText(myPojo.getDetail());
        holder.cbDel.setChecked(myPojo.getChecked());


        Log.d(TAG, "onBindViewHolder: " + position);
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                holder.cbDel.setVisibility(View.VISIBLE);
                Boolean toogleVal = data.get(position).getChecked();
                holder.cbDel.setChecked(!toogleVal);
                data.get(position).setChecked(!toogleVal);
                Log.d(TAG, "onLongClick: " + "ONCLICK");

                for(MyPojo myPojo : data){

                    Log.d(TAG, "onLongClick: "+ myPojo.topic);
                    myPojo.getViewHolder().cbDel.setVisibility(View.VISIBLE);

                }
                return true;
            }
        });

        ((CheckBox) holder.itemView.findViewById(R.id.cbDel)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                Boolean toggleVal = holder.cbDel.isChecked();
                data.get(position).setChecked(toggleVal);
                Log.d(TAG, "onCheckedChanged: ");
            }
        });

    }

    @Override
    public int getItemCount() {

        Log.d(TAG, "getItemCount: ");
        return this.data.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvTopic, tvDetail;
        CheckBox cbDel;
        View itemView;
        Boolean isFirstTime = false;

        public void setFirstTime(Boolean firstTime) {
            isFirstTime = firstTime;
        }

        public Boolean getIsFirstTime() {
            return isFirstTime;
        }

        public MyViewHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "MyViewHolder: ");

            tvTopic = (TextView) itemView.findViewById(R.id.tvTopic);
            tvDetail = (TextView) itemView.findViewById(R.id.tvDetail);
            cbDel = (CheckBox) itemView.findViewById(R.id.cbDel);
            this.itemView = itemView;

        }
    }
}