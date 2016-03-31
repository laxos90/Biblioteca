package com.twu.biblioteca.util;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.LibraryItem;

import java.util.ArrayList;

/**
 * Created by user on 3/14/16.
 */
public class Printer {
    public static void printWelcomeMessage() {
        System.out.println("Welcome to the Bangalore Public Library");
    }

    public static void askLibraryNumber() {
        System.out.print("Enter your library number: ");
    }

    public static void askPassword() {
        System.out.print("Enter your password: ");
    }

    public static void printMenuOptions() {
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

    public static void printInvalidOptionMessage() {
        System.out.println("Invalid Option! Please select a valid option:");
    }

    public static void askBookTitle(UserLibraryAction action) {
        System.out.println("Type the title of the book you want to " + action + ":");
    }

    public static void askMovieName(UserLibraryAction action) {
        System.out.println("Type the name of the movie you want to " + action + ":");
    }

    public static void notifyCheckoutStatus(boolean isSuccessfulCheckout, LibraryItemName libraryItem) {
        if (isSuccessfulCheckout) {
            System.out.println("Thank you! Enjoy the " + libraryItem + ".");
        } else {
            System.out.println("That " + libraryItem + " is not available.");
        }
    }

    public static void notifyReturnStatus(boolean isSuccessfulReturn, LibraryItemName libraryItem) {
        if (isSuccessfulReturn) {
            System.out.println("Thank you for returning the " + libraryItem + ".");
        } else {
            System.out.println("That is not a valid " + libraryItem + " to return.");
        }
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

}
