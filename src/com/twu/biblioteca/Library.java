package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by m on 3/11/2016.
 */
public class Library {
    private static String bookFileName = "books.txt";
    private static String movieFileName = "movies.txt";
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();

    public Library() {
        readBooks();
        readMovies();
    }

    private void readBooks() {
        try {
            File myFile = new File(bookFileName);
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] information = line.split(",");
                books.add(new Book(information[0].trim(), information[1].trim(), Integer.parseInt(information[2].trim())));
            }

            reader.close();
        } catch (Exception ex) {
            System.out.println("There was a problem reading data.");
            System.exit(1);
        }
    }

    private void readMovies() {
        try {
            File myFile = new File(movieFileName);
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] information = line.split(",");
                movies.add(new Movie(information[0].trim(), Integer.parseInt(information[1].trim()),
                        information[2].trim(), information[3].trim()));
            }

            reader.close();
        } catch (Exception ex) {
            System.out.println("There was a problem reading data.");
            System.exit(1);
        }
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

    public boolean checkoutMovie(String movieName) {
        boolean isSuccessfulCheckout = false;
        for (Movie movie : movies) {
            if (movie.isAvailable() && movieName.equals(movie.getName())) {
                movie.setAvailable(false);
                isSuccessfulCheckout = true;
            }
        }
        return isSuccessfulCheckout;
    }

    public boolean returnMovie(String movieName) {
        boolean isSuccessfulReturn = false;
        for (Movie movie : movies) {
            if (!movie.isAvailable() && movieName.equals(movie.getName())) {
                movie.setAvailable(true);
                isSuccessfulReturn = true;
            }
        }
        return isSuccessfulReturn;
    }
}
