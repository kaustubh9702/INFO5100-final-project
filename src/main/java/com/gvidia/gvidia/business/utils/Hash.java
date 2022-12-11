/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business.utils;

import com.gvidia.gvidia.business.useraccount.UserAccountDirectory;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nishau
 */
public class Hash {
    
    
    public static String hash(String p) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(p.getBytes(StandardCharsets.UTF_8));
            byte[] encoded = Base64.getEncoder().encode(hash);
            return new String(encoded);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserAccountDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        
        
        
    }
    
}
