/*
 * RevenueSource.java
 *
 * Created on March 12, 2007, 2:54 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package edu.byu.isys413.cbb54.intex2.data;

/**
 *
 * @author Cameron
 */
public class RevenueSource {
    
    private String id;
    private String type;
    private Double price;
    private int quantity;
    private boolean dirty = false;
    private boolean isInDB = false;
    
    /** Creates a new instance of RevenueSource */
    public RevenueSource(String id) {
        this.id = id;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setPrice(double price){
        this.dirty = true;
        this.price = price;
    }
    
    /*
    public String getDescription(){
        return "Canon EOS 1Ds Mark II";
    }*/

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.dirty = true;
        this.type = type;
    }

    public boolean isDirty() {
        return dirty;
    }

    public boolean isInDB() {
        return isInDB;
    }

    public void seInDB(boolean isInDB) {
        this.isInDB = isInDB;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.dirty = true;
    }
    
}
