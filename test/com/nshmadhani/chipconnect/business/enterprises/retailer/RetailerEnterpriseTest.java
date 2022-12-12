package com.gvidia.gvidia.business.enterprises.retailer;

import com.github.javafaker.Faker;
import com.gvidia.gvidia.business.EcoSystem;
import com.gvidia.gvidia.business.db4outil.DB4OUtil;
import com.gvidia.gvidia.business.enterprise.employee.Employee;
import com.gvidia.gvidia.business.enterprises.retailer.organisations.ProcurementOrganisation;
import com.gvidia.gvidia.business.enterprises.retailer.organisations.SalesOrganisation;
import com.gvidia.gvidia.business.enterprises.retailer.personnel.customer.Customer;
import com.gvidia.gvidia.business.enterprises.supplier.SupplierEnterprise;
import com.gvidia.gvidia.business.enterprises.supplier.organisations.ExecutiveOrganisation;
import com.gvidia.gvidia.business.enterprises.supplier.organisations.UnionOrganisation;
import com.gvidia.gvidia.business.useraccount.UserAccount;
import com.gvidia.gvidia.business.util.Helper;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class RetailerEnterpriseTest {

    EcoSystem system;
    RetailerEnterprise mRetailer;
    @BeforeAll
    public void setUp() throws Exception {
        system = EcoSystem.getInstance();
        mRetailer = new RetailerEnterprise();
    }

    @Test
    @Order(1)
    public void organisationTest() {
        ProcurementOrganisation procurementOrganisation = new ProcurementOrganisation();
        mRetailer.getmOrganizationList().add(procurementOrganisation);
        SalesOrganisation sales = new SalesOrganisation();
        mRetailer.getmOrganizationList().add(sales);
        assertEquals(mRetailer.getmOrganizationList().getList().size(),2);
    }

    @Test
    @Order(2)
    public void procurementTest() {
        ProcurementOrganisation procurementOrganisation = (ProcurementOrganisation) mRetailer.getmOrganizationList().getList().get(0);
        assertNotNull(procurementOrganisation);
        addProcurementManager(system, procurementOrganisation, 5);
        assertNotNull(system.getUserAccountDirectory().authenticateUser("procurer0","procurer0"));
    }
    @Test
    @Order(3)
    public void salesOrgTest() {
        SalesOrganisation salesOrganisation = (SalesOrganisation) mRetailer.getmOrganizationList().getList().get(1);
        assertNotNull(salesOrganisation);
        addCustomers(system, salesOrganisation, 5);
        assertNotNull(system.getUserAccountDirectory().authenticateUser("customer2","customer2"));
    }

    @AfterAll
    public void tearDown() {
        system.setmRetailer(mRetailer);
        DB4OUtil.getInstance().storeSystem(system);
    }

    private void addCustomers(EcoSystem system, SalesOrganisation salesOrganisation, int i) {

        int size = mRetailer.getCustomerDirectory().size();
        for(;i>=0;i--,size++) {
            Faker faker = new Faker(new Locale("en-IND"));
            UserAccount ua = system.getUserAccountDirectory().createUserAccount(
                    "customer"+size,"customer"+size ,"nsh1madhani@gmail.com", null,
                    null);
            Customer cus = mRetailer.getCustomerDirectory().add(faker.name().fullName(), faker.address().streetAddress(),
                    faker.phoneNumber().cellPhone(),Helper.getAvatarFile(),ua);
            cus.getmUserAccount().setRole(salesOrganisation.getSupportedRole(cus).get(0));

        }
    }

    private static void addProcurementManager(EcoSystem system, ProcurementOrganisation procurementOrganisation, int i ) {
        List<Employee> emps = Helper.createEmployees(procurementOrganisation, i);
        for(Employee emp:emps) {
            system.getUserAccountDirectory().createUserAccount("procurer"+emp.getmID(), "procurer"+emp.getmID(),
                    "nsh1madhani@gmail.com", emp, procurementOrganisation.getSupportedRole(emp).get(0));
        }
    }
}