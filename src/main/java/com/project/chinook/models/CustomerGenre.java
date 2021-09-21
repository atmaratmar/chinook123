package com.project.chinook.models;

public class CustomerGenre {
    private int GenreCount ;
    private String FirstName;
    private String GenreName;

    public CustomerGenre() {
    }

    public int getGenreCount() {
        return GenreCount;
    }

    public void setGenreCount(int genreCount) {
        GenreCount = genreCount;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getGenreName() {
        return GenreName;
    }

    public void setGenreName(String genreName) {
        GenreName = genreName;
    }


}
