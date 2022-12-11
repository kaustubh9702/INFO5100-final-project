package com.gvidia.gvidia.business.enterprises.manufacturer.wr;

import com.gvidia.gvidia.business.base.TableSerializable;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest;
import com.gvidia.gvidia.business.enterprises.supplier.SupplierEnterprise;
import com.gvidia.gvidia.business.order.Cart;
import com.gvidia.gvidia.business.order.Product;
import java.io.Serializable;

import java.util.Objects;
import javax.swing.ImageIcon;
/**
 *
 * @author kaustubh
 */
public class ProductPlacementWorkRequest extends WorkRequest implements TableSerializable{

    private Product mProductToPlace;
    private int mQuantity;

    public ProductPlacementWorkRequest(Product p, int quantity) {
        this.mProductToPlace = p;
        this.mQuantity = quantity;
    }


    public static ProductPlacementWorkRequest createRequest(Product p, int quantity) {
        return new ProductPlacementWorkRequest(p, quantity);
    }


    public Product getmProductToPlace() {
        return mProductToPlace;
    }

    public void setmProductToPlace(Product mProductToPlace) {
        this.mProductToPlace = mProductToPlace;
    }

    public int getmQuantity() {
        return mQuantity;
    }

    public void setmQuantity(int mQuantity) {
        this.mQuantity = mQuantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductPlacementWorkRequest that = (ProductPlacementWorkRequest) o;
        return super.equals(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mProductToPlace, mQuantity);
    }

    @Override
    public void delete() {
    }

    @Override
    public String[] columns() {
        return new String[]{
            "ID",
            "Name",
            "Quantity",
            "Status"
        };
    }

    @Override
    public Object[] row() {
        return new Object[]{
            mID,
            mProductToPlace.getName(),
            mQuantity,
            getStatus()
        };
    }

    @Override
    public ImageIcon getImageIcon() {
        return null;
    }
}
