/*
 * RevenueSourceDAO.java
 *
 * Created on March 30, 2007, 2:25 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package edu.byu.isys413.cbb54.intex2.data;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author kyle
 */
public class RevenueSourceDAO {
    
    ///////////////////////////////////////
    ///   Singleton pattern
    
    Map<String, RSDAO> DAOmap = new TreeMap<String, RSDAO>();
    
    private static RevenueSourceDAO instance = null;
    
    /** Creates a new instance of RSSFeedDAO */
    private RevenueSourceDAO() {
        DAOmap.put("sale", SaleDAO.getInstance());
        DAOmap.put("ba", BackupDAO.getInstance());
        DAOmap.put("po", PrintOrderDAO.getInstance());
        DAOmap.put("rn", RentalDAO.getInstance());
        DAOmap.put("rp", RepairDAO.getInstance());
    }
    
    /**
     * Singleton Pattern to allow only one instance of RevenueSourceDAO
     * @return RevenueSourceDAO
     */
    public static synchronized RevenueSourceDAO getInstance() {
        if (instance == null) {
            instance = new RevenueSourceDAO();
        }
        return instance;
    }
    // KEY (ba = backup | rn = rental | us = used | rp = repair | po = printOrder | sale = Sale)
    ///////////////////////////////////////////
    //// Create
    public RevenueSource create(String sku) throws DataException{
        try{
            // check first digit if backup/rental/used/repair/printOrder
            String type = String.valueOf(sku.charAt(0)) + String.valueOf(sku.charAt(1));
            boolean isSale = false;

            // grab DAO from map
            RSDAO dao = DAOmap.get(type);
            if (dao == null){
                dao = SaleDAO.getInstance();
                isSale = true;
            }

            // create BO
            RevenueSource rs = dao.create();
            System.out.println(rs.getId());
            rs.setType(type);
            if (isSale){
                rs.setType("sale");
            }
            // return
            return rs;
        }catch (DataException de){
            throw new DataException("Could not create new Revenue Source", de);
        }catch (Exception e){
            throw new DataException("Could not create new Revenue Source.", e);
        }        
    }
    
    
//    ///////////////////////////////////////////
//    /// Read
//    
//    public RevenueSource read(String id){
//        // read from  RevenueSource database with id
//        // grab DAO from map
//        // send in id to DAO
//        // set price on returned object
//        // return
//    }
//    
//    
//    ///////////////////////////////////////////
//    /// Save
//    
//    public void save(RevenueSource rs){
//        // revenuesource saves price/type/id
//        // gets DAO for type
//        // sends in rs to DAO
//        // returns
//        
//    }
//    
//    
//    ///////////////////////////////////////////
//    /// Delete
//    
//    // for business reasons we are not deleteing any revenue sources
//    
//    ///////////////////////////////////////////
//    /// DAO Map
//    
//    
}
