package sustainablehealthsolutionsllc.bitecounter;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Created by john on 3/20/15.
 */
public class ScreenSlidePagerActivity extends FragmentActivity {

    //the number of pages
    private static final int NUM_PAGES = 5;

    /**
     * THe pager widget, which handles animation and allows swiping horizontal
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides pages to the view pager
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        //instatiate a ViewPager and a PagerAdapter
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());

        mPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            //Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem());
        }
    }

    /**
     * a simple pager adapter that represents 5 ScreenSlidePagerFragment objects, in
     * sequence
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        public ScreenSlidePagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new Fragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}

