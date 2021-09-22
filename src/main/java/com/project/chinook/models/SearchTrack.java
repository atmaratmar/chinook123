package com.project.chinook.models;

public class SearchTrack {
    private String trackName;
    private String albumTitle;
    private  String genreName;
    private String artistName;

    public SearchTrack(String trackName, String albumTitle, String genreName, String artistName) {
        this.trackName = trackName;
        this.albumTitle = albumTitle;
        this.genreName = genreName;
        this.artistName = artistName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
