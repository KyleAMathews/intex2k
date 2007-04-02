/*
 * PhotoSetDAO.java
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
public class PhotoSetDAO{
    
    ///////////////////////////////////////
    ///   Singleton pattern
    
    private static PhotoSetDAO instance = null;
    
    /** Creates a new instance of RSSFeedDAO */
    private PhotoSetDAO() {
    }
    
    /**
     * Singleton Pattern to allow only one instance of PhotoSetDAO
     * @return PhotoSetDAO
     */
    public static synchronized PhotoSetDAO getInstance() {
        if (instance == null) {
            instance = new PhotoSetDAO();
        }
        return instance;
    }
    
    ///////////////////////////////////////////
    /// Create
    
    public PhotoSet create() throws Exception{
        String id = GUID.generate();
        PhotoSet photoSet = new PhotoSet(id);
        
        //put RS into Cache
        Cache c = Cache.getInstance();
        c.put(photoSet.getId(),photoSet);
        
        return photoSet;
    }
    
    ///////////////////////////////////////////
    /// Read
        public PhotoSet read(String id) throws Exception {
        PhotoSet po = null;
        
        //check to see if ID is in cache.  If so, return immediately
        if(po == null && Cache.getInstance().containsKey(id) == true){
            po = (PhotoSet)Cache.getInstance().get(id);
        }else {
            //if not in cache, create connection and Member objects
            Connection conn = ConnectionPool.getInstance().get();
            
            try {
                //if not in cache, retrieve DB connection
                conn = ConnectionPool.getInstance().get();
                
                //get a result set from a SELECT SQL statement
                PreparedStatement ps = conn.prepareStatement("select * from \"photoset\" where \"id\" = '" + id + "'");
                ResultSet result = ps.executeQuery();
                
                po.setDescription(result.getString("description"));
                po.setInDB(true);
                po.setDirty(false);
                po.setNumPhotos(result.getInt("numPhotos"));
            } catch (Exception e){
                e.printStackTrace();
            }
            
            //put into cache
            Cache c = Cache.getInstance();
            c.put(po.getId(),po);
            
        }
        return po;
    }
        
    public PhotoSet read(String id, Connection conn) throws Exception {
        PhotoSet po = null;
        
        //check to see if ID is in cache.  If so, return immediately
        if(po == null && Cache.getInstance().containsKey(id) == true){
            po = (PhotoSet)Cache.getInstance().get(id);
        }else {
            //if not in cache, create connection and Member objects
            
            try {
                //if not in cache, retrieve DB connection
                conn = ConnectionPool.getInstance().get();
                
                //get a result set from a SELECT SQL statement
                PreparedStatement ps = conn.prepareStatement("select * from \"photoset\" where \"id\" = '" + id + "'");
                ResultSet result = ps.executeQuery();
                
                ps.close();
                
                po.setDescription(result.getString("description"));
                po.setInDB(true);
                po.setDirty(false);
                po.setNumPhotos(result.getInt("numPhotos"));
                
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
    
    public synchronized void save(PhotoSet ps, Connection conn) throws SQLException, Exception {
        if (ps.getIsInDB() == true) {
            update(ps);
        }else{
            insert(ps);
        }
    }
    
    public synchronized void save(PhotoSet ps) throws SQLException, Exception {
        if (ps.getIsInDB() == true) {
            update(ps);
        }else{
            insert(ps);
        }
    }
    
    private synchronized void update(PhotoSet photoSet) throws Exception{
        //get connection
        Connection conn = ConnectionPool.getInstance().get();
        
        //do update statement
        PreparedStatement ps = conn.prepareStatement("update \"photoset\" set \"id\" = '" + photoSet.getId() +
                "', \"description\" = '" + photoSet.getDescription() + "', \"numphotos\" + '" + photoSet.getNumPhotos() + "'");
        ps.execute();
        conn.commit();
        ps.close();
        
        //release connection
        ConnectionPool.getInstance().release(conn);
        
        //touch the cache for the object (renew the 30 min time limit)
        Cache.getInstance().touch(photoSet.getId());
    }
    
    private synchronized void insert(PhotoSet photoSet) throws SQLException, Exception{
        Connection conn = ConnectionPool.getInstance().get();
        photoSet.setInDB(true);
        
        PreparedStatement ps = conn.prepareStatement("insert into \"photoset\" values (?,?,?)");
        ps.setString(1,photoSet.getId());
        ps.setString(2,photoSet.getDescription());
        ps.setInt(3,photoSet.getNumPhotos());
        
        ps.execute();
        conn.commit();
        ps.close();
        
        //release connection
        ConnectionPool.getInstance().release(conn);
        
        //touch the cache for the object (renew the 30 min time limit)
        Cache.getInstance().touch(photoSet.getId());
    }
    
    
//////////////////////////////////////////
/// delete
    
// for business reasons we're not supporting deleting
    
    
}

