package com.twu.biblioteca;

import com.twu.model.Library;
import com.twu.model.LibraryItem;

import java.util.ArrayList;

/**
 * Created by user on 3/14/16.
 */
public class Printer {
    static void printWelcomeMessage() {
        System.out.println("Welcome to the Bangalore Public Library");
    }

    static void printMenuOptions() {
        System.out.println("Choose an option");
        System.out.println("1 - List available books");
        System.out.println("2 - Checkout a book");
        System.out.println("3 - Return a book");
        System.out.println("4 - List available movies");
        System.out.println("5 - Checkout a movie");
        System.out.println("6 - Return a movie");
        System.out.println("7 - Display user information");
        System.out.println("Enter 0 to quit!");
    }

    static void printInvalidOptionMessage() {
        System.out.println("Invalid Option! Please select a valid option:");
    }

    static void askBookTitle(String action) {
        System.out.println("Type the title of the book you want to " + action + ":");
    }

    static void askMovieName(String action) {
        System.out.println("Type the name of the movie you want to " + action + ":");
    }

    static void notifyCheckoutStatus(boolean isSuccessfulCheckout, String element) {
        if (isSuccessfulCheckout) {
            System.out.println("Thank you! Enjoy the " + element + ".");
        } else {
            System.out.println("That " + element + " is not available.");
        }
    }

    static void notifyReturnStatus(boolean isSuccessfulReturn, String element) {
        if (isSuccessfulReturn) {
            System.out.println("Thank you for returning the " + element + ".");
        } else {
            System.out.println("That is not a valid " + element + " to return.");
        }
    }

    static void printBooks(Library library) {
        System.out.println("Title\t\t\t\t\t\tAuthor\t\t\t\tPublished Year");
        printLibraryItems(library.getBooks());
    }

    static void printMovies(Library library) {
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

}
