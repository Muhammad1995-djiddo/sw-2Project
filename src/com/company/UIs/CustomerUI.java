package com.company.UIs;

import com.company.Users.Customer;

import java.util.Scanner;

/**
 * CustomerUI: Let a customer interact with the system.
 * @author Ntajugumba Guy Cherubin
 * @version 1.0
 */
public class CustomerUI extends UI{
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
                "2. My bookings.\n +" +
                "3. Log Out");

        int choice = getChoice(3);

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
    }

    /**
     * Let a customer see all the bookings taken
     * And the possibility to rate a driver for a given booking
     */
    private void listBookings() {
    }


}
