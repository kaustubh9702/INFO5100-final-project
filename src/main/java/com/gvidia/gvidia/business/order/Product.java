/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business.order;

import com.gvidia.gvidia.business.base.Identifier;
import com.gvidia.gvidia.business.base.TableSerializable;
import com.gvidia.gvidia.business.utils.ImageUtil;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Mitesh
 */
public class Product extends Identifier implements TableSerializable, Comparable<Product>{


    private static  int counter = 0;
    String mName;
    double mPrice;
    String mSelectedImage;
    int mMaterialRequired;
    private ImageIcon mImageIcon;

    public Product(String name,double price, String selectedImagePath, int mMaterialRequired) {
        super(counter++);
        this.mName = name;
        this.mPrice = price;
        this.mSelectedImage = selectedImagePath;
        this.mMaterialRequired = mMaterialRequired;

    }

    public int getmMaterialRequired() {
        return mMaterialRequired;
    }
    
    

    public void setmMaterialRequired(int mMaterialRequired) {
        this.mMaterialRequired = mMaterialRequired;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        this.mPrice = price;
    }


    public String getSelectedImage() {
        return mSelectedImage;
    }

    public void setmSelectedImage(String mSelectedImage) {
        this.mSelectedImage = mSelectedImage;
    }
    

    

    
    

    @Override
    public void delete() {
    }

    @Override
    public String[] columns() {
       return new String[] {
           "Image",
           "ID",
           "Name",
           "Price"
       };
    }

    @Override
    public Object[] row() {
       return new Object[]{
           getImageIcon(),
           mID,
           mName,
           mPrice
       }; 
       
    }

    @Override
    public String toString() {
        return mName;
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
        final Product other = (Product) obj;
        return super.equals(other);
    }
    
    @Override
    public ImageIcon getImageIcon() {
        return ImageUtil.getImageIcon(90, 60, mSelectedImage);
    }

    @Override
    public int compareTo(Product o) {
        return o.toString().compareTo(toString());
    }
}
