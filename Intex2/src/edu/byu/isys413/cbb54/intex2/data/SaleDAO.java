/*
 * SaleDAO.java
 *
 * Created on March 29, 2007, 2:07 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package edu.byu.isys413.cbb54.intex2.data;

/**
 *
 * @author Cameron
 */
public class SaleDAO extends RevenueSourceDAO {
    
    private static SaleDAO instance = null;
    
    /** Creates a new instance of SaleDAO */
    private SaleDAO() {
    }
    
    public static synchronized SaleDAO getInstance(){
        if(instance == null){
            instance = new SaleDAO();
        }
        return instance;
    }
    
    public String getType(){
        
    }
    public double getPrice(){}
    public int getQuantity(){}
    
    public static SaleBO create(){
        String g = GUID.generate();
        SaleBO bo = new SaleBO(g);
        return bo;
    }
}
