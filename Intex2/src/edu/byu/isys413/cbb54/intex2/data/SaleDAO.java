/*
 * SaleDAO.java
 *
 * Created on March 29, 2007, 2:07 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package edu.byu.isys413.cbb54.intex2.data;

import java.sql.Connection;

/**
 *
 * @author Cameron
 */
public class SaleDAO extends RSDAO {
    
    ///////////////////////////////////////
    ///   Singleton pattern
    
    private static SaleDAO instance = null;
    
    /** Creates a new instance of RSSFeedDAO */
    private SaleDAO() {
    }
    
    /**
     * Singleton Pattern to allow only one instance of SaleDAO
     * @return SaleDAO
     */
    public static synchronized SaleDAO getInstance() {
        if (instance == null) {
            instance = new SaleDAO();
        }
        return instance;
    }
    
    ///////////////////////////////////////////
    /// Create
    
    public RevenueSource create(String sku){
        RevenueSource rs = null;
        return rs;
    }
    
    ///////////////////////////////////////////
    /// Read
    
    public RevenueSource read(String sku) {
        RevenueSource rs = null;
        return rs;
    }
    
    public RevenueSource read(String sku, Connection conn){
        RevenueSource rs = null;
        return rs;
    }
    
    ///////////////////////////////////////////
    /// Save
    
    public void save(RevenueSource rsbo) {
        
    }
    
    public void save(RevenueSource rsbo, Connection conn){
        
    }
    
    //////////////////////////////////////////
    /// delete
    
    // for business reasons we're not supporting deleting
    
    
}

