package com.gvidia.gvidia.business.enterprises.manufacturer;

import com.gvidia.gvidia.business.enterprise.Enterprise;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest;
import static com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest.Status.CREATED;
import static com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest.Status.FULFILLED;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequestDirectory;
import com.gvidia.gvidia.business.enterprises.manufacturer.organisations.InventoryOrganisation;
import com.gvidia.gvidia.business.enterprises.manufacturer.organisations.ProductDevelopmentOrganisation;
import com.gvidia.gvidia.business.enterprises.manufacturer.organisations.PurchaseOrganisation;
import com.gvidia.gvidia.business.enterprises.manufacturer.wr.MaterialWorkRequest;
import com.gvidia.gvidia.business.enterprises.manufacturer.wr.ProductPlacementWorkRequest;
import com.gvidia.gvidia.business.enterprises.manufacturer.wr.RawMaterialWorkRequest;
import com.gvidia.gvidia.business.enterprises.retailer.wr.OrderWorkRequest;
import com.gvidia.gvidia.business.order.OrderItem;
import com.gvidia.gvidia.business.order.Product;
import com.gvidia.gvidia.business.useraccount.UserAccount;
import com.gvidia.gvidia.ui.Colors;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.UnknownKeyException;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
/**
 *
 * @author kaustubh, krishica
 */
public class ManufacturingEnterprise extends Enterprise {

    public ManufacturingEnterprise() {
        super("PSN Chips");
    }












    public RawMaterialWorkRequest developProduct(UserAccount account, String name, double price, String photo, int q, int material) {
        Product p = new Product(name, price,photo, material);
        MaterialWorkRequest materialWorkRequest = getProductDevOrganisation().developProduct(p,q,material);
        RawMaterialWorkRequest rawMaterialWorkRequest = getPurchaseOrganisation().requestRawMaterial(account, materialWorkRequest);
        return rawMaterialWorkRequest;
    }


    @Override
    public void delete() {

    }


    public InventoryOrganisation getInventoryOrganisation() {
        return (InventoryOrganisation) getFromList(2);
    }

    public ProductDevelopmentOrganisation getProductDevOrganisation() { return (ProductDevelopmentOrganisation) getFromList(1);
    }
    public PurchaseOrganisation getPurchaseOrganisation() {
        return (PurchaseOrganisation) getFromList(0);
    }

    public void placeProduct(ProductPlacementWorkRequest p) {
        getInventoryOrganisation().addToRequests(p);
    }
    
        @Override
    public Colors getThemeColor() {
        return new Colors(){
            @Override
            public Color PRIMARY() {
                return Color.decode("#4a148c");
            }

            @Override
            public Color PRIMARY_LIGHT() {
                return Color.decode("#c50e29");
            }

            @Override
            public Color PRIMARY_DARK() {
                return Color.decode("#7f0000");
            }

            @Override
            public Color SECONDARY() {
                return Color.decode("#aa00ff");
            }

            @Override
            public Color SECONDARY_LIGHT() {
                return Color.decode("#e254ff");
            }

            @Override
            public Color SECONDARY_DARK() {
                return Color.decode("#e254ff");
            }

            @Override
            public Color COMPL_WHITE() {
                return Color.decode("#f3e5f5");
            }
            
        };
    }
    private Integer getValue(DefaultPieDataset dataset, Product p) {
        int x = 0;
        try {
                    x = dataset.getValue(p) == null ? 0 : 
                        dataset.getValue(p).intValue();
                } catch(UnknownKeyException e) {
                    
                }
        return x;
    }
    @Override
    public JFreeChart  getInsights() {
    
        DefaultPieDataset dataset = new DefaultPieDataset();  
        
        
        InventoryOrganisation inv = getInventoryOrganisation();
        
        WorkRequestDirectory<OrderWorkRequest> customerOrders = inv.getmOrderWorkRequestWorkRequests();
        
        for(OrderWorkRequest t:customerOrders.getList()) {
            System.out.println(t.getStatus());
            if(!t.status().equals(CREATED)) continue;
            for(OrderItem i: t.getmOrder().getmOrderItems()) {
                dataset.setValue(i.getmProduct(), 
                        new Integer(i.getmQuantity()) + getValue(dataset, i.getmProduct()));
            }
        }
        for(Product p: inv.getmInventory().keySet()) {
                dataset.setValue(p, 
                        new Integer(0) + getValue(dataset, p));
        
        }
        
        
        return ChartFactory.createPieChart("Product Share", dataset, true, true, true);
    }


}
