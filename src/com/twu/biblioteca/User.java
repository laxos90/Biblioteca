package com.twu.biblioteca;

/**
 * Created by user on 3/16/16.
 */
public class User {
    private String name;
    private String emailAddress;
    private String phoneNumber;

    public User(String name, String emailAdress, String phoneNumber) {
        this.name = name;
        this.emailAddress = emailAdress;
        this.phoneNumber = phoneNumber;
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

