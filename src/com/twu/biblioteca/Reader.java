package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by user on 3/14/16.
 */
public class Reader {
    public static int getUserOption() {
        Scanner reader = new Scanner(System.in);
        return reader.nextInt();
    }

    public static String getBookTitleFromUser() {
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }

    public static String getMovieNameFromUser() {
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }
}
