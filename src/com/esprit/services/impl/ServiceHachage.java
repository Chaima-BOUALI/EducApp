/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stef info
 */
public class ServiceHachage {
    private static MessageDigest md;
    
     public static String cryptWithMD5(String motDePasse){
    try {
        md = MessageDigest.getInstance("MD5");
        byte[] passBytes = motDePasse.getBytes();
        md.reset();
        byte[] digested = md.digest(passBytes);
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<digested.length;i++){
            sb.append(Integer.toHexString(0xff & digested[i]));
        }
        return sb.toString();
    } catch (NoSuchAlgorithmException ex) {
        Logger.getLogger(ServiceHachage.class.getName()).log(Level.SEVERE, null, ex);
    }
        return null;


   }
}
