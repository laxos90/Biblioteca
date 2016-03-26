package com.twu.biblioteca.util;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by user on 3/14/16.
 */
public class Reader {
    public static UserChoice getUserChoice() {
        Scanner reader = new Scanner(System.in);

        try {
            return UserChoice.values()[reader.nextInt()];
        } catch (InputMismatchException | ArrayIndexOutOfBoundsException ex) {
            return UserChoice.INVALID_OPTION;
        }
    }

    public static String getBookTitleFromUser() {
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }

    public static String getMovieNameFromUser() {
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }

    public static String getLibraryNumberFromUser() {
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }

    public static String getPasswordFromUser() {
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }
}
