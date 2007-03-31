/*
 * RepairDAO.java
 *
 * Created on March 30, 2007, 4:03 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package edu.byu.isys413.cbb54.intex2.data;

import java.sql.Connection;

/**
 *
 * @author kyle
 */
public class RepairDAO extends RSDAO{
    
    ///////////////////////////////////////
    ///   Singleton pattern
    
    private static RepairDAO instance = null;
    
    /** Creates a new instance of RSSFeedDAO */
    private RepairDAO() {
    }
    
    /**
     * Singleton Pattern to allow only one instance of RentalDAO
     * @return RentalDAO
     */
    public static synchronized RepairDAO getInstance() {
        if (instance == null) {
            instance = new RepairDAO();
        }
        return instance;
    }
    
    ///////////////////////////////////////////
    /// Create
    
     RevenueSource create() throws Exception {
        RevenueSource rs = null;
        return rs;
    }
    
    ///////////////////////////////////////////
    /// Read
    
    public RevenueSource read (String sku) {
        RevenueSource rs = null;
        return rs;
    }
    
    public RevenueSource read (String sku, Connection conn){
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
