package com.gvidia.gvidia.business.enterprises.manufacturer.organisations;

import com.gvidia.gvidia.business.enterprise.Enterprise;
import com.gvidia.gvidia.business.enterprise.organisation.Organization;
import com.gvidia.gvidia.business.enterprise.role.Role;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequestDirectory;
import com.gvidia.gvidia.business.enterprises.logisitics.organisations.OnGroundDeliveryOrg;
import com.gvidia.gvidia.business.enterprises.manufacturer.wr.MaterialWorkRequest;
import com.gvidia.gvidia.business.enterprises.manufacturer.wr.ProductPlacementWorkRequest;
import com.gvidia.gvidia.business.enterprises.retailer.organisations.ProcurementOrganisation;
import com.gvidia.gvidia.business.order.Product;
import com.gvidia.gvidia.business.useraccount.UserAccount;
import com.gvidia.gvidia.ui.base.Controller;
import com.gvidia.gvidia.ui.manufacturing.DeveloperPanel;
import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author kaustubh, mitesh
 */
public class ProductDevelopmentOrganisation extends Organization {


    WorkRequestDirectory<MaterialWorkRequest> mMaterialWorkRequest;
    WorkRequestDirectory<ProductPlacementWorkRequest> mProductPlacementWorkRequests;



    Map<ProductPlacementWorkRequest, MaterialWorkRequest> mRequestsForProductMaterial;

    public ProductDevelopmentOrganisation() {
        super("Dev Team");
        mMaterialWorkRequest = new WorkRequestDirectory<>();
        mProductPlacementWorkRequests = new WorkRequestDirectory<>();
        mRequestsForProductMaterial = new HashMap<>();
    }

    public MaterialWorkRequest developProduct(Product product,int quantity, int requiredMaterial) {

        ProductPlacementWorkRequest productPlacementWorkRequest = ProductPlacementWorkRequest.createRequest(product,quantity);
        MaterialWorkRequest materialWorkRequest = MaterialWorkRequest.createMaterialRequest(requiredMaterial);
        mRequestsForProductMaterial.put(productPlacementWorkRequest, materialWorkRequest);
        mMaterialWorkRequest.add(materialWorkRequest);
        mProductPlacementWorkRequests.add(productPlacementWorkRequest);
        return materialWorkRequest;
    }

    public ProductPlacementWorkRequest getProductFromMaterialRequest(MaterialWorkRequest mr) {
        for(ProductPlacementWorkRequest r: mRequestsForProductMaterial.keySet()) {
            if(mRequestsForProductMaterial.get(r).equals(mr)) {
                return r;
            }
        }
        return null;
    }


    //It means i have gotten my stuff
    public boolean isMateiralAvailable(ProductPlacementWorkRequest productPlacementWorkRequest) {
        MaterialWorkRequest materialWorkRequest = mRequestsForProductMaterial.get(productPlacementWorkRequest);
        return materialWorkRequest != null && materialWorkRequest.status().equals(WorkRequest.Status.FULFILLED);
    }

    public boolean finishDevelopment(ProductPlacementWorkRequest productPlacementWorkRequest) {
        if(!isMateiralAvailable(productPlacementWorkRequest) && productPlacementWorkRequest.status().equals(WorkRequest.Status.PENDING))
            return false;

        productPlacementWorkRequest.setStatus(WorkRequest.Status.EN_ROUTE);

        return true;
    }


    public WorkRequestDirectory<MaterialWorkRequest> getmMaterialWorkRequest() {
        return mMaterialWorkRequest;
    }

    public void setmMaterialWorkRequest(WorkRequestDirectory<MaterialWorkRequest> mMaterialWorkRequest) {
        this.mMaterialWorkRequest = mMaterialWorkRequest;
    }

    public WorkRequestDirectory<ProductPlacementWorkRequest> getmProductPlacementWorkRequests() {
        return mProductPlacementWorkRequests;
    }

    public void setmProductPlacementWorkRequests(WorkRequestDirectory<ProductPlacementWorkRequest> mProductPlacementWorkRequests) {
        this.mProductPlacementWorkRequests = mProductPlacementWorkRequests;
    }

    public Map<ProductPlacementWorkRequest, MaterialWorkRequest> getmRequestsForProductMaterial() {
        return mRequestsForProductMaterial;
    }

    public void setmRequestsForProductMaterial(Map<ProductPlacementWorkRequest, MaterialWorkRequest> mRequestsForProductMaterial) {
        this.mRequestsForProductMaterial = mRequestsForProductMaterial;
    }

    @Override
    public List<Role> getSupportedRole(Object object) {
        return Arrays.asList(
                new ProDevRole(object)
         );
    }
         public class ProDevRole extends Role {
        public ProDevRole(Object obj) {
            super(obj);
        }
         @Override
            public JPanel createWorkArea(Controller controller, Organization organization, UserAccount account, Enterprise business) {
                return new DeveloperPanel(controller, organization, account, business);
            }

            @Override
            public String getRoleName() {
                return ProductDevelopmentOrganisation.class.toString();
            }
    }

    
    
}
