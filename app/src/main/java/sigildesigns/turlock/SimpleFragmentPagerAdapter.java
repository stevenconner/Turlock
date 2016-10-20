package sigildesigns.turlock;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context getmContext;

    public SimpleFragmentPagerAdapter(FragmentManager fm, Context nContext) {
        super(fm);
        getmContext = nContext;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return getmContext.getString(R.string.category_1);
        } else if (position == 1) {
            return getmContext.getString(R.string.category_2);
        } else if (position == 2) {
            return getmContext.getString(R.string.category_3);
        } else {
            return getmContext.getString(R.string.category_4);
        }
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new LandmarksFragment();
        } else if (position == 1) {
            return new EventsFragment();
        } else if (position == 2) {
            return new RestaurantsFragment();
        } else {
            return new ShoppingFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}