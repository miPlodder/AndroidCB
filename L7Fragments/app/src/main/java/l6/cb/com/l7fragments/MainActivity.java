package l6.cb.com.l7fragments;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        final ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("Pandora", "Arnav", "Java"));
        courses.add(new Course("Launchpad", "Prateek", "C++"));
        courses.add(new Course("Crux", "Sumeet", "Java"));

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        final FragmentManager fragMan = getSupportFragmentManager();

        //making OnClickListener Class Implementation
        View.OnClickListener courseButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Course course = null;
                int cId = 0;

                switch (view.getId()) {

                    case R.id.btn1:
                        cId = 0;
                        course = courses.get(cId);
                        break;
                    case R.id.btn2:
                        cId = 1;
                        course = courses.get(cId);
                        break;
                    case R.id.btn3:
                        cId = 2;
                        course = courses.get(cId);
                        break;

                }

                //this way we wont be able to send our data to the BlankFragment
                //and use that to set text on Fragment Layout
              /* fragMan.beginTransaction()
                       .replace(R.id.flFragContainer, new BlankFragment())
                       .commit();
                */

                //sending osal as parameter is called as CALLBACK METHOD
                BlankFragment.OnStudentAddListener osal = new BlankFragment.OnStudentAddListener() {
                    @Override
                    public void addStudent(int cId) {

                        incrementStudentCounter(cId);

                    }

                };


                //after we commit the changes then Fragment LifeCycle starts..........................
                Log.d(TAG, "onClick: before commit");
                fragMan.beginTransaction().replace(R.id.flFragContainer, BlankFragment.newInstance(course, cId, osal))
                        .commit();


                Log.d(TAG, "onClick: after commit");
            }
        };


        btn1.setOnClickListener(courseButtonListener);
        btn2.setOnClickListener(courseButtonListener);
        btn3.setOnClickListener(courseButtonListener);

    }

    private void incrementStudentCounter(int cId) {

        switch (cId) {

            case 0:
                ((TextView) findViewById(R.id.tv0)).setText(
                        String.valueOf(Integer.valueOf(((TextView) findViewById(R.id.tv0)).getText().toString()) + 1));
                break;
            case 1:
                ((TextView) findViewById(R.id.tv1)).setText(
                        String.valueOf(Integer.valueOf(((TextView) findViewById(R.id.tv1)).getText().toString()) + 1));
                break;
            case 2:

                ((TextView) findViewById(R.id.tv2)).setText(
                        String.valueOf(Integer.valueOf(((TextView) findViewById(R.id.tv2)).getText().toString()) + 1));
                break;

        }

    }
}
