/*
 * RSDAO.java
 *
 * Created on March 30, 2007, 3:50 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package edu.byu.isys413.cbb54.intex2.data;

import java.sql.Connection;

/**
 *
 * @author kyle
 */
public abstract class RSDAO {
    
    /** Creates a new instance of RSDAO */
    public RSDAO() {
    }
    
    ///////////////////////////////////////////
    /// Create
    
    abstract RevenueSource create() throws Exception;
    
    ///////////////////////////////////////////
    /// Read
    
    public RevenueSource read (String sku) {
        RevenueSource rs = null;
        return rs;
    }
    
    public RevenueSource read (String sku, Connection conn){
        RevenueSource rs = null;
        return rs;
    }
    
    ///////////////////////////////////////////
    /// Save
    
    public void save(RevenueSource rsbo) {
        
    }
    
    public void save(RevenueSource rsbo, Connection conn){
        
    }
            
    
    
    
}
