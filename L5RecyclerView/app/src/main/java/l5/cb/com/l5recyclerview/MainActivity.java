package l5.cb.com.l5recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

//alt + ins -> pojo class getter, setter, constructor methods
//ctrl + o -> to add abstract methods of the parent class
//ctrl + p -> to view all the parameters of the function

public class MainActivity extends AppCompatActivity {

    EditText etName, etAge;
    Button btnAdd;
    RecyclerView rvList;
    ArrayList<StudentDetails> studentDetails = generator();
    RecycleAdapter recycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        rvList = (RecyclerView) findViewById(R.id.rvList);

        //we have to set layout manager for recycler view
        //we can give linear, grid and other layouts also
        rvList.setLayoutManager(new LinearLayoutManager(this));
        recycleAdapter = new RecycleAdapter(this,studentDetails);
        rvList.setAdapter(recycleAdapter);

        //add hook to the button for EVENT onClickActionListener
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addStudent();

            }
        });

    }

    static ArrayList<StudentDetails> generator(){

        ArrayList<StudentDetails> rv = new ArrayList<>();

        //add data to the arraylist here
        //this method is static which are the first thing which is made when the class is made

        return rv;
    }

    public void addStudent(){

        String name, age ;
        name = etName.getText().toString();
        age = etAge.getText().toString();

        this.studentDetails.add(new StudentDetails(name, age));
        recycleAdapter.notifyDataSetChanged();

    }
}