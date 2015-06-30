/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goeuro.dto;

/**
 *
 * @author ahmed
 */
public class ResponseDto {

    public static final String PLACE_INFO_ALREADY_EXIST = "Note: Information Already Exist.";
    public static final String PLACE_INFO_SAVED_SUCCESFULLY = "Note: Information Saved Succesfully.";
    public static final String PLACE_INFO_ERROR_WHILE_SAVING = "Note: Error While Saving Information , Pleas Try Again.";
    public static final String PLACE_INFO_ERROR_WHILE_SEARCHING = "Note: Error While Searching , Pleas Try Again.";
    public static final String CONNECTION_ERROR = "Error: in Connection, please try again.";
    public static final String Empty_Respose = "Note: Sorry Nothing match the input you entered, please try again";
    public static final String NORMAL_ERROR = "Error: Sorry there is an error , please try again.";

    private String message;
    private boolean found;
    private boolean saved;
    private boolean connected;
    private boolean empty;

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

}
