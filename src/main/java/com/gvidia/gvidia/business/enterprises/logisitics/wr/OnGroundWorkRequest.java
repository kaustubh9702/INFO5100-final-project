package com.gvidia.gvidia.business.enterprises.logisitics.wr;

import com.gvidia.gvidia.business.base.TableSerializable;
import com.gvidia.gvidia.business.deliveryman.DeliveryMan;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest;
import com.gvidia.gvidia.business.enterprises.retailer.wr.OrderWorkRequest;
import com.gvidia.gvidia.business.order.Shipment;
import javax.swing.ImageIcon;
/**
 *
 * @author kaustubh
 */
public class OnGroundWorkRequest extends WorkRequest implements TableSerializable{

    Shipment mShipment;
    DeliveryMan mDeliveryMan;
    WorkRequest mShipmentRequest;

    public OnGroundWorkRequest(Shipment mShipment, DeliveryMan mDeliveryMan, WorkRequest mShipmentRequest) {
        this.mShipment = mShipment;
        this.mDeliveryMan = mDeliveryMan;
        this.mShipmentRequest = mShipmentRequest;
    }

    public Shipment getmShipment() {
        return mShipment;
    }

    public DeliveryMan getmDeliveryMan() {
        return mDeliveryMan;
    }

    public void setmDeliveryMan(DeliveryMan mDeliveryMan) {
        this.mDeliveryMan = mDeliveryMan;
    }
    


    public static OnGroundWorkRequest createOnGroundWorkRequest(Shipment s, OrderWorkRequest orderWorkRequest) {
        return new OnGroundWorkRequest(s, null, orderWorkRequest);
    }


    @Override
    public void delete() {

    }

    @Override
    public void setStatus(Status status) {
        super.setStatus(status);
        if(status.equals(Status.FULFILLED)) mShipmentRequest.setResolved();
        else mShipmentRequest.setStatus(status);
    }

    @Override
    public void setResolved() { setStatus(Status.FULFILLED); }
    
    public String[] columns() {
        return new String[]{
            "mID",
            "Delivery Man",
            "To",
            "From",
            "Status"
        };
    }

    @Override
    public Object[] row() {
        return new Object[]{
            getmID(),
            mDeliveryMan == null ?"None" :mDeliveryMan.getmUserAccount().getEmployee().getName(),
            mShipment.getmPickUpAddress().toString(),
            mShipment.getmDropOffAddress().toString(),
            getStatus()
        };
    }

    @Override
    public ImageIcon getImageIcon() {
        return null;
    }
}
