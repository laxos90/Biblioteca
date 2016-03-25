package com.twu.model;

/**
 * Created by user on 3/16/16.
 */
public class User {
    private String name;
    private String emailAddress;
    private String phoneNumber;
    private String libraryNumber;
    private String password;

    public User(String name, String emailAddress, String phoneNumber, String userLibraryNumber, String userPassword) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.libraryNumber = userLibraryNumber;
        this.password = userPassword;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setLibraryNumber(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Name:\t" + name + "\n" +
                "Email:\t" + emailAddress + "\n" +
                "Phone:\t" + phoneNumber + "\n";
    }

}

