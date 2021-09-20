package com.project.chinook.models;
// Shorter version of customer
public class Customer {
    private int customerId;
    private String FirstName;
    private String LastName;
    private String Country;
    private String PostalCode;
    private String Phone;
    private  String Email;

    public Customer() {
    }

    public Customer(int customerId, String firstName, String lastName, String country, String postalCode, String phone, String email) {
        this.customerId = customerId;
        FirstName = firstName;
        LastName = lastName;
        Country = country;
        PostalCode = postalCode;
        Phone = phone;
        Email = email;
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

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        this.Country = country;
    }
    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
