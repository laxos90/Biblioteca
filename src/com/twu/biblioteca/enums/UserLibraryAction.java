package com.twu.biblioteca.enums;

/**
 * Created by m on 3/31/2016.
 */
public enum UserLibraryAction {
    CHECKOUT("checkout"), RETURN("return");

    private String action;

    UserLibraryAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return action;
    }
}
