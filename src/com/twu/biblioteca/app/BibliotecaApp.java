package com.twu.biblioteca.app;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.util.Printer;
import com.twu.biblioteca.util.Reader;
import com.twu.biblioteca.util.UserChoice;

public class BibliotecaApp {

    public static void main(String[] args) {
        UserChoice option;
        String bookTitle;
        String selectedMovie;
        User currentUser;
        boolean isSuccessfulCheckout;
        boolean isSuccessfulReturn;
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
            Printer.printMenuOptions();
            option = Reader.getUserChoice();

            switch (option) {
                case QUIT:
                    break;
                case LIST_BOOKS:
                    Printer.printBooks(library);
                    break;
                case CHECKOUT_BOOK:
                    Printer.askBookTitle("checkout");
                    bookTitle = Reader.getBookTitleFromUser();
                    isSuccessfulCheckout = library.checkoutBook(bookTitle);
                    Printer.notifyCheckoutStatus(isSuccessfulCheckout, "book");
                    break;
                case RETURN_BOOK:
                    Printer.askBookTitle("return");
                    bookTitle = Reader.getBookTitleFromUser();
                    isSuccessfulReturn = library.returnBook(bookTitle);
                    Printer.notifyReturnStatus(isSuccessfulReturn, "book");
                    break;
                case LIST_MOVIES:
                    Printer.printMovies(library);
                    break;
                case CHECKOUT_MOVIE:
                    Printer.askMovieName("checkout");
                    selectedMovie = Reader.getMovieNameFromUser();
                    isSuccessfulCheckout = library.checkoutMovie(selectedMovie);
                    Printer.notifyCheckoutStatus(isSuccessfulCheckout, "movie");
                    break;
                case RETURN_MOVIE:
                    Printer.askMovieName("return");
                    String movieNameFromUser = Reader.getMovieNameFromUser();
                    isSuccessfulReturn = library.returnMovie(movieNameFromUser);
                    Printer.notifyReturnStatus(isSuccessfulReturn, "movie");
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
