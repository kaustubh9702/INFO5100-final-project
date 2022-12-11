/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Nisha
 */
public class ImageUtil {


    public static final String BASE_IMAGE ="C:\\Users\\kaustubh\\Downloads\\A\\chip (1)\\ChipConnect\\src\\resources\\images\\";
    public static final String BASE_ICON ="C:\\Users\\kaustubh\\Downloads\\A\\chip (1)\\ChipConnect\\src\\resources\\icons\\";


    public static ImageIcon getImageIcon(int w, int h, String selectedImagePath) {
        
            ImageIcon ii = new ImageIcon(selectedImagePath);
            Image image = ii.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
            return new ImageIcon(image);
    }
    
   
}
