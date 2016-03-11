package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        printWelcomeMessageAndMenuOptions();

        Scanner reader = new Scanner(System.in);
        int option = reader.nextInt();

        if (option == 1) {
            printBooks(library);
        }
    }

    private static void printWelcomeMessageAndMenuOptions() {
        System.out.println("Welcome to The Bangalore Public Library");
        System.out.println("Choose an option");
        System.out.println("1 - List available books");
    }

    private static void printBooks(Library library) {
        for (Book book: library.getBooks()) {
            System.out.println(book);
        }
    }
}
