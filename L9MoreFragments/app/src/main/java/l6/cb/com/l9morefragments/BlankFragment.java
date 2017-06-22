package l6.cb.com.l9morefragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BlankFragment extends Fragment {

    private static final String KEY1 = "param1";
    private static final String KEY2 = "param2";
    public static final String TAG = "BlankFragment" ;
    
    private String mVal1;
    private String mVal2;


    public BlankFragment() {
        Log.d(TAG, "BlankFragment: ");
        // Required empty public constructor
    }

    //this static method is taken to take variables from external activity
    public static BlankFragment newInstance(String param1, String param2) {

        Log.d(TAG, "newInstance: ");
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(KEY1, param1);
        args.putString(KEY2, param2);

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    //this method will set the object data variables
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){

            Log.d(TAG, "onCreate: "+savedInstanceState.toString());

        }
        if (getArguments() != null) {

            mVal1 = getArguments().getString(KEY1);
            mVal2 = getArguments().getString(KEY2);
        }

        Log.d(TAG, "onCreate: " + mVal1);



    }

    @Override
    //making of the fragment occurs here
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView: " + mVal1);

        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);

        ((TextView) rootView.findViewById(R.id.tvCount))
                .setText(mVal1);
        ((TextView) rootView.findViewById(R.id.tvSomeText))
                .setText(mVal2);

        return rootView;
    }

}
