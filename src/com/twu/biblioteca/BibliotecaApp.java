package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Welcome to The Bangalore Public Library");
        Library library = new Library();

        printBooks(library);
    }

    private static void printBooks(Library library) {
        for (Book book: library.getBooks()) {
            System.out.println(book);
        }
    }
}
