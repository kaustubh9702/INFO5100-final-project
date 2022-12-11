package com.gvidia.gvidia.business.enterprises.manufacturer;

import com.gvidia.gvidia.business.EcoSystem;
import com.gvidia.gvidia.business.db4outil.DB4OUtil;
import com.gvidia.gvidia.business.enterprise.employee.Employee;
import com.gvidia.gvidia.business.enterprises.manufacturer.organisations.InventoryOrganisation;
import com.gvidia.gvidia.business.enterprises.manufacturer.organisations.ProductDevelopmentOrganisation;
import com.gvidia.gvidia.business.enterprises.manufacturer.organisations.PurchaseOrganisation;
import com.gvidia.gvidia.business.util.Helper;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class ManfEnterpriseTest {
    EcoSystem system;
    ManufacturingEnterprise manufacturingEnterprise;
    @BeforeAll
    public void setUp(){
        system = EcoSystem.getInstance();
        manufacturingEnterprise = new ManufacturingEnterprise();
    }

    @Test
    @Order(1)
    public void organisationTest() {
        PurchaseOrganisation purchaseOrganisation = new PurchaseOrganisation();
        manufacturingEnterprise.getmOrganizationList().add(purchaseOrganisation);
        ProductDevelopmentOrganisation productDevelopmentOrganisation = new ProductDevelopmentOrganisation();
        manufacturingEnterprise.getmOrganizationList().add(productDevelopmentOrganisation);
        InventoryOrganisation io = new InventoryOrganisation();
        manufacturingEnterprise.getmOrganizationList().getList().add(io);
        assertNotNull(manufacturingEnterprise.getFromList(2));
        assertEquals(manufacturingEnterprise.getmOrganizationList().getList().size(),3);
    }

    @Test
    @Order(2)
    public void productDevTest() {
        ProductDevelopmentOrganisation productDevelopmentOrganisation = manufacturingEnterprise.getProductDevOrganisation();
        assertNotNull(productDevelopmentOrganisation);
        addProductDevs(system, productDevelopmentOrganisation, 5);
        assertNotNull(system.getUserAccountDirectory().authenticateUser("dev0","dev0"));
    }
    @Test
    @Order(3)
    public void inventoryManTest() {
        InventoryOrganisation inventoryOrganisation = (InventoryOrganisation) manufacturingEnterprise.getFromList(2);
        assertNotNull(inventoryOrganisation);
        addInventoryManager(system, inventoryOrganisation, 5);
        assertNotNull(system.getUserAccountDirectory().authenticateUser("imanager4","imanager4"));
    }
    @Test
    @Order(4)
    public void purchaseOrgTest() {
        PurchaseOrganisation purchaseOrganisation = manufacturingEnterprise.getPurchaseOrganisation();
        assertNotNull(purchaseOrganisation);
        addPurchasers(system, purchaseOrganisation, 5);
        //Testing if Wrong passwords authenticate
        assertNull(system.getUserAccountDirectory().authenticateUser("purchaser4","customer4"));
    }


    @AfterAll
    public void tearDown() {
        system.setmManufacturer(manufacturingEnterprise);
        DB4OUtil.getInstance().storeSystem(system);
    }


    private static void addProductDevs(EcoSystem system, ProductDevelopmentOrganisation productDevelopmentOrganisation, int i ) {
        List<Employee> emps = Helper.createEmployees(productDevelopmentOrganisation, i);
        for(Employee emp:emps) {
            system.getUserAccountDirectory().createUserAccount("dev"+emp.getmID(), "dev"+emp.getmID(),
                    "nsh1madhani@gmail.com", emp, productDevelopmentOrganisation.getSupportedRole(emp).get(0));
        }
    }
    private static void addInventoryManager(EcoSystem system, InventoryOrganisation inventoryOrganisation, int i ) {
        List<Employee> emps = Helper.createEmployees(inventoryOrganisation, i);
        for(Employee emp:emps) {
            system.getUserAccountDirectory().createUserAccount("imanager"+emp.getmID(), "imanager"+emp.getmID(),
                    "nsh1madhani@gmail.com", emp, inventoryOrganisation.getSupportedRole(emp).get(0));
        }
    }
    private static void addPurchasers(EcoSystem system, PurchaseOrganisation purchaseOrganisation, int i ) {
        List<Employee> emps = Helper.createEmployees(purchaseOrganisation, i);
        for(Employee emp:emps) {
            system.getUserAccountDirectory().createUserAccount("purchaser"+emp.getmID(), "purchaser"+emp.getmID(),
                    "nsh1madhani@gmail.com", emp, purchaseOrganisation.getSupportedRole(emp).get(0));
        }
    }
}