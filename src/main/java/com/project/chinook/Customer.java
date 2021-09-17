package com.project.chinook;

public class Customer {
    private String FirstName;

    public Customer() {
    }

    public Customer(String firstName) {
        FirstName = firstName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
}
