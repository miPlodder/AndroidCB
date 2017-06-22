package l6.cb.com.l7fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    private static final String ARG_CNAME = "Course";
    private static final String ARG_TEACHER = "Teacher";
    private static final String ARG_LANG = "Language";
    private static final String ARG_CID = "courseId";
    public static final String TAG = "BlankFragment";

    private String mCourse = "nothing Yet";
    private String mTeacher = "nothing Yet";
    private String mLanguage = "nothing Yet";
    private int mCid = 0;

    OnStudentAddListener osal ;

    //interface member methods and variables are static by defaul
    //interface inside a class is static by default
    interface OnStudentAddListener{
        void addStudent(int cId);
    }

    public void setOnStudentAddListener(OnStudentAddListener osal){

        this.osal = osal ;
    }

    public BlankFragment() {
        // Required empty public constructor
        Log.d(TAG, "BlankFragment: ");
    }

    public static BlankFragment newInstance(Course course, int cId){
        return newInstance(course,cId,null);
    }

    //this static
    public static BlankFragment newInstance(Course course, int cId,OnStudentAddListener osal)
    {

        Log.d(TAG, "newInstance1: inside newInstance commit");
        BlankFragment fragment = new BlankFragment();


        Bundle args = new Bundle();
        args.putString(ARG_CNAME, course.getCourseName());
        args.putString(ARG_TEACHER, course.getCourseTeacher());
        args.putString(ARG_LANG, course.getCourseLanguage());
        args.putInt(ARG_CID,cId);

        //adding a bag of Bundle to the fragments
        fragment.setArguments(args);
        fragment.setOnStudentAddListener(osal);

        Log.d(TAG, "newInstance2: inside newInstance commit end");
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*

        getActivity();
        getActivity();
*/
        Log.d(TAG, "onCreate: ");
        if (getArguments() != null) {

            this.mCourse = getArguments().getString(ARG_CNAME);
            this.mLanguage = getArguments().getString(ARG_LANG);
            this.mTeacher = getArguments().getString(ARG_TEACHER);
            this.mCid = getArguments().getInt(ARG_CID);

        }
    }

    @Override
    //-----------------------------------------------------------------------same thread by this approach, otherwise 2 threads
    //-----------------------------------------------------------------------bundle use
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_course, container, false);

        Log.d(TAG, "onCreateView: ");
        ((TextView) v.findViewById(R.id.tvCourse)).setText(mCourse);
        ((TextView) v.findViewById(R.id.tvLanguage)).setText(mLanguage);
        ((TextView) v.findViewById(R.id.tvTeacher)).setText(mTeacher);

        //here i want my fragment to make changes to external activity
        ((Button)v.findViewById(R.id.btnAdd)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //this approach will cause Security Issues as we are accessing other class function in other class
                //((MainActivity)getActivity()).incrementStudentCounter(mCid);
                Log.d(TAG, "onClick: innermethod");
                if(osal != null)
                    osal.addStudent(mCid);


            }
        });
        return v;
    }

}
