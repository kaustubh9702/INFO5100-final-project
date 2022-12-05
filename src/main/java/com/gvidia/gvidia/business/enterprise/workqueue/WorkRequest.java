/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business.enterprise.workqueue;

import com.gvidia.gvidia.business.base.Identifier;
import com.gvidia.gvidia.business.useraccount.UserAccount;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author kaustubh, krishica
 */
public abstract class WorkRequest extends Identifier {

    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private Date requestDate;
    private Date resolveDate;

    public enum Status {NOT_INIT,PENDING, CREATED, FULFILLED, EN_ROUTE, REJECTED};

    Status status;


    public static int count = 0;
    public WorkRequest(){
        super(++count);
        requestDate = new Date();
        status = Status.PENDING;
        requestDate = Date.from(Instant.now());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
      switch (status) {
          case CREATED:return "Created";
          case PENDING: return "Pending";
          case EN_ROUTE: return "En Route";
          case REJECTED: return "Rejected";
          case FULFILLED: return "Fulfilled";
          default: return "NOT_INIT";
      }
    }
    public Status status() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }
    
    public void setResolved() {
        this.resolveDate = Date.from(Instant.now());
        this.setStatus(Status.FULFILLED);
    }
    
}
