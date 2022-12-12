/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.nio.file.Paths;
import javax.swing.ImageIcon;

/**
 *
 * @author Mitesh
 */
public class ImageUtil {
    
    private static final String BASE = Paths.get(System.getProperty("user.dir"), "src", "resources").toString();

    public static final String BASE_IMAGE = Paths.get(BASE, "images").toAbsolutePath().toString() + "\\";
    public static final String BASE_ICON = Paths.get(BASE, "icons").toAbsolutePath().toString() + "\\";


    public static ImageIcon getImageIcon(int w, int h, String selectedImagePath) {
        
            ImageIcon ii = new ImageIcon(selectedImagePath);
            Image image = ii.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
            return new ImageIcon(image);
    }
    
    public static void main(String[] args) {
        System.out.println(BASE_IMAGE);
    }
    
    
   
}
