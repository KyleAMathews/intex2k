/*
 * Main.java
 *
 * Created on February 21, 2007, 4:10 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package edu.byu.isys413.cbb54.intex2;

import edu.byu.isys413.cbb54.intex2.data.*;



/**
 *
 * @author Cameron
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        //new GUI().setVisible(true);//creates and loads the gui 
        new tester().main(args);
        batchBackupRepair batchbackup = new batchBackupRepair();
        batchbackup.batch();
        
        
        }catch(DataException e){
            System.out.println(e);        }
        
        
    }
    
}
