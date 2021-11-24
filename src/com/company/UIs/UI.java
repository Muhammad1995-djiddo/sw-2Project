package com.company.UIs;

import com.company.Security.Authentication;
import com.company.Security.Validation;
import com.company.Users.Admin;
import com.company.Users.Customer;
import com.company.Users.Driver;
import com.company.Users.State;
import com.company.Utils.Database;

import java.util.Scanner;

/**
 * UI: Let a User interact with the system.
 * @author Ntajugumba Guy Cherubin
 *  @version 1.0
 */
public class UI {

    /**
     * Constructs a new UI object and calls a main menu.
     */
    public UI() {
        mainMenu();
    }

    /**
     * Show a User options to choose from.
     */
    private void mainMenu() {
        Scanner input = new Scanner(System.in);

        System.out.println("================ TransCom ===============");
        System.out.println("1. SignUp.");
        System.out.println("2. LogIn.");
        System.out.println("3. LogIn as Admin.");
        System.out.print("4. Exit.");

        System.out.print("\nChoice (1 - 4): ");

        int choice = input.nextInt();

        while (choice < 1 || choice > 4) {
            System.out.println("\n==>Invalid input!");
            System.out.println("==>Choose between the presented options.");
            System.out.print("\nChoice (1 - 4): ");
            choice = input.nextInt();
        }

        switch (choice) {
            case 1 -> signUp();
            case 2 -> logIn();
            case 3 -> logAdmin();
            case 4 -> System.exit(0);
        }
    }

    /**
     * Get user username and password,
     * After checking if they are valid and after authentication,
     * Initialize a UI corresponding to the user
     */
    private void logIn() {
        Scanner input = new Scanner(System.in);

        int profileType = getProfileType();

        System.out.print("Username: ");
        String username = input.nextLine();
        while(!Authentication.existUsername(username)) {
            System.out.println("The username you entered is not found!\n" +
                    "==> Try again.");
            System.out.print("Username: ");
            username = input.nextLine();
        }

        System.out.print("Password: ");
        String password = input.nextLine();
        while(!Authentication.isPasswordCorrect(username, password)) {
            System.out.println("The password you entered is not found!\n" +
                    "==> Try again.");
            System.out.print("Password: ");
            password = input.nextLine();
        }

        switch (profileType) {
            case 1 -> {
                Customer customer = (Customer) Database.getUserInfo(username);
                new CustomerUI(username, customer);
            }
            case 2 -> {
                Driver driver = (Driver) Database.getUserInfo(username);
                new DriverUI(username, driver);
            }
        }
    }

    /**
     * Register a new user in the database.
     */
    private void signUp() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the below required information.");

        // Get profile type
        int profileType = getProfileType();

        // Get username and checks if it doesn't exist in the database.
        System.out.print("username: ");
        String username = input.nextLine();
        while (Authentication.existUsername(username)) {
            System.out.println("The username entered is already taken.");
            System.out.print("Username: ");
            username = input.nextLine();
        }

        // Get phone number and checks if it is valid
        System.out.print("Phone Number: +2");
        String phoneNumber = input.nextLine();
        while (!Validation.validPhoneNumber(phoneNumber)) {
            System.out.println("A telephone number must be contains 11 numbers.");
            System.out.print("Phone Number: +2");
            phoneNumber = input.nextLine();
        }

        // Get email and checks if it is valid
        System.out.print("Email: ");
        String email = input.nextLine();
        while (!Validation.validEmail(email)) {
            System.out.println("Wrong format. Your email must be in this format: ");
            System.out.println("==> characters@domain.com");
            System.out.print("Email: ");
            email = input.nextLine();
        }

        // Get password and checks if it is strong
        System.out.print("Password: ");
        String password = input.nextLine();
        while(!Validation.validPassword(password)) {
            System.out.println("\nA password must be at least 8 characters long!");
            System.out.print("Password: ");
            password = input.nextLine();
        }

        switch (profileType) {
            case 1 -> {
                Customer customer = new Customer(username, phoneNumber, email, password, State.ACTIVE);
                Database.addUser(username, customer, "Customer");
                new CustomerUI(username, customer);
            }
            case 2 -> {
                // Get national and checks if it is valid
                System.out.print("National ID: ");
                String nationalID = input.nextLine();
                while(!Validation.validNationalID(nationalID)) {
                    System.out.println("Wrong format.Your ID must be 14 long!");
                    System.out.print("National ID: ");
                    nationalID = input.nextLine();
                }

                // Get license id and checks if it is valid
                System.out.print("Driving License ID: ");
                String drivingLicense = input.nextLine();
                while(!Validation.validDrivingLicense(drivingLicense)) {
                    System.out.println("Wrong format.Your driving license ID must be 14 long!");
                    System.out.print("Driving License ID: ");
                    drivingLicense = input.nextLine();
                }

                Driver driver = new Driver(username, phoneNumber, email, nationalID, drivingLicense, password, State.INACTIVE);
                Database.addUser(username, driver, "Driver");
                new DriverUI(username, driver);
            }
        }
    }

    /**
     * Log an administrator in
     * after checking if the password is correct.
     * <p>For an administrator, the username is "admin"
     * So, no need to ask the username.
     */
    private void logAdmin() {
        Scanner input = new Scanner(System.in);
        System.out.print("Password: ");
        String password = input.nextLine();

        while(!Authentication.validAdminPassword(password)) {
            System.out.println("Invalid password\n" +
                    "==> Try again");
            System.out.print("Password: ");
            password = input.nextLine();
        }
        Admin admin = new Admin(password);
        new AdminUI(admin);
    }

    /**
     * Get the profile type of the user.
     * <p>It can be a Customer or a Driver profile.
     * @return profile type
     */
    private int getProfileType() {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose your profile");
        System.out.print("1. Customer." + "\n2. Driver.\n");
        System.out.print("\nChoice (1 - 2): ");
        int profileType = input.nextInt();
        while (profileType < 1 || profileType > 2) {
            System.out.println("Invalid input");
            System.out.print("\nChoice (1 - 2): ");
            profileType = input.nextInt();
        }

        return profileType;
    }

    /**
     * Returns the choice of the customer from menu choices
     * @return menu option
     * @param max max choice
     */
    static int getChoice(int max) {
        Scanner input = new Scanner(System.in);
        System.out.print("\nChoice (1 - " + max + " ): ");
        int choice = input.nextInt();
        while (choice < 1 || choice > max) {
            System.out.println("Invalid input");
            System.out.print("\nChoice (1 - " + max + " ): ");
            choice = input.nextInt();
        }

        return choice;
    }
}
