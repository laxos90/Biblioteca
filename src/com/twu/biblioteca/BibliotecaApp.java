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
                    isSuccessfulCheckout = checkoutMovie(library, selectedMovie);

                    if (isSuccessfulCheckout) {
                        Printer.notifySuccessfulCheckout("movie");
                    } else {
                        Printer.notifyUnsuccessfulCheckout("movie");
                    }
                    break;
                case 6:
                    Printer.printNameOfReturnedMovie();
                    String movieNameFromUser = Reader.getMovieNameFromUser();
                    isSuccessfulReturn = returnMovie(library, movieNameFromUser);

                    if (isSuccessfulReturn) {
                        Printer.notifyUserReturnWasSuccessful("movie");
                    } else {
                        Printer.notifyUserReturnWasUnsuccessful("movie");
                    }
                    break;
                default:
                    Printer.printInvalidOptionMessage();
                    break;
            }
        } while (option != 0);
    }

    private static boolean checkoutMovie(Library library, String selectedMovie) {
        boolean isSuccessfulCheckout = false;
        for (Movie movie : library.getMovies()) {
            if (movie.isAvailable() && selectedMovie.equals(movie.getName())) {
                movie.setAvailable(false);
                isSuccessfulCheckout = true;
            }
        }
        return isSuccessfulCheckout;
    }

    private static boolean returnMovie(Library library, String movieNameFromUser) {
        boolean isSuccessfulReturn = false;
        for (Movie movie : library.getMovies()) {
            if (!movie.isAvailable() && movieNameFromUser.equals(movie.getName())) {
                movie.setAvailable(true);
                isSuccessfulReturn = true;
            }
        }
        return isSuccessfulReturn;
    }

}
