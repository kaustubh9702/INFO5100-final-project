/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.ui.panels.tables;

import javax.swing.ImageIcon;

/**
 *
 * @author Nisha
 */
public class ElementButton<T> {
    
    
    
    private static String RESOURCE_PATH ="C:\\Users\\Nisha\\Documents\\Studies\\Fall 2021\\INFO5100\\Assignment 5\\JuberEats\\src\\main\\resources\\images\\";
    
    String mButtonText;
    String mIcon;
    ActionInterface mAction;

    
    public ElementButton(String mButtonText, String mIcon, ActionInterface mAction) {
        this.mButtonText = mButtonText;
        this.mIcon = mIcon;
        this.mAction = mAction;
    }
    
    
    

    public String getmButtonText() {
        return mButtonText;
    }

    public void setmButtonText(String mButtonText) {
        this.mButtonText = mButtonText;
    }

    public ImageIcon getmIcon() {
        return new ImageIcon(RESOURCE_PATH + mIcon);
    }

    public void setmIcon(String mIcon) {
        this.mIcon = mIcon;
    }

    public ActionInterface getmAction() {
        return mAction;
    }

    public void setmAction(ActionInterface mAction) {
        this.mAction = mAction;
    }
    

    
    
    
    
    
    
}

