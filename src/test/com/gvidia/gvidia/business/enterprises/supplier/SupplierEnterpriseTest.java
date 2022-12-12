package com.gvidia.gvidia.business.enterprises.supplier;

import com.github.javafaker.Faker;
import com.gvidia.gvidia.business.EcoSystem;
import com.gvidia.gvidia.business.db4outil.DB4OUtil;
import com.gvidia.gvidia.business.deliveryman.DeliveryMan;
import com.gvidia.gvidia.business.enterprise.employee.Employee;
import com.gvidia.gvidia.business.enterprise.organisation.Organization;
import com.gvidia.gvidia.business.enterprises.supplier.organisations.ExecutiveOrganisation;
import com.gvidia.gvidia.business.enterprises.supplier.organisations.UnionOrganisation;
import com.gvidia.gvidia.business.useraccount.UserAccount;
import com.gvidia.gvidia.business.util.Helper;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SupplierEnterpriseTest {

    EcoSystem system;
    SupplierEnterprise mSupplier;
    @BeforeAll
    public void setUp() throws Exception {
        system = EcoSystem.getInstance();
        mSupplier = new SupplierEnterprise();
    }

    @Test
    @Order(1)
    public void organisationTest() {
        UnionOrganisation union = new UnionOrganisation();
        mSupplier.getmOrganizationList().add(union);
        ExecutiveOrganisation ex = new ExecutiveOrganisation();
        mSupplier.getmOrganizationList().add(ex);
        assertEquals(mSupplier.getmOrganizationList().getList().size(),2);
    }

    @Test
    @Order(2)
    public void unionLeaderTest() {
        UnionOrganisation union = (UnionOrganisation) mSupplier.getmOrganizationList().getList().get(0);
        assertNotNull(union);
        addUnionLeaders(system, union, 5);
        assertNotNull(system.getUserAccountDirectory().authenticateUser("uleader1","uleader1"));
    }
    @Test
    @Order(3)
    public void executiveHeadTest() {
        ExecutiveOrganisation executiveOrganisation = (ExecutiveOrganisation) mSupplier.getmOrganizationList().getList().get(1);
        assertNotNull(executiveOrganisation);
        addExecutives(system, executiveOrganisation, 5);
        assertNotNull(system.getUserAccountDirectory().authenticateUser("executive0","executive0"));
    }

    @AfterAll
    public void tearDown() {
        system.setmSupplier(mSupplier);
        DB4OUtil.getInstance().storeSystem(system);
    }

    private void addExecutives(EcoSystem system, ExecutiveOrganisation executiveOrganisation, int i) {
        List<Employee> emps = Helper.createEmployees(executiveOrganisation, i);
        for(Employee emp:emps) {
            system.getUserAccountDirectory().createUserAccount("executive"+emp.getmID(), "executive"+emp.getmID(),
                    "nsh1madhani@gmail.com", emp, executiveOrganisation.getSupportedRole(emp).get(0));
        }
    }

    private static void addUnionLeaders(EcoSystem system, UnionOrganisation unionOrganisation, int i ) {
        List<Employee> emps = Helper.createEmployees(unionOrganisation, i);
        for(Employee emp:emps) {
            System.out.println(emp.getmID());
            system.getUserAccountDirectory().createUserAccount("uleader"+emp.getmID(), "uleader"+emp.getmID(),
                    "nsh1madhani@gmail.com", emp, unionOrganisation.getSupportedRole(emp).get(0));
        }
    }



}