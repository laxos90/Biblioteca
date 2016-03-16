package com.twu.biblioteca;

import java.util.InputMismatchException;

public class BibliotecaApp {

    public static void main(String[] args) {
        int option;
        String bookTitle;
        String selectedMovie;
        boolean isSuccessfulCheckout;
        boolean isSuccessfulReturn;
        Library library = new Library();
        User user = new User("Diego Vaca", "laxos90@gmail.com", "0995235323");

        Printer.printWelcomeMessage();

        do {
            Printer.printMenuOptions();

            try {
                option = Reader.getUserOption();
            } catch (InputMismatchException ex) {
                option = 8;
            }

            switch (option) {
                case 0:
                    break;
                case 1:
                    Printer.printBooks(library);
                    break;
                case 2:
                    Printer.askBookTitle("checkout");
                    bookTitle = Reader.getBookTitleFromUser();
                    isSuccessfulCheckout = library.checkoutBook(bookTitle);
                    Printer.notifyCheckoutStatus(isSuccessfulCheckout, "book");
                    break;
                case 3:
                    Printer.askBookTitle("return");
                    bookTitle = Reader.getBookTitleFromUser();
                    isSuccessfulReturn = library.returnBook(bookTitle);
                    Printer.notifyReturnStatus(isSuccessfulReturn, "book");
                    break;
                case 4:
                    Printer.printMovies(library);
                    break;
                case 5:
                    Printer.askMovieName("checkout");
                    selectedMovie = Reader.getMovieNameFromUser();
                    isSuccessfulCheckout = library.checkoutMovie(selectedMovie);
                    Printer.notifyCheckoutStatus(isSuccessfulCheckout, "movie");
                    break;
                case 6:
                    Printer.askMovieName("return");
                    String movieNameFromUser = Reader.getMovieNameFromUser();
                    isSuccessfulReturn = library.returnMovie(movieNameFromUser);
                    Printer.notifyReturnStatus(isSuccessfulReturn, "movie");
                    break;
                case 7:
                    System.out.println(user);
                    break;
                default:
                    Printer.printInvalidOptionMessage();
                    break;
            }
        } while (option != 0);
    }
}
