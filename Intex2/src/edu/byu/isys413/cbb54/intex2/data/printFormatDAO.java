/*
 * printFormatDAO.java
 *
 * Created on March 30, 2007, 2:26 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package edu.byu.isys413.cbb54.intex2.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kyle
 */
public class printFormatDAO{
    
    ///////////////////////////////////////
    ///   Singleton pattern
    
    private static printFormatDAO instance = null;
    
    /** Creates a new instance of RSSFeedDAO */
    private printFormatDAO() {
    }
    
    /**
     * Singleton Pattern to allow only one instance of printFormatDAO
     * @return printFormatDAO
     */
    public static synchronized printFormatDAO getInstance() {
        if (instance == null) {
            instance = new printFormatDAO();
        }
        return instance;
    }
    
    ///////////////////////////////////////////
    /// Create
    
    public printFormat create() throws Exception{
        String id = GUID.generate();
        printFormat printFormat = new printFormat(id);
        
        //put RS into Cache
        Cache c = Cache.getInstance();
        c.put(printFormat.getId(),printFormat);
        
        return printFormat;
    }
    
    ///////////////////////////////////////////
    /// Read
    public printFormat read(String id) throws Exception {
        printFormat po = null;
        
        //check to see if ID is in cache.  If so, return immediately
        if(po == null && Cache.getInstance().containsKey(id) == true){
            po = (printFormat)Cache.getInstance().get(id);
        }else {
            //if not in cache, create connection and Member objects
            Connection conn = ConnectionPool.getInstance().get();
            
            try {
                //if not in cache, retrieve DB connection
                conn = ConnectionPool.getInstance().get();
                
                //get a result set from a SELECT SQL statement
                PreparedStatement ps = conn.prepareStatement("select * from \"printformat\" where \"id\" = '" + id + "'");
                ResultSet result = ps.executeQuery();
                
                po.setPaperType(result.getString("papertype"));
                po.setSize(result.getString("size"));
                po.setSourceType(result.getString("sourcetype"));
                
            } catch (Exception e){
                e.printStackTrace();
            }
            
            //put into cache
            Cache c = Cache.getInstance();
            c.put(po.getId(),po);
            
        }
        return po;
    }
    
    public printFormat read(String id, Connection conn) throws Exception {
        printFormat po = null;
        
        //check to see if ID is in cache.  If so, return immediately
        if(po == null && Cache.getInstance().containsKey(id) == true){
            po = (printFormat)Cache.getInstance().get(id);
        }else {
            //if not in cache, create connection and Member objects
            
            try {
                //if not in cache, retrieve DB connection
                conn = ConnectionPool.getInstance().get();
                
                //get a result set from a SELECT SQL statement
                PreparedStatement ps = conn.prepareStatement("select * from \"printformat\" where \"id\" = '" + id + "'");
                ResultSet result = ps.executeQuery();
                
                po.setPaperType(result.getString("papertype"));
                po.setSize(result.getString("size"));
                po.setSourceType(result.getString("sourcetype"));
                
            } catch (Exception e){
                e.printStackTrace();
            }
            
            //put into cache
            Cache c = Cache.getInstance();
            c.put(po.getId(),po);
            
            
        }
        return po;
    }
    
///////////////////////////////////////////
/// Save
    
    public synchronized void save(printFormat ps, Connection conn) throws SQLException, Exception {
        if (ps.getIsInDB() == true) {
            if (ps.isDirty() == true){
                update(ps);
            }
        }else{
            insert(ps);
        }
    }
    
    public synchronized void save(printFormat ps) throws SQLException, Exception {
        if (ps.getIsInDB() == true) {
            if (ps.isDirty() == true){
                update(ps);
            }
        }else{
            insert(ps);
        }
    }
    
    private synchronized void update(printFormat printFormat) throws Exception{
        //get connection
        Connection conn = ConnectionPool.getInstance().get();
        
        //do update statement
        PreparedStatement ps = conn.prepareStatement("update \"printformat\" set \"size\" = '" + printFormat.getSize() + "', \"papertype\" = '" + printFormat.getPaperType() + "'," +
                " \"sourcetype\" = '" + printFormat.getSourceType() + "', \"price\" = " + printFormat.getPrice() + " where" +
                " \"id\" = '" + printFormat.getId() + "'");
        ps.execute();
        conn.commit();
        ps.close();
        
        //release connection
        ConnectionPool.getInstance().release(conn);
        
        //touch the cache for the object (renew the 30 min time limit)
        Cache.getInstance().touch(printFormat.getId());
    }
    
    private synchronized void insert(printFormat printFormat) throws SQLException, Exception{
        Connection conn = ConnectionPool.getInstance().get();
        printFormat.setInDB(true);
        
        PreparedStatement ps = conn.prepareStatement("insert into \"printformat\" values (?,?,?,?,?)");
        ps.setString(1,printFormat.getId());
        ps.setString(2,printFormat.getSize());
        ps.setString(3,printFormat.getPaperType());
        ps.setString(4,printFormat.getSourceType());
        ps.setDouble(5,printFormat.getPrice());
        
        ps.execute();
        conn.commit();
        ps.close();
        
        //release connection
        ConnectionPool.getInstance().release(conn);
        
        //touch the cache for the object (renew the 30 min time limit)
        Cache.getInstance().touch(printFormat.getId());
    }
    
    
//////////////////////////////////////////
/// delete
    
// for business reasons we're not supporting deleting
    
    
}

