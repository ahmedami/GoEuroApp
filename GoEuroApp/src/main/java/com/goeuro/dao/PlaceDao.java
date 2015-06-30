/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goeuro.dao;

import com.goeuro.customexception.CustomException;
import com.goeuro.pojo.Place;

/**
 *
 * @author ahmed
 */
public interface PlaceDao {

    void presist(Place place) throws CustomException;

    boolean findById(String id) throws CustomException;
}
