/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goeuro.dao.Imp;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

import com.goeuro.customexception.CustomException;
import com.goeuro.dao.CheckExistance;


/**
 *
 * @author ahmed
 */
public class CheckExistanceImp implements CheckExistance {

    private static final CheckExistanceImp check = new CheckExistanceImp();

    private FileWriter writer = null;

    private CheckExistanceImp() {
    }

    public static CheckExistanceImp getInstance() {
        return check;
    }

    @Override
    public FileWriter CreateFileIFNotExist() throws CustomException {

        try {
            String pathHome = System.getProperty("user.home");
            File file = new File(pathHome + "/Places.csv");
            if (file.exists()) {
                if (writer == null) {
                    writer = new FileWriter(file, true);
                }
            } else {
                file.createNewFile();
                writer = new FileWriter(file, true);
                writer.append("ID");
                writer.append(',');
                writer.append("Name");
                writer.append(',');
                writer.append("Type");
                writer.append(',');
                writer.append("Latitude");
                writer.append(',');
                writer.append("Longitude");
                writer.append('\n');
                writer.flush();
            }
        } catch (IOException ex) {
            throw new CustomException(ex.getMessage());
        } finally {
            return writer;
        }
    }

    @Override
    public void closeStream() throws CustomException {
        try {
            this.writer.close();
        } catch (IOException ex) {
            throw new CustomException(ex.getMessage());
        }
    }

}
