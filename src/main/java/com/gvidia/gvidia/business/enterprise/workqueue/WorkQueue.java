/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business.enterprise.workqueue;

import java.util.ArrayList;

/**
 *
 * @author kaustubh, mitesh
 */
public class WorkQueue {
    
    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
}