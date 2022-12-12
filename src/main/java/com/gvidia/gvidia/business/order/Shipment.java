package com.gvidia.gvidia.business.order;

import com.gvidia.gvidia.business.base.Identifier;
import com.gvidia.gvidia.business.enterprise.location.Address;
import com.gvidia.gvidia.business.enterprises.retailer.wr.OrderWorkRequest;
import com.gvidia.gvidia.business.enterprises.supplier.wr.SourceMaterialWorkRequest;

public class Shipment extends Identifier {

    private static int counter = 0;
    Order mOrderToBeDelivered;
    Address mPickUpAddress;
    Address mDropOffAddress;


    public Shipment(Order mOrderToBeDelivered, Address mPickUpAddress, Address mDropOffAddress) {
        super(counter++);
        this.mOrderToBeDelivered = mOrderToBeDelivered;
        this.mPickUpAddress = mPickUpAddress;
        this.mDropOffAddress = mDropOffAddress;
    }


    public static Shipment createShipment(Order order, Address from, Address to) {
        return new Shipment(order, from, to);
    }


    public Order getmOrderToBeDelivered() {
        return mOrderToBeDelivered;
    }

    public void setmOrderToBeDelivered(Order mOrderToBeDelivered) {
        this.mOrderToBeDelivered = mOrderToBeDelivered;
    }

    public Address getmPickUpAddress() {
        return mPickUpAddress;
    }

    public void setmPickUpAddress(Address mPickUpAddress) {
        this.mPickUpAddress = mPickUpAddress;
    }

    public Address getmDropOffAddress() {
        return mDropOffAddress;
    }

    public void setmDropOffAddress(Address mDropOffAddress) {
        this.mDropOffAddress = mDropOffAddress;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Shipment that = (Shipment) o;
        return super.equals(that);
    }

    @Override
    public void delete() {

    }
}
