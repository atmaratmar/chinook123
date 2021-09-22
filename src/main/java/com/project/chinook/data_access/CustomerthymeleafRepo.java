package com.project.chinook.data_access;

import com.project.chinook.logging.LogToConsole;
import com.project.chinook.models.*;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
@Repository
public class CustomerthymeleafRepo implements CustomerthymeRepo {

    private final  LogToConsole logger;
    // Setting up the connection object we need.
    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;
    public CustomerthymeleafRepo(LogToConsole logger) {this.logger = logger;}

    public ArrayList<Artist> getRandomArtists() {
        ArrayList<Artist> artists = new ArrayList<>();
        try {
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            logger.log("Connection to SQLite has been established.");
            // Make SQL query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT * FROM Artist ORDER BY RANDOM() LIMIT 5;");
            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                artists.add(
                        new Artist(
                               resultSet.getInt("ArtistId"),
                                resultSet.getString("Name")



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
        return artists;
    }

    @Override
    public ArrayList<Track> getRandomTrack() {
        ArrayList<Track> tracks = new ArrayList<>();
        try {
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            logger.log("Connection to SQLite has been established.");
            // Make SQL query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT * FROM Track ORDER BY RANDOM() LIMIT 5;");
            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tracks.add(
                        new Track(
                                resultSet.getInt("TrackId"),
                                resultSet.getString("Name")



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
        return tracks;
     }

    @Override
    public ArrayList<Genre> getRandomGenre() {
        ArrayList<Genre> genres = new ArrayList<>();
        try {
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            logger.log("Connection to SQLite has been established.");
            // Make SQL query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT * FROM Genre ORDER BY RANDOM() LIMIT 5;");
            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                genres.add(
                        new Genre(
                                resultSet.getInt("GenreId"),
                                resultSet.getString("Name")



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
        return genres;
    }

    @Override
    public ArrayList<Customer> getCustomerByNameSearch(String name) {
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
}


