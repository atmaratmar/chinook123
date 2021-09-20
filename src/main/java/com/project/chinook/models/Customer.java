package com.project.chinook.models;
// Shorter version of customer
public class Customer {
    private int customerId;
    private String FirstName;
    private String LastName;
    private String Company;

    public Customer() {
    }

    public Customer(int customerId, String FirstName, String LastName, String Company) {
        this.customerId = customerId;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Company = Company;
    }

    // Getters and setters

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        this.Company = company;
    }
}
