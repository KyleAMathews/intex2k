/*
 * ConceptualDAO.java
 *
 * Created on April 2, 2007, 4:36 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package edu.byu.isys413.cbb54.intex2.data;

/**
 *
 * @author Cameron
 */
public class ConceptualDAO extends ProductDAO{
    
    private static ConceptualDAO instance = null;
    
    /** Creates a new instance of ConceptualDAO */
    private ConceptualDAO() {
    }
    
    public static ConceptualDAO getInstance(){
        if(instance == null){
            instance = new ConceptualDAO();
        }
        return instance;
    }
    
}
