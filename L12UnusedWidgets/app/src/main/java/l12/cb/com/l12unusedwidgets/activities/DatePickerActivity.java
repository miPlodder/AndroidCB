package l12.cb.com.l12unusedwidgets.activities;

import android.icu.util.Calendar;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import l12.cb.com.l12unusedwidgets.R;

public class DatePickerActivity extends AppCompatActivity {

    DatePicker dp;
    int year, month, day;
    private DatePicker.OnDateChangedListener onDateChangedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        findViewById(R.id.datePicker);


        //SDK_INT -> it is the device API Level
        //VERSION_CODES -> it is the minimmun required API Level for that API to work

        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Calendar calendar = Calendar.getInstance();
            day = calendar.get(Calendar.DAY_OF_WEEK);
            month = calendar.get(Calendar.MONTH);
            year = calendar.get(Calendar.YEAR);
        }
        else{

            Toast.makeText(this, "Lower API Device "+Build.VERSION.SDK_INT + "/" + Build.VERSION_CODES.N_MR1, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "KitKat ->" + Build.VERSION_CODES.KITKAT + "/ jellybeans -> " + Build.VERSION_CODES.JELLY_BEAN_MR2 + "/" + Build.VERSION_CODES.JELLY_BEAN , Toast.LENGTH_SHORT).show();
        }*/



        dp = (DatePicker) findViewById(R.id.datePicker);

        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(DatePickerActivity.this, "CLICKED", Toast.LENGTH_SHORT).show();

            }
        });


        // VERSION_CODES.O -> stands for API Level 26
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dp.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {

                    Toast.makeText(DatePickerActivity.this, i+"/"+i1+"/"+i2, Toast.LENGTH_SHORT).show();

                }
            });
        }
    }
    }

