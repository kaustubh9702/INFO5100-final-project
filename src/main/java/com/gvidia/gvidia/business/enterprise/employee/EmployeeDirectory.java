/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business.enterprise.employee;

import com.gvidia.gvidia.business.base.GenericDirectory;

/**
 *
 * @author kaustubh, krishica
 */
public class EmployeeDirectory extends GenericDirectory<Employee>{
    

    public EmployeeDirectory() {
    }

    
    public static Employee createEmployee(int id,String name, String phoneNumber, String profileLocation){
        Employee employee = new Employee(id,name,phoneNumber, profileLocation);
        return employee;
    }
    public  Employee addEmployee(String name, String phoneNumber, String profileLocation){
        Employee employee = createEmployee(size(),name, phoneNumber, profileLocation);
        add(employee);
        return employee;
    }

}