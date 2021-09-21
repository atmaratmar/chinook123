package com.project.chinook.data_access;

import com.project.chinook.models.CountryCount;
import com.project.chinook.models.Customer;

import java.util.ArrayList;

public interface CustomerRepository {
    public ArrayList<Customer> getAllCustomers();
    public Customer getCustomerById(int custId);
    public Boolean addCustomer(Customer customer);
    public Boolean updateCustomer(Customer customer);
    public  ArrayList<Customer>  getCustomerByName(String name);
    public ArrayList<CountryCount> getCustomerByCountry();

   public ArrayList<Customer> GetAllCustomersFromLimitOfset(int limit, int ofset);
}
