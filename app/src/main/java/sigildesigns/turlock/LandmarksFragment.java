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
 * Fragment that displays Landmarks located in Turlock.
 */
public class LandmarksFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {

        View rootView = inflater.inflate(R.layout.entry_list, container, false);

        // Create a list of the landmarks in Turlock
        final ArrayList<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(getString(R.string.landmarks_name_one), "http://www.roadsideamerica" +
                ".com/tip/41944", R
                .drawable.landmark_one));
        entries.add(new Entry(getString(R.string.landmarks_name_two), "http://www" +
                ".carnegieartsturlock.org/", R
                .drawable.landmark_two));
        entries.add(new Entry(getString(R.string.landmarks_name_three), "http://local" +
                ".townsquarepublications" +
                ".com/california/turlock_old-10/02/topic.html", R.drawable.landmark_three));
        entries.add(new Entry(getString(R.string.landmarks_name_four), "http://www.stancofair" +
                ".com/fair-history-2/", R.drawable.landmark_four));
        entries.add(new Entry(getString(R.string.landmarks_name_five), "http://www" +
                ".turlockdowntown.com/", R
                .drawable.landmark_five));
        entries.add(new Entry(getString(R.string.landmarks_name_six), "https://ths-turlockusd-ca" +
                ".schoolloop.com/",
                R.drawable.landmark_six));
        entries.add(new Entry(getString(R.string.landmarks_name_seven),
                "http://turlockhistoricalsociety.org/", R
                .drawable.landmark_seven));

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

    public LandmarksFragment() {
        // Required empty public constructor
    }
}