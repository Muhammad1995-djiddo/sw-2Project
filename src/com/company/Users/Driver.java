package com.company.Users;

public class Driver extends User {
    private String nationalID;
    private String drivingLicense;
    public Driver(String username, String phoneNumber, String email, String nationalID, String drivingLicense, String password, State status) {
        super(username, phoneNumber, email, password, status);

    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getNationalID() {
        return nationalID;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }
}
