package com.project.chinook.models;

public class Artist {
    private int ArtistId;
    private String Name;

    public Artist(int artistId, String name) {
        ArtistId = artistId;
        Name = name;
    }

    public int getArtistId() {
        return ArtistId;
    }

    public void setArtistId(int artistId) {
        ArtistId = artistId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
