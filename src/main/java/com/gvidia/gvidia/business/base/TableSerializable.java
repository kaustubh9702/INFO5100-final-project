/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business.base;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author kaustubh
 */
public interface TableSerializable {
    
    public String[] columns();
    public Object[] row();
   
    public ImageIcon getImageIcon();
    
}
