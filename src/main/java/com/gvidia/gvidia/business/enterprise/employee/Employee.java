/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business.enterprise.employee;

import com.gvidia.gvidia.business.base.Identifier;
import com.gvidia.gvidia.business.base.TableSerializable;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author kaustubh, krishica
 */
public class Employee extends Identifier {
    
    private String name;
    private String mPhoneNumner;
    private String mProfileLocation;
    
    public Employee(int id,String name, String mPhoneNumner, String mProfileLocation) {
        super(id);
        this.name = name;
        this.mPhoneNumner = mPhoneNumner;
        this.mProfileLocation = mProfileLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getmPhoneNumner() {
        return mPhoneNumner;
    }

    public void setmPhoneNumner(String mPhoneNumner) {
        this.mPhoneNumner = mPhoneNumner;
    }

    public String getmProfileLocation() {
        return mProfileLocation;
    }

    public void setmProfileLocation(String mProfileLocation) {
        this.mProfileLocation = mProfileLocation;
    }


    @Override
    public String toString() {
        return name;
    }

    @Override
    public void delete() {
        
    }

    public Icon getImage() {
        return new ImageIcon(mProfileLocation);
    }

    
    
}
