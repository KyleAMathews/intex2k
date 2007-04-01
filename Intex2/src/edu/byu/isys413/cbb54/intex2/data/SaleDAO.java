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
    
    public RevenueSource create() throws Exception{
        String id = GUID.generate("sa");
        RevenueSource rs = new SaleBO(id);
        System.out.println("I've created a SaleBO  :  ID: " + rs.getId());
        return rs;
    }
    
    ///////////////////////////////////////////
    /// Read
    
    public RevenueSource read(String id, Connection conn){
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

