package l6.cb.com.l6fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DynamicFragment extends AppCompatActivity {

    Button btnRed, btnBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        btnRed = (Button) findViewById(R.id.btnRed);
        btnBlue = (Button) findViewById(R.id.btnBlue);

        //in android we have 2 fragment class support one and another class
        //we should use one at a time and
        //support is mostly prefered as it can run on earlier devices

        //our activity class also inherits a fragmentActivity class
        final FragmentManager fragMan = getSupportFragmentManager();

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction fragTrans = fragMan.beginTransaction();
                //prepare for changes
                fragTrans.add(R.id.flFragmentContainer, new BlueFragment(), "blue");
                //execute the changes
                fragTrans.commit();


            }
        });

        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction fragTrans = fragMan.beginTransaction();
                fragTrans.add(R.id.flFragmentContainer, new RedFragment(), "red");
                fragTrans.commit();


            }
        });

    }
}
