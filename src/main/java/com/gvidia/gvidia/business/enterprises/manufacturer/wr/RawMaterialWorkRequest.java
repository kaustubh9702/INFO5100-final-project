package com.gvidia.gvidia.business.enterprises.manufacturer.wr;

import com.gvidia.gvidia.business.base.TableSerializable;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest;
import com.gvidia.gvidia.business.enterprises.supplier.SupplierEnterprise;
import com.gvidia.gvidia.business.order.Cart;
import com.gvidia.gvidia.business.order.Order;
import com.gvidia.gvidia.business.useraccount.UserAccount;

import java.util.Objects;
import javax.swing.ImageIcon;
/**
 *
 * @author kaustubh
 */

public class RawMaterialWorkRequest extends WorkRequest implements TableSerializable{


    Order mRawMaterialOrder;
    MaterialWorkRequest mMaterialWorkRequest;

    public RawMaterialWorkRequest(Order mRawMaterialOrder, MaterialWorkRequest mMaterialWorkRequest) {
        this.mRawMaterialOrder = mRawMaterialOrder;
        this.mMaterialWorkRequest = mMaterialWorkRequest;
    }

    @Override
    public void delete() {

    }

    public Order getmRawMaterialOrder() {
        return mRawMaterialOrder;
    }

    public MaterialWorkRequest getmMaterialWorkRequest() {
        return mMaterialWorkRequest;
    }

    //Fixed order only quantity changed
    public static RawMaterialWorkRequest createRequest(MaterialWorkRequest mr, UserAccount account) {
        Cart cart = new Cart(account);

        for(int i=0;i<mr.getmRequestedQuantity();i++)
            cart.add(SupplierEnterprise.RawMaterialBundle);

        System.out.println(mr.getmRequestedQuantity());
        return new RawMaterialWorkRequest(cart.createOrder(), mr);
    }


    @Override
    public void setStatus(Status status) {
        super.setStatus(status);
        mMaterialWorkRequest.setStatus(status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RawMaterialWorkRequest that = (RawMaterialWorkRequest) o;
        return super.equals(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mRawMaterialOrder, mMaterialWorkRequest);
    }
    public int hours() {
        return getmRawMaterialOrder().items() * 2; 
    }

   @Override
    public String[] columns() {
        return new String[]{
            "ID",
            "Quantity",
            "Total",
            "Hours",
            "Status"
        };
    }

    @Override
    public Object[] row() {
        return new Object[]{
            mID,
            mMaterialWorkRequest.mRequestedQuantity,
            mRawMaterialOrder.total(),
            hours(),
            getStatus()
        };
    }
    @Override
    public ImageIcon getImageIcon() {
        return null;
    }
}
