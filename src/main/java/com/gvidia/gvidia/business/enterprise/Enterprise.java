package com.gvidia.gvidia.business.enterprise;


import com.gvidia.gvidia.business.base.GenericDirectory;
import com.gvidia.gvidia.business.base.Identifier;
import com.gvidia.gvidia.business.enterprise.organisation.Organization;
import com.gvidia.gvidia.business.enterprise.role.Role;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequest;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkRequestDirectory;
import com.gvidia.gvidia.ui.Colors;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;

/**
 *
 * @author kaustubh, mitesh
 */

public abstract class Enterprise extends Identifier {


    private String mName;
    private GenericDirectory<Organization> mOrganizationList;
    private static int counter=0;

    public Enterprise(String name) {
        super(++counter);
        this.mName = name;
        mOrganizationList = new GenericDirectory<Organization>();
    }


    public GenericDirectory<Organization> getmOrganizationList() {
        return mOrganizationList;
    }

    public void setmOrganizationList(GenericDirectory<Organization> mOrganizationList) {
        this.mOrganizationList = mOrganizationList;
    }

    public String getName() {
        return mName;
    }
    public void setName(String name) {
        this.mName = name;
    }


    public Organization getFromList(int i) {
        return getmOrganizationList().get(i);
    }


    @Override
    public String toString() {
        return mName;
    }
    
    public abstract Colors getThemeColor();
    


    public Organization getOrganisation(Role role) {
        String orgName = role.getRoleName();
        System.out.println(orgName);
        for(Organization org: getmOrganizationList().getList()) {
            if(org.getClass().toString().equals(orgName)) {
                return org;
            }
        }
        return null;
    }

    

    public abstract JFreeChart  getInsights();
    
    public Number filterAndSize(WorkRequestDirectory requests, WorkRequest.Status status) {
        return new Integer(
                requests.filter(status).size()
        );
    }
}
