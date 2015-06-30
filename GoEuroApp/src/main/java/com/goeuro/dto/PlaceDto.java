/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goeuro.dto;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author ahmed
 */
public class PlaceDto {

    @SerializedName("_id")
    private long id;
    private String key;
    private String name;
    private String fullName;
    @SerializedName("iata_airport_code")
    private String airPortCode;
    private String type;
    private String country;
    @SerializedName("geo_position")
    private GeoPositionDto position;
    private long locationId;
    private boolean inEurope;
    private String countryCode;
    private String distance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAirPortCode() {
        return airPortCode;
    }

    public void setAirPortCode(String airPortCode) {
        this.airPortCode = airPortCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public GeoPositionDto getPosition() {
        return position;
    }

    public void setPosition(GeoPositionDto position) {
        this.position = position;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public boolean isInEurope() {
        return inEurope;
    }

    public void setInEurope(boolean inEurope) {
        this.inEurope = inEurope;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PlaceDto other = (PlaceDto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PlaceDto{" + "id=" + id + ", key=" + key + ", name=" + name + ", fullName=" + fullName + ", airPortCode=" + airPortCode + ", type=" + type + ", country=" + country + ", position=" + position + ", location_id=" + locationId + ", inEurope=" + inEurope + ", countryCode=" + countryCode + ", distance=" + distance + '}';
    }

}
