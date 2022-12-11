/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business.order;

import com.gvidia.gvidia.business.base.Identifier;
import com.gvidia.gvidia.business.enterprises.supplier.wr.SourceMaterialWorkRequest;
import com.gvidia.gvidia.business.useraccount.UserAccount;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nisha
 */
public class Order extends Identifier{
    
    List<OrderItem> mOrderItems;
    UserAccount mAccount;

    private static int count = 0;
    
    public Order(List<OrderItem> mOrderItems, UserAccount account) {
        super(count++);
        this.mOrderItems = new LinkedList<>();
        this.mOrderItems.addAll(mOrderItems);
        mAccount = account;
    }

    public List<OrderItem> getmOrderItems() {
        return mOrderItems;
    }

    public void setmOrderItems(List<OrderItem> mOrderItems) {
        this.mOrderItems = mOrderItems;
    }

    public double total() {
        double sum = 0;
        
        
        for(OrderItem item : mOrderItems) {
            sum += item.getPrice();
        }
        return sum;
    }

    @Override
    public void delete() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order that = (Order) o;
        return super.equals(that);
    }

    public int items() {
        int items = 0;
        for(OrderItem i: getmOrderItems()) {
            items += i.getmQuantity();
        }
        return items;
    }
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
