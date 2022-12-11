///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.gvidia.gvidia.business.deliveryman;
//
//import com.gvidia.gvidia.business.base.TableSerializable;
//import com.gvidia.gvidia.business.order.Order;
//import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest;
//import javax.swing.ImageIcon;
//
///**
// *
// * @author kaustubh
// */
//public class DeliveryWorkRequest  extends WorkRequest implements TableSerializable{
//
//    Order mOrder;
//
//
//    public DeliveryWorkRequest(Order mOrder) {
//         this.mOrder = mOrder;
//
//    }
//
//
//
//    public Order getmOrder() {
//        return mOrder;
//    }
//
//    public void setmOrder(Order mOrder) {
//        this.mOrder = mOrder;
//    }
//
//
//
//    @Override
//    public void delete() {
//    }
//
//    @Override
//    public String[] columns() {
//        return new String[]{
//            "ID",
//            "Cusomter Name",
//            "Customer Address",
//            "Status",
//        };
//    }
//
//    @Override
//    public Object[] row() {
//        return new Object[]{
//            mID,
//            mOrder.getmCustomer().getmName(),
//            mOrder.getmCustomer().getmAddress(),
//            this.getStatus()
//        };
//    }
//
//    @Override
//    public ImageIcon getImageIcon() {
//        return null;
//    }
//
//
//
//
//
//
//
//}
