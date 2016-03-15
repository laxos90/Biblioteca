package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by user on 3/14/16.
 */
public class Printer {
    public static void printWelcomeMessage() {
        System.out.println("Welcome to The Bangalore Public Library");
    }

    public static void notifyUserReturnBookWasUnsuccessful() {
        System.out.println("That is not a valid book to return.");
    }

    public static void notifyUserBookWasReturned() {
        System.out.println("Thank you for returning the book.");
    }

    public static void printTitleOfReturnedBook() {
        System.out.println("Enter the title of the book you want to return.");
    }

    public static void notifyUnsuccessfulBookCheckout() {
        System.out.println("That book is not available.");
    }

    public static void notifyUserSuccessfulBookCheckout() {
        System.out.println("Thank you! Enjoy the book");
    }

    public static void askBookTitle() {
        System.out.println("Type the title of the book you want to checkout");
    }

    public static void printInvalidOptionMessage() {
        System.out.println("Invalid Option! Please select a valid option");
    }

    public static void printMenuOptions() {
        System.out.println("Choose an option");
        System.out.println("1 - List available books");
        System.out.println("2 - Checkout a book");
        System.out.println("3 - Return a book");
        System.out.println("4 - List available movies");
        System.out.println("5 - Checkout a movie");
        System.out.println("6 - Return a movie");
        System.out.println("Press 0 to quit!");
    }

    public static void printBooks(Library library) {
        System.out.println("Title\t\t\t\t\t\tAuthor\t\t\t\tPublished Year");
        printLibraryItems(library.getBooks());
    }

    public static void printMovies(Library library) {
        System.out.println("Name\t\t\t\t\t\tYear\t\t\tDirector\t\t\t\tRating");
        printLibraryItems(library.getMovies());
    }

    private static void printLibraryItems(ArrayList<? extends LibraryItem> libraryItems) {
        for (LibraryItem libraryItem: libraryItems) {
            if (libraryItem.isAvailable()) {
                System.out.println(libraryItem);
            }
        }
        System.out.println();
    }

    public static void askMovieName() {
        System.out.println("Type the name of the movie you want to checkout");
    }

    public static void notifyUserSuccessfulMovieCheckout() {
        System.out.println("Thank you! Enjoy the movie");
    }

    public static void notifyUnsuccessfulMovieCheckout() {
        System.out.println("That movie is not available.");
    }

    public static void printNameOfReturnedMovie() {
        System.out.println("Enter the name of the movie you want to return.");
    }

    public static void notifyUserMovieWasReturned() {
        System.out.println("Thank you for returning the movie.");
    }

    public static void notifyUserReturnMovieWasUnsuccessful() {
        System.out.println("That is not a valid movie to return.");
    }
}
