package com.company.UIs;

import com.company.Users.Customer;
import com.company.Users.Driver;
import com.company.Utils.Database;

import java.util.Scanner;

/**
 * CustomerUI: Let a customer interact with the system.
 * @author Ntajugumba Guy Cherubin
 * @version 1.0
 */
public class CustomerUI {
    private final Customer customer;
    private final String username;

    public CustomerUI(String username, Customer customer) {
        this.username = username;
        this.customer = customer;
        System.out.println("\nWelcome " + username);
        menu();
    }

    /**
     * Intended for the customer to choose an option.
     */
    private void menu() {
        System.out.println("\n1. Book a ride.\n" +
                "2. My bookings.\n" +
                "3. Log Out");

        int choice = UI.getChoice(3);

        switch (choice) {
            case 1 -> bookRide();
            case 2 -> listBookings();
            case 3 -> new UI();
        }
    }

    /**
     * Let a customer book a ride
     */
    private void bookRide() {
        Scanner input = new Scanner(System.in);

        System.out.print("Source: ");
        String source = input.nextLine();
        System.out.print("Destination: ");
        String destination = input.nextLine();
        System.out.println("Wait for a driver to be available...");

        Driver driver = Database.addRideRequest(source, destination);

        if (driver == null) {
            System.out.println("No driver is available for the moment.Try again later.");
        }
        else {
            int driverAverageRating = Database.getDriverAverageRatings(driver.getUsername());
            System.out.println("Driver's information: \n" +
                    "Telephone Number: " + driver.getPhoneNumber() +
                    "\nAverage Rating: " + driverAverageRating);
        }

    }

    /**
     * Let a customer see all the bookings taken
     * And the possibility to rate a driver for a given booking
     */
    private void listBookings() {
    }


}
