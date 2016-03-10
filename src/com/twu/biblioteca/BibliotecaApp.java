package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Welcome to The Bangalore Public Library");
        ArrayList<String> books = new ArrayList<String>() {{
            add("A Thousand Splendid Suns");
            add("Hunger Games");
            add("Two Towers");
        }};

        for (String book: books) {
            System.out.println(book);
        }
    }
}
