package com.example.firebase_real;

public class John {
    private String artistID;
    private String artistname;
    private String artistselect;

    public John(String artistID, String artistname, String artistselect) {
        this.artistID = artistID;
        this.artistname = artistname;
        this.artistselect = artistselect;
    }

    public String getArtistID() {
        return artistID;
    }

    public String getArtistname() {
        return artistname;
    }

    public String getArtistselect() {
        return artistselect;
    }
}
