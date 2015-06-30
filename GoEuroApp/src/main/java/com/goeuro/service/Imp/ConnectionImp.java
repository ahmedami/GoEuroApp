/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goeuro.service.Imp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;

import com.goeuro.customexception.CustomException;
import com.goeuro.dto.PlaceDto;
import com.goeuro.service.Connection;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


/**
 *
 * @author ahmed
 */
public class ConnectionImp implements Connection {

    public static final String SERVICE_URL = "http://api.goeuro.com/api/v2/position/suggest/en/";

    @Override
    public HttpURLConnection getConnection(String place_name) throws CustomException {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(SERVICE_URL + place_name);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
        } catch (MalformedURLException ex) {
            throw new CustomException(ex.getMessage());
        } catch (IOException ex) {
            throw new CustomException(ex.getMessage());
        } catch (Exception ex) {
            throw new CustomException(ex.getMessage());
        } finally {
            return conn;
        }
    }

    @Override
    public List<PlaceDto> getResponse(HttpURLConnection conn) throws CustomException {
        ArrayList<PlaceDto> placeList = new ArrayList<PlaceDto>();
        try {
            if (conn.getResponseCode() != 200) {
                throw new CustomException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String response;
            while ((response = br.readLine()) != null) {
                Gson gson = new Gson();
                JsonParser jsonParser = new JsonParser();
                JsonArray jsonArray = jsonParser.parse(response).getAsJsonArray();

                for (JsonElement obj : jsonArray) {
                    PlaceDto placeDto = gson.fromJson(obj, PlaceDto.class);
                    placeList.add(placeDto);
                }
            }

        } catch (IOException ex) {
            throw new CustomException(ex.getMessage());
        } catch (Exception ex) {
            throw new CustomException(ex.getMessage());
        } finally {
            conn.disconnect();
            return placeList;
        }
    }

}
