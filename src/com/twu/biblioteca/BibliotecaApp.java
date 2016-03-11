package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        printWelcomeMessage();

        int option;
        String selectedBook;

        do {
            printMenuOptions();
            option = getUserOption();

            if (option == 1) {
                printBooks(library);
            } else if (option == 2) {
                askBookTitle();
                selectedBook = getBookTitleFromUser();

                for (Book book: library.getBooks()) {
                    if (selectedBook.equals(book.getTitle())) {
                        notifyUserSuccessfulCheckout();
                        library.getBooks().remove(book);
                    }
                }

            } else if (option != 0) {
                printInvalidOptionMessage();
            }
        } while (option != 0);
    }

    private static void notifyUserSuccessfulCheckout() {
        System.out.println("Thank you! Enjoy the book");
    }

    private static void askBookTitle() {
        System.out.println("Type the title of the book you want to checkout");
    }

    private static void printInvalidOptionMessage() {
        System.out.println("Invalid Option! Please select a valid option");
    }

    private static int getUserOption() {
        Scanner reader = new Scanner(System.in);
        return reader.nextInt();
    }

    private static String getBookTitleFromUser() {
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }

    private static void printMenuOptions() {
        System.out.println("Choose an option");
        System.out.println("1 - List available books");
        System.out.println("2 - Checkout a book");
        System.out.println("Press 0 to quit!");
    }

    private static void printWelcomeMessage() {
        System.out.println("Welcome to The Bangalore Public Library");
    }

    private static void printBooks(Library library) {
        for (Book book: library.getBooks()) {
            System.out.println(book);
        }
    }
}
