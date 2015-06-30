/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goeuro.service.Imp;

import com.goeuro.customexception.CustomException;
import com.goeuro.dao.Imp.CheckExistanceImp;
import com.goeuro.dao.Imp.PlaceDaoImp;
import com.goeuro.dto.PlaceDto;
import com.goeuro.dto.ResponseDto;
import com.goeuro.pojo.Place;
import com.goeuro.service.Transaction;


/**
 *
 * @author ahmed
 */
public class TransactionImp implements Transaction {

    /**
     *
     * @param placeDto
     * @return ResponseDto
     */
    @Override
    public ResponseDto savePlaceInfo(PlaceDto placeDto) {
        ResponseDto response = new ResponseDto();
        try {
            Place place = new Place(placeDto);
            PlaceDaoImp dao = new PlaceDaoImp();
            dao.presist(place);
            response.setSaved(true);
            response.setMessage(ResponseDto.PLACE_INFO_SAVED_SUCCESFULLY);
        } catch (CustomException ex) {
            response.setSaved(false);
            response.setMessage(ResponseDto.PLACE_INFO_ERROR_WHILE_SAVING);
        } finally {
            return response;
        }
    }

    /**
     *
     * @param placeDto
     * @return ResponseDto
     */
    @Override
    public ResponseDto find(PlaceDto placeDto) {
        ResponseDto response = new ResponseDto();
        try {
            PlaceDaoImp dao = new PlaceDaoImp();
            if (dao.findById(String.valueOf(placeDto.getId()))) {
                response.setFound(true);
            } else {
                response.setFound(false);
            }
        } catch (CustomException ex) {
            response.setFound(false);
            response.setMessage(ResponseDto.PLACE_INFO_ERROR_WHILE_SEARCHING);
        } finally {
            return response;
        }

    }

    /**
     *
     * @return ResponseDto
     */
    @Override
    public ResponseDto closeStream() {
        ResponseDto response = new ResponseDto();
        try {
            CheckExistanceImp.getInstance().closeStream();
        } catch (CustomException ex) {
            response.setMessage(ResponseDto.NORMAL_ERROR);
        } finally {
            return response;
        }
    }

}
