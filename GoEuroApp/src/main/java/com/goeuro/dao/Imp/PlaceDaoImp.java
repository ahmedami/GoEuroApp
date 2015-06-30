/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goeuro.dao.Imp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

import com.goeuro.customexception.CustomException;
import com.goeuro.dao.PlaceDao;
import com.goeuro.pojo.Place;



/**
 *
 * @author ahmed
 */
public class PlaceDaoImp implements PlaceDao {

    @Override
    public void presist(Place place) throws CustomException {
        FileWriter writer = null;
        try {
            writer = CheckExistanceImp.getInstance().CreateFileIFNotExist();
            writer.append(String.valueOf(place.getId()));
            writer.append(',');
            writer.append(place.getName());
            writer.append(',');
            writer.append(place.getType());
            writer.append(',');
            writer.append(String.valueOf(place.getLatitude()));
            writer.append(',');
            writer.append(String.valueOf(place.getLongitude()));
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new CustomException(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new CustomException(ex.getMessage());
        }

    }

    @Override
    public boolean findById(String id) throws CustomException {
        boolean result = false;
        CheckExistanceImp.getInstance().CreateFileIFNotExist();
        String pathHome = System.getProperty("user.home");
        try {
            Scanner file = new Scanner(new File(pathHome + "/Places.csv"));
            while (file.hasNext()) {
                String[] words = file.nextLine().split(",");
                if (words[0].equals(id)) {
                    result = true;
                }
            }
        } catch (FileNotFoundException ex) {
            throw new CustomException(ex.getMessage());
        }
        return result;
    }

}
