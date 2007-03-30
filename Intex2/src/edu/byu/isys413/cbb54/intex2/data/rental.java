/*
 * rental.java
 *
 * Created on March 30, 2007, 2:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package edu.byu.isys413.cbb54.intex2.data;

/**
 *
 * @author kyle
 */
public class rental {
    
    private long dateOut;
    private long dateDue;
    
    
    /** Creates a new instance of rental */
    public rental() {
    }

    public long getDateOut() {
        return dateOut;
    }

    public void setDateOut(long dateOut) {
        this.dateOut = dateOut;
    }

    public long getDateDue() {
        return dateDue;
    }

    public void setDateDue(long dateDue) {
        this.dateDue = dateDue;
    }
    
}
