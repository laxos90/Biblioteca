package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by m on 3/11/2016.
 */
public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<Book>() {{
            add(new Book("A Thousand Splendid Suns", "Khaled Hosseini", 2006));
            add(new Book("Hunger Games", "Susane Collins", 2004));
            add(new Book("Two Towers", "JR Tolkien", 1994));
        }};
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
