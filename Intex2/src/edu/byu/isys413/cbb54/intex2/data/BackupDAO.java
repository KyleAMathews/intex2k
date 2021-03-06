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
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
        String id = GUID.generate("ba");
        RevenueSource rs = new backup(id);
        System.out.println("I've created a backupBO  :  ID: " + rs.getId());
        return rs;
    }
    
    ///////////////////////////////////////////
    /// Read
    
    public RevenueSource read(String id, Connection conn) throws Exception{
        backup bkup = new backup(id);
        
        PreparedStatement read = conn.prepareStatement(
                "SELECT * FROM \"backup\" WHERE \"id\" = ?");
        read.clearParameters();
        read.setString(1, id);
        ResultSet rs = read.executeQuery();
        
        // set variables
        bkup.setSize(rs.getDouble("size"));
        bkup.setPrice(rs.getDouble("price"));
        bkup.setLengthOfBackup(rs.getDouble("lengthofbackup"));
        
        // return the RevenueSource
        RevenueSource rst = (RevenueSource)bkup;
        return rst;
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
        rsbo.setInDB(true);
        System.out.println("inserting backup");
        backup bkup = (backup)rsbo;
        System.out.println("backup price: " + bkup.getPrice());
        PreparedStatement insert = conn.prepareStatement(
                "INSERT INTO \"backup\" VALUES (?,?,?,?)");
        insert.clearParameters();
        insert.setString(1, bkup.getId());
        insert.setDouble(2, bkup.getSize());
        insert.setDouble(3, bkup.getLengthOfBackup());
        insert.setDouble(4, bkup.getPrice());
        insert.executeUpdate();
    }
    
    public void update(RevenueSource rsbo, Connection conn) throws Exception{
        backup bkup = (backup)rsbo;
        PreparedStatement update = conn.prepareStatement(
                "UPDATE \"backup\" SET \"size\"=?, \"lengthofbackup\" = ?, \"price\" = ? WHERE \"id\" = ?");
        update.clearParameters();
        update.setDouble(1, bkup.getSize());
        update.setDouble(2, bkup.getLengthOfBackup());
        update.setDouble(3, bkup.getPrice());
        update.setString(4, bkup.getId());
        update.executeUpdate();
    }
    
//////////////////////////////////////////
/// delete
    
// for business reasons we're not supporting deleting
    
    
}
