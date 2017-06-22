package l6.cb.com.l7fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CourseFragment extends Fragment {


    TextView tvName, tvCourse, tvLanguage;

    public CourseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //inflating the fragment
        View rootView = inflater.inflate(R.layout.fragment_course, container, false);

        tvName = (TextView) rootView.findViewById(R.id.tvTeacher);
        tvCourse = (TextView) rootView.findViewById(R.id.tvCourse);
        tvLanguage = (TextView) rootView.findViewById(R.id.tvLanguage);

        return rootView;

    }

    public void setData(String courseName, String courseTeacher, String courseLanguage) {

        tvCourse.setText(courseName);
        tvName.setText(courseTeacher);
        tvLanguage.setText(courseLanguage);

    }

}
