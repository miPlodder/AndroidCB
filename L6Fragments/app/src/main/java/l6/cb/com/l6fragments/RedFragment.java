package l6.cb.com.l6fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class RedFragment extends Fragment {


    public RedFragment() {
        // Required empty public constructor
    }


    @Override
    //this method returns the view for fragment
    //and can also make dynamic changes to the fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rv = inflater.inflate(R.layout.fragment_red, container, false);
        //Toast.makeText(, "", Toast.LENGTH_SHORT).show();
        return rv;
    }

}
