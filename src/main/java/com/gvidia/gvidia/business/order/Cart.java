/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business.order;

import com.gvidia.gvidia.business.useraccount.UserAccount;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mitesh
 */
public class Cart {
    
    List<OrderItem> mOrderItems;
    UserAccount mAcocunt;

    public Cart(UserAccount mAcocunt) {
        this.mOrderItems = new ArrayList<OrderItem>();
        this.mAcocunt = mAcocunt;
    }

    public List<OrderItem> getmOrderItems() {
        return mOrderItems;
    }


    
    public Order createOrder() {
        Order order = new Order(mOrderItems,mAcocunt);
        return order;
    }
    public UserAccount getAccount(){return mAcocunt;}

    public boolean add(Product t) {
    
        
        OrderItem i = null;
        for(OrderItem item:this.getmOrderItems()) {
            if(item.getmProduct().equals(t)) {
                i = item;
            }
        }
        if(i == null) {
            i = new OrderItem(t, 0);
            this.getmOrderItems().add(i);
        }
        i.setmQuantity(i.getmQuantity()+1);

        
        
        return true;
        
    
    }

    public void clear() {
        this.mOrderItems.clear();
    }

    public boolean remove(Product t) {
         for(OrderItem item:this.getmOrderItems()) {
            if(item.getmProduct().equals(t)) {
                return this.getmOrderItems().remove(item);
            }
        }
        System.out.println("sss");
        return false;
    }




}
