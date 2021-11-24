package com.company.Security;

import com.company.Utils.Database;

public class Authentication {

    /**
     * Checks if a given username exists in the users database
     * @param username to be checked
     * @return true if exists otherwise false
     */
    public static boolean existUsername(String username) {
        return Database.existUsername(username);
    }

    /**
     * Password is checked against the Database class for its existence.
     * @param username to be checked
     * @param password to be checked
     * @return true if correct otherwise false
     */
    public static boolean isPasswordCorrect(String username, String password) {
        return Database.existPassword(username, password);
    }

    /**
     * Validate a password.
     * @param password to be validated
     * @return true if equals otherwise false
     */
    public static boolean validAdminPassword(String password) {
        return Database.validAdminPassword(password);
    }
}
