/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business.enterprises.retailer.personnel.customer;

import com.gvidia.gvidia.business.base.GenericDirectory;
import com.gvidia.gvidia.business.useraccount.UserAccount;

/**
 *
 * @author Mitesh
 */
public class CustomerDirectory extends GenericDirectory<Customer>{
    
    
    public CustomerDirectory() {
        super();
    }

    
    
    
    
    public Customer add(String name, String address, String phoneNumber,String pro, UserAccount ua) {
        Customer customer = Customer.createNewCustomer(getList().size(), name, address,phoneNumber, pro,ua);
        add(customer);
        return customer;
        
    }
    
    
    
    
}
