package com.gvidia.gvidia.business.enterprise.workqueue;

import com.gvidia.gvidia.business.base.GenericDirectory;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
/**
 *
 * @author kaustubh, mitesh
 */
public class WorkRequestDirectory<T extends WorkRequest> extends GenericDirectory<T> {


    public WorkRequestDirectory() {
        super();
    }


    public List<T> filter(WorkRequest.Status status ) {
        List<T> workRequests = new ArrayList<>();
        for(T wr: getList()) {
            if(wr.status == status) {
                workRequests.add(wr);
            }
        }
        return workRequests;
    }
    public List<T> filter(Function<WorkRequest, Boolean> map) {
        List<T> workRequests = new ArrayList<>();
        for(T wr: getList()) {
            if(map.apply(wr)) {
                workRequests.add(wr);
            }
        }
        return workRequests;
    }


}
