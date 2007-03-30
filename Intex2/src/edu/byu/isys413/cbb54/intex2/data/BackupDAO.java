/*
 * BackupDAO.java
 *
 * Created on March 30, 2007, 2:26 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package edu.byu.isys413.cbb54.intex2.data;

/**
 *
 * @author kyle
 */
public class BackupDAO {
    
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
    
}
