package com.company.Users;

/**
 * User: Represents a user and his/her properties and methods.
 * @author  Muhammad Ibrahim Muhammad
 * @version 1.0
 */
public class User {
    private String username;
    private String phoneNumber;
    private String email;
    private String password;
    private State status;

    /**
     * Constructs a User object.
     */
    public User(String username, String phoneNumber, String email,
                String password, State status) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public State getStatus() {
        return status;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(State status) {
        this.status = status;
    }
}
