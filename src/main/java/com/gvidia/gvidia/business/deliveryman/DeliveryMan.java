/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business.deliveryman;

import com.gvidia.gvidia.business.EcoSystem;
import com.gvidia.gvidia.business.base.GenericDirectory;
import com.gvidia.gvidia.business.base.Identifier;
import com.gvidia.gvidia.business.base.TableSerializable;
import com.gvidia.gvidia.business.enterprise.employee.Employee;

import com.gvidia.gvidia.business.enterprises.retailer.wr.OrderWorkRequest;
import com.gvidia.gvidia.business.useraccount.UserAccount;

import javax.swing.ImageIcon;

/**
 *
 * @author kaustubh, krishica
 */
public class DeliveryMan extends Identifier implements TableSerializable{
    
    
    
    
    public String mPhoneNumber;
    public OrderWorkRequest mCurrentRequest;
    public GenericDirectory<OrderWorkRequest> mDeliveryRequest;
    public UserAccount mUserAccount;

    public DeliveryMan(String phoneNumber,UserAccount mUserAccount, int mID) {
        super(mID);
        this.mPhoneNumber = phoneNumber;
        this.mCurrentRequest = null;
        this.mDeliveryRequest = new GenericDirectory<OrderWorkRequest>();
        this.mUserAccount = mUserAccount;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public UserAccount getmUserAccount() {
        return mUserAccount;
    }

    public void setmUserAccount(UserAccount mUserAccount) {
        this.mUserAccount = mUserAccount;
    }

  

    public OrderWorkRequest getmCurrentRequest() {
        return mCurrentRequest;
    }

    public void setmCurrentRequest(OrderWorkRequest mCurrentRequest) {
        this.mCurrentRequest = mCurrentRequest;
    }

    public GenericDirectory<OrderWorkRequest> getmDeliveryRequest() {
        return mDeliveryRequest;
    }

    public void setmDeliveryRequest(GenericDirectory<OrderWorkRequest> mDeliveryRequest) {
        this.mDeliveryRequest = mDeliveryRequest;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.mID;
        hash = 19 * hash + (this.mUserAccount.getEmployee().getName() != null ? mUserAccount.getEmployee().getName().hashCode() : 0);
        hash = 19 * hash + (this.mCurrentRequest != null ? this.mCurrentRequest.hashCode() : 0);
        hash = 19 * hash + (this.mDeliveryRequest != null ? this.mDeliveryRequest.hashCode() : 0);
        return hash;
    }
    
//    public static DeliveryMan createNewDeliveryMan(int id,String name, String phoneNumber, String userName, String password) {
//
//
//        Employee emp = EcoSystem.getInstance(true).getEmployeeDirectory().createEmployee(name);
//        UserAccount userAccount = EcoSystem.getInstance(true)
//                                    .getUserAccountDirectory()
//                                    .createUserAccount(userName, password, emp, null);
//        DeliveryMan customer = new DeliveryMan(phoneNumber, userAccount,id);
//
//        userAccount.setRole(new DeliverManRole(customer));
//
//        return customer;
//
//    }

    @Override
    public String[] columns() {
        return new String[]{
            "Name",
            "Phon Number",
            "Current Delivery"
        };
    }

    @Override
    public Object[] row() {
        return new Object[]{
            mUserAccount.getEmployee().getName(),
            mPhoneNumber,
            mCurrentRequest == null ? "NO" : "Out and About"
        };
    }

    @Override
    public void delete() {
        
        //TODO Remove all work requests
        
        mUserAccount.getEmployee().delete();
        mUserAccount.delete();
    }

    @Override
    public ImageIcon getImageIcon() {
        return null;
    }

    @Override
    public String toString() {
        return mUserAccount.getEmployee().getName();
    }
    
    

    

    
    
    
    
    
    
    
    
    
    
    
    
}
