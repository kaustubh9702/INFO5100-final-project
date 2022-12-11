//package com.gvidia.gvidia.business.working;
//
//import com.db4o.User;
//import com.gvidia.gvidia.business.EcoSystem;
//import com.gvidia.gvidia.business.db4outil.DB4OUtil;
//import com.gvidia.gvidia.business.enterprise.employee.Employee;
//import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest;
//import com.gvidia.gvidia.business.enterprises.logisitics.LogisticsEnterprise;
//import com.gvidia.gvidia.business.enterprises.logisitics.organisations.OffGroundDeliveryOrg;
//import com.gvidia.gvidia.business.enterprises.logisitics.organisations.OnGroundDeliveryOrg;
//import com.gvidia.gvidia.business.enterprises.logisitics.wr.OffGroundWorkRequest;
//import com.gvidia.gvidia.business.enterprises.logisitics.wr.OnGroundWorkRequest;
//import com.gvidia.gvidia.business.enterprises.manufacturer.ManufacturingEnterprise;
//import com.gvidia.gvidia.business.enterprises.manufacturer.organisations.InventoryOrganisation;
//import com.gvidia.gvidia.business.enterprises.manufacturer.organisations.ProductDevelopmentOrganisation;
//import com.gvidia.gvidia.business.enterprises.manufacturer.organisations.PurchaseOrganisation;
//import com.gvidia.gvidia.business.enterprises.manufacturer.wr.MaterialWorkRequest;
//import com.gvidia.gvidia.business.enterprises.manufacturer.wr.ProductPlacementWorkRequest;
//import com.gvidia.gvidia.business.enterprises.manufacturer.wr.RawMaterialWorkRequest;
//import com.gvidia.gvidia.business.enterprises.retailer.RetailerEnterprise;
//import com.gvidia.gvidia.business.enterprises.retailer.personnel.customer.Customer;
//import com.gvidia.gvidia.business.enterprises.retailer.wr.OrderWorkRequest;
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
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class CustomerOrderTest {
//
//
//    EcoSystem system;
//    ManufacturingEnterprise mManufacturingEnterprise;
//    RetailerEnterprise mRetailer;
//    LogisticsEnterprise mLogistics;
//
//    @BeforeAll
//
//    public  void setUp() throws Exception {
//        system = EcoSystem.getInstance();
//        mManufacturingEnterprise = (ManufacturingEnterprise) system.getmManufacturer();
//        mRetailer=  system.getmRetailer();
//        mLogistics = system.getmLogisitics();
//    }
//
//    @Test
//    @Order(1)
//    public void retailerOrgTest() {
//        //See if there is the organisations we neet
//
//        assertEquals(mRetailer.getmOrganizationList().getList().size(), 2);
//        assertNotNull(mRetailer.getProcurementOrganisation());
//        assertNotNull(mRetailer.getSalesOrganisation());
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
//    public void logisticsEnterpriseTest() {
//        //See if there is the organisations we neet
//        assertEquals(mLogistics.getmOrganizationList().getList().size(), 2);
//        assertNotNull(mLogistics.getOffGroundDeliveryOrg());
//        assertNotNull(mLogistics.getOnGroundDeliveryOrg());
//
//
//    }
//
//
//    @Test
//    @Order(4)
//    public void orderProductsForSale() throws Exception {
//
//
//        Product product = new Product("Iphone", 23, "",10);
//        mManufacturingEnterprise.getInventoryOrganisation().addToInventory(ProductPlacementWorkRequest.createRequest(product,3));
//
//        UserAccount account = system.getUserAccountDirectory().authenticateUser("procurer0", "procurer0");
//        assertNotNull(account);
//        //First you get the products from Manfuacturer
//        product  = testProductExists();
//        //You Buy some and store them with Purchaser Organisation
//        com.gvidia.gvidia.business.order.Order order = createOrder(account, product);
//        assertNotNull(order);
//
//        //Now send it to manufacurer
//        OrderWorkRequest orderWorkRequest  = mRetailer.getProcurementOrganisation().createRequest(order);
//        assertNotNull(orderWorkRequest);
//        assertEquals(orderWorkRequest.getmOrder(), order);
//
//        mManufacturingEnterprise.getInventoryOrganisation().addOrder(orderWorkRequest);
//        assertNotEquals(mManufacturingEnterprise.getInventoryOrganisation().getmOrderWorkRequestWorkRequests().size(), 0);
//        assertEquals(mManufacturingEnterprise.getInventoryOrganisation().getmOrderWorkRequestWorkRequests().get(0), orderWorkRequest);
//
//
//        //Now make the inventory approve it
//        boolean isApproved = testForApproval(orderWorkRequest);
//        assertTrue(isApproved);
//
//        Shipment shipment =  mManufacturingEnterprise.getInventoryOrganisation().createShipment(orderWorkRequest, null, null);
//        assertNotNull(shipment);
//
//        mLogistics.shipOffGround(shipment, orderWorkRequest);
//
//        assertNotEquals(0,mLogistics.getOffGroundDeliveryOrg().getRequests().size());
//        assertNotNull(mLogistics.getOffGroundDeliveryOrg().getRequests().get(0));
//        OffGroundWorkRequest offGroundWorkRequest = (OffGroundWorkRequest) mLogistics.getOffGroundDeliveryOrg().getRequests().get(0);
//        assertEquals(shipment,offGroundWorkRequest.getmShipment());
//        assertEquals(orderWorkRequest,offGroundWorkRequest.getmShipmentRequest());
//
//
//        assertEquals(offGroundWorkRequest.status(), WorkRequest.Status.PENDING);
//        assertEquals(orderWorkRequest.status(), WorkRequest.Status.EN_ROUTE);
//
//        //Now Delivery Man will mark as fulltilled
//        mLogistics.getOffGroundDeliveryOrg().deliveryDone(offGroundWorkRequest);
//
//
//        assertEquals(offGroundWorkRequest.status(), WorkRequest.Status.FULFILLED);
//        assertEquals(orderWorkRequest.status(), WorkRequest.Status.FULFILLED);
//
//        //Now Since they have received it, Push to inventory by developer
////        List<WorkRequest> deliveryDone = mRetailer.getProcurementOrganisation().getmOrderWorkRequests()
////                .filter((workRequest -> !((OrderWorkRequest) workRequest).isInventory()));
////
////        assertEquals(1, deliveryDone.size());
////        assertEquals(orderWorkRequest, deliveryDone.get(0));
////
////        mRetailer.getProcurementOrganisation().placeInInventory(orderWorkRequest);
////
////        assertEquals(mRetailer.getProcurementOrganisation().getmInventory().get(product), 3);
////
////        buyProducts();
//
//
//
//
//
//    }
//
//
//
//
//
//
//
//
//    private com.gvidia.gvidia.business.order.Order createOrder(UserAccount account, Product product) {
//        mRetailer.getProcurementOrganisation().addToCart(account, product);
//        mRetailer.getProcurementOrganisation().addToCart(account, product);
//        mRetailer.getProcurementOrganisation().addToCart(account, product);
//
//        assertNotNull(mRetailer.getProcurementOrganisation().getCart(account));
//        assertEquals(mRetailer.getProcurementOrganisation().getCart(account).getmOrderItems().size(), 1);
//        assertEquals(mRetailer.getProcurementOrganisation().getCart(account).getmOrderItems().get(0).getmQuantity(), 3);
//
//
//        return mRetailer.getProcurementOrganisation().getCart(account).createOrder();
//    }
//
//    private Product testProductExists() {
//        Set<Product> products = mManufacturingEnterprise.getInventoryOrganisation().getmInventory().keySet();
//        assertNotNull(products);
//        assertNotEquals(0,((Set) products).size());
//
//        Product product = products.iterator().next();
//        assertNotNull(product);
//        return product;
//    }
//    private Product testRetailerProducts() {
//        Set<Product> products = mRetailer.getProcurementOrganisation().getmInventory().keySet();
//        assertNotNull(products);
//        assertNotEquals(0,((Set) products).size());
//
//        Product product = products.iterator().next();
//        assertNotNull(product);
//        return product;
//    }
//
//
//
//    public void buyProducts() {
//
//
//            UserAccount account = system.getUserAccountDirectory().authenticateUser("customer0", "customer0");
//            assertNotNull(account);
//
//            //First you get the products from Manfuacturer
//            Product product  = testRetailerProducts();
//
//            // Now create a cart for it
//
//            Customer customer = (Customer) account.getRole().getmObjective();
//            assertNotNull(customer);
//            customer.getmCart().add(product);
//            customer.getmCart().add(product);
//            customer.getmCart().add(product);
//
//            // Then create the order for it
//            com.gvidia.gvidia.business.order.Order order = customer.getmCart().createOrder();
//
//
//            // Use the order as a work request it
//            OrderWorkRequest orderWorkRequest = OrderWorkRequest.createOrderWorkRequest(order);
//            // Send it to inventory
//
//            boolean canPlace = mRetailer.getProcurementOrganisation().placeOrder(orderWorkRequest);
//            // If inventory is there
//                // then accept it
//                // if you cant then reject it
//            assertTrue(canPlace);
//
//
//            // if accepted create on ground request and send it off
//            Shipment s = mRetailer.getProcurementOrganisation().shipOrder(orderWorkRequest, null,null);
//            // update the elivery
//            OnGroundWorkRequest onGroundWorkRequest = mLogistics.shipOnGround(s, orderWorkRequest);
//
//
//            mLogistics.getOnGroundDeliveryOrg().deliveryDone(onGroundWorkRequest);
//
//            // then update the curstomer
//
//
//            assertEquals(onGroundWorkRequest.status(), WorkRequest.Status.FULFILLED);
//            assertEquals(orderWorkRequest.status(), WorkRequest.Status.FULFILLED);
//
//
//    }
//
//
//
//
//
//    private boolean testForApproval(OrderWorkRequest orderWorkRequest) {
//        return mManufacturingEnterprise.getInventoryOrganisation().approve(orderWorkRequest);
//    }
//
//    @AfterAll
//    public void tearDown() {
//    }
//
//
//
//
//
//
//
//}
