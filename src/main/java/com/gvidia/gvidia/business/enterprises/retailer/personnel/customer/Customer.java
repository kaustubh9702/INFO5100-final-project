/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business.enterprises.retailer.personnel.customer;

import com.gvidia.gvidia.business.EcoSystem;
import com.gvidia.gvidia.business.base.GenericDirectory;
import com.gvidia.gvidia.business.base.Identifier;
import com.gvidia.gvidia.business.base.TableSerializable;
import com.gvidia.gvidia.business.enterprises.retailer.wr.OrderWorkRequest;
import com.gvidia.gvidia.business.order.Cart;
import com.gvidia.gvidia.business.useraccount.UserAccount;

import javax.swing.ImageIcon;

/**
 *
 * @author Mitesh
 */

public class Customer extends Identifier implements TableSerializable{
    
    
    
    String mName;
    String mAddress;
    String mPhoneNumber;
    String mProfileLocation;
    UserAccount mUserAccount;

    Cart mCart;
    GenericDirectory<OrderWorkRequest> mOrderWorkRequest;
    
    
    
    public Customer(int id, String mName, String mAddress, String mPhoneNumber, 
                        String profileLocation,UserAccount mUserAccount) {
        super(id);
        this.mName = mName;
        this.mAddress = mAddress;
        this.mProfileLocation = profileLocation;
        this.mPhoneNumber = mPhoneNumber;
        this.mUserAccount = mUserAccount;
        mCart =  null;
        mOrderWorkRequest = new GenericDirectory<>();
    }


    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public void setmUserAccount(UserAccount mUserAccount) {
        this.mUserAccount = mUserAccount;
    }
    
  

    public String getmName() {
        return mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public UserAccount getmUserAccount() {
        return mUserAccount;
    }

    public Cart getmCart() {
        if(mCart == null) {
            mCart = new Cart(getmUserAccount());
        }
        return mCart;
    }

    public void setmCart(Cart mCart) {
        this.mCart = mCart;
    }

    public GenericDirectory<OrderWorkRequest> getmOrderWorkRequest() {
        return mOrderWorkRequest;
    }

    public void setmOrderWorkRequest(GenericDirectory<OrderWorkRequest> mOrderWorkRequest) {
        this.mOrderWorkRequest = mOrderWorkRequest;
    }

    public String getmProfileLocation() {
        return mProfileLocation;
    }

    public void setmProfileLocation(String mProfileLocation) {
        this.mProfileLocation = mProfileLocation;
    }
    
    
    
    
    
    
    
    
    public static Customer createNewCustomer(int id,String name, String address, String phoneNumber, String pro,UserAccount userAccount) {
        Customer customer = new Customer(id,name, address,phoneNumber,pro, userAccount);
        return customer;
        
    }

    @Override
    public int hashCode() {
        int hash = 5; 
        hash = 17 * hash + this.getmID();
        hash = 17 * hash + (this.mName != null ? this.mName.hashCode() : 0);
        hash = 17 * hash + (this.mAddress != null ? this.mAddress.hashCode() : 0);
        hash = 17 * hash + (this.mPhoneNumber != null ? this.mPhoneNumber.hashCode() : 0);
        hash = 17 * hash + (this.mUserAccount != null ? this.mUserAccount.hashCode() : 0);
        return hash;
    }

    @Override
    public String[] columns() {
     return new String[]{
         "Name",
         "Address",
         "Phone Number"
     };   
    }

    @Override
    public Object[] row() {
        return new Object[]{
            mName,
            mAddress,
            mPhoneNumber
        };
    }

    @Override
    public void delete() {
    
        
        mUserAccount.delete();
        
    }

    @Override
    public ImageIcon getImageIcon() {
        return null;
    }

    
    
    
    
    
    
    
    
    
    
}
