package com.company.UIs;

public class AdminUI extends UI{
    public AdminUI() {
        System.out.println("Welcome Administrator.");
        menu();
    }

    /**
     * Let an admin choose an option from the menu.
     */
    private void menu() {
        System.out.println("\n1.Manage playgrounds.\n" +
                "2. Manage complaints.\n" +
                "3. Log Out.");
        int choice = getChoice(3);
        switch (choice) {
            case 1 -> listPendingRegistration();
            case 2 -> suspendUser();
            case 3 -> new UI();
        }
    }

    /**
     * Let an admin suspend a user
     */
    private void suspendUser() {
    }

    /**
     * List pending registrations so that admin can register them
     */
    private void listPendingRegistration() {
    }
}
