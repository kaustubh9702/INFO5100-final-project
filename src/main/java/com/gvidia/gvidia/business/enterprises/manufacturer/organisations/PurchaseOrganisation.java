package com.gvidia.gvidia.business.enterprises.manufacturer.organisations;

import com.gvidia.gvidia.business.EcoSystem;
import com.gvidia.gvidia.business.base.GenericDirectory;
import com.gvidia.gvidia.business.enterprise.Enterprise;
import com.gvidia.gvidia.business.enterprise.organisation.Organization;
import com.gvidia.gvidia.business.enterprise.role.Role;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequestDirectory;
import com.gvidia.gvidia.business.enterprises.manufacturer.wr.MaterialWorkRequest;
import com.gvidia.gvidia.business.enterprises.manufacturer.wr.RawMaterialWorkRequest;
import com.gvidia.gvidia.business.order.Cart;
import com.gvidia.gvidia.business.useraccount.UserAccount;
import com.gvidia.gvidia.ui.base.Controller;import com.gvidia.gvidia.ui.manufacturing.PurchaserPanel;


import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author kaustubh, mitesh
 */
public class PurchaseOrganisation extends Organization {

    WorkRequestDirectory<RawMaterialWorkRequest> mMaterialRequests;
    WorkRequestDirectory<RawMaterialWorkRequest> mRawMaterialWorkRequests;
    Map<UserAccount, Cart> mCarts;


    public PurchaseOrganisation() {
        super("Purchase Org");
        mMaterialRequests = new WorkRequestDirectory<>();
        mRawMaterialWorkRequests = new WorkRequestDirectory<>();
        mCarts = new HashMap<>();
    }

    public WorkRequestDirectory<RawMaterialWorkRequest> getmMaterialRequests() {
        return mMaterialRequests;
    }

    public Cart getCart(UserAccount userAccount) {
        Cart a = mCarts.get(userAccount);
        if(a == null)
            a =  new Cart(userAccount);
        mCarts.put(userAccount,a);
        return a;
    }

    public WorkRequestDirectory<RawMaterialWorkRequest> getmRawMaterialWorkRequests() {
        return mRawMaterialWorkRequests;
    }


    @Override
    public List<Role> getSupportedRole(Object object) {
        return Arrays.asList(
                new PurchaserRole(object)
        );
    }

    public RawMaterialWorkRequest requestRawMaterial(UserAccount account, MaterialWorkRequest materialWorkRequest) {
        RawMaterialWorkRequest rawMaterialWorkRequest = RawMaterialWorkRequest.createRequest(materialWorkRequest,account);
        mMaterialRequests.add(rawMaterialWorkRequest);
        return rawMaterialWorkRequest;
    }
    
    public class PurchaserRole extends Role {
        
        public PurchaserRole(Object obj) {
            super(obj);
        }
                @Override
                    public JPanel createWorkArea(Controller controller, Organization organization, UserAccount account, Enterprise business) {
                        return new PurchaserPanel(controller, organization, account, business);
                    }

            @Override
            public String getRoleName() {
                return PurchaseOrganisation.class.toString();
            }
    }
}
