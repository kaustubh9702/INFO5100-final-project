/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business;


import com.gvidia.gvidia.business.base.GenericDirectory;
import com.gvidia.gvidia.business.db4outil.DB4OUtil;
import com.gvidia.gvidia.business.enterprise.Enterprise;
import com.gvidia.gvidia.business.enterprise.organisation.Organization;
import com.gvidia.gvidia.business.enterprise.role.Role;
import com.gvidia.gvidia.business.enterprises.logisitics.LogisticsEnterprise;
import com.gvidia.gvidia.business.enterprises.manufacturer.ManufacturingEnterprise;
import com.gvidia.gvidia.business.enterprises.retailer.RetailerEnterprise;
import com.gvidia.gvidia.business.enterprises.supplier.SupplierEnterprise;
import com.gvidia.gvidia.business.useraccount.UserAccountDirectory;
import sun.rmi.runtime.Log;

/**
 *
 * @author kaustubh
 */
public class EcoSystem{
    
    private static EcoSystem business;

    private UserAccountDirectory mUserAccountDirectory;
    private SupplierEnterprise mSupplier;
    private ManufacturingEnterprise mManufacturer;
    private RetailerEnterprise mRetailer;
    private LogisticsEnterprise mLogisitics;


    public static EcoSystem getInstance(){
        if(business==null){
            business= DB4OUtil.getInstance().retrieveSystem(false);
        }
        return business;
    }
    public static EcoSystem getInstance(boolean toReload){
        if(business == null || toReload){
            business= DB4OUtil.getInstance().retrieveSystem(toReload);
        }
        return business;
    }


    public EcoSystem(SupplierEnterprise mSupplier, ManufacturingEnterprise mManufacturer, RetailerEnterprise mRetailer, LogisticsEnterprise mLogisitics) {
        this.mUserAccountDirectory = new UserAccountDirectory();
        this.mSupplier = mSupplier;
        this.mManufacturer = mManufacturer;
        this.mRetailer = mRetailer;
        this.mLogisitics = mLogisitics;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return mUserAccountDirectory;
    }

    public SupplierEnterprise getmSupplier() {
        return mSupplier;
    }

    public ManufacturingEnterprise getmManufacturer() {
        return mManufacturer;
    }

    public RetailerEnterprise getmRetailer() {
        return mRetailer;
    }

    public LogisticsEnterprise getmLogisitics() {
        return mLogisitics;
    }

    public void setUserAccountDirectory(UserAccountDirectory mUserAccountDirectory) {
        this.mUserAccountDirectory = mUserAccountDirectory;
    }


    public void setmSupplier(SupplierEnterprise mSupplier) {
        this.mSupplier = mSupplier;
    }

    public void setmManufacturer(ManufacturingEnterprise mManufacturer) {
        this.mManufacturer = mManufacturer;
    }

    public void setmRetailer(RetailerEnterprise mRetailer) {
        this.mRetailer = mRetailer;
    }

    public void setmLogisitics(LogisticsEnterprise mLogisitics) {
        this.mLogisitics = mLogisitics;
    }

    public Enterprise getEnterprise(Role role) {
        
        if(mSupplier.getOrganisation(role) != null) {
            return mSupplier;
        }
        if(mManufacturer.getOrganisation(role) != null) {
            return mManufacturer;
        }if(mLogisitics.getOrganisation(role) != null) {
            return mLogisitics;
        }
        if(mRetailer.getOrganisation(role) != null) {
            return mRetailer;
        }
        return null;
    }
}
