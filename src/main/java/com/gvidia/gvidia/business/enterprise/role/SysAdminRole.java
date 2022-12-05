package com.gvidia.gvidia.business.enterprise.role;

import com.gvidia.gvidia.business.enterprise.Enterprise;
import com.gvidia.gvidia.business.enterprise.organisation.Organization;
import com.gvidia.gvidia.business.useraccount.UserAccount;
import com.gvidia.gvidia.ui.base.Controller;
import com.gvidia.gvidia.ui.systemadminworkarea.SysAdminHomePanel;

import javax.swing.*;
/**
 *
 * @author kaustubh, mitesh
 */

public class SysAdminRole extends Role {

    public SysAdminRole(Object mObjective) {
        super(mObjective);
    }

    @Override
    public JPanel createWorkArea(Controller controller, Organization organization, UserAccount account,
                                 Enterprise business) {
        return new SysAdminHomePanel(controller, account,business);
    }

    @Override
    public String getRoleName() {
        return "SysAdmmin";
    }


}
