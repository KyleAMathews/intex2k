/*
 * RevenueSourceDAO.java
 *
 * Created on March 29, 2007, 1:42 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package edu.byu.isys413.cbb54.intex2.data;

/**
 *
 * @author tylerf
 */
public abstract class RevenueSourceDAO {
    
    
    
    /** Creates a new instance of RevenueSourceDAO */
    public RevenueSourceDAO() {
    }
    
    private String type;
    private Double price;
    private int quantity;
    
    public abstract String getType();
    public abstract double getPrice();
    public abstract int getQuantity();
    
    public RevenueSource create(String type){
        RevenueSourceDAO rsDAO = Factory.getInstance().getDAO(type);
        RevenueSource bo = rsDAO.create();
        System.out.println("Create");
        return bo;
    }
//    Factory.getInstance().getDAO("sale").create();
}
