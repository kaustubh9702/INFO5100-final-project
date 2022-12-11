package com.gvidia.gvidia.business.enterprises.supplier.organisations;

import com.gvidia.gvidia.business.EcoSystem;
import com.gvidia.gvidia.business.base.GenericDirectory;
import com.gvidia.gvidia.business.enterprise.Enterprise;
import com.gvidia.gvidia.business.enterprise.organisation.Organization;
import com.gvidia.gvidia.business.enterprise.role.Role;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequestDirectory;
import com.gvidia.gvidia.business.enterprises.manufacturer.wr.RawMaterialWorkRequest;
import com.gvidia.gvidia.business.enterprises.supplier.wr.SourceMaterialWorkRequest;
import com.gvidia.gvidia.business.useraccount.UserAccount;
import com.gvidia.gvidia.ui.base.Controller;
import com.gvidia.gvidia.ui.retailer.CustomerPanel;
import com.gvidia.gvidia.ui.supplier.ExecutivePanel;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExecutiveOrganisation extends Organization {


    WorkRequestDirectory<RawMaterialWorkRequest> mRawMaterialRequests;
    WorkRequestDirectory<SourceMaterialWorkRequest> mSourceMaterialRequests;



    public ExecutiveOrganisation() {
        super("Executive Team");
        this.mRawMaterialRequests = new WorkRequestDirectory<>();
        this.mSourceMaterialRequests = new WorkRequestDirectory<>();
    }

    public WorkRequestDirectory<RawMaterialWorkRequest> getmRawMaterialRequests() {
        return mRawMaterialRequests;
    }

    public WorkRequestDirectory<SourceMaterialWorkRequest> getmSourceMaterialRequests() {
        return mSourceMaterialRequests;
    }

    @Override
    public List<Role> getSupportedRole(Object object) {
        return Arrays.asList(
                new ExRole(object)
         );
    }

    public SourceMaterialWorkRequest askUnion(RawMaterialWorkRequest raw) {
        SourceMaterialWorkRequest sw = SourceMaterialWorkRequest.createRequest(raw);
        this.getmSourceMaterialRequests().add(sw);
        return sw;
    }
    
                public class ExRole extends Role {
        
        public ExRole(Object obj) {
            super(obj);
        }
                @Override
                    public JPanel createWorkArea(Controller controller, Organization organization, UserAccount account, Enterprise business) {
                        return new ExecutivePanel(controller, organization, account, business);
                    }

            @Override
            public String getRoleName() {
                return ExecutiveOrganisation.class.toString();
            }
    }

}