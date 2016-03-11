package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        printWelcomeMessage();

        int option;

        do {
            printMenuOptions();
            option = getUserOption();

            if (option == 1) {
                printBooks(library);
            } else if (option != 0) {
                printInvalidOptionMessage();
            }
        } while (option != 0);
    }

    private static void printInvalidOptionMessage() {
        System.out.println("Invalid Option! Please select a valid option");
    }

    private static int getUserOption() {
        Scanner reader = new Scanner(System.in);
        return reader.nextInt();
    }

    private static void printMenuOptions() {
        System.out.println("Choose an option");
        System.out.println("1 - List available books");
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
