/*
 * batchBackupRepair.java
 *
 * Created on March 28, 2007, 7:49 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package edu.byu.isys413.cbb54.intex2.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author kyle
 */
public class batchBackupRepair {
    
    /** Creates a new instance of batchBackupRepair */
    public batchBackupRepair() {
    }
    public static void main(String[] args) throws DataException {
        Connection conn = null;
        List<String> repairEmails = new LinkedList<String>();
        
        try {
            // retrieve a database connection from the pool
            conn = ConnectionPool.getInstance().get();
            
            // select repair transactions which are 30 days old and send email
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM \"serviceRepair\" WHERE \"dateEnded\" <= ?");
            ps.setLong(1, (System.currentTimeMillis() - (long)(30*24*60*60*1000))); //subtract num of miliseconds in 30 days from current time
            ResultSet rs = ps.executeQuery();
            
            
            while(rs.next()){
                // select transactionline using repair revenuesource id
                PreparedStatement txlinePS = conn.prepareStatement("SELECT * FROM \"transactionline\" WHERE \"revenuesourceid\" = ?");
                //txlinePS.clearParameters();
                txlinePS.setString(1, rs.getString("id")); //subtract num of miliseconds in 30 days from current time
                ResultSet txlineRS = txlinePS.executeQuery();
                txlineRS.next();
                // use transaction id to get customer's email
                Transaction trans = new Transaction(txlineRS.getString("transactionid"));
                trans.setCustomer(new Customer("00000109123b9144eb018b64001000"));
                
                // needs real data to work
                //Transaction trans2 = TransactionDAO.getInstance().read(txlineRS.getString("transactionid"), conn);
                
                Customer cust = CustomerDAO.getInstance().read(trans.getCustomer().getId(), conn);
                System.out.println(cust.getEmail());
                //add email of customer to list
                repairEmails.add(cust.getEmail());
            }
            
            // email people
            
            System.out.println(repairEmails);
            
            // select backup services which are within 7 days of expiring
            PreparedStatement psbk = conn.prepareStatement("SELECT * FROM \"membership\" WHERE \"backupExpDate\" <= ?");
            psbk.setLong(1, (System.currentTimeMillis() - (long)(7*24*60*60*1000))); //subtract num of miliseconds in 30 days from current time
            ResultSet rsbk = psbk.executeQuery();
            
            while(rsbk.next()){
                
            }
            
            // check if credit card for member is expired
            
            // if expired -- email customer // else charge card
            
            
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
            
            throw new DataException("   :   " + e);
        }
        
    }
}
/**In a nightly cycle you must generate notices to customers whose items have been repaired and who have not picked them up within 30 days of when
 * the work was complete.  You must also generate renewal billings for customers whose expiration date for their backup  service has arrived.
 * Automatically charge their credit cards for the renewal amount.  If the expiration date of the credit card has arrived,
 * send a notice to the customer that their backup service will terminate if they do not update their credit card information.
 **/
