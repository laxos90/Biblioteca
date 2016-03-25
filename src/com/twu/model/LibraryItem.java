package com.twu.model;

/**
 * Created by user on 3/15/16.
 */
public abstract class LibraryItem {
    private boolean isAvailable;

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
