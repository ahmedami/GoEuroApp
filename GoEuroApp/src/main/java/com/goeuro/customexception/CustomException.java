/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goeuro.customexception;

/**
 *
 * @author ahmed
 */
public class CustomException extends Exception {

    public CustomException(){}

    public CustomException(String message){
        super(message);
    }

    public CustomException(Throwable cause){
        super(cause);
    }

    public CustomException(String message, Throwable cause){
        super(message, cause);
    }

    public CustomException(String message, Throwable cause,boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
