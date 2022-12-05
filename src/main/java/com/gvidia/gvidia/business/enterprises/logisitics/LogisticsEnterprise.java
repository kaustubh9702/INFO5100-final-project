package com.gvidia.gvidia.business.enterprises.logisitics;

import com.gvidia.gvidia.business.enterprise.Enterprise;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequestDirectory;
import com.gvidia.gvidia.business.enterprises.logisitics.organisations.OffGroundDeliveryOrg;
import com.gvidia.gvidia.business.enterprises.logisitics.organisations.OnGroundDeliveryOrg;
import com.gvidia.gvidia.business.enterprises.logisitics.wr.OffGroundWorkRequest;
import com.gvidia.gvidia.business.enterprises.logisitics.wr.OnGroundWorkRequest;
import com.gvidia.gvidia.business.enterprises.retailer.wr.OrderWorkRequest;
import com.gvidia.gvidia.business.order.Shipment;
import com.gvidia.gvidia.ui.Colors;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
/**
 *
 * @author kaustubh, mitesh
 */
public class LogisticsEnterprise extends Enterprise {



    public LogisticsEnterprise() {
        super("Juber Delivery");

    }


    public OnGroundDeliveryOrg getOnGroundDeliveryOrg() {
        return (OnGroundDeliveryOrg) getFromList(0);
    }
    public OffGroundDeliveryOrg getOffGroundDeliveryOrg() {
        return (OffGroundDeliveryOrg) getFromList(1);
    }

    @Override
    public void delete() {

    }

    public OffGroundWorkRequest shipOffGround(Shipment s, WorkRequest sourceMaterialWorkRequest) {
        OffGroundWorkRequest offGroundWorkRequest = OffGroundWorkRequest.createOffGroundWorkRequest(s, sourceMaterialWorkRequest);
        getOffGroundDeliveryOrg().getRequests().add(offGroundWorkRequest);
        return offGroundWorkRequest;
    }

    public OnGroundWorkRequest shipOnGround(Shipment s, OrderWorkRequest sourceMaterialWorkRequest) {
        OnGroundWorkRequest onGroundWorkRequest = OnGroundWorkRequest.createOnGroundWorkRequest(s, sourceMaterialWorkRequest);
        getOnGroundDeliveryOrg().getRequests().add(onGroundWorkRequest);
        return onGroundWorkRequest;
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
                return Color.decode("#7c43bd");
            }

            @Override
            public Color PRIMARY_DARK() {
                return Color.decode("#004005");
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
    
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  
        
        
        dataset.addValue( filterAndSize(getOnGroundDeliveryOrg().getRequests(),
                    WorkRequest.Status.PENDING) , "On Ground" , 
                    WorkRequest.Status.PENDING);    
        dataset.addValue( filterAndSize(getOnGroundDeliveryOrg().getRequests(),
                    WorkRequest.Status.FULFILLED) , "On Ground" , 
                    WorkRequest.Status.FULFILLED);     
        dataset.addValue( filterAndSize(getOnGroundDeliveryOrg().getRequests(),
                    WorkRequest.Status.EN_ROUTE) , "On Ground" , 
                    WorkRequest.Status.EN_ROUTE);     
       
        dataset.addValue( filterAndSize(getOffGroundDeliveryOrg().getRequests(),
                    WorkRequest.Status.PENDING) , "Off Ground" , 
                    WorkRequest.Status.PENDING);    
        dataset.addValue( filterAndSize(getOffGroundDeliveryOrg().getRequests(),
                    WorkRequest.Status.FULFILLED) , "Off Ground" , 
                    WorkRequest.Status.FULFILLED);     
        dataset.addValue( filterAndSize(getOffGroundDeliveryOrg().getRequests(),
                    WorkRequest.Status.EN_ROUTE) , "Off Ground" , 
                    WorkRequest.Status.EN_ROUTE);     
       
        
        
        return ChartFactory.createBarChart(
                "Delivery Insights", 
                "Status", 
                "Total Orders", 
                dataset , 
                PlotOrientation.HORIZONTAL, 
                true, true, true);
        
        
        
    
    }

  


}
