/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goeuro.service;

import com.goeuro.customexception.CustomException;
import com.goeuro.dto.PlaceDto;

import java.net.HttpURLConnection;
import java.util.List;


/**
 *
 * @author ahmed
 */
public interface Connection {

    HttpURLConnection getConnection(String place_name) throws CustomException;

    List<PlaceDto> getResponse(HttpURLConnection conn) throws CustomException;
}
