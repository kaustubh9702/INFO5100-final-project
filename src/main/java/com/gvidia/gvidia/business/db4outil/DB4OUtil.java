package com.gvidia.gvidia.business.db4outil;

import com.gvidia.gvidia.business.ConfigureASystem;
import com.gvidia.gvidia.business.EcoSystem;

/**
 *
 * @author kaustubh
 * @author mitesh
 */
public class DB4OUtil {

    private static DB4OUtil dB4OUtil;
    
    public synchronized static DB4OUtil getInstance(){
        if (dB4OUtil == null){
            dB4OUtil = new DB4OUtil();
        }
        return dB4OUtil;
    }

   
    

    public synchronized void storeSystem(EcoSystem system) {
        
    }
    
    public EcoSystem retrieveSystem(boolean toReload){
        return ConfigureASystem.configure();
    }
}