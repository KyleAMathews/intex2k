/*
 * Sale.java
 *
 * Created on March 29, 2007, 1:31 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package edu.byu.isys413.cbb54.intex2.data;

/**
 * Extends abstract class RevenueSource
 * @author Group2K
 */
public class Sale extends RevenueSource {
    
    
    private int quantity;
    /**
     * Create new instance of Sale
     * 
     * @param id String
     */
    public Sale(String id){
        this.id = id;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.dirty = true;
    }
}