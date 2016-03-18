package com.twu.biblioteca;

/**
 * Created by user on 3/16/16.
 */
public class User {
    private String name;
    private String emailAddress;
    private String phoneNumber;
    private String userLibraryNumber;
    private String userPassword;

    public User(String name, String emailAdress, String phoneNumber) {
        this.name = name;
        this.emailAddress = emailAdress;
        this.phoneNumber = phoneNumber;
    }

    public User(String userLibraryNumber, String userPassword) {
        this.userLibraryNumber = userLibraryNumber;
        this.userPassword = userPassword;
    }

    public String getUserLibraryNumber() {
        return userLibraryNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserLibraryNumber(String userLibraryNumber) {
        this.userLibraryNumber = userLibraryNumber;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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

