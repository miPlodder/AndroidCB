//this recycleAdapter onCreateView method is called every time when new data is added to the list
//but now called while we are scrolling up and down

package l5.cb.com.l5recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ip510 feih on 17-06-2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.myViewHolderBucket> {

    public static final String TAG = "RecyclerView";
    Context context;
    ArrayList<StudentDetails> studentDetails;
    int layoutId ;

    public RecycleAdapter(Context context, ArrayList<StudentDetails> studentDetails) {


        Log.d(TAG, "RecycleAdapter: constructor");
        this.context = context;
        this.studentDetails = studentDetails;

    }

    @Override
    //called for the first 6 tuples and
    //after these 6 tuples are created, then
    //these are used again and again (RECYCLED)
    //int viewType is the logic which is to be used when we have multiple layouts for our lists
    public myViewHolderBucket onCreateViewHolder(ViewGroup parent, int viewType) {


        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Log.d(TAG, "onCreateViewHolder: ");

        //never attach to root -> it adds the list to the xml file -> which can cause crashing of application
        //as in a layout, not more than one view can have same ID

        if(viewType == 1){

            //left
            layoutId = R.layout.student_tuple_item;

        }
        else{

            //right
            layoutId = R.layout.student_tuple_item_right;

        }


        parent = (ViewGroup) li.inflate(layoutId, parent, false);
        myViewHolderBucket myViewHolderBucket = new myViewHolderBucket(parent, layoutId);

        return myViewHolderBucket;
    }


    @Override
    //this method is called when we need to have more than one layout for our LIST
    //this method is called by ANDROID OS to get the value of itemView
    public int getItemViewType(int position) {
        int layoutID = 1;

        if(this.studentDetails.get(position).getName().length() > 7){

            layoutID = 0 ;

        }

        return layoutID;
    }

    @Override
    //this method is called every time,
    // but after onCreateViewHolder Class
    //writing text to the view work is done here
    public void onBindViewHolder(myViewHolderBucket holder, int position) {

        Log.d(TAG, "onBindViewHolder: ");
        StudentDetails student = this.studentDetails.get(position);
        holder.tvName.setText(student.getName());
        holder.tvAge.setText(student.getAge());

    }

    //this method just returns the size of the ARRAYLIST
    @Override
    public int getItemCount() {

        Log.d(TAG, "getItemCount: ");
        return this.studentDetails.size();

    }


    //this class is for tags which I used while working with BaseAdapter Class
    //so that we dont have to findViewById again and again
    //this class is called after onCreateViewHolder method
    class myViewHolderBucket extends RecyclerView.ViewHolder {

        public TextView tvName, tvAge;


        public myViewHolderBucket(View itemView, int layoutID) {

            super(itemView);
            Log.d(TAG, "myViewHolderBucket: ");

            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvAge = (TextView) itemView.findViewById(R.id.tvAge);

            if(layoutID == R.layout.student_tuple_item) {

                tvName.setTextSize(25);
                tvAge.setTextSize(15);
                tvName.setTextColor(Color.BLUE);
                //tvAge.setTextColor(Color.blue(122222));

            }else{

                tvName.setTextSize(35);
                tvAge.setTextSize(25);
                tvName.setTextColor(Color.GREEN);
                //tvAge.setTextColor(Color.green(123));
            }


        }


            }
}