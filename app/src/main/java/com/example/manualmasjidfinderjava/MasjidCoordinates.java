package com.example.manualmasjidfinderjava;

public class MasjidCoordinates {
    private String masjid;
    private int latitude;
    private int longitude;

    //constructors


    public MasjidCoordinates(int latitude, int longitude, String masjid) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.masjid = masjid;
    }

    public MasjidCoordinates() {}
    //tostring is neccesary to print out items

    @Override
    public String toString() {
        return "MasjidCoordinates{" +
                "masjid='" + masjid + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    //getters and setters
    public String getMasjid() {
        return masjid;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setMasjid(String masjid) {
        this.masjid = masjid;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
}
