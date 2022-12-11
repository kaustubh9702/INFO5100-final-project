package com.gvidia.gvidia.business.enterprises.retailer.organisations;

import com.gvidia.gvidia.business.enterprise.Enterprise;
import com.gvidia.gvidia.business.enterprise.location.Address;
import com.gvidia.gvidia.business.enterprise.organisation.Organization;
import com.gvidia.gvidia.business.enterprise.role.Role;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequestDirectory;
import com.gvidia.gvidia.business.enterprises.logisitics.wr.OnGroundWorkRequest;
import com.gvidia.gvidia.business.enterprises.retailer.wr.OrderWorkRequest;
import com.gvidia.gvidia.business.order.*;
import com.gvidia.gvidia.business.useraccount.UserAccount;
import com.gvidia.gvidia.ui.base.Controller;
import com.gvidia.gvidia.ui.manufacturing.PurchaserPanel;
import com.gvidia.gvidia.ui.retailer.ProcurerPanel1;
import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author kaustubh, mitesh
 */
public class ProcurementOrganisation extends Organization {


    Map<Product, Integer> mInventory;
    Map<UserAccount, Cart> mCarts;
    WorkRequestDirectory<OrderWorkRequest> mOrderWorkRequests;
    WorkRequestDirectory<OrderWorkRequest> mCustomerOrders;


    public ProcurementOrganisation() {
        super("Procurement Team");
        mInventory = new HashMap<>();
        mCarts = new HashMap<>();
        mOrderWorkRequests = new WorkRequestDirectory<>();
        mCustomerOrders = new WorkRequestDirectory<>();
    }

    public Cart getCart(UserAccount account) {
        Cart a = mCarts.get(account);
        if(a == null)
            a =  new Cart(account);
        mCarts.put(account,a);
        return a;
    }

    public Map<Product, Integer> getmInventory() {
        return mInventory;
    }


    public Map<UserAccount, Cart> getmCarts() {
        return mCarts;
    }

    public WorkRequestDirectory<OrderWorkRequest> getmCustomerOrders() {
        return mCustomerOrders;
    }

    public void addToCart(UserAccount account, Product p) {
        getCart(account).add(p);
    }

    public Order getOrder(UserAccount account) {
        return getCart(account).createOrder();
    }


    public WorkRequestDirectory<OrderWorkRequest> getmOrderWorkRequests() {
        return mOrderWorkRequests;
    }

    @Override
    public List<Role> getSupportedRole(Object object) {
        return Arrays.asList(
                new ProcurerRole(object)
         );
    }

    public OrderWorkRequest createRequest(Order order) {
        OrderWorkRequest or =  OrderWorkRequest.createOrderWorkRequest(order);
        mOrderWorkRequests.add(or);
        return or;
    }

    public void placeInInventory(OrderWorkRequest orderWorkRequest) {
        orderWorkRequest.setStatus(WorkRequest.Status.CREATED);
        for(OrderItem orderItem:orderWorkRequest.getmOrder().getmOrderItems()) {
            mInventory.put(orderItem.getmProduct(),
                    mInventory.getOrDefault(orderItem.getmProduct(),0) + orderItem.getmQuantity());
        }
    }

    public boolean placeOrder(OrderWorkRequest orderWorkRequest) {
        for(OrderItem orderItem:orderWorkRequest.getmOrder().getmOrderItems()) {
            int q = orderItem.getmQuantity();
            if(q > mInventory.getOrDefault(orderItem.getmProduct(), 0)) {
                return false;
            }
        }
        mCustomerOrders.add(orderWorkRequest);
        return true;
    }

    public Shipment shipOrder(OrderWorkRequest orderWorkRequest, Address from, Address to) {
        orderWorkRequest.setStatus(WorkRequest.Status.EN_ROUTE);
        Shipment s = Shipment.createShipment(orderWorkRequest.getmOrder(),from, to);
        return s;
    }
    public List<OrderItem> getInventoryList() {
        List<OrderItem> items = new LinkedList<>();
        for(Product p: mInventory.keySet()) {
            items.add(new OrderItem(p, mInventory.get(p)));
        }
        return items;
    }
    
        public class ProcurerRole extends Role {
        
        public ProcurerRole(Object obj) {
            super(obj);
        }
                @Override
                    public JPanel createWorkArea(Controller controller, Organization organization, UserAccount account, Enterprise business) {
                        return new ProcurerPanel1(controller, organization, account, business);
                    }

            @Override
            public String getRoleName() {
                return ProcurementOrganisation.class.toString();
            }
    }

}
