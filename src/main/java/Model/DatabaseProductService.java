/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Pojos.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Programming
 */
public class DatabaseProductService implements ProductService {

    ////////////////////////////////////////
    // ---------- CONSTRUCTORS ---------- //
    ////////////////////////////////////////
    ////////////////////////////////////////
    // ------ INTERACTABLE METHODS ------ //
    ////////////////////////////////////////
    @Override
    public Product findProduct(String productId) {
        List<Product> results = getProductListQuery("select * from product where productid like '%" + productId + "%'");
        if(results.isEmpty()) return null;
        else return results.get(0);
    }

    @Override
    public List<Product> searchProducts(String searchParam) {
        String sql = "select * from product ";
        sql += "where Lower(productname) like Lower('%" + searchParam + "%')";
        List<Product> results = getProductListQuery(sql); 
        return results;
    }

    ////////////////////////////////////////
    // --------- SETTER METHODS --------- //
    ////////////////////////////////////////
    ////////////////////////////////////////
    // --------- GETTER METHODS --------- //
    ////////////////////////////////////////
    @Override
    public List<Product> getAllProducts() {
        List<Product> results = getProductListQuery("select * from product");
        return results;
    }

    ////////////////////////////////////////
    // ----- PRIVATE HELPER METHODS ----- //
    ////////////////////////////////////////
    private List<Product> getProductListQuery(String query){
        Connection connect = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Product> prodList = new LinkedList<>();
        try{
            //Connect to DB
            Context initContext = new InitialContext();
            Context webContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) webContext.lookup("jdbc/myProducts");
            connect = ds.getConnection();
            
            //Exicute Query
            stmt = connect.prepareStatement(query);
            rs = stmt.executeQuery();
            
            //Create Product List From Result
            while(rs.next()){
                String productId = rs.getString("productid");
                String productName = rs.getString("productname");
                double unitPrice = rs.getDouble("unitprice");
                String imageURL = rs.getString("imageurl");
                String dShort = rs.getString("descriptionshort");
                String dLong = rs.getString("descriptionlong");
                prodList.add(new Product(productId,productName,unitPrice,imageURL,dShort,dLong));
            }
            
        }catch(SQLException | NamingException e){
            e.printStackTrace();
        }finally{
            if(rs != null) try {rs.close();} catch (SQLException ex) { }
            if(stmt != null) try { stmt.close(); } catch (SQLException ex) {}
            if(connect != null) try { connect.close();} catch (SQLException ex) {}
        }

        return prodList;
    }

    ////////////////////////////////////////
    // --------- OTHER METHOID ---------- //
    ////////////////////////////////////////
}
