package com.gvidia.gvidia.business.enterprises.logisitics;

import com.gvidia.gvidia.business.EcoSystem;
import com.gvidia.gvidia.business.db4outil.DB4OUtil;
import com.gvidia.gvidia.business.enterprise.employee.Employee;
import com.gvidia.gvidia.business.enterprises.logisitics.organisations.OffGroundDeliveryOrg;
import com.gvidia.gvidia.business.enterprises.logisitics.organisations.OnGroundDeliveryOrg;
import com.gvidia.gvidia.business.util.Helper;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LogisticsEnterpriseTest {
    EcoSystem system;
    LogisticsEnterprise mLogistics;

    @BeforeAll
    public void setUp() throws Exception {
        system = EcoSystem.getInstance();
        mLogistics = new LogisticsEnterprise();

    }

    @Test
    @Order(1)
    public void organisationTest() {
        OnGroundDeliveryOrg union = new OnGroundDeliveryOrg();
        mLogistics.getmOrganizationList().add(union);
        OffGroundDeliveryOrg ex = new OffGroundDeliveryOrg();
        mLogistics.getmOrganizationList().add(ex);
        assertEquals(mLogistics.getmOrganizationList().size(),2);
    }

    @Test
    @Order(2)
    public void onGroundTest() {
        OnGroundDeliveryOrg union = (OnGroundDeliveryOrg) mLogistics.getmOrganizationList().getList().get(0);
        assertNotNull(union);
        addOnGroundMen(system, union, 5);
        assertNotNull(system.getUserAccountDirectory().authenticateUser("onground0","onground0"));
    }
    @Test
    @Order(3)
    public void offGroundTest() {
        assertEquals(2, mLogistics.getmOrganizationList().size());
        OffGroundDeliveryOrg executiveOrganisation = (OffGroundDeliveryOrg) mLogistics.getmOrganizationList().get(1);
        assertNotNull( mLogistics.getmOrganizationList().get(1));
        addOffGroundMen(system, executiveOrganisation, 5);
        assertNotNull(system.getUserAccountDirectory().authenticateUser("offground0","offground0"));
    }

    @AfterAll
    public void tearDown() {
        system.setmLogisitics(mLogistics);
        DB4OUtil.getInstance().storeSystem(system);
    }

    
}