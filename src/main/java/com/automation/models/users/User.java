package com.automation.models.users;

public class User {

    private String firstName;

    private String lastName;

    private String email;

    private String company;

    private String jobTitle;

    private String phoneNumber;

    public User(String firstName, String lastName, String email, String company, String jobTitle, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.company = company;
        this.jobTitle = jobTitle;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
