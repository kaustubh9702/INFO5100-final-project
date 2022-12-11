/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business.enterprise.organisation;

import com.gvidia.gvidia.business.base.Identifier;
import com.gvidia.gvidia.business.enterprise.employee.EmployeeDirectory;
import com.gvidia.gvidia.business.enterprise.role.Role;
import com.gvidia.gvidia.business.useraccount.UserAccountDirectory;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkQueue;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kaustubh
 */
public abstract class Organization extends Identifier {

    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;

    private static int counter=0;

    public Organization(String name) {
        super(counter++);
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();

    }
    


    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }

    
    public abstract List<Role> getSupportedRole(Object object);




    @Override
    public void delete() {

    }
    
    
}
