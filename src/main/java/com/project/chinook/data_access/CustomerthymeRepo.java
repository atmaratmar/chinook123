package com.project.chinook.data_access;

import com.project.chinook.models.Artist;
import com.project.chinook.models.Customer;
import com.project.chinook.models.Genre;
import com.project.chinook.models.Track;

import java.util.ArrayList;

public interface CustomerthymeRepo {
    public ArrayList<Artist> getRandomArtists();
    public ArrayList<Track> getRandomTrack();
    public ArrayList<Genre> getRandomGenre();
    public  ArrayList<Customer> getCustomerByNameSearch(String name);
}
