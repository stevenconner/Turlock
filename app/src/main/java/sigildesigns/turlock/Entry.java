package sigildesigns.turlock;

/**
 * {@Link Entry} represents an entry in one of the categories for the user to view.
 */

public class Entry {

    // Name of the entry
    private String mName;

    // Link to more information of the entry
    private String mLink;

    // Image associated with the entry, initially set to -1
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    // Public Constructor to create an entry with a name and a description only.
    public Entry(String nameOfEntry, String linkOfEntry) {
        mName = nameOfEntry;
        mLink = linkOfEntry;
    }

    // Public Constructor to create an entry with a name, description, and image file.
    public Entry(String nameOfEntry, String linkOfEntry, int imageResourceOfEntry) {
        mName = nameOfEntry;
        mLink = linkOfEntry;
        mImageResourceId = imageResourceOfEntry;
    }

    // Create Getters for the class
    public String getmName() {
        return mName;
    }

    public String getmLink() {
        return mLink;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    // Returns whether or not there is an image for the entry
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}