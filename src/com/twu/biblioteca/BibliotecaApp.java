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
                    String bookTitleFromUser = Reader.getBookTitleFromUser();
                    isSuccessfulReturn = returnBook(library, bookTitleFromUser);

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
                    isSuccessfulCheckout = false;

                    for (Movie movie : library.getMovies()) {
                        if (movie.isAvailable() && selectedMovie.equals(movie.getName())) {
                            movie.setAvailable(false);
                            isSuccessfulCheckout = true;
                            Printer.notifySuccessfulCheckout("movie");
                        }
                    }

                    if (!isSuccessfulCheckout) {
                        Printer.notifyUnsuccessfulCheckout("movie");
                    }
                    break;
                case 6:
                    Printer.printNameOfReturnedMovie();
                    String movieNameFromUser = Reader.getMovieNameFromUser();
                    isSuccessfulReturn = false;

                    for (Movie movie : library.getMovies()) {
                        if (!movie.isAvailable() && movieNameFromUser.equals(movie.getName())) {
                            movie.setAvailable(true);
                            isSuccessfulReturn = true;
                            Printer.notifyUserReturnWasSuccessful("movie");
                        }
                    }

                    if (!isSuccessfulReturn) {
                        Printer.notifyUserReturnWasUnsuccessful("movie");
                    }
                    break;
                default:
                    Printer.printInvalidOptionMessage();
                    break;
            }
        } while (option != 0);
    }

    private static boolean returnBook(Library library, String bookTitleFromUser) {
        boolean isSuccessfulReturn = false;
        for (Book book : library.getBooks()) {
            if (!book.isAvailable() && bookTitleFromUser.equals(book.getTitle())) {
                book.setAvailable(true);
                isSuccessfulReturn = true;
            }
        }
        return isSuccessfulReturn;
    }
    
}
