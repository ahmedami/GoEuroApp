/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goeuro;

/**
 *
 * @author ahmed
 */
import com.goeuro.customexception.CustomException;
import com.goeuro.dao.Imp.CheckExistanceImp;
import com.goeuro.dto.PlaceDto;
import com.goeuro.facade.Imp.ControllerImp;


public class Test {

    public static void main(String[] args) {
        String placeName=" ";
        if(args.length!=0)
            placeName=args[0];
        ControllerImp controller = new ControllerImp();
        controller.run(placeName);
    }

   
}
