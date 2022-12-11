/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business;

import com.github.javafaker.Faker;
import com.gvidia.gvidia.business.db4outil.DB4OUtil;
import com.gvidia.gvidia.business.enterprise.employee.Employee;
import com.gvidia.gvidia.business.enterprise.role.Role;
import com.gvidia.gvidia.business.enterprises.logisitics.LogisticsEnterprise;
import com.gvidia.gvidia.business.enterprises.logisitics.organisations.OffGroundDeliveryOrg;
import com.gvidia.gvidia.business.enterprises.logisitics.organisations.OnGroundDeliveryOrg;
import com.gvidia.gvidia.business.enterprises.manufacturer.ManufacturingEnterprise;
import com.gvidia.gvidia.business.enterprises.manufacturer.organisations.InventoryOrganisation;
import com.gvidia.gvidia.business.enterprises.manufacturer.organisations.ProductDevelopmentOrganisation;
import com.gvidia.gvidia.business.enterprises.manufacturer.organisations.PurchaseOrganisation;
import com.gvidia.gvidia.business.enterprises.retailer.RetailerEnterprise;
import com.gvidia.gvidia.business.enterprises.retailer.organisations.ProcurementOrganisation;
import com.gvidia.gvidia.business.enterprises.retailer.organisations.SalesOrganisation;
import com.gvidia.gvidia.business.enterprises.retailer.personnel.customer.Customer;
import com.gvidia.gvidia.business.enterprises.supplier.SupplierEnterprise;
import com.gvidia.gvidia.business.enterprises.supplier.organisations.ExecutiveOrganisation;
import com.gvidia.gvidia.business.enterprises.supplier.organisations.UnionOrganisation;
import com.gvidia.gvidia.business.useraccount.UserAccount;
import com.gvidia.gvidia.business.util.Helper;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author kaustubh
 */
public class Setup {
    public static void setup(EcoSystem instance) {

        logistics(instance);
        suuplier(instance);
        retailer(instance);
        manufacturer(instance);
         
    }
    
    public static void logistics(EcoSystem instance) {
          
        LogisticsEnterprise mLogistics = instance.getmLogisitics();
        OnGroundDeliveryOrg union = new OnGroundDeliveryOrg();
        mLogistics.getmOrganizationList().add(union);
        OffGroundDeliveryOrg ex = new OffGroundDeliveryOrg();
        mLogistics.getmOrganizationList().add(ex);
        
        addOffGroundMen(instance, ex, 5);
        addOnGroundMen(instance, union, 5);
    }
    
    public static void suuplier(EcoSystem instance) {
          
        SupplierEnterprise mSupplier = instance.getmSupplier();
        UnionOrganisation union = new UnionOrganisation();
        mSupplier.getmOrganizationList().add(union);
        ExecutiveOrganisation ex = new ExecutiveOrganisation();
        mSupplier.getmOrganizationList().add(ex);
        
        addExecutives(instance, ex, 5);
        addUnionLeaders(instance, union, 5);
    }
    
    public static void retailer(EcoSystem instance) {
          
        RetailerEnterprise mRetailer = instance.getmRetailer();
        ProcurementOrganisation procurementOrganisation = new ProcurementOrganisation();
        mRetailer.getmOrganizationList().add(procurementOrganisation);
        SalesOrganisation sales = new SalesOrganisation();
        mRetailer.getmOrganizationList().add(sales);
        
        addCustomers(instance, sales, 5, mRetailer);
        addProcurementManager(instance, procurementOrganisation, 5);
        
    }
    
    public static void manufacturer(EcoSystem instance) {
        
        ManufacturingEnterprise ent = instance.getmManufacturer();
        PurchaseOrganisation purchaseOrganisation = new PurchaseOrganisation();
        ent.getmOrganizationList().add(purchaseOrganisation);
        ProductDevelopmentOrganisation productDevelopmentOrganisation = new ProductDevelopmentOrganisation();
        ent.getmOrganizationList().add(productDevelopmentOrganisation);
        InventoryOrganisation io = new InventoryOrganisation();
        ent.getmOrganizationList().getList().add(io);
        
        addProductDevs(instance, productDevelopmentOrganisation, 5);
        addInventoryManager(instance, io, 5);
        addPurchasers(instance, purchaseOrganisation, 5);
        
    }
    
    
    private static void addOffGroundMen(EcoSystem system, OffGroundDeliveryOrg executiveOrganisation, int i) {
        List<Employee> emps = Helper.createEmployees(executiveOrganisation, i);
        for(Employee emp:emps) {
            Role r = executiveOrganisation.getSupportedRole(emp).get(0);
            system.getUserAccountDirectory().createUserAccount("offground"+emp.getmID(), "offground"+emp.getmID(),
                    "kaustubhlawale4@gmail.com", emp, r);
        }
    }

    private static void addOnGroundMen(EcoSystem system, OnGroundDeliveryOrg onGroundDeliveryOrg, int i ) {
        List<Employee> emps = Helper.createEmployees(onGroundDeliveryOrg, i);
        for(Employee emp:emps) {
            system.getUserAccountDirectory().createUserAccount("onground"+emp.getmID(), "onground"+emp.getmID(),
                    "kaustubhlawale4@gmail.com", emp, onGroundDeliveryOrg.getSupportedRole(emp).get(0));
        }
    }
    
    
    private static void addProductDevs(EcoSystem system, ProductDevelopmentOrganisation productDevelopmentOrganisation, int i ) {
        List<Employee> emps = Helper.createEmployees(productDevelopmentOrganisation, i);
        for(Employee emp:emps) {
            system.getUserAccountDirectory().createUserAccount("dev"+emp.getmID(), "dev"+emp.getmID(),
                    "kaustubhlawale4@gmail.com", emp, productDevelopmentOrganisation.getSupportedRole(emp).get(0));
        }
    }
    private static void addInventoryManager(EcoSystem system, InventoryOrganisation inventoryOrganisation, int i ) {
        List<Employee> emps = Helper.createEmployees(inventoryOrganisation, i);
        for(Employee emp:emps) {
            system.getUserAccountDirectory().createUserAccount("imanager"+emp.getmID(), "imanager"+emp.getmID(),
                    "kaustubhlawale4@gmail.com", emp, inventoryOrganisation.getSupportedRole(emp).get(0));
        }
    }
    private static void addPurchasers(EcoSystem system, PurchaseOrganisation purchaseOrganisation, int i ) {
        List<Employee> emps = Helper.createEmployees(purchaseOrganisation, i);
        for(Employee emp:emps) {
            system.getUserAccountDirectory().createUserAccount("purchaser"+emp.getmID(), "purchaser"+emp.getmID(),
                    "kaustubhlawale4@gmail.com", emp, purchaseOrganisation.getSupportedRole(emp).get(0));
        }
    }
    
    private static void addCustomers(EcoSystem system, SalesOrganisation salesOrganisation, int i, RetailerEnterprise mRetailer) {
        int size = mRetailer.getCustomerDirectory().size();
        for(;i>=0;i--,size++) {
            Faker faker = new Faker(new Locale("en-IND"));
            
            UserAccount ua = system.getUserAccountDirectory().createUserAccount(
                    "customer"+size,"customer"+size ,"kaustubhlawale4@gmail.com", null,
                    null);
            Customer cus = mRetailer.getCustomerDirectory()
                    .add(faker.name().fullName(), faker.address().streetAddress(),
                    faker.phoneNumber().cellPhone(),Helper.getAvatarFile(),ua);
            
            cus.getmUserAccount().setRole(salesOrganisation.getSupportedRole(cus).get(0));

        }
    }
    private static void addProcurementManager(EcoSystem system, ProcurementOrganisation procurementOrganisation, int i ) {
        List<Employee> emps = Helper.createEmployees(procurementOrganisation, i);
        for(Employee emp:emps) {
            system.getUserAccountDirectory().createUserAccount("procurer"+emp.getmID(), "procurer"+emp.getmID(),
                    "kaustubhlawale4@gmail.com", emp, procurementOrganisation.getSupportedRole(emp).get(0));
        }
    }
    
    private static void addExecutives(EcoSystem system, ExecutiveOrganisation executiveOrganisation, int i) {
        List<Employee> emps = Helper.createEmployees(executiveOrganisation, i);
        for(Employee emp:emps) {
            system.getUserAccountDirectory().createUserAccount("executive"+emp.getmID(), "executive"+emp.getmID(),
                    "kaustubhlawale4@gmail.com", emp, executiveOrganisation.getSupportedRole(emp).get(0));
        }
    }
    private static void addUnionLeaders(EcoSystem system, UnionOrganisation unionOrganisation, int i ) {
        List<Employee> emps = Helper.createEmployees(unionOrganisation, i);
        for(Employee emp:emps) {
            System.out.println(emp.getmID());
            system.getUserAccountDirectory().createUserAccount("uleader"+emp.getmID(), "uleader"+emp.getmID(),
                    "kaustubhlawale4@gmail.com", emp, unionOrganisation.getSupportedRole(emp).get(0));
        }
    }
}
