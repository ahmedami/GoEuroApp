/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goeuro.facade.Imp;

import com.goeuro.customexception.CustomException;
import com.goeuro.dto.PlaceDto;
import com.goeuro.dto.ResponseDto;
import com.goeuro.facade.Controller;
import com.goeuro.service.Imp.ConnectionImp;
import com.goeuro.service.Imp.TransactionImp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.List;

/**
 *
 * @author ahmed
 */
public class ControllerImp implements Controller {

    private static boolean exit;
    private ResponseDto response;
    private String placeName;

    /**
     *
     * @param place_name
     */
    @Override
    public void run(String place_name) {
        this.placeName = place_name;
        boolean exit = false;
        while (!exit) {
            try {
                if (!"".equals(this.placeName)) {
                    savePlaceInfo(this.placeName);
                } else {
                    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                    this.placeName = bufferRead.readLine();
                    if (this.placeName.toLowerCase().equals("exit")) {
                        exit = true;
                    } else {
                        savePlaceInfo(this.placeName);
                    }
                }
            } catch (IOException e) {
                response = new ResponseDto();
                response.setMessage(ResponseDto.NORMAL_ERROR);
                display(response);
            }
        }
    }

    /**
     *
     * @param place_name
     * @return List of PlaceDto
     * @throws CustomException
     */
    @Override
    public List<PlaceDto> getPlacesInfo(String place_name) throws CustomException {
        List<PlaceDto> placesList;
        HttpURLConnection conn;
        try {
            conn = new ConnectionImp().getConnection(place_name);
        } catch (CustomException ex) {
            response = new ResponseDto();
            response.setConnected(false);
            response.setMessage(ResponseDto.CONNECTION_ERROR);
            throw new CustomException();
        }
        try {
            placesList = new ConnectionImp().getResponse(conn);
            if (placesList.isEmpty()) {
                throw new CustomException();
            }
        } catch (CustomException ex) {
            response = new ResponseDto();
            response.setEmpty(true);
            response.setMessage(ResponseDto.Empty_Respose);
            throw new CustomException();
        }
        return placesList;
    }

    /**
     *
     * @param place_name
     */
    @Override
    public void savePlaceInfo(String place_name) {
        List<PlaceDto> placeList;
        int listSize;
        int counter = 0;
        try {
            placeList = getPlacesInfo(place_name);
            listSize = placeList.size();
            for (PlaceDto dto : placeList) {
                response = new TransactionImp().find(dto);
                if (!response.isFound()) {
                    response = new TransactionImp().savePlaceInfo(dto);
                } else {
                    counter++;
                }
            }
            if (counter == listSize) {
                response = new ResponseDto();
                response.setFound(true);
                response.setMessage(ResponseDto.PLACE_INFO_ALREADY_EXIST);
                display(response);
            } else {
                display(response);
            }
        } catch (CustomException ex) {
            display(response);
        }

    }

    /**
     *
     * @param response
     */
    @Override
    public void display(ResponseDto response) {

        System.out.println("*************************************************************************************");
        System.out.println("*************************************************************************************");
        System.out.println("*************************************************************************************");
        System.out.println("--NOTE: Kindly find your CSV file at: " + System.getProperty("user.home") + "/Places.csv");
        System.out.println("*************************************************************************************");
        if (!"".equals(response.getMessage())) {
            System.out.println("--" + response.getMessage() + ".");
        }
        System.out.println("************************************************************************************");
        System.out.println("** you can insert another place name + Enter, or just type 'exit' + Enter to EXIT **");
        System.out.println("************************************************************************************");
        this.response = null;
        this.placeName = "";
    }

}
