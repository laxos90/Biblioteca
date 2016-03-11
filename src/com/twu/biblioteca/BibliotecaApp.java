package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Welcome to The Bangalore Public Library");
        Library library = new Library();

        for (Book book: library.getBooks()) {
            System.out.println(book);
        }
    }
}
