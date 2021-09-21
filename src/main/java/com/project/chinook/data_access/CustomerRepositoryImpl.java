package com.project.chinook.data_access;
import com.project.chinook.logging.LogToConsole;
import com.project.chinook.models.CountryCount;
import com.project.chinook.models.Customer;
import com.project.chinook.models.CustomerGenre;
import com.project.chinook.models.CustomerSpender;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
 This class serves as the encapsulation of all database interactions,
 it removes the implementation from the controllers to models - as they should only be responsible
 for handling user interactions and deciding what to do with it.
*/
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private final LogToConsole logger;
    // Setting up the connection object we need.
    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    public CustomerRepositoryImpl(LogToConsole logger) {
        this.logger = logger;
    }

    /*
     Need methods to serve the needs of the controller requests.
     Just mirror what your endpoints want.
    */
    //http://localhost:8080/api/customers
    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            logger.log("Connection to SQLite has been established.");
            // Make SQL query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT CustomerId,FirstName, LastName,Country ,PostalCode,Phone,Email  FROM Customer");
            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customers.add(
                        new Customer(
                                resultSet.getInt("CustomerId"),
                                resultSet.getString("FirstName"),
                                resultSet.getString("LastName"),
                                resultSet.getString("Country"),
                                resultSet.getString("PostalCode"),
                                resultSet.getString("Phone"),
                                resultSet.getString("Email")
                        ));
            }
            logger.log("Select all customers successful");
        } catch (Exception exception) {
            logger.log(exception.toString());
        } finally {
            try {
                conn.close();
            } catch (Exception exception) {
                logger.log(exception.toString());
            }
        }
        return customers;
    }

    //http://localhost:8080/api/customers/id/1
    public Customer getCustomerById(int custId) {
        Customer customer = null;
        try {
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            logger.log("Connection to SQLite has been established.");
            // Make SQL query
            PreparedStatement preparedStatement =
                    //conn.prepareStatement("SELECT CustomerId,FirstName, LastName,Country,PostalCode,Phone,Email FROM customers WHERE CustomerId = ?");
                    conn.prepareStatement("SELECT CustomerId,FirstName, LastName,Country,PostalCode,Phone,Email FROM Customer WHERE CustomerId = ?");
            preparedStatement.setInt(1, custId);
            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getInt("CustomerId"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Country"),
                        resultSet.getString("PostalCode"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email")
                );
            }
            logger.log("Select specific customer successful");
        } catch (Exception exception) {
            logger.log(exception.toString());
        } finally {
            try {
                conn.close();
            } catch (Exception exception) {
                logger.log(exception.toString());
            }
        }
        return customer;
    }

    public Boolean addCustomer(Customer customer) {
        Boolean success = false;
        try {
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            logger.log("Connection to SQLite has been established.");
            // Make SQL query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("INSERT INTO Customer(CustomerId,FirstName,LastName,Company) VALUES(?,?,?,?)");
            preparedStatement.setInt(1, customer.getCustomerId());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.setString(4, customer.getCountry());
            // Execute Query
            int result = preparedStatement.executeUpdate();
            success = (result != 0);
            logger.log("Add customer successful");
        } catch (Exception exception) {
            logger.log(exception.toString());
        } finally {
            try {
                conn.close();
            } catch (Exception exception) {
                logger.log(exception.toString());
            }
        }
        return success;
    }

    public Boolean updateCustomer(Customer customer) {
        Boolean success = false;
        try {
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            logger.log("Connection to SQLite has been established.");
            // Make SQL query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("UPDATE Customer SET CustomerId = ?, FirstName = ?, LastName = ?, Company = ? WHERE Id=?");
            preparedStatement.setInt(1, customer.getCustomerId());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.setString(4, customer.getCountry());
            preparedStatement.setInt(5, customer.getCustomerId());
            // Execute Query
            int result = preparedStatement.executeUpdate();
            success = (result != 0);
            logger.log("Update customer successful");
        } catch (Exception exception) {
            logger.log(exception.toString());
        } finally {
            try {
                conn.close();
            } catch (Exception exception) {
                logger.log(exception.toString());
            }
        }
        return success;
    }

    //http://localhost:8080/api/customers/name/ma
    @Override
    public ArrayList<Customer> getCustomerByName(String name) {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            logger.log("Connection to SQLite has been established.");
            // Make SQL query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT CustomerId,FirstName, LastName,Country ,PostalCode,Phone,Email  FROM Customer WHERE FirstName LIKE ?  ");
            preparedStatement.setString(1, name + '%');
            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customers.add(
                        new Customer(
                                resultSet.getInt("CustomerId"),
                                resultSet.getString("FirstName"),
                                resultSet.getString("LastName"),
                                resultSet.getString("Country"),
                                resultSet.getString("PostalCode"),
                                resultSet.getString("Phone"),
                                resultSet.getString("Email")
                        ));
            }
            logger.log("Select all customers successful");
        } catch (Exception exception) {
            logger.log(exception.toString());
        } finally {
            try {
                conn.close();
            } catch (Exception exception) {
                logger.log(exception.toString());
            }
        }
        return customers;
    }

    //http://localhost:8080/api/customers/country
    @Override
    public ArrayList<CountryCount> getCustomerByCountry() {
        ArrayList<CountryCount> customers = new ArrayList<>();
        try {
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            logger.log("Connection to SQLite has been established.");
            // Make SQL query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT Country, count(*) as CustomerCount from Customer GROUP BY Country ORDER BY CustomerCount DESC ");
            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CountryCount customersInEachCountries = new CountryCount();
                customersInEachCountries.setNumber(resultSet.getInt("CustomerCount"));
                customersInEachCountries.setName(resultSet.getString("Country"));
                customers.add(customersInEachCountries);

            }
            logger.log("Select all customers successful");
        } catch (Exception exception) {
            logger.log(exception.toString());
        } finally {
            try {
                conn.close();
            } catch (Exception exception) {
                logger.log(exception.toString());
            }
        }
        return customers;
    }

    //http://localhost:8080/api/customers/Ofset/2/Limit/10
    @Override
    public ArrayList<Customer> GetAllCustomersFromLimitOfset(int ofset, int limit) {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            logger.log("Connection to SQLite has been established.");
            // Make SQL query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT  * FROM Customer  WHERE CustomerId BETWEEN ? AND ? ");
            preparedStatement.setInt(1, ofset + 1);
            preparedStatement.setInt(2, limit + ofset);
            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customers.add(
                        new Customer(
                                resultSet.getInt("CustomerId"),
                                resultSet.getString("FirstName"),
                                resultSet.getString("LastName"),
                                resultSet.getString("Country"),
                                resultSet.getString("PostalCode"),
                                resultSet.getString("Phone"),
                                resultSet.getString("Email")
                        ));
            }
            logger.log("Select all customers successful");
        } catch (Exception exception) {
            logger.log(exception.toString());
        } finally {
            try {
                conn.close();
            } catch (Exception exception) {
                logger.log(exception.toString());
            }
        }
        return customers;
    }

    //http://localhost:8080/api/customers/customer/1
    @Override
    public ArrayList<CustomerGenre> GetCustomerPopularGenre(int id) {
        ArrayList<CustomerGenre> customerGenres = new ArrayList<>();
        try {
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            logger.log("Connection to SQLite has been established.");
            // Make SQL query
            PreparedStatement preparedStatement =
                    //conn.prepareStatement("SELECT CustomerId,FirstName, LastName,Country,PostalCode,Phone,Email FROM customers WHERE CustomerId = ?");
                    conn.prepareStatement("SELECT Customer.CustomerId, Customer.FirstName,Customer.LastName, Genre.Name, COUNT( InvoiceLine.Quantity) myCount " +
                            "FROM Customer " +
                            "         INNER JOIN Invoice on Customer.CustomerId = Invoice.CustomerId " +
                            "         INNER JOIN InvoiceLine ON Invoice.InvoiceId = InvoiceLine.InvoiceId " +
                            "         INNER JOIN Track on InvoiceLine.TrackId = Track.TrackId " +
                            "         INNER JOIN Genre on Track.GenreId = Genre.GenreId " +
                            "WHERE Customer.CustomerId = ? " +
                            "GROUP BY Genre.Name " +
                            "ORDER BY myCount  DESC ");
            preparedStatement.setInt(1, id);
            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet.getString("FirstName"));
            while (resultSet.next()) {
                CustomerGenre customerGenre = new CustomerGenre();
                customerGenre.setGenreCount(resultSet.getInt("myCount"));
                customerGenre.setGenreName(resultSet.getString("Name"));
                customerGenre.setFirstName(resultSet.getString("FirstName"));
                customerGenres.add(customerGenre);


            }
            logger.log("Select all customers successful");
        } catch (Exception exception) {
            logger.log(exception.toString());
        } finally {
            try {
                conn.close();
            } catch (Exception exception) {
                logger.log(exception.toString());
            }
        }
        return customerGenres;
    }

    //http://localhost:8080/api/customers/customerspender
    @Override
    public ArrayList<CustomerSpender> GetAllCustomersByHighestSpender() {
        ArrayList<CustomerSpender> customerSpenders = new ArrayList<>();
        try {
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            logger.log("Connection to SQLite has been established.");
            // Make SQL query
            PreparedStatement preparedStatement =
                    //conn.prepareStatement("SELECT CustomerId,FirstName, LastName,Country,PostalCode,Phone,Email FROM customers WHERE CustomerId = ?");
                    conn.prepareStatement("SELECT Customer.FirstName, SUM(Invoice.Total) AS TotalItemsOrdered " +
                            "  FROM Invoice, Customer " +
                            " Where Invoice.CustomerId = Customer.CustomerId " +
                            " Group by Customer.FirstName, Customer.LastName " +
                            " ORDER BY TotalItemsOrdered DESC");
            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CustomerSpender customerSpender = new CustomerSpender();
                customerSpender.setTotal(resultSet.getFloat("TotalItemsOrdered"));
                customerSpender.setFirstName(resultSet.getString("FirstName"));
                customerSpenders.add(customerSpender);
            }
            logger.log("Select all customers successful");
        } catch (Exception exception) {
            logger.log(exception.toString());
        } finally {
            try {
                conn.close();
            } catch (Exception exception) {
                logger.log(exception.toString());
            }
        }
        return customerSpenders;
    }

}
