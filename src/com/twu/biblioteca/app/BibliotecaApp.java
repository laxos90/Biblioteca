package com.twu.biblioteca.app;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.util.Printer;
import com.twu.biblioteca.util.Reader;
import com.twu.biblioteca.enums.UserChoice;

import static com.twu.biblioteca.enums.LibraryItemName.*;
import static com.twu.biblioteca.enums.UserLibraryAction.*;

public class BibliotecaApp {

    public static void main(String[] args) {
        UserChoice option;
        User currentUser;
        Library library = new Library();

        Printer.printWelcomeMessage();
        Printer.askLibraryNumber();
        String libraryNumber = Reader.getLibraryNumberFromUser();
        currentUser = library.getUserWithLibraryNumber(libraryNumber);

        Printer.askPassword();
        String password = Reader.getPasswordFromUser();

        if (currentUser == null || !isValidUserPassword(currentUser, password)) {
            System.out.println( "Invalid user credentials!");
            System.exit(2);
        }

        do {
            String bookTitle, movieName;
            boolean isSuccessfulCheckout, isSuccessfulReturn;

            Printer.printMenuOptions();
            option = Reader.getUserChoice();

            switch (option) {
                case QUIT:
                    break;
                case LIST_BOOKS:
                    Printer.printBooks(library);
                    break;
                case CHECKOUT_BOOK:
                    Printer.askBookTitle(CHECKOUT);
                    bookTitle = Reader.getBookTitleFromUser();
                    isSuccessfulCheckout = library.checkoutBook(bookTitle);
                    Printer.notifyCheckoutStatus(isSuccessfulCheckout, BOOK);
                    break;
                case RETURN_BOOK:
                    Printer.askBookTitle(RETURN);
                    bookTitle = Reader.getBookTitleFromUser();
                    isSuccessfulReturn = library.returnBook(bookTitle);
                    Printer.notifyReturnStatus(isSuccessfulReturn, BOOK);
                    break;
                case LIST_MOVIES:
                    Printer.printMovies(library);
                    break;
                case CHECKOUT_MOVIE:
                    Printer.askMovieName(CHECKOUT);
                    movieName = Reader.getMovieNameFromUser();
                    isSuccessfulCheckout = library.checkoutMovie(movieName);
                    Printer.notifyCheckoutStatus(isSuccessfulCheckout, MOVIE);
                    break;
                case RETURN_MOVIE:
                    Printer.askMovieName(RETURN);
                    String movieNameFromUser = Reader.getMovieNameFromUser();
                    isSuccessfulReturn = library.returnMovie(movieNameFromUser);
                    Printer.notifyReturnStatus(isSuccessfulReturn, MOVIE);
                    break;
                case USER_INFORMATION:
                    System.out.println(currentUser);
                    break;
                default:
                    Printer.printInvalidOptionMessage();
                    break;
            }
        } while (option != UserChoice.QUIT);
    }

    private static boolean isValidUserPassword(User currentUser, String password) {
        return password.equals(currentUser.getPassword());
    }
}
