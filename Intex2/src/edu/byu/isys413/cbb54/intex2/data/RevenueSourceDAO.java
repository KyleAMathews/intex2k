/*
 * RevenueSourceDAO.java
 *
 * Created on March 30, 2007, 2:25 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package edu.byu.isys413.cbb54.intex2.data;

/**
 *
 * @author kyle
 */
public class RevenueSourceDAO {
    
    RevenueSourceDAO cust = null;
    
    
    ///////////////////////////////////////
    ///   Singleton pattern
    
    private static RevenueSourceDAO instance = null;
    
    /** Creates a new instance of RSSFeedDAO */
    private RevenueSourceDAO() {
    }
    
    /**
     * Singleton Pattern to allow only one instance of RevenueSourceDAO
     * @return RevenueSourceDAO
     */
    public static synchronized RevenueSourceDAO getInstance() {
        if (instance == null) {
            instance = new RevenueSourceDAO();
        }
        return instance;
    }
    
}
