package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        Printer.printWelcomeMessage();

        int option;
        String selectedBook;

        do {
            Printer.printMenuOptions();
            option = getUserOption();


            switch (option) {
                case 0:
                    break;
                case 1:
                    Printer.printBooks(library);
                    break;
                case 2:
                    Printer.askBookTitle();
                    selectedBook = getBookTitleFromUser();
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
                    String bookTitleFromUser = getBookTitleFromUser();
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
                default:
                    Printer.printInvalidOptionMessage();
                    break;
            }
        } while (option != 0);
    }

    private static int getUserOption() {
        Scanner reader = new Scanner(System.in);
        return reader.nextInt();
    }

    private static String getBookTitleFromUser() {
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }

}
