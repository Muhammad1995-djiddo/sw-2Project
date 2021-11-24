package com.company.Utils;

import com.company.UIs.UI;
import com.company.Users.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private static Map<String, String> ridesRequests = new HashMap<>();
    private static Map<String, List<String>> favoriteAreas = new HashMap<>();
    private static Map<String, List<Integer>> driverRatings = new HashMap<>();


    /**
     * Constructs a Database object
     * <p>add an administrator user
     * <p>Initialize a UI object
     */
    public Database() {
        admins.put("admin", new Admin("admin123"));
        Customer customer = new Customer("chi", "01228331194", "ghrbn@gmail.com", "abcd12345", State.ACTIVE);
        Customer customer1 = new Customer("chichi", "01228331195", "gchrbn@gmail.com", "abcd12345", State.ACTIVE);
        Driver driver = new Driver("taximan", "01125449102", "djiddo23@gmail.com", "45699854456312", "452136522589", "edcba123", State.ACTIVE);
        Driver driver1 = new Driver("djiddo", "01125449101", "djiddo@gmail.com", "45699854456312", "452136522589", "edcba123", State.INACTIVE);

        users.put("chi", customer);
        userTypes.put("chi", "Customer");
        users.put("chichi", customer1);
        userTypes.put("chichi", "Customer");

        users.put("taximan", driver);
        userTypes.put("taximan", "Driver");
        favoriteAreas.put("taximan", new ArrayList<String>());
        favoriteAreas.get("taximan").add("Dokki");
        favoriteAreas.get("taximan").add("New Cairo");
        favoriteAreas.get("taximan").add("Lebanon");
        driverRatings.put("taximan", new ArrayList<>());
        driverRatings.get("taximan").add(3);
        driverRatings.get("taximan").add(2);
        driverRatings.get("taximan").add(4);
        driverRatings.get("taximan").add(5);
        driverRatings.get("taximan").add(1);

        users.put("djiddo", driver1);
        userTypes.put("djiddo", "Driver");
        favoriteAreas.put("djiddo", new ArrayList<String>());
        favoriteAreas.get("djiddo").add("6th October");
        favoriteAreas.get("djiddo").add("Madinat");
        favoriteAreas.get("djiddo").add("Nasser");
        driverRatings.put("djiddo", new ArrayList<>());
        driverRatings.get("djiddo").add(3);
        driverRatings.get("djiddo").add(1);
        driverRatings.get("djiddo").add(2);
        driverRatings.get("djiddo").add(1);
        driverRatings.get("djiddo").add(3);
        new UI();
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
        return users.get(username);
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

    public static Driver addRideRequest(String source, String destination) {
        ridesRequests.put(source, destination);
        for (Map.Entry<String, String> entry: userTypes.entrySet()) {
            if (entry.getValue().equals("Driver")) {
                return (Driver) users.get(entry.getKey());
            }
        }
        return null;
    }

    public static int getDriverAverageRatings(String username) {
        int totalRatings = driverRatings.get(username).stream().mapToInt(integer -> integer).sum();
        return totalRatings / driverRatings.get(username).size();
    }
}
