/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business.enterprise.role;


import com.gvidia.gvidia.business.enterprise.Enterprise;
import com.gvidia.gvidia.business.enterprise.organisation.Organization;
import com.gvidia.gvidia.business.useraccount.UserAccount;
import javax.swing.JPanel;
import com.gvidia.gvidia.ui.base.Controller;

/**
 *
 * @author kaustubh
 */
public abstract class Role {
   
    //What is the role working on
    public Object mObjective;

    public Role(Object mObjective) {
        this.mObjective = mObjective;
    }

    
    public abstract JPanel createWorkArea(Controller controller, Organization organization,
                                          UserAccount account,
                                          Enterprise business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }

    public Object getmObjective() {
        return mObjective;
    }

    public void setmObjective(Object mObjective) {
        this.mObjective = mObjective;
    }

    
    public abstract String getRoleName();
    
    
    
}