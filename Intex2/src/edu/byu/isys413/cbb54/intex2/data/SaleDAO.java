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
        RevenueSource rs = new Sale(id);
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
         // check the dirty flag in the object.  if it is dirty,
        // run update or insert
        if (rsbo.isDirty()) {
            if (rsbo.isInDB()) {
                // We are not supporting update
                //update(rsbo, conn);
            }else{
                insert(rsbo, conn);
            }
            
            // set the dirty flag to false now that we've saved it
            rsbo.setDirty(false);
            
        }
     }
            
     public void insert(RevenueSource rsbo, Connection conn) throws Exception{
        System.out.println("inserting backup");
        Sale sale = (Sale)rsbo;
        PreparedStatement insert = conn.prepareStatement(
                "INSERT INTO \"sale\" VALUES (?,?,?,?)");
        insert.setString(1, sale.getId());
        insert.setDouble(2, sale.getSize());
        insert.setDouble(3, sale.getLengthOfBackup());
        insert.setDouble(4, sale.getPrice());
        insert.executeUpdate();
        sale.seInDB(true);
     }
    
     public void update(RevenueSource rsbo, Connection conn) throws Exception{
         
     }
    
    
    //////////////////////////////////////////
    /// delete
    
    // for business reasons we're not supporting deleting
    
    
}

