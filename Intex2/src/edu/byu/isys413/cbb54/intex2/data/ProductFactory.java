/*
 * ProductFactory.java
 *
 * Created on April 2, 2007, 6:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package edu.byu.isys413.cbb54.intex2.data;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Cameron
 */
public class ProductFactory {
    
    private static ProductFactory instance = null;
    Map<String, ProductDAO> DAOmap = new TreeMap<String, ProductDAO>();
    
    /** Creates a new instance of ProductFactory */
    private ProductFactory() {
        DAOmap.put("physical", PhysicalDAO.getInstance());
        DAOmap.put("conceptual", ConceptualDAO.getInstance());
    }
    
    public static ProductFactory getInstance(){
        if(instance == null){
            instance = new ProductFactory();
        }
        return instance;
    }
    
    public ProductDAO getDAO(){
        ProductDAO pDAO = DAOmap.get(type);
        return pDAO;
    }
}
