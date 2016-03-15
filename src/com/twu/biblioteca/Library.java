package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by m on 3/11/2016.
 */
public class Library {
    private ArrayList<Book> books;
    private ArrayList<Movie> movies;

    public Library() {
        books = new ArrayList<Book>() {{
            add(new Book("A Thousand Splendid Suns", "Khaled Hosseini", 2006));
            add(new Book("Hunger Games", "Susane Collins", 2004));
            add(new Book("Two Towers", "JR Tolkien", 1994));
        }};
        movies = new ArrayList<Movie>() {{
            add(new Movie("Pulp Fiction", 1979, "Tarantino", "8.9"));
            add(new Movie("The Godfather", 1975, "Coppola", "9.2"));
            add(new Movie("The Departed", 2006, "Scorsese", "8.5"));
        }};
    }

    public ArrayList<Book> getBooks() { return books; }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public boolean checkoutBook(String bookTitle) {
        boolean isSuccessfulCheckout = false;

        for (Book book : books) {
            if (book.isAvailable() && bookTitle.equals(book.getTitle())) {
                book.setAvailable(false);
                isSuccessfulCheckout = true;
            }
        }
        return isSuccessfulCheckout;
    }

    public boolean returnBook(String bookTitle) {
        boolean isSuccessfulReturn = false;
        for (Book book : books) {
            if (!book.isAvailable() && bookTitle.equals(book.getTitle())) {
                book.setAvailable(true);
                isSuccessfulReturn = true;
            }
        }
        return isSuccessfulReturn;
    }

}
