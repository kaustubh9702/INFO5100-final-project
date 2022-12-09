package com.gvidia.gvidia.business.enterprises.manufacturer.wr;

import com.gvidia.gvidia.business.base.TableSerializable;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest;


import java.util.Objects;
import javax.swing.ImageIcon;
/**
 *
 * @author kaustubh, krishica
 */
public class MaterialWorkRequest extends WorkRequest implements TableSerializable{

    int mRequestedQuantity;

    public MaterialWorkRequest(int rq) {
        this.mRequestedQuantity = rq;
    }


    public int getmRequestedQuantity() {
        return mRequestedQuantity;
    }

    @Override
    public void delete() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MaterialWorkRequest that = (MaterialWorkRequest) o;
        return super.equals(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mRequestedQuantity);
    }

    public static MaterialWorkRequest createMaterialRequest(int q) {
        return new MaterialWorkRequest(q);
    }

    @Override
    public String[] columns() {
        return new String[]{
            "ID",
            "Quantity",
            "Status"
        };
    }

    @Override
    public Object[] row() {
        return new Object[]{
            mID,
            mRequestedQuantity,
            getStatus()
        };
    }

    @Override
    public ImageIcon getImageIcon() {
        return null;
    }

}
