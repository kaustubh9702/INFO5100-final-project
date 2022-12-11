package com.gvidia.gvidia.business.enterprises.logisitics.organisations;

import com.gvidia.gvidia.business.EcoSystem;
import com.gvidia.gvidia.business.base.GenericDirectory;
import com.gvidia.gvidia.business.deliveryman.DeliveryMan;
import com.gvidia.gvidia.business.enterprise.Enterprise;
import com.gvidia.gvidia.business.enterprise.organisation.Organization;
import com.gvidia.gvidia.business.enterprise.role.Role;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequestDirectory;
import com.gvidia.gvidia.business.enterprises.logisitics.wr.OnGroundWorkRequest;
import com.gvidia.gvidia.business.useraccount.UserAccount;
import com.gvidia.gvidia.ui.base.Controller;
import com.gvidia.gvidia.ui.logisitics.OffGroundPanel;
import com.gvidia.gvidia.ui.logisitics.OnGroundPanel;
import javax.swing.*;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author kaustubh, mitesh
 */
public class OnGroundDeliveryOrg extends Organization {


    WorkRequestDirectory<OnGroundWorkRequest> mOnGroundWorkRequestWorkRequestDirectory;
    GenericDirectory<DeliveryMan> mDeliveryMenDirectory;

    public OnGroundDeliveryOrg() {
        super("Purchase Org");
        mOnGroundWorkRequestWorkRequestDirectory = new WorkRequestDirectory<>();
        mDeliveryMenDirectory = new GenericDirectory<>();
    }

    public WorkRequestDirectory<OnGroundWorkRequest> getRequests() {
        return mOnGroundWorkRequestWorkRequestDirectory;
    }






    @Override
    public List<Role> getSupportedRole(Object object) {
        return Arrays.asList( new OnGroundRole(object) );
    }

    public void deliveryDone(OnGroundWorkRequest onGroundWorkRequest, UserAccount ua) {
        DeliveryMan man = new DeliveryMan("", ua, 0);
        onGroundWorkRequest.setmDeliveryMan(man);
        onGroundWorkRequest.setStatus(WorkRequest.Status.FULFILLED);
    }
    
        public class OnGroundRole extends Role {
        public OnGroundRole(Object obj) {
            super(obj);
        }
         @Override
            public JPanel createWorkArea(Controller controller, Organization organization, UserAccount account, Enterprise business) {
                return new OnGroundPanel(controller, organization, account, business);
            }

            @Override
            public String getRoleName() {
                return OnGroundDeliveryOrg.class.toString();
            }
    }

}
