package sigildesigns.turlock;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Takes an arraylist as input and outputs into a gridview
 */

public class EntryAdapter extends ArrayAdapter<Entry> {

    public EntryAdapter(Activity context, ArrayList<Entry> entries) {
        super(context, 0, entries);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if existing view is being reused, otherwise inflate the view
        View gridItemView = convertView;
        if (gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,
                    false);
        }

        // Get the {@link entries} object located at this position in the list
        Entry currentEntry = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID name_of_entry
        TextView entryTextView = (TextView) gridItemView.findViewById(R.id.name_of_entry);

        // Get the name of the entry from the current entry object and set on the variable
        entryTextView.setText(currentEntry.getmName());

        // Find the ImageView in the list_item.xml layout with the ID image_of_entry
        ImageView entryImageView = (ImageView) gridItemView.findViewById(R.id.image_of_entry);

        // If the word has an image associated with it set the image and set visibility to visible
        // Otherwise set the visibility to GONE
        if (currentEntry.hasImage()) {
            // Get the image resource ID from the current entry and set to the imageView
            entryImageView.setImageResource(currentEntry.getmImageResourceId());

            // Set the image to visible
            entryImageView.setVisibility(View.VISIBLE);
        } else {
            // Else set the visibility to GONE
            entryImageView.setVisibility(View.GONE);
        }
        return gridItemView;
    }
}