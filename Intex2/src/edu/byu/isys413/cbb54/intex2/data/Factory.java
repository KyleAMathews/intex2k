/*
 * Factory.java
 *
 * Created on March 29, 2007, 1:46 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package edu.byu.isys413.cbb54.intex2.data;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author tylerf
 */
public class Factory {
    
    Map<String,RevenueSourceDAO> m = new TreeMap<String,RevenueSourceDAO>();
    private static Factory instance = null;
    
    private Factory(){
    
    }
    
    public static synchronized Factory getInstance(){
        if(instance == null){
            instance = new Factory();
        }
        return instance;
    }
    
    public void getDAO(String type){
        
        
    }
    
}
