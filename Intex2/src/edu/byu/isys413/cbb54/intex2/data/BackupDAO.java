/*
 * BackupDAO.java
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
public class BackupDAO extends RSDAO{
    
    ///////////////////////////////////////
    ///   Singleton pattern
    
    private static BackupDAO instance = null;
    
    /** Creates a new instance of RSSFeedDAO */
    private BackupDAO() {
    }
    
    /**
     * Singleton Pattern to allow only one instance of BackupDAO
     * @return BackupDAO
     */
    public static synchronized BackupDAO getInstance() {
        if (instance == null) {
            instance = new BackupDAO();
        }
        return instance;
    }
    
    
    ///////////////////////////////////////////
    /// Create
    
    public RevenueSource create() throws Exception{
        String id = GUID.generate();
        RevenueSource rs = new backup(id);
        System.out.println("I've created a backupBO  :  ID: " + rs.getId());
        return rs;
    }
    
    ///////////////////////////////////////////
    /// Read
    
    public RevenueSource read (String sku) {
        RevenueSource rs = null;
        System.out.println("I've read a backupBO");
        return rs;
    }
    
    public RevenueSource read (String sku, Connection conn){
        RevenueSource rs = null;
        System.out.println("I've created a backupBO");
        return rs;
    }
    
    ///////////////////////////////////////////
    /// Save
    
    public void save(RevenueSource rsbo) {
        System.out.println("I've saved a backupBO");
    }
    
    public void save(RevenueSource rsbo, Connection conn){
        
    }
            
    //////////////////////////////////////////
    /// delete
    
    // for business reasons we're not supporting deleting
    
    
}
