package com.twu.biblioteca;

import java.util.InputMismatchException;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        int option;
        String selectedBook;
        String selectedMovie;
        boolean isSuccessfulCheckout;

        Printer.printWelcomeMessage();

        do {
            Printer.printMenuOptions();

            try {
                option = Reader.getUserOption();
            } catch (InputMismatchException ex) {
                option = 7;
            }

            switch (option) {
                case 0:
                    break;
                case 1:
                    Printer.printBooks(library);
                    break;
                case 2:
                    Printer.askBookTitle();
                    selectedBook = Reader.getBookTitleFromUser();
                    isSuccessfulCheckout = false;

                    for (Book book : library.getBooks()) {
                        if (book.isAvailable() && selectedBook.equals(book.getTitle())) {
                            book.setAvailable(false);
                            isSuccessfulCheckout = true;
                            Printer.notifyUserSuccessfulBookCheckout();
                        }
                    }

                    if (!isSuccessfulCheckout) {
                        Printer.notifyUnsuccessfulBookCheckout();
                    }
                    break;
                case 3:
                    Printer.printTitleOfReturnedBook();
                    String bookTitleFromUser = Reader.getBookTitleFromUser();
                    boolean isSuccessfulReturn = false;

                    for (Book book : library.getBooks()) {
                        if (!book.isAvailable() && bookTitleFromUser.equals(book.getTitle())) {
                            book.setAvailable(true);
                            isSuccessfulReturn = true;
                            Printer.notifyUserBookWasReturned();
                        }
                    }

                    if (!isSuccessfulReturn) {
                        Printer.notifyUserReturnWasUnsuccessful();
                    }
                    break;
                case 4:
                    Printer.printMovies(library);
                    break;
                case 5:
                    Printer.askMovieName();
                    selectedMovie = Reader.getMovieNameFromUser();
                    isSuccessfulCheckout = false;

                    for (Movie movie : library.getMovies()) {
                        if (movie.isAvailable() && selectedMovie.equals(movie.getName())) {
                            movie.setAvailable(false);
                            isSuccessfulCheckout = true;
                            Printer.notifyUserSuccessfulMovieCheckout();
                        }
                    }

                    if (!isSuccessfulCheckout) {
                        Printer.notifyUnsuccessfulMovieCheckout();
                    }
                    break;
                case 6:
                    break;
                default:
                    Printer.printInvalidOptionMessage();
                    break;
            }
        } while (option != 0);
    }

}
