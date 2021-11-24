package com.company.UIs;

import com.company.Users.Driver;

/**
 * DriverUI: Let a driver interact with the system.
 * @author Ntajugumba Guy Cherubin
 * @version 1.0
 */
public class DriverUI extends UI{
    private final Driver driver;
    private final String username;
    /**
     * Constructs a DriverUI object.
     * @param username of the driver
     * @param driver Driver object
     */
    public DriverUI(String username, Driver driver) {
        this.username = username;
        this.driver = driver;
        System.out.println("\nWelcome " + username);
        menu();
    }


    private void menu() {
        System.out.println("\n\n1. List rides.\n" +
                "2. List Users rating.\n" +
                "3. Add favorite area.\n" +
                "4. Log Out.");

        int choice = getChoice(4);

        switch (choice) {
            case 1 -> viewRides();
            case 2 -> viewUsersRatings();
            case 3 -> addFavorite();
            case 4 -> new UI();
        }
    }

    /**
     * Let a driver add a favorite area.
     */
    private void addFavorite() {
    }

    /**
     * Let a driver see the ratings given by the customers
     */
    private void viewUsersRatings() {
    }

    /**
     * List available rides requests.
     */
    private void viewRides() {
    }

}
