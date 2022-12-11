///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.gvidia.gvidia.business.restaraunt;
//
//import com.gvidia.gvidia.business.EcoSystem;
//import com.gvidia.gvidia.business.base.Identifier;
//import com.gvidia.gvidia.business.base.GenericDirectory;
//import com.gvidia.gvidia.business.base.TableSerializable;
//import com.gvidia.gvidia.business.enterprise.employee.Employee;
//import com.gvidia.gvidia.business.order.Cart;
//import com.gvidia.gvidia.business.order.OrderWorkRequest;
//import com.gvidia.gvidia.business.enterprise.role.AdminRole;
//import com.gvidia.gvidia.business.useraccount.UserAccount;
//
//import javax.swing.ImageIcon;
//
///**
// *
// * @author harold
// */
//public class Restaurant extends Identifier implements TableSerializable{
//
//
//
//
//    String mName;
//    String mAddress;
//    String mPhonNumber;
//    Cart.ProductDirectory mMenuDirectory;
//    GenericDirectory<OrderWorkRequest> mOrderDirectory;
//    UserAccount mManager;
//
//
//
//    //TODO ORders
//
//
//
//    public Restaurant(String mName, String mAddress, String mPhonNumber, UserAccount mManager, int mID) {
//        super(mID);
//        this.mName = mName;
//        this.mAddress = mAddress;
//        this.mPhonNumber = mPhonNumber;
//        this.mManager = mManager;
//        mMenuDirectory = new Cart.ProductDirectory();
//        mOrderDirectory = new GenericDirectory<OrderWorkRequest>();
//    }
//
//    @Override
//    public String[] columns() {
//        return new String[]{
//            "Restaurant Name",
//            "Address",
//            "Phone Number",
//            "Managaer",
//        };
//    }
//
//    @Override
//    public Object[] row() {
//       return new Object[]{
//           mName,
//           mAddress,
//           mPhonNumber,
//           mManager.getEmployee().getName()
//       };
//    }
//
//    public String getmName() {
//        return mName;
//    }
//
//    public void setmName(String mName) {
//        this.mName = mName;
//    }
//
//    public String getmAddress() {
//        return mAddress;
//    }
//
//    public void setmAddress(String mAddress) {
//        this.mAddress = mAddress;
//    }
//
//    public String getmPhonNumber() {
//        return mPhonNumber;
//    }
//
//    public void setmPhonNumber(String mPhonNumber) {
//        this.mPhonNumber = mPhonNumber;
//    }
//
//    public Cart.ProductDirectory getmMenuDirectory() {
//        return mMenuDirectory;
//    }
//
//    public void setmMenuDirectory(Cart.ProductDirectory mMenuDirectory) {
//        this.mMenuDirectory = mMenuDirectory;
//    }
//
//    public GenericDirectory<OrderWorkRequest> getmOrderDirectory() {
//        return mOrderDirectory;
//    }
//
//    public void setmOrderDirectory(GenericDirectory<OrderWorkRequest> mOrderDirectory) {
//        this.mOrderDirectory = mOrderDirectory;
//    }
//
//    public UserAccount getmManager() {
//        return mManager;
//    }
//
//    public void setmManager(UserAccount mManager) {
//        this.mManager = mManager;
//    }
//
//
//
//
//    static Restaurant createNewRestaurant(int id, String resName, String address, String phoneNumber, String manName, String userName, String password) {
//
//        Employee employee = EcoSystem.getInstance(true).getEmployeeDirectory().createEmployee(manName);
//        UserAccount userAccount = EcoSystem.getInstance(true).getUserAccountDirectory().createUserAccount(userName, password, employee, null);
//        Restaurant res = new Restaurant(resName,address,phoneNumber, userAccount, id);
//
//        userAccount.setRole(new AdminRole(res));
//
//        return res;
//    }
//
//    @Override
//    public void delete() {
//        mManager.getEmployee().delete();
//        mManager.delete();
//    }
//
//    @Override
//    public ImageIcon getImageIcon() {
//        return null;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Restaurant other = (Restaurant) obj;
//        return super.equals(obj);
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//}
