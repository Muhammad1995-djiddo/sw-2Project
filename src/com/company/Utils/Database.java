package com.company.Utils;

import com.company.Users.Admin;
import com.company.Users.Customer;
import com.company.Users.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Database: Stores used information.
 * <p>In charge with functions that deals with the database.
 * @author Ntajugumba Guy Cherubin 20160379
 * @version 1.0
 */
public class Database {

    // Store all users and their usernames.
    private static Map<String, User> users = new HashMap<>();
    private static Map<String, Admin> admins = new HashMap<>();
    private static Map<String, String> userTypes = new HashMap<>();

    /**
     * Constructs a Database object
     * <p>add an administrator user
     * <p>Initialize a UI object
     */
    public Database() {

    }

    /**
     * Checks if a given username exists in the users database
     * @param username to be checked
     * @return true if exists otherwise false
     */
    public static boolean existUsername(String username) {

        return users.containsKey(username);
    }

    /**
     * Check if a given password is correct for the corresponding username
     * @param username to be checked
     * @param password password to be checked
     * @return true if correct otherwise false
     */
    public static boolean existPassword(String username, String password) {
        if (users.containsKey(username)) {
            return users.get(username).getPassword().equals(password);
        }
        return false;
    }

    public static User getUserInfo(String username) {
        return null;
    }

    /**
     * Validate a password in the database
     * @param password to be validated
     * @return true if equals otherwise false
     */
    public static boolean validAdminPassword(String password) {
        return admins.get("admin").getPassword().equals(password);
    }

    /**
     * Add a new user object to the users database
     * @param username user's username
     * @param user user to add
     * @param profileType user profile
     */
    public static void addUser(String username, User user, String profileType) {
        users.put(username, user);
        userTypes.put(username, profileType);

    }
}
