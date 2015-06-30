/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goeuro.facade;

import java.util.List;

import com.goeuro.customexception.CustomException;
import com.goeuro.dto.PlaceDto;
import com.goeuro.dto.ResponseDto;

/**
 *
 * @author ahmed
 */
public interface Controller {

    void run(String place_name);

    List<PlaceDto> getPlacesInfo(String place_name) throws CustomException;

    void savePlaceInfo(String place_name);

    void display(ResponseDto response);

}
