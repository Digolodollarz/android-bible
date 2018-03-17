package tech.diggle.apps.bible.bhaibheridzvenemuchishona.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import tech.diggle.apps.bible.bhaibheridzvenemuchishona.home.Testament.TestamentFragment;
import tech.diggle.apps.bible.bhaibheridzvenemuchishona.home.devotional.DevotionalFragment;

/**
 * Created by Diggle E. Gonese on 17/3/2018.
 */

public class HomeFragmentPageAdapter extends FragmentPagerAdapter {
    private static final String TAG = HomeFragmentPageAdapter.class.getSimpleName();
    private static final int FRAGMENT_COUNT = 4;
    public HomeFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new DevotionalFragment();
            case 1:
                return new TestamentFragment();
            case 2:
                return new TestamentFragment();
            case 3:
                return new TestamentFragment();
        }
        return null;
    }
    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Devotional";
            case 1:
                return "New Testament";
            case 2:
                return "Old Testament";
            case 3:
                return "The Rest";
        }
        return null;
    }
}
