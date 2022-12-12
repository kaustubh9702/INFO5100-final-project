//package com.gvidia.gvidia.business.working;
//
//import com.db4o.Db4o;
//import com.gvidia.gvidia.business.EcoSystem;
//import com.gvidia.gvidia.business.db4outil.DB4OUtil;
//import com.gvidia.gvidia.business.enterprise.employee.Employee;
//import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest;
//import com.gvidia.gvidia.business.enterprises.logisitics.LogisticsEnterprise;
//import com.gvidia.gvidia.business.enterprises.logisitics.organisations.OffGroundDeliveryOrg;
//import com.gvidia.gvidia.business.enterprises.logisitics.organisations.OnGroundDeliveryOrg;
//import com.gvidia.gvidia.business.enterprises.logisitics.wr.OffGroundWorkRequest;
//import com.gvidia.gvidia.business.enterprises.manufacturer.ManufacturingEnterprise;
//import com.gvidia.gvidia.business.enterprises.manufacturer.organisations.InventoryOrganisation;
//import com.gvidia.gvidia.business.enterprises.manufacturer.organisations.ProductDevelopmentOrganisation;
//import com.gvidia.gvidia.business.enterprises.manufacturer.organisations.PurchaseOrganisation;
//import com.gvidia.gvidia.business.enterprises.manufacturer.wr.MaterialWorkRequest;
//import com.gvidia.gvidia.business.enterprises.manufacturer.wr.ProductPlacementWorkRequest;
//import com.gvidia.gvidia.business.enterprises.manufacturer.wr.RawMaterialWorkRequest;
//import com.gvidia.gvidia.business.enterprises.supplier.SupplierEnterprise;
//import com.gvidia.gvidia.business.enterprises.supplier.organisations.ExecutiveOrganisation;
//import com.gvidia.gvidia.business.enterprises.supplier.organisations.UnionOrganisation;
//import com.gvidia.gvidia.business.enterprises.supplier.wr.SourceMaterialWorkRequest;
//import com.gvidia.gvidia.business.order.Product;
//import com.gvidia.gvidia.business.order.Shipment;
//import com.gvidia.gvidia.business.useraccount.UserAccount;
//import com.gvidia.gvidia.business.util.Helper;
//import org.junit.jupiter.api.*;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class ProductCreationTest {
//
//
//
//    EcoSystem system;
//    ManufacturingEnterprise mManufacturingEnterprise;
//    SupplierEnterprise mSupplier;
//    LogisticsEnterprise mLogistics;
//
//    @BeforeAll
//
//    public  void setUp() throws Exception {
//        system = EcoSystem.getInstance();
//        mManufacturingEnterprise = (ManufacturingEnterprise) system.getmManufacturer();
//        mSupplier = (SupplierEnterprise) system.getmSupplier();
//        mLogistics = system.getmLogisitics();
//    }
//
//    @Test
//    @Order(1)
//    public void supplierOrganisationTest() {
//     //See if there is the organisations we neet
//
//        assertEquals(mSupplier.getmOrganizationList().getList().size(), 2);
//        assertNotNull((UnionOrganisation)mSupplier.getmOrganizationList().getList().get(0));
//        assertNotNull((ExecutiveOrganisation)mSupplier.getmOrganizationList().getList().get(1));
//
//    }
//    @Test
//    @Order(2)
//    public void manufacturingOrganisationTest() {
//        //See if there is the organisations we neet
//        assertEquals(mManufacturingEnterprise.getmOrganizationList().getList().size(), 3);
//        assertNotNull(mManufacturingEnterprise.getProductDevOrganisation());
//        assertNotNull(mManufacturingEnterprise.getInventoryOrganisation());
//        assertNotNull(mManufacturingEnterprise.getProductDevOrganisation());
//
//
//
//    }
//
//    @Test
//    @Order(3)
//    public void createProduct() {
//
//
//        int PRODUCTS_TO_CREATE = 1;
//
//        for(int i=0;i<PRODUCTS_TO_CREATE;i++) {
//            createProduct("Iphone",1000, "", 10,100);
//        }
//
//
//    }
//
//
//
//    public Product createProduct(String prductName, double price, String photo, int q, int material) {
//
//        UserAccount account = system.getUserAccountDirectory().authenticateUser("purchaser0", "purchaser0");
//        assertNotNull(account);
//
//        RawMaterialWorkRequest raw = mManufacturingEnterprise.developProduct(account, prductName,price, photo, q, material);
//
//        assertEquals( 1,raw.getmRawMaterialOrder().getmOrderItems().size());
//        assertEquals(100,raw.getmRawMaterialOrder().getmOrderItems().get(0).getmQuantity());
//
//
//        assertEquals(raw.status(), WorkRequest.Status.PENDING);
//        assertEquals(raw.getmMaterialWorkRequest().status(), WorkRequest.Status.PENDING);
//
//        int size = mManufacturingEnterprise.getPurchaseOrganisation().getmRawMaterialWorkRequests().size();
//
//        assertNotEquals(0,size);
//        assertEquals(mManufacturingEnterprise.getPurchaseOrganisation().getmRawMaterialWorkRequests().get(size-1), raw);
//
//        assertEquals(mManufacturingEnterprise.getPurchaseOrganisation().getmMaterialRequests().size(), 1);
//        assertEquals(mManufacturingEnterprise.getPurchaseOrganisation().getmMaterialRequests().get(0), raw);
//
//
//        ProductPlacementWorkRequest p = mManufacturingEnterprise.getProductDevOrganisation().getProductFromMaterialRequest(raw.getmMaterialWorkRequest());
//        assertNotNull(p);
//        assertEquals(p.getmProductToPlace().getName().equals("Iphone"), true);
//
//        assertEquals(mManufacturingEnterprise.getProductDevOrganisation().getmRequestsForProductMaterial().get(p), raw.getmMaterialWorkRequest());
//
//
//        //Now the Purchaser will send it to supplier
//
//        //Basically give the request to executive
//        mSupplier.sourceMaterial(raw);
//        assertEquals(mSupplier.getExecutiveOrganisation().getmRawMaterialRequests().size(),1);
//        assertEquals(mSupplier.getExecutiveOrganisation().getmRawMaterialRequests().get(0),raw);
//
//        //Now Executive gives to Union
//        SourceMaterialWorkRequest sourceMaterialWorkRequest = mSupplier.getExecutiveOrganisation().askUnion(raw);
//        assertEquals(mSupplier.getExecutiveOrganisation().getmSourceMaterialRequests().size(),1);
//        assertEquals(mSupplier.getExecutiveOrganisation().getmSourceMaterialRequests().get(0),sourceMaterialWorkRequest);
//
//        mSupplier.askUnionToSource(sourceMaterialWorkRequest);
//        assertEquals(mSupplier.getUnionOrganisation().getmSourceMaterialWorkRequests().size(),1);
//        assertEquals(mSupplier.getUnionOrganisation().getmSourceMaterialWorkRequests().get(0),sourceMaterialWorkRequest);
//
//        //Union will now source it and then ship it in one Action
//        Shipment s = mSupplier.getUnionOrganisation().createShipment(sourceMaterialWorkRequest, null, null);
//        assertEquals(s.getmOrderToBeDelivered(), sourceMaterialWorkRequest.getmRawMaterialWorkRequest().getmRawMaterialOrder());
//
//
//
//        //Supplier will ship
//        mLogistics.shipOffGround(s, sourceMaterialWorkRequest);
//
//        assertNotEquals(0,mLogistics.getOffGroundDeliveryOrg().getRequests().size());
//        assertNotNull(mLogistics.getOffGroundDeliveryOrg().getRequests().get(0));
//
//        OffGroundWorkRequest offGroundWorkRequest = (OffGroundWorkRequest) mLogistics.getOffGroundDeliveryOrg().getRequests().get(0);
//
//        assertEquals(s,offGroundWorkRequest.getmShipment());
//        assertEquals(sourceMaterialWorkRequest,offGroundWorkRequest.getmShipmentRequest());
//
//
//        assertEquals(offGroundWorkRequest.status(), WorkRequest.Status.PENDING);
//        assertEquals(sourceMaterialWorkRequest.status(), WorkRequest.Status.EN_ROUTE);
//        assertEquals(raw.status(), WorkRequest.Status.EN_ROUTE);
//        assertEquals(raw.getmMaterialWorkRequest().status(), WorkRequest.Status.EN_ROUTE);
//
//        //Now Delivery Man will mark as fulltilled
//        mLogistics.getOffGroundDeliveryOrg().deliveryDone(offGroundWorkRequest);
//
//
//        assertEquals(offGroundWorkRequest.status(), WorkRequest.Status.FULFILLED);
//        assertEquals(sourceMaterialWorkRequest.status(), WorkRequest.Status.FULFILLED);
//        assertEquals(raw.status(), WorkRequest.Status.FULFILLED);
//        assertEquals(raw.getmMaterialWorkRequest().status(), WorkRequest.Status.FULFILLED);
//
//        assertTrue(mManufacturingEnterprise.getProductDevOrganisation().isMateiralAvailable(p));
//
//        //Now Since they have received it, Push to inventory by developer
////        List<WorkRequest> deliveryDone = mManufacturingEnterprise.getProductDevOrganisation().getmMaterialWorkRequest().filter(WorkRequest.Status.FULFILLED);
////        assertEquals(1, deliveryDone.size());
////
////        mManufacturingEnterprise.getProductDevOrganisation().finishDevelopment(p);
////        assertEquals(p.status(), WorkRequest.Status.EN_ROUTE);
////
////
////        //Done by Dev
////        mManufacturingEnterprise.placeProduct(p);
////        assertEquals(mManufacturingEnterprise.getInventoryOrganisation().getmInventoryRequests().size(),1);
////        assertEquals(mManufacturingEnterprise.getInventoryOrganisation().getmInventoryRequests().get(0), p);
////
////
////        //Accept INventory
////        mManufacturingEnterprise.getInventoryOrganisation().addToInventory(p);
////        assertNotEquals(0, mManufacturingEnterprise.getInventoryOrganisation().getmInventory().size());
////        assertEquals(mManufacturingEnterprise.getInventoryOrganisation().getmInventory().get(p.getmProductToPlace()), 10);
//
//
//
//        return p.getmProductToPlace();
//
//    }
//
//    @AfterAll
//    public void tearDown() {
//        //DB4OUtil.getInstance().storeSystem(system);
//    }
//
//
//
//
//
//
//
//}
