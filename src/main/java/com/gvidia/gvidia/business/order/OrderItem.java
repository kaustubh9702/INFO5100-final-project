/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business.order;

import com.gvidia.gvidia.business.base.Identifier;
import com.gvidia.gvidia.business.base.TableSerializable;
import com.gvidia.gvidia.business.order.Product;
import java.util.Objects;

import javax.swing.ImageIcon;

/**
 *
 * @author Mitesh
 */
public class OrderItem extends Identifier implements TableSerializable{
    
    
    Product mProduct;
    int mQuantity;
    private static int count = 0;
    public OrderItem(Product mProduct, int mQuantity) {
        super(count++);
        this.mProduct = mProduct;
        this.mQuantity = mQuantity;
    }

    public Product getmProduct() {
        return mProduct;
    }

    public void setmProduct(Product mProduct) {
        this.mProduct = mProduct;
    }

    public int getmQuantity() {
        return mQuantity;
    }

    public void setmQuantity(int mQuantity) {
        this.mQuantity = mQuantity;
    }
    
    
    public double getPrice() {
        return mProduct.getPrice() *  mQuantity;
    }

    @Override
    public void delete() {
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderItem other = (OrderItem) obj;
        if (this.mQuantity != other.mQuantity) {
            return false;
        }
        if (!Objects.equals(this.mProduct, other.mProduct)) {
            return false;
        }
        return true;
    }
    
    
    

    @Override
    public String[] columns() {
         return new String[] {
           "Image",
           "Name",
           "Price",
           "Quantity",
           "Total"
       };
    }

    @Override
    public Object[] row() {
         return new Object[]{
            mProduct.getImageIcon(), //getmImage and getImage are two different function, both need to be there seperately
            mProduct.getName(),
            mQuantity,
            mProduct.getPrice(),
            getPrice()
       }; 
    }

   @Override
    public ImageIcon getImageIcon() {
        return mProduct.getImageIcon();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
