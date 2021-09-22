package com.project.chinook.models;

public class Track {
    private int TrackId;
    private  String Name;

    public Track(int trackId, String name) {
        TrackId = trackId;
        Name = name;
    }

    public int getTrackId() {
        return TrackId;
    }

    public void setTrackId(int trackId) {
        TrackId = trackId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
