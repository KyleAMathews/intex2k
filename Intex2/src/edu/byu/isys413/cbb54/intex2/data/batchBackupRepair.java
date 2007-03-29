/*
 * batchBackupRepair.java
 *
 * Created on March 28, 2007, 7:49 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package edu.byu.isys413.cbb54.intex2.data;

/**
 *
 * @author kyle
 */
public class batchBackupRepair {
    
    /** Creates a new instance of batchBackupRepair */
    public batchBackupRepair() {
        
        Connection conn = null;
        try {
            // retrieve a database connection from the pool
            conn = ConnectionPool.getInstance().get();
            
            // select repair transactions which are 30 days old and send email
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ");
            
            
            
            
            
            // release the connection
            conn.commit();
            ConnectionPool.getInstance().release(conn);
            
        }catch (ConnectionPoolException e){
            throw new DataException("Could not get a connection to the database.");
            
        }catch (SQLException e) {
            // rollback
            try {
                conn.rollback();
                ConnectionPool.getInstance().release(conn);
            }catch (ConnectionPoolException ce){
                throw new DataException("There was an error with the connection to the database", ce);
            }catch (SQLException e2) {
                throw new DataException("Big error: could not even release the connection", e2);
            }
            
            throw new DataException("Could not retrieve record for id=" + id, e);
        }
        
        
        
// select backup services which are within 7 days of expiring
        
// check if credit card for member is expired
        
// if expired -- email customer // else charge card
        
    }
    /**In a nightly cycle you must generate notices to customers whose items have been repaired and who have not picked them up within 30 days of when
     * the work was complete.  You must also generate renewal billings for customers whose expiration date for their backup  service has arrived.
     * Automatically charge their credit cards for the renewal amount.  If the expiration date of the credit card has arrived,
     * send a notice to the customer that their backup service will terminate if they do not update their credit card information.
     **/