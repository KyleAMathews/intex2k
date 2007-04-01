/*
 * RentalDAO.java
 *
 * Created on March 30, 2007, 2:26 PM
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
public class RentalDAO extends RSDAO{
    
    ///////////////////////////////////////
    ///   Singleton pattern
    
    private static RentalDAO instance = null;
    
    /** Creates a new instance of RSSFeedDAO */
    private RentalDAO() {
    }
    
    /**
     * Singleton Pattern to allow only one instance of RentalDAO
     * @return RentalDAO
     */
    public static synchronized RentalDAO getInstance() {
        if (instance == null) {
            instance = new RentalDAO();
        }
        return instance;
    }
    
    ///////////////////////////////////////////
    /// Create
    
    public RevenueSource create() throws Exception{
        String id = GUID.generate("rn");
        RevenueSource rs = new rental(id);
        System.out.println("I've created a RentalBO  :  ID: " + rs.getId());
        return rs;
    }
    
    ///////////////////////////////////////////
    /// Read
    
    public RevenueSource read (String id, Connection conn){
        RevenueSource rs = null;
        return rs;
    }
    
    ///////////////////////////////////////////
    /// Save
    
    public void save(RevenueSource rsbo, Connection conn) throws Exception{
        
    }
            
    public void insert(RevenueSource rsbo, Connection conn) throws Exception{
        
    }
    
    public void update(RevenueSource rsbo, Connection conn) throws Exception{
        
    }
    
            
    //////////////////////////////////////////
    /// delete
    
    // for business reasons we're not supporting deleting

    
    
}
