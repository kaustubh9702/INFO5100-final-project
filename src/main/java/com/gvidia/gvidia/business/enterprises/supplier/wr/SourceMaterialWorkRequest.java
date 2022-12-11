package com.gvidia.gvidia.business.enterprises.supplier.wr;

import com.gvidia.gvidia.business.base.TableSerializable;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest;
import com.gvidia.gvidia.business.enterprises.manufacturer.wr.RawMaterialWorkRequest;
import com.gvidia.gvidia.business.order.Order;

import java.util.Objects;
import javax.swing.ImageIcon;

public class SourceMaterialWorkRequest extends WorkRequest implements TableSerializable{

    RawMaterialWorkRequest mRawMaterialWorkRequest;
    public SourceMaterialWorkRequest(RawMaterialWorkRequest rawMaterialWorkRequest) {
        this.mRawMaterialWorkRequest = rawMaterialWorkRequest;
    }

    public static SourceMaterialWorkRequest createRequest(RawMaterialWorkRequest rawMaterialWorkRequest) {
        return new SourceMaterialWorkRequest(rawMaterialWorkRequest);
    }

    public RawMaterialWorkRequest getmRawMaterialWorkRequest() {
        return mRawMaterialWorkRequest;
    }

    public void setmRawMaterialWorkRequest(RawMaterialWorkRequest mRawMaterialWorkRequest) {
        this.mRawMaterialWorkRequest = mRawMaterialWorkRequest;
    }
    

    @Override
    public void delete() {


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SourceMaterialWorkRequest that = (SourceMaterialWorkRequest) o;
        return super.equals(that);
    }


    @Override
    public void setStatus(Status status) {
        super.setStatus(status);
        mRawMaterialWorkRequest.setStatus(status);
    }

    @Override
    public void setResolved() {
        super.setResolved();
    }

    @Override
    public String[] columns() {
        return new String[]{
            "ID",
            "Requester",
            "Quantity",
            "Hours",
            "Status"
        };
    }

    @Override
    public Object[] row() {
        return new Object[]{
            getmID(),
            getSender() == null ? "N/A" : getSender().getEmployee().getName(),
            getmRawMaterialWorkRequest().getmMaterialWorkRequest().getmRequestedQuantity(),
            getmRawMaterialWorkRequest().hours(),
            getStatus()
        };
    }

    @Override
    public ImageIcon getImageIcon() {
        return null;
    }
}
