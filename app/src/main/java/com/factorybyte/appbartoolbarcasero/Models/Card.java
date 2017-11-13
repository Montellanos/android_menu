package com.factorybyte.appbartoolbarcasero.Models;

/**
 * Created by Jorge on 13/11/2017.
 */

public class Card {


    public String image, name, description, telefono;
    public double latitude, longitude;



    public Card(){

    }


    public Card(String image, String name, String description, String telefono, double latitude, double longitude){
        this.image = image;
        this.name = name;
        this.description = description;
        this.telefono = telefono;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
