package com.twu.biblioteca.util;

/**
 * Created by m on 3/31/2016.
 */
public enum LibraryItemName {
    BOOK("book"), MOVIE("movie");

    private String name;

    LibraryItemName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
