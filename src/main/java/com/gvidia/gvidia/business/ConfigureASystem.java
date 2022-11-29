package com.gvidia.gvidia.business;

import com.gvidia.gvidia.business.enterprise.role.SysAdminRole;
import com.gvidia.gvidia.business.enterprises.retailer.personnel.customer.Customer;
import com.gvidia.gvidia.business.enterprise.employee.Employee;
import com.gvidia.gvidia.business.enterprises.logisitics.LogisticsEnterprise;
import com.gvidia.gvidia.business.enterprises.manufacturer.ManufacturingEnterprise;
import com.gvidia.gvidia.business.enterprises.retailer.RetailerEnterprise;
import com.gvidia.gvidia.business.enterprises.supplier.SupplierEnterprise;
import com.gvidia.gvidia.business.useraccount.UserAccount;

    
/**
 *
 * @author kaustubh
 */
public class ConfigureASystem {


    public static final String BASE_IMG = "C:\\Users\\kaustubh\\Documents\\Studies\\Fall 2022\\INFO5100\\";
    public static EcoSystem configure(){

        EcoSystem system = new EcoSystem(new SupplierEnterprise(),
                                        new ManufacturingEnterprise(),
                                    new RetailerEnterprise(),new LogisticsEnterprise());

        Employee emp = new Employee(Integer.MAX_VALUE, "kaustubh lawale", "123-4567-890", "");
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", 
                "sysadmin", "kaustubhlawale54@gmail.com", emp, 
                new SysAdminRole(null));

        Setup.setup(system);
        return system;
    }




}
