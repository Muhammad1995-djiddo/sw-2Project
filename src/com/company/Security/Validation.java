package com.company.Security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public Validation() {}

    /**
     * Checks if a given phone number is 11 numbers
     * @param phoneNumber to be checked.
     * @return true if contains 11 numbers otherwise false
     */
    public static boolean validPhoneNumber(String phoneNumber) {
        return phoneNumber.length() == 11;
    }

    /**
     * Checks if a given email has a match with the emailRegex(email pattern)
     * @param email to be checked
     * @return true if found match otherwise returns false
     */
    public static boolean validEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    /**
     * Checks if a given password is more than 8 characters long.
     * @param password to be checked.
     * @return true if contains more than 8 characters otherwise false.
     */
    public static boolean validPassword(String password) {
        return password.length() > 8;
    }

    /**
     * Checks if a given nationalID is 14 numbers
     * @param nationalID to be checked.
     * @return true if contains 14 numbers otherwise false.
     */
    public static boolean validNationalID(String nationalID) {
        return nationalID.length() == 14;
    }

    /**
     * Checks if a given drivingLicenseID is 14 numbers
     * @param drivingLicense to be checked.
     * @return true if contains 14 numbers otherwise false.
     */
    public static boolean validDrivingLicense(String drivingLicense) {
        return drivingLicense.length() == 14;
    }
}
