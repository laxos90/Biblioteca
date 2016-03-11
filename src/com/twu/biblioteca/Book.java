package com.twu.biblioteca;

/**
 * Created by m on 3/10/2016.
 */
public class Book {
    private String title;
    private String author;
    private int publishedYear;
    private boolean isAvailable;

    public Book(String title, String author, int publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.isAvailable = true;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishedYear(short publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return title + " - " + author + " - " + publishedYear;
    }
}
