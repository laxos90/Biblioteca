package com.twu.biblioteca;

import sun.font.TrueTypeFont;

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


            switch (option) {
                case 0: break;
                case 1:
                    printBooks(library);
                    break;
                case 2:
                    askBookTitle();
                    selectedBook = getBookTitleFromUser();
                    boolean isSuccessfulCheckout = false;

                    for (Book book: library.getBooks()) {
                        if (book.isAvailable() && selectedBook.equals(book.getTitle())) {
                            book.setAvailable(false);
                            isSuccessfulCheckout = true;
                            notifyUserSuccessfulCheckout();
                        }
                    }

                    if (!isSuccessfulCheckout) {
                        notifyUnsuccessfulCheckout();
                    }
                    break;
                case 3:
                    printTitleOfReturnedBook();
                    String bookTitleFromUser = getBookTitleFromUser();
                    boolean isSuccessfulReturn = false;


                    for (Book book: library.getBooks()) {
                        if (!book.isAvailable() && bookTitleFromUser.equals(book.getTitle())) {
                            book.setAvailable(true);
                            isSuccessfulReturn = true;
                            notifyUserBookWasReturned();
                        }
                    }
                    if (!isSuccessfulReturn) {
                        notifyUserReturnWasUnsuccessful();
                    }
                    break;
                default:
                    printInvalidOptionMessage();
                    break;
            }
        } while (option != 0);
    }

    private static void notifyUserReturnWasUnsuccessful() {
        System.out.println("That is not a valid book to return.");
    }

    private static void notifyUserBookWasReturned() {
        System.out.println("Thank you for returning the book.");
    }

    private static void printTitleOfReturnedBook() {
        System.out.println("Enter the title of the book you want to return.");
    }

    private static void notifyUnsuccessfulCheckout() {
        System.out.println("That book is not available.");
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
        System.out.println("3 - Return a book");
        System.out.println("Press 0 to quit!");
    }

    private static void printWelcomeMessage() {
        System.out.println("Welcome to The Bangalore Public Library");
    }

    private static void printBooks(Library library) {
        System.out.println("Title\t\t\t\t\t\tAuthor\t\t\t\tPublished Year");
        for (Book book: library.getBooks()) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
        System.out.println();
    }
}
