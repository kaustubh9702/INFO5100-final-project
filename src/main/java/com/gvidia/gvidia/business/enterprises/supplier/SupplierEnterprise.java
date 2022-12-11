package com.gvidia.gvidia.business.enterprises.supplier;

import com.gvidia.gvidia.business.enterprise.Enterprise;
import com.gvidia.gvidia.business.enterprises.manufacturer.wr.RawMaterialWorkRequest;
import com.gvidia.gvidia.business.enterprises.supplier.organisations.ExecutiveOrganisation;
import com.gvidia.gvidia.business.enterprises.supplier.organisations.UnionOrganisation;
import com.gvidia.gvidia.business.enterprises.supplier.wr.SourceMaterialWorkRequest;
import com.gvidia.gvidia.business.order.Product;
import com.gvidia.gvidia.business.useraccount.UserAccount;
import com.gvidia.gvidia.ui.Colors;
import java.awt.Color;
import org.jfree.chart.JFreeChart;

public class SupplierEnterprise extends Enterprise {





    public SupplierEnterprise() {
        super("Sunny Sand Suppliers");
    }


    @Override
    public void delete() {

    }


    public ExecutiveOrganisation getExecutiveOrganisation() {
        return (ExecutiveOrganisation) getFromList(1);
    }
    public UnionOrganisation getUnionOrganisation() {
        return (UnionOrganisation) getFromList(0);
    }


    public static final Product RawMaterialBundle = new Product("Sand", 12, "", 0);

    public void sourceMaterial(RawMaterialWorkRequest raw, UserAccount account) {
        raw.setSender(account);
        getExecutiveOrganisation().getmRawMaterialRequests().add(raw);
    }

    public void askUnionToSource(SourceMaterialWorkRequest sourceMaterialWorkRequest) {
        getUnionOrganisation().getmSourceMaterialWorkRequests().add(sourceMaterialWorkRequest);
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
                return Color.decode("#12005e");
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
    public JFreeChart getInsights() {
        return null;
    }

}
