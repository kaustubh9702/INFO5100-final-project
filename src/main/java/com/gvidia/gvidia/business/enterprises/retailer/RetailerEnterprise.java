package com.gvidia.gvidia.business.enterprises.retailer;

import com.gvidia.gvidia.business.enterprise.Enterprise;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest;
import static com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest.Status.FULFILLED;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequestDirectory;
import com.gvidia.gvidia.business.enterprises.manufacturer.organisations.InventoryOrganisation;
import com.gvidia.gvidia.business.enterprises.retailer.organisations.ProcurementOrganisation;
import com.gvidia.gvidia.business.enterprises.retailer.organisations.SalesOrganisation;
import com.gvidia.gvidia.business.enterprises.retailer.personnel.customer.Customer;
import com.gvidia.gvidia.business.enterprises.retailer.personnel.customer.CustomerDirectory;
import com.gvidia.gvidia.business.enterprises.retailer.wr.OrderWorkRequest;
import com.gvidia.gvidia.business.order.OrderItem;
import com.gvidia.gvidia.business.order.Product;
import com.gvidia.gvidia.ui.Colors;
import java.awt.Color;

import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
/**
 *
 * @author kaustubh, krishica
 */
public class RetailerEnterprise extends Enterprise {




    public RetailerEnterprise() {
        super("Retailer Enterprise");

    }

    public CustomerDirectory getCustomerDirectory() {
        return ((SalesOrganisation) getmOrganizationList().getList().get(1)).getmCustomerDirectory();
    }

    @Override
    public void delete() {

    }

    public SalesOrganisation getSalesOrganisation() {return (SalesOrganisation) getFromList(1);}
    public ProcurementOrganisation getProcurementOrganisation() { return (ProcurementOrganisation) getFromList(0); }

        @Override
    public Colors getThemeColor() {
        return new Colors(){
            @Override
            public Color PRIMARY() {
                return Color.decode("#4a148c");
            }

            @Override
            public Color PRIMARY_LIGHT() {
                return Color.decode("#7c43bd");
            }

            @Override
            public Color PRIMARY_DARK() {
                return Color.decode("#4a148c");
                
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
    
    @Override
    public JFreeChart  getInsights() {
    
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
 
        ProcurementOrganisation sales = getProcurementOrganisation();
        WorkRequestDirectory<OrderWorkRequest> customerOrders = sales.getmCustomerOrders();
        for(Customer p: getCustomerDirectory().getList()) {
            int orders = 0;
            int items = 0;
            
            for(OrderWorkRequest c:customerOrders.getList()) {
                if(!c.getSender().equals(p.getmUserAccount()))
                    continue;
                orders++;
                items += c.getmOrder().items();
            }
            dataset.addValue( orders,
                    p.getmName(), 
                    "Total Orders");   
            dataset.addValue( items,
                    p.getmName(), 
                    "Total Items");   
            
        }
        
        return ChartFactory.createBarChart(
                "Customer Insights", 
                "Status", 
                "Scores", 
                dataset , 
                PlotOrientation.VERTICAL, 
                true, true, true);
    }



}
