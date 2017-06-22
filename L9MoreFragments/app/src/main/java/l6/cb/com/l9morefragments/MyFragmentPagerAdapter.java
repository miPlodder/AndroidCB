package l6.cb.com.l9morefragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.util.Log;

import java.util.List;

/**
 * Created by ip510 feih on 22-06-2017.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private int fragCount = 0;
    List<BlankFragment> b ;
    public static final String TAG = "MyFragmentPagerAdapter";
    
    public MyFragmentPagerAdapter(FragmentManager fm, int count) {
        super(fm);
        this.fragCount = count;
        Log.d(TAG, "MyFragmentPagerAdapter: ");
    }

    @Override
    public Fragment getItem(int position) {
        Log.d(TAG, "getItem: ");
        return BlankFragment.newInstance(
                "Fragment :" + position,
                "Yet another fragment"
        );
    }

    @Override
    public int getCount() {
        Log.d(TAG, "getCount: ");
        return fragCount;
    }
}