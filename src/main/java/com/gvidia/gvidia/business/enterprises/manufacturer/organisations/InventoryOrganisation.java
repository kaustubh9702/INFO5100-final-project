package com.gvidia.gvidia.business.enterprises.manufacturer.organisations;

import com.gvidia.gvidia.business.enterprise.Enterprise;
import com.gvidia.gvidia.business.enterprise.location.Address;
import com.gvidia.gvidia.business.enterprise.organisation.Organization;
import com.gvidia.gvidia.business.enterprise.role.Role;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequestDirectory;
import com.gvidia.gvidia.business.enterprises.logisitics.organisations.OnGroundDeliveryOrg;
import com.gvidia.gvidia.business.enterprises.logisitics.wr.OffGroundWorkRequest;
import com.gvidia.gvidia.business.enterprises.manufacturer.wr.ProductPlacementWorkRequest;
import com.gvidia.gvidia.business.enterprises.retailer.wr.OrderWorkRequest;
import com.gvidia.gvidia.business.order.Order;
import com.gvidia.gvidia.business.order.OrderItem;
import com.gvidia.gvidia.business.order.Product;
import com.gvidia.gvidia.business.order.Shipment;
import com.gvidia.gvidia.business.useraccount.UserAccount;
import com.gvidia.gvidia.ui.base.Controller;
import com.gvidia.gvidia.ui.logisitics.OnGroundPanel;
import com.gvidia.gvidia.ui.manufacturing.InventoryPanel;

import javax.swing.*;
import java.util.*;
/**
 *
 * @author kaustubh
 */
public class InventoryOrganisation extends Organization {


    Map<Product, Integer> mInventory;
    WorkRequestDirectory<ProductPlacementWorkRequest> mInventoryRequests;
    WorkRequestDirectory<OrderWorkRequest> mOrderWorkRequestWorkRequests;




    public InventoryOrganisation() {
        super("Inventory Managers");
        mInventory = new HashMap<>();
        mInventoryRequests =  new WorkRequestDirectory<>();
        mOrderWorkRequestWorkRequests = new WorkRequestDirectory<>();
    }

    @Override
    public List<Role> getSupportedRole(Object object) {
        return Arrays.asList( new InvManRole(object)
         );
    }

    public Map<Product, Integer> getmInventory() {
        return mInventory;
    }
    public WorkRequestDirectory<ProductPlacementWorkRequest> getmInventoryRequests() {
        return mInventoryRequests;
    }

    public WorkRequestDirectory<OrderWorkRequest> getmOrderWorkRequestWorkRequests() {
        return mOrderWorkRequestWorkRequests;
    }

    public void addToRequests(ProductPlacementWorkRequest p) {
        mInventoryRequests.add(p);
    }
    public void addToInventory(ProductPlacementWorkRequest p) {
        p.setResolved();
        mInventory.put(p.getmProductToPlace(),mInventory.getOrDefault(p.getmProductToPlace(),0)+p.getmQuantity());
    }

    public void addOrder(OrderWorkRequest orderWorkRequest) {
        mOrderWorkRequestWorkRequests.add(orderWorkRequest);
    }
    
    public List<OrderItem> getInventoryList() {
        List<OrderItem> items = new LinkedList<>();
        for(Product p: mInventory.keySet()) {
            items.add(new OrderItem(p, mInventory.get(p)));
        }
        return items;
    }



    public Shipment createShipment(OrderWorkRequest orderWorkRequest, Address from, Address to) {

        Order order = orderWorkRequest.getmOrder();
        if(!approve(orderWorkRequest)) {
            return null;
        }
        orderWorkRequest.setStatus(WorkRequest.Status.EN_ROUTE);
        for(OrderItem orderItem: order.getmOrderItems()) {
            int quantityAvail = mInventory.getOrDefault(orderItem.getmProduct(),0);
            mInventory.put(orderItem.getmProduct(), quantityAvail - orderItem.getmQuantity());
        }
        return new Shipment(orderWorkRequest.getmOrder(), from, to) ;
    }

    public boolean approve(OrderWorkRequest orderWorkRequest) {

        for(OrderItem orderItem: orderWorkRequest.getmOrder().getmOrderItems()) {
            int quantityAvail = mInventory.getOrDefault(orderItem.getmProduct(),0);
            if(quantityAvail < orderItem.getmQuantity()) {
                return false;
            }
        }
        return true;
    }
    
            public class InvManRole extends Role {
        public InvManRole(Object obj) {
            super(obj);
        }
         @Override
            public JPanel createWorkArea(Controller controller, Organization organization, UserAccount account, Enterprise business) {
                return new InventoryPanel(controller, organization, account, business);
            }

            @Override
            public String getRoleName() {
                return InventoryOrganisation.class.toString();
            }
    }

}
