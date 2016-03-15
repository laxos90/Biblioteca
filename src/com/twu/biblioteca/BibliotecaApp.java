package com.twu.biblioteca;

import java.util.InputMismatchException;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        int option;
        String selectedBook;

        Printer.printWelcomeMessage();

        do {
            Printer.printMenuOptions();

            try {
                option = Reader.getUserOption();
            } catch (InputMismatchException ex) {
                option = 5;
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
                    boolean isSuccessfulCheckout = false;

                    for (Book book : library.getBooks()) {
                        if (book.isAvailable() && selectedBook.equals(book.getTitle())) {
                            book.setAvailable(false);
                            isSuccessfulCheckout = true;
                            Printer.notifyUserSuccessfulCheckout();
                        }
                    }

                    if (!isSuccessfulCheckout) {
                        Printer.notifyUnsuccessfulCheckout();
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
                default:
                    Printer.printInvalidOptionMessage();
                    break;
            }
        } while (option != 0);
    }

}
