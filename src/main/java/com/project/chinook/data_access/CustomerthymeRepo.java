package com.project.chinook.data_access;

import com.project.chinook.models.*;

import java.util.ArrayList;

public interface CustomerthymeRepo {
    public ArrayList<Artist> getRandomArtists();
    public ArrayList<Track> getRandomTrack();
    public ArrayList<Genre> getRandomGenre();
    public  ArrayList<SearchTrack> getTrackByNameSearch(String name);
}
