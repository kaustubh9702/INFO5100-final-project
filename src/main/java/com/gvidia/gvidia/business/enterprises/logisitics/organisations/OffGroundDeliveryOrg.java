package com.gvidia.gvidia.business.enterprises.logisitics.organisations;

import com.gvidia.gvidia.business.EcoSystem;
import com.gvidia.gvidia.business.base.GenericDirectory;
import com.gvidia.gvidia.business.deliveryman.DeliveryMan;
import com.gvidia.gvidia.business.enterprise.Enterprise;
import com.gvidia.gvidia.business.enterprise.organisation.Organization;
import com.gvidia.gvidia.business.enterprise.role.Role;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequestDirectory;
import com.gvidia.gvidia.business.enterprises.logisitics.wr.OffGroundWorkRequest;
import com.gvidia.gvidia.business.useraccount.UserAccount;
import com.gvidia.gvidia.ui.base.Controller;
import com.gvidia.gvidia.ui.logisitics.OffGroundPanel;
import com.gvidia.gvidia.ui.logisitics.OnGroundPanel;
import com.sun.org.apache.bcel.internal.generic.DDIV;
import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import org.jfree.data.xy.XYSeriesCollection;
/**
 *
 * @author kaustubh, mitesh
 */
public class OffGroundDeliveryOrg extends Organization {

    WorkRequestDirectory<OffGroundWorkRequest> mOffGroundWorkRequestWorkRequestDirectory;
    GenericDirectory<DeliveryMan> mDeliveryMenDirectory;

    public OffGroundDeliveryOrg() {
        super("Purchase Org");
        mOffGroundWorkRequestWorkRequestDirectory = new WorkRequestDirectory<>();
        mDeliveryMenDirectory = new GenericDirectory<>();
    }

    public WorkRequestDirectory<OffGroundWorkRequest> getRequests() {
        return mOffGroundWorkRequestWorkRequestDirectory;
    }

    @Override
    public List<Role> getSupportedRole(Object object) {
        return Arrays.asList(
                new OffGroundRole(object)
        );
    }

    public void deliveryDone(OffGroundWorkRequest offGroundWorkRequest, UserAccount ua) {

        DeliveryMan man = new DeliveryMan("", ua, 0);
        offGroundWorkRequest.setStatus(WorkRequest.Status.FULFILLED);
        offGroundWorkRequest.setmDeliveryMan(man);
    }
    
    
    public class OffGroundRole extends Role {
        public OffGroundRole(Object obj) {
            super(obj);
        }
         @Override
            public JPanel createWorkArea(Controller controller, Organization organization, UserAccount account, Enterprise business) {
                return new OffGroundPanel(controller, organization, account, business);
            }

            @Override
            public String getRoleName() {
                return OffGroundDeliveryOrg.class.toString();
            }
    }

}
