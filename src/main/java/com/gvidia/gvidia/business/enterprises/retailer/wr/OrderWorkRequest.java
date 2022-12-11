package com.gvidia.gvidia.business.enterprises.retailer.wr;

import com.gvidia.gvidia.business.base.TableSerializable;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest;
import static com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest.Status.CREATED;
import com.gvidia.gvidia.business.order.Order;

import java.util.Objects;
import javax.swing.ImageIcon;

public class OrderWorkRequest extends WorkRequest implements TableSerializable{

    Order mOrder;
    boolean isInventory = false;

    public OrderWorkRequest(Order mOrder) {
        this.mOrder = mOrder;
    }

    public Order getmOrder() {
        return mOrder;
    }


    public static OrderWorkRequest createOrderWorkRequest(Order order) {
        return new OrderWorkRequest(order);
    }

    @Override
    public String getStatus() {
        if(status().equals(CREATED))
            return "In Inv";
        return super.getStatus(); //To change body of generated methods, choose Tools | Templates.
    }
    
    


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OrderWorkRequest that = (OrderWorkRequest) o;
        return super.equals(that);
    }


    @Override
    public void delete() {

    }

    @Override
    public void setResolved() {
        super.setResolved();
    }

    public Boolean isInventory() {
        return isInventory;
    }

    @Override
    public String[] columns() {
        return new String[]{
            "ID",
            "From",
            "Items",
            "Total",
            "Status"
        };
    }

    @Override
    public Object[] row() {
        return new Object[]{
            getmID(),
            getSender() == null? "N/A":getSender().getUsername(),
            getmOrder().items(),
            getmOrder().total(),
            getStatus()
        };
    }

    @Override
    public ImageIcon getImageIcon() {
        return null;
    }
}
