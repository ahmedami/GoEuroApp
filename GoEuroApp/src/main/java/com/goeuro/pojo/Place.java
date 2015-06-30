/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goeuro.pojo;

import com.goeuro.dto.PlaceDto;

/**
 *
 * @author ahmed
 */
public class Place {
    private long id;
    private String name;
    private String type;
    private double latitude;
    private double longitude;
    
    public Place(){}
    
    public Place(PlaceDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.type = dto.getType();
        this.latitude = dto.getPosition().getLatitude();
        this.longitude = dto.getPosition().getLongitude();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "Place{" + "id=" + id + ", name=" + name + ", type=" + type + ", latitude=" + latitude + ", longitude=" + longitude + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Place other = (Place) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
