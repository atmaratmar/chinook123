package com.project.chinook.controller;

import com.project.chinook.data_access.CustomerRepository;
import com.project.chinook.models.CountryCount;
import com.project.chinook.models.Customer;
import com.project.chinook.models.CustomerGenre;
import com.project.chinook.models.CustomerSpender;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {
    // Configure some endpoints to manage crud
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(value="/api/customers", method = RequestMethod.GET)
    public ArrayList<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

    @RequestMapping(value = "api/customers/id/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable int id){
        return customerRepository.getCustomerById(id);
    }
    @RequestMapping(value = "api/customers/Ofset/{Ofset}/Limit/{Limit}", method = RequestMethod.GET)
    public ArrayList<Customer> GetAllCustomersFromLimitOfset(@PathVariable int Ofset, @PathVariable int Limit){
        return customerRepository.GetAllCustomersFromLimitOfset(Ofset, Limit);
    }

    @RequestMapping(value = "api/customers/name/{Name}", method = RequestMethod.GET)
    public ArrayList<Customer> getCustomerByName(@PathVariable String Name){
        return customerRepository.getCustomerByName(Name);
    }

    @RequestMapping(value = "api/customers/country", method = RequestMethod.GET)
    public ArrayList<CountryCount> getCustomerByCountry(){
        return customerRepository.getCustomerByCountry();
    }

    @RequestMapping(value = "api/customers/customer/{id}", method = RequestMethod.GET)
    public ArrayList<CustomerGenre>  GetCustomerPopularGenre(@PathVariable int id){
        return customerRepository.GetCustomerPopularGenre(id);
    }

    @RequestMapping(value = "api/customers/customerspender", method = RequestMethod.GET)
    public ArrayList<CustomerSpender>  GetAllCustomersByHighestSpender(){
        return customerRepository.GetAllCustomersByHighestSpender();
    }


    @RequestMapping(value = "api/customers", method = RequestMethod.POST)
    public Boolean addNewCustomer(@RequestBody Customer customer){
        return customerRepository.addCustomer(customer);
    }

    @RequestMapping(value = "api/customers/{id}", method = RequestMethod.PUT)
    public Boolean updateExistingCustomer(@PathVariable String id, @RequestBody Customer customer){
        return customerRepository.updateCustomer(customer);
    }

}
