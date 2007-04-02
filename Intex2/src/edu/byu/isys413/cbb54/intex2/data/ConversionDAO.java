/*
 * ConversionDAO.java
 *
 * Created on March 30, 2007, 2:26 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package edu.byu.isys413.cbb54.intex2.data;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author kyle
 */
public class ConversionDAO extends RSDAO{
    
    ///////////////////////////////////////
    ///   Singleton pattern
    
    private static ConversionDAO instance = null;
    
    /** Creates a new instance of RSSFeedDAO */
    private ConversionDAO() {
    }
    
    /**
     * Singleton Pattern to allow only one instance of ConversionDAO
     * @return ConversionDAO
     */
    public static synchronized ConversionDAO getInstance() {
        if (instance == null) {
            instance = new ConversionDAO();
        }
        return instance;
    }
    
    ///////////////////////////////////////////
    /// Create
    
    public RevenueSource create() throws Exception{
        String id = GUID.generate("po");
        RevenueSource rs = new conversionBO(id);
        System.out.println("I've created a conversionBO  :  ID: " + rs.getId());
        return rs;
    }
    
    ///////////////////////////////////////////
    /// Read
    
    public RevenueSource read(String id, Connection conn) throws Exception {
        conversionBO conversionBO = new conversionBO(id);
        
        //read from DB and populate new RS object
        
        //put into cache
        
        RevenueSource rs =(RevenueSource)conversionBO;
        return conversionBO;
    }
    
    ///////////////////////////////////////////
    /// Save
    
    public void save(RevenueSource rsbo, Connection conn) throws Exception{
        // check the dirty flag in the object.  if it is dirty,
        // run update or insert
        if (rsbo.isDirty()) {
            if (rsbo.isInDB()) {
                update(rsbo, conn);
            }else{
                insert(rsbo, conn);
            }
            
            // set the dirty flag to false now that we've saved it
            rsbo.setDirty(false);
            
        }
    }
    
    public void insert(RevenueSource rsbo, Connection conn) throws Exception{
        conversionBO po = (conversionBO)rsbo;
        
        //put into cache
        
        //insert object into DB
    }
    
    public void update(RevenueSource rsbo, Connection conn) throws Exception{
        conversionBO po = (conversionBO)rsbo;

        //update DB
        
        //update cache
    }
    
    
    //////////////////////////////////////////
    /// delete
    
    // for business reasons we're not supporting deleting
    
    
}

