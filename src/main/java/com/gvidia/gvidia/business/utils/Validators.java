package com.gvidia.gvidia.business.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mitesh
 */
public class Validators {
    
    
   
    public static boolean isAlpha(String s) {
        return s != null && !s.isEmpty() && s.matches("^[a-zA-Z ]*$");
    }
     
     
    public static int[] parseArray(String arrString) {
        arrString = arrString.replace("[", "");
        arrString = arrString.replace("]", "");
        String[] minValues  = arrString.split(",");
        try {
            int min = Integer.parseInt(minValues[0]);
            int max = Integer.parseInt(minValues[1]);
            return new int[]{min,max};
        } catch(Exception e ) {
            return null;
        }
    } 
    
    
    public static boolean isAlphaNum(String s) {
       return s != null && s.matches("^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*$");
    }
    
    public static boolean isPassword(String s) {
        return s != null && s.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
    }
    
    public static boolean isPhoneNumber(String s) {
        return s != null && s.matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$");
    }

    public static boolean isNum(String price) {
        try {
            Double.valueOf(price);
            return true;
        } catch(Exception e ){
            return false;
        }
    }
    
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean isEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
    
    
    
}
