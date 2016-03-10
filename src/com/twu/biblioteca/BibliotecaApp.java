package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Welcome to The Bangalore Public Library");
        ArrayList<Book> books = new ArrayList<Book>() {{
            add(new Book("A Thousand Splendid Suns", "Khaled Hosseini", 2006));
            add(new Book("Hunger Games", "Susane Collins", 2004));
            add(new Book("Two Towers", "JR Tolkien", 1994));
        }};

        for (Book book: books) {
            System.out.println(book);
        }
    }
}
