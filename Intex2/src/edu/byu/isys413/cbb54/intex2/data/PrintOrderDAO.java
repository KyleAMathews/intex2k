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
import java.sql.PreparedStatement;

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
    
    public RevenueSource create() throws Exception{
        String id = GUID.generate("po");
        RevenueSource rs = new printOrder(id);
        System.out.println("I've created a PrintOrder  :  ID: " + rs.getId());
        
        //put RS into Cache
        Cache c = new Cache();
        c.put(rs.getId(),rs);
        
        return rs;
    }
    
    ///////////////////////////////////////////
    /// Read
    
    public RevenueSource read(String id, Connection conn) throws Exception {
        printOrder po = new printOrder(id);
        
        //read from DB and populate new RS object
        PreparedStatement ps = conn.prepareStatement("select * from \"printorder\" where \"id\" = '" + id + "'");
        ps.execute();
        
        po.setQuantity(ps.getDouble("quantity"));
        po.setPhotoSet(PhotoSetDAO.getInstance().read(ps.getString("photoSet")));
        po.seInDB(true);
        po.setDirty(false);
        po.setPrice(ps.getDouble("price"));
        
        //put into cache
        
        RevenueSource rs =(RevenueSource)conv;
        return po;
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
        printOrder po = (printOrder)rsbo;
        
        //put into cache
        
        //insert object into DB
    }
    
    public void update(RevenueSource rsbo, Connection conn) throws Exception{
        printOrder po = (printOrder)rsbo;

        //update DB
        
        //update cache
    }
    
    
    //////////////////////////////////////////
    /// delete
    
    // for business reasons we're not supporting deleting
    
    
}

