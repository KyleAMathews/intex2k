/*
 * RentalDAO.java
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
public class RentalDAO {
    
    ///////////////////////////////////////
    ///   Singleton pattern
    
    private static RentalDAO instance = null;
    
    /** Creates a new instance of RSSFeedDAO */
    private RentalDAO() {
    }
    
    /**
     * Singleton Pattern to allow only one instance of RentalDAO
     * @return RentalDAO
     */
    public static synchronized RentalDAO getInstance() {
        if (instance == null) {
            instance = new RentalDAO();
        }
        return instance;
    }
    
}
