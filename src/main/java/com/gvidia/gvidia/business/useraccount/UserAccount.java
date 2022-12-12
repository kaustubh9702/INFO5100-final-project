/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business.useraccount;

import com.gvidia.gvidia.business.base.Identifier;
import com.gvidia.gvidia.business.base.TableSerializable;
import com.gvidia.gvidia.business.enterprise.employee.Employee;
import com.gvidia.gvidia.business.enterprise.role.Role;
import com.gvidia.gvidia.business.enterprise.workqueue.WorkQueue;

import java.util.Objects;
import javax.swing.ImageIcon;


public class UserAccount extends Identifier implements TableSerializable{
    
    private String username;
    private String passwordHash;
    private String email;
    private Employee employee;

    private Role role;
    
    private WorkQueue workQueue;
    private boolean active = true;

    public static int count = 0;

    
    
    public UserAccount(String username, String password,String em, Employee employee, Role role) {
        super(count++);
        this.username = username;
        this.passwordHash = password;
        this.employee = employee;
        this.role = role;
        email = em;
        workQueue = new WorkQueue();
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return passwordHash;
    }

    public void setPassword(String password) {
        this.passwordHash = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public boolean isActive() {
        
        return active;
    }

    public void setIsInActive(boolean isInActive) {
        
        this.active = isInActive;
    }

    
    
    @Override
    public String toString() {
        return username;
    }

    @Override
    public void delete() {
       active = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(username, that.username) ||
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, passwordHash,email);
    }

    @Override
    public Object[] row() {
        return new String[]{
            getmID() + "",
            employee.getName(),
            employee.getmPhoneNumner(),
            getUsername()
        };
    }

    @Override
    public String[] columns() {
        return new String[]{
            "ID",
            "Name",
            "PhoneNumber",
            "Username"
        };
    }

    @Override
    public ImageIcon getImageIcon() {
        return null;
    }
}