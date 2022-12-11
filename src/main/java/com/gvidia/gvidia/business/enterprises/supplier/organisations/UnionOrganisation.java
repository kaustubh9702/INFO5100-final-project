package com.gvidia.gvidia.business.enterprises.supplier.organisations;

import com.gvidia.gvidia.business.EcoSystem;
import com.gvidia.gvidia.business.base.GenericDirectory;
import com.gvidia.gvidia.business.enterprise.Enterprise;
import com.gvidia.gvidia.business.enterprise.location.Address;
import com.gvidia.gvidia.business.enterprise.organisation.Organization;
import com.gvidia.gvidia.business.enterprise.role.Role;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequestDirectory;
import com.gvidia.gvidia.business.enterprises.supplier.wr.SourceMaterialWorkRequest;
import com.gvidia.gvidia.business.order.Shipment;
import com.gvidia.gvidia.business.useraccount.UserAccount;
import com.gvidia.gvidia.ui.base.Controller;
import com.gvidia.gvidia.ui.supplier.ExecutivePanel;
import com.gvidia.gvidia.ui.supplier.UnionPanel;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionOrganisation extends Organization {


    WorkRequestDirectory<SourceMaterialWorkRequest> mSourceMaterialWorkRequests;
    public UnionOrganisation() {
        super("Union");
        this.mSourceMaterialWorkRequests = new WorkRequestDirectory<>();
    }

    public WorkRequestDirectory<SourceMaterialWorkRequest> getmSourceMaterialWorkRequests() {
        return mSourceMaterialWorkRequests;
    }

    @Override
    public List<Role> getSupportedRole(Object object) {
        return Arrays.asList(
                new UnionRole(object)
        );
    }

    public Shipment createShipment(SourceMaterialWorkRequest sourceMaterialWorkRequest, Address from, Address to) {

        Shipment s =Shipment.createShipment(sourceMaterialWorkRequest.getmRawMaterialWorkRequest().getmRawMaterialOrder(), from, to);
        sourceMaterialWorkRequest.setStatus(WorkRequest.Status.EN_ROUTE);

        return s;
    }
    
                   public class UnionRole extends Role {
        
        public UnionRole(Object obj) {
            super(obj);
        }
                @Override
                    public JPanel createWorkArea(Controller controller, Organization organization, UserAccount account, Enterprise business) {
                        return new UnionPanel(controller, organization, account, business);
                    }

            @Override
            public String getRoleName() {
                return UnionOrganisation.class.toString();
            }
    }

}
