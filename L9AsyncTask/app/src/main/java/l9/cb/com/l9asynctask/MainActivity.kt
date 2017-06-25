package l9.cb.com.l9asynctask

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

//this class import helps us to use xml id as variables in java code, so no need to fvbi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //this companion object means that static object
    companion object {

        //val stands for value which means its value cannot be changed
        //var stands for variable which means its value can be changed
        val TAG = "MainActivity" ;

    }

    //IN kotlin xml files ID can be used as refernce variables to the VIEWS in the activity
    //internal var tv: TextView

    //? in bundle variable
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.activity_main) ;

        //tv = findViewById(R.id.tv) as TextView

        (findViewById(R.id.btn1) as Button).setOnClickListener {


            //there is no new keyword here
            val myAsyncTask = MyAsyncTask(tv) ;
            myAsyncTask.execute(10) ;

        }


        //if interface has one method only
        //then we can simply use curly brackets and write code for that one method
        (findViewById(R.id.btn2) as Button).setOnClickListener {

            //get and setter methods of the pojao class can be used as written below
            tv.text = "WOW" ;

            var myStr : String = tv.text as String ; //as String -> is used to typecast

            myStr = "hello" + myStr ;
            Log.d(TAG,myStr);


        }
    }


}
