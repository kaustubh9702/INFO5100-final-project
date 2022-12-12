/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business.useraccount;

import com.gvidia.gvidia.business.base.GenericDirectory;
import com.gvidia.gvidia.business.enterprise.employee.Employee;
import com.gvidia.gvidia.business.enterprise.role.Role;
import com.gvidia.gvidia.business.utils.Hash;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Mitesh
 */
public class UserAccountDirectory extends GenericDirectory<UserAccount> {
    

    public UserAccountDirectory() {
        super();
    }

    
    
    
    
    public UserAccount authenticateUser(String username, String password){
        password = Hash.hash(password);
        for (UserAccount ua : getList()) {
            
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password) && ua.isActive()){
                return ua;
            }
        }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password,String email, Employee employee, Role role){
        UserAccount userAccount = new UserAccount(username,Hash.hash(password), email ,employee,role);
        
        add(userAccount);
        
        return userAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username, String email){
        UserAccount tem = new UserAccount(username,"",email, null, null);
        for (UserAccount ua : getList()){
            if (ua.equals(tem)) {
                tem = null;
                return false;
            }
        }
        tem = null;
        return true;
    }

    public List<UserAccount> fliter(String pred) {
     getList().stream().forEach((t) -> System.out.println(t.getRole()));
     return getList().stream().filter((t) -> {
         return t.getRole().getRoleName().equals(pred); 
     }).collect(Collectors.toList());
    }
}
