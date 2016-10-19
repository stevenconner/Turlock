package sigildesigns.turlock;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return "Landmarks";
        } else if (position == 1){
            return "Events";
        } else if (position == 2){
            return "Eating";
        } else{
            return "Shopping";
        }
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new LandmarksFragment();
        } else if (position == 1){
            return new EventsFragment();
        } else if (position == 2){
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
