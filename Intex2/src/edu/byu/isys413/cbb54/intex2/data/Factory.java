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
    
    private static Factory instance = null;
    
    Map<String, RevenueSourceDAO> m = new TreeMap<String, RevenueSourceDAO>();
        

    
    
    
    
    private Factory(){
        m.put("sale", SaleDAO.getInstance());
//        m.put("backup", BackupDAO.getInstance());
//        m.put("print", PrintDAO.getInstance());
//        m.put("rental", RentalDAO.getInstance());
    }
    
    public static synchronized Factory getInstance(){
        if(instance == null){
            instance = new Factory();
        }
        return instance;
    }
    
    public RevenueSourceDAO getDAO(String type){
        RevenueSourceDAO rsDAO = m.get(type);
        return rsDAO;   
    }
    
}
