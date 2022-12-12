/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.ui;

import java.awt.Color;

/**
 *
 * @author Mitesh
 */

public abstract class Colors {
    
    
    public static final Color BACKGROUND = Color.WHITE;

    public static Colors getSupplierColors() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public abstract Color PRIMARY();
    public abstract Color PRIMARY_LIGHT();
    public abstract Color PRIMARY_DARK();
    public abstract Color SECONDARY();
    public abstract Color SECONDARY_LIGHT();
    public abstract Color SECONDARY_DARK();
    public abstract Color COMPL_WHITE();
  
    
    public static Colors getSysAdminColors() {
        return new Colors() {
            @Override
            public Color PRIMARY() {
                return null;
            }

            @Override
            public Color PRIMARY_LIGHT() {
                return null;
            }

            @Override
            public Color PRIMARY_DARK() {
                return Color.decode("#5E17EB");
            }

            @Override
            public Color SECONDARY() {
                return null;
            }

            @Override
            public Color SECONDARY_LIGHT() {
                return null;
            }

            @Override
            public Color SECONDARY_DARK() {
                return null;
            }

            @Override
            public Color COMPL_WHITE() {
                return Color.decode("#F8F0E3");
            }
            
        };
    }
    
    
    
}
