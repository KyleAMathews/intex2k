/*
 * PrintOrderDAO.java
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
public class PrintOrderDAO extends RSDAO{
    
    ///////////////////////////////////////
    ///   Singleton pattern
    
    private static PrintOrderDAO instance = null;
    
    /** Creates a new instance of RSSFeedDAO */
    private PrintOrderDAO() {
    }
    
    /**
     * Singleton Pattern to allow only one instance of PrintOrderDAO
     * @return PrintOrderDAO
     */
    public static synchronized PrintOrderDAO getInstance() {
        if (instance == null) {
            instance = new PrintOrderDAO();
        }
        return instance;
    }
    
    ///////////////////////////////////////////
    /// Create
    
    public RevenueSource create(){
        RevenueSource rs = null;
        return rs;
    }
    
    ///////////////////////////////////////////
    /// Read
    
    public RevenueSource read (String id) {
        RevenueSource rs = null;
        return rs;
    }
    
    public RevenueSource read (String id, Connection conn){
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

