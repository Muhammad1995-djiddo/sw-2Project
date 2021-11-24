package com.company.Users;

public class Admin {
    private final String username = "admin";
    private String password;

    public Admin(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
