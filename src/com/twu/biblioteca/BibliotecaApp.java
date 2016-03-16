package com.twu.biblioteca;

import java.util.InputMismatchException;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        int option;
        String bookTitle;
        String selectedMovie;
        boolean isSuccessfulCheckout;
        boolean isSuccessfulReturn;
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
                    Printer.askBookTitle();
                    bookTitle = Reader.getBookTitleFromUser();
                    isSuccessfulCheckout = library.checkoutBook(bookTitle);

                    if (isSuccessfulCheckout) {
                        Printer.notifySuccessfulCheckout("book");
                    } else {
                        Printer.notifyUnsuccessfulCheckout("book");
                    }
                    break;
                case 3:
                    Printer.printTitleOfReturnedBook();
                    bookTitle = Reader.getBookTitleFromUser();
                    isSuccessfulReturn = library.returnBook(bookTitle);

                    if (isSuccessfulReturn) {
                        Printer.notifyUserReturnWasSuccessful("book");
                    } else {
                        Printer.notifyUserReturnWasUnsuccessful("book");
                    }
                    break;
                case 4:
                    Printer.printMovies(library);
                    break;
                case 5:
                    Printer.askMovieName();
                    selectedMovie = Reader.getMovieNameFromUser();
                    isSuccessfulCheckout = library.checkoutMovie(selectedMovie);

                    if (isSuccessfulCheckout) {
                        Printer.notifySuccessfulCheckout("movie");
                    } else {
                        Printer.notifyUnsuccessfulCheckout("movie");
                    }
                    break;
                case 6:
                    Printer.printNameOfReturnedMovie();
                    String movieNameFromUser = Reader.getMovieNameFromUser();
                    isSuccessfulReturn = library.returnMovie(movieNameFromUser);

                    if (isSuccessfulReturn) {
                        Printer.notifyUserReturnWasSuccessful("movie");
                    } else {
                        Printer.notifyUserReturnWasUnsuccessful("movie");
                    }
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
