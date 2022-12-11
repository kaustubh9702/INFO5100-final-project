package com.gvidia.gvidia.business.enterprises.retailer.organisations;

import com.gvidia.gvidia.business.enterprise.Enterprise;
import com.gvidia.gvidia.business.enterprise.organisation.Organization;
import com.gvidia.gvidia.business.enterprise.role.Role;
import com.gvidia.gvidia.business.enterprises.retailer.personnel.customer.Customer;
import com.gvidia.gvidia.business.enterprises.retailer.personnel.customer.CustomerDirectory;
import com.gvidia.gvidia.business.order.Product;
import com.gvidia.gvidia.business.useraccount.UserAccount;
import com.gvidia.gvidia.ui.base.Controller;
import com.gvidia.gvidia.ui.retailer.CustomerPanel;
import com.gvidia.gvidia.ui.retailer.ProcurerPanel1;
import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author kaustubh, mitesh
 */
public class SalesOrganisation extends Organization {


    CustomerDirectory mCustomerDirectory;
    Map<Product, Integer> mInventory;

    public SalesOrganisation() {
        super("Sales Team");
        mInventory = new HashMap<>();
        mCustomerDirectory = new CustomerDirectory();
    }


    public CustomerDirectory getmCustomerDirectory() {
        return mCustomerDirectory;
    }

    public void setmCustomerDirectory(CustomerDirectory mCustomerDirectory) {
        this.mCustomerDirectory = mCustomerDirectory;
    }

    @Override
    public List<Role> getSupportedRole(Object object) {
        return Arrays.asList(                
                new SalesmenRole(object)
        );
    }

    public Customer getmCustomer(UserAccount account) {
        for(Customer cus:getmCustomerDirectory().getList()) {
            if(cus.getmUserAccount().equals(account)) {
                return cus;
            }
        }
        return null;
    }
    
            public class SalesmenRole extends Role {
        
        public SalesmenRole(Object obj) {
            super(obj);
        }
                @Override
                    public JPanel createWorkArea(Controller controller, Organization organization, UserAccount account, Enterprise business) {
                        return new CustomerPanel(controller, organization, account, business);
                    }

            @Override
            public String getRoleName() {
                return SalesOrganisation.class.toString();
            }
    }


}
