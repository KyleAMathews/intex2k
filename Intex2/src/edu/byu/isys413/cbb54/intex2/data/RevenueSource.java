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
public abstract class RevenueSource {
    
    String id;
    String type;
    Double price;
    boolean dirty = false;
    boolean isInDB = false;
    
    public double getPrice(){
        return price;
    }
    
    public void setPrice(double price){
        this.dirty = true;
        this.price = price;
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



    public String getId() {
        return id;
    }
    
}
