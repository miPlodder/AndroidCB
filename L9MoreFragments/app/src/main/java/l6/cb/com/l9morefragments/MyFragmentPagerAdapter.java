package l6.cb.com.l9morefragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ip510 feih on 22-06-2017.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private int fragCount = 0;
    public static final String TAG = "MyFragmentPagerAdapter";
    ArrayList<Fragment> fragmentList;

    //constructor for the FragmentPagerAdapter
    public MyFragmentPagerAdapter(FragmentManager fm, int count) {

        super(fm);
        this.fragCount = count;
        this.fragmentList = new ArrayList<>();
        for(int i = 0 ; i < count ; i++)
            this.fragmentList.add(i,null);

        Log.d(TAG, "MyFragmentPagerAdapter: " + this.fragmentList + this.fragmentList.size());
        Log.d(TAG, "MyFragmentPagerAdapter: ");

    }

    @Override
    //this method is called for every pager working
    //this method returns a fragment which will lay on the viewpager
    public Fragment getItem(int position) {

        Log.d(TAG, "getItem: ");

        if(fragmentList.get(position) != null){

            Log.d(TAG, "getItem: inside condition return fragment from arraylist");
            return fragmentList.get(position);
        }

        //making of fragment occurs here
        Fragment fragment = BlankFragment.newInstance(
                "Fragment :" + position,
                "Yet another fragment");

        Log.d(TAG, "getItem: outside condition adding fragment to arraylist"+fragmentList);
        Log.d(TAG, "getItem: "+position);
        fragmentList.set(position,fragment);



        return fragment;

        //github code
       /* int count = 0;
        Fragment fragment;
        Log.d("FRAG", "getItem: " + fragmentList.size());
        try {

            fragment = fragmentList.get(position);
        } catch (IndexOutOfBoundsException ioobe) {
            fragment = BlankFragment.newInstance(
                    "Fragment :" + position,
                    "Yet another fragment"
            );
            count++;
            fragmentList.add(position, fragment);
            Log.d(TAG, "getItem: " + "ADDED NEW INSIDE TRY");
        }


        if (fragment == null) {
            fragment = BlankFragment.newInstance(
                    "Fragment :" + position,
                    "Yet another fragment"
            );
            count++;
            Log.d(TAG, "getItem: " + "ADDED NEW INSIDE IF");
            fragmentList.add(position, fragment);
        }
        Log.d(TAG, "getItem: counter value is "+count);
        if(count == 0){

            Log.d(TAG, "getItem: "+"ADDED FROM ARRAYLIST");
        }
        return fragment;*/


    }

    @Override
    //this will just return the size of the fragments
    public int getCount() {
        Log.d(TAG, "getCount: ");
        return fragCount;
    }
}