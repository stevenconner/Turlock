package sigildesigns.turlock;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Fragment that displays Restaurant destinations in Turlock.
 */
public class RestaurantsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {

        View rootView = inflater.inflate(R.layout.entry_list, container, false);

        //Create a list of some of the good restaurants in Turlock
        final ArrayList<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(getString(R.string.restaurants_name_one), "http://www.juraspizza" +
                ".com/home" +
                ".aspx", R.drawable.restaurants_one));
        entries.add(new Entry(getString(R.string.restaurants_name_two), "https://www.yelp" +
                ".com/biz/silvas-taco-truck-turlock", R.drawable.restaurants_two));
        entries.add(new Entry(getString(R.string.restaurants_name_three), "https://www.yelp" +
                ".com/biz/gyros-and-more-turlock-2", R.drawable.restaurants_three));
        entries.add(new Entry(getString(R.string.restaurants_name_four), "http://www" +
                ".dustbowlbrewing" +
                ".com/taprooms/downtown/", R.drawable.restaurants_four));
        entries.add(new Entry(getString(R.string.restaurants_name_five), "http://www" +
                ".kravingkebabpizza.com", R
                .drawable.restaurants_five));
        entries.add(new Entry(getString(R.string.restaurants_name_six), "https://www.yelp" +
                ".com/biz/the-creperie-turlock", R
                .drawable.restaurants_six));
        entries.add(new Entry(getString(R.string.restaurants_name_seven), "https://www.yelp" +
                ".com/biz/manna-korean-cuisine-turlock", R.drawable.restaurants_seven));
        entries.add(new Entry(getString(R.string.restaurants_name_eight), "https://www.yelp" +
                ".com/biz/la-mo-cafe-turlock", R
                .drawable.restaurants_eight));
        entries.add(new Entry(getString(R.string.restaurants_name_nine), "https://www.yelp" +
                ".com/biz/crust-and-crumb-turlock", R.drawable.restaurants_nine));
        entries.add(new Entry(getString(R.string.restaurants_name_ten), "http://www.patoghdining" +
                ".com/", R.drawable
                .restaurants_ten));

        // Create an {@link EntryAdapter}, whose data source is a list of {@link entry}s. The
        // Adapter knows how to create list items for each item in the list.
        EntryAdapter adapter = new EntryAdapter(getActivity(), entries);

        // Find the {@link GridView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link GridView} with the view ID called gridview
        GridView gridView = (GridView) rootView.findViewById(R.id.gridview);

        // Make the {@link GridView} use the {@link EntryAdapter} we created above, so that the
        // {@link GridView} will display list items for each {@link Entry} in the list.
        gridView.setAdapter(adapter);

        // Set an onclick listener, this is going to open a specified URL when clicked by the user
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the position of the entry
                Entry entry = entries.get(position);

                // Create an intent to open a url
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(entry.getmLink()));
                startActivity(browserIntent);
            }
        });

        return rootView;
    }
}