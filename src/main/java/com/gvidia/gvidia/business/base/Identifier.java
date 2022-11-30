/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business.base;

/**
 *
 * @author kaustubh, krishica
 */
public abstract class Identifier {
    
    public Integer mID;

    public Identifier(int mID) {
        this.mID = mID;
    }

    
    
    

    @Override
    public boolean equals(Object obj) {
        return mID.equals(obj);
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }
    
    public abstract void delete();
    
    
    
    
    
    
    
    
    
}
