/*
 * printOrder.java
 *
 * Created on March 30, 2007, 2:09 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package edu.byu.isys413.cbb54.intex2.data;

/**
 *
 * @author kyle
 */
public class conversionBO extends RevenueSource {
    
    private conversionTypeBO conversionType;
    private int quantity;
    
    /** Creates a new instance of printOrder */
    public conversionBO(String id) {
        this.id = id;
    }

    public conversionTypeBO getConversionType() {
        return conversionType;
    }

    public void setConversionType(conversionTypeBO conversionType) {
        this.conversionType = conversionType;
        this.dirty = true;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.dirty = true;
    }
}
