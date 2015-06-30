/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goeuro.service;

import com.goeuro.dto.PlaceDto;
import com.goeuro.dto.ResponseDto;

/**
 *
 * @author ahmed
 */
public interface Transaction {

    ResponseDto savePlaceInfo(PlaceDto placeDto);

    ResponseDto find(PlaceDto placeDto);

    ResponseDto closeStream();
}
